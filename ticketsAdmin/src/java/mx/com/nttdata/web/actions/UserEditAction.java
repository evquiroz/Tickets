package mx.com.nttdata.web.actions;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import mx.com.nttdata.beans.User;
import mx.com.nttdata.service.ILocalUserService;
import mx.com.nttdata.service.UserService;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Messages;
import mx.com.nttdata.util.TicketUtils;

/**
 * Accion que maneja las operaciones altas, bajas y cambios de usuarios locales
 * @version 1.0.0
 */
public class UserEditAction extends ActionSupport implements SessionAware {


  /** Auxiliar de serializacino */
  private static final long serialVersionUID = -8618331931176501916L;

  /** Mapa de variables de sesion */
  private Map<String,Object> session;

  /** Logger de la aplicacion */
  private Logger logger = Logger.getLogger( this.getClass());


  private Integer userActionID;
  private Integer userID;
  private String  userName;
  private String  userSecret;
  private String  userMail;
  private Integer userLevel;
  private String  userStatus;

  private String  message;

  private String  userNameFieldError;
  private String  userSecretFieldError;
  private String  userMailFieldError;
  private String  userLevelFieldError;
  private String  userStatusFieldError;

  private Boolean redirect = false;

  private Integer loginLevel;

  @Override
  public String execute() throws Exception {

    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
    session.remove( IGlobalConstants.LOGIN_ERROR_MSG );

    loginLevel = (Integer) session.get( IGlobalConstants.SESS_USER_LEVEL );
    if ( loginLevel == null )
       loginLevel = IGlobalConstants.DEFAULT_USER_LEVEL;
//    HttpServletResponse resp = ServletActionContext.getResponse();
    HttpServletRequest  req  = ServletActionContext.getRequest();

    String bufferAc = req.getParameter( IGlobalConstants.WEB_PARAM_ACTION );
    String bufferID = req.getParameter( IGlobalConstants.WEB_PARAM_ID );

    session.put( IGlobalConstants.SESS_LOGIN_NAME, loginName );
    session.put( IGlobalConstants.SESS_USER_LEVEL, loginLevel );

    if ( bufferAc == null || bufferAc.isEmpty()) {

       this.redirect = false;
       if ( this.userActionID != null ) {

          bufferAc = this.userActionID.toString();
          if ( this.userActionID != IGlobalConstants.ACN_CREATE_RECORD &&
               ( this.userName == null || this.userName.isEmpty()))
             redirect = true;
          else
             bufferID = this.userName;
       }
       if ( this.redirect ) {

          this.message = Messages.getMessage( IGlobalConstants.INVALID_ACTION_MSG );
          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
          return Action.SUCCESS;
       }
    }
    this.userActionID = Integer.parseInt( bufferAc );

    String loginID;
    if ( this.userActionID > IGlobalConstants.ACN_CREATE_RECORD )
    {
       if ( bufferID == null || bufferID.isEmpty()) {
          this.message = Messages.getMessage( IGlobalConstants.INVALID_REC_ID_MSG );
          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
          return Action.SUCCESS;
       }
       if (( this.userActionID == IGlobalConstants.ACN_UPDATE_RECORD || this.userActionID == IGlobalConstants.ACN_DELETE_RECORD )&&
           ( this.userName == null || this.userName.isEmpty()))
          loginID = TicketUtils.uncloackData( bufferID );
       else
          loginID = this.userName;
       ILocalUserService svc = new UserService();

       if ( this.userActionID == IGlobalConstants.ACN_UPDATE_RECORD )
       {

          User bean = svc.getUser( loginID );
          this.userID     = bean.getID();
          this.userName   = bean.getLoginName();
          this.userMail   = bean.getMail();
          this.userLevel  = bean.getLevel();
          this.userStatus = bean.getStatus();

          session.put( "userBean", bean );
          session.put( "recordAction", this.userActionID );
          this.resetMessages();
       }
       else if ( this.userActionID == IGlobalConstants.ACN_DELETE_RECORD )
       {
          this.message = svc.deleteUser( loginID, loginName );
          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );

          List<User> userlist = svc.getUserList( this.loginLevel, "" );
          session.put( IGlobalConstants.SESS_USER_LIST, userlist );

          return Action.SUCCESS;
       }
       else if ( this.userActionID == IGlobalConstants.ACN_SAVE_NEW_RECORD ||
                 this.userActionID == IGlobalConstants.ACN_SAVE_EDIT_RECORD )
       {

          User bean = new User();
          if ( this.userActionID == IGlobalConstants.ACN_SAVE_EDIT_RECORD )
             bean.setID( this.userID );
          bean.setLoginName( this.userName );
          bean.setMail( this.userMail );
          bean.setSecret( this.userSecret );
          bean.setLevel( this.userLevel );
          bean.setStatus( this.userStatus );

          if ( !this.isValidated()) {

             this.userActionID -= 3;
             this.message = "Hay errores en sus datos";

             session.put( "userBean", bean );
             session.put( "recordAction", this.userActionID );

             session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
             session.put( "usrNameError",   this.userNameFieldError );
             session.put( "usrSecretError", this.userSecretFieldError );
             session.put( "usrMailError",   this.userMailFieldError );
             session.put( "usrLevelError",  this.userLevelFieldError );
             session.put( "usrStatusError", this.userStatusFieldError );

             return Action.INPUT;
          }

          if ( this.userActionID == IGlobalConstants.ACN_SAVE_NEW_RECORD )
             this.message = svc.createUser( bean, loginName );
          else
             this.message = svc.updateUser( bean, loginName );

          List<User> userlist = svc.getUserList( this.loginLevel, "" );
          session.put( IGlobalConstants.SESS_USER_LIST, userlist );
          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
          return Action.SUCCESS;
       }
    }
    else
    {
       this.userName   = IGlobalConstants.EMPTY_STRING;
       this.userSecret = IGlobalConstants.EMPTY_STRING;
       this.userMail   = IGlobalConstants.EMPTY_STRING;
       this.userLevel  = ( this.loginLevel > IGlobalConstants.DEFAULT_USER_LEVEL )
                       ? this.loginLevel : IGlobalConstants.DEFAULT_USER_LEVEL;
       this.userStatus = IGlobalConstants.DEFAULT_USER_STATUS;
       this.message    = IGlobalConstants.EMPTY_STRING;

       User bean = new User();
       bean.setLoginName( this.userName );
       bean.setMail( this.userMail );
       bean.setLevel( this.userLevel );
       bean.setStatus( this.userStatus );

       session.put( "userBean", bean );
       session.put( "recordAction", this.userActionID );
       this.resetMessages();
    }

    return Action.INPUT;
  }

  private boolean isValidated() {

    if ( this.userNameFieldError   == null || this.userNameFieldError.isEmpty())
       if ( this.userSecretFieldError == null || this.userSecretFieldError.isEmpty())
          if ( this.userMailFieldError   == null || this.userMailFieldError.isEmpty())
             if ( this.userLevelFieldError  == null || this.userLevelFieldError.isEmpty())
                if ( this.userStatusFieldError == null || this.userStatusFieldError.isEmpty())
                   return true;
    return false;
  }

  private void resetMessages() {

    this.message              = IGlobalConstants.EMPTY_STRING;
    this.userNameFieldError   = IGlobalConstants.EMPTY_STRING;
    this.userSecretFieldError = IGlobalConstants.EMPTY_STRING;
    this.userMailFieldError   = IGlobalConstants.EMPTY_STRING;
    this.userLevelFieldError  = IGlobalConstants.EMPTY_STRING;
    this.userStatusFieldError = IGlobalConstants.EMPTY_STRING;

    session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
    session.put( "usrNameError",   IGlobalConstants.EMPTY_STRING );
    session.put( "usrSecretError", IGlobalConstants.EMPTY_STRING );
    session.put( "usrMailError",   IGlobalConstants.EMPTY_STRING );
    session.put( "usrLevelError",  IGlobalConstants.EMPTY_STRING );
    session.put( "usrStatusError", IGlobalConstants.EMPTY_STRING );
  }

  @Override
  public void validate() {

    if ( this.userActionID == null  )
       return;
    validateUserName();
    validateSecret();
    validateMail();
    validateUserLevel();
    validateUserStatus();
  }

  private void validateUserName() {

    if ( !this.userName.matches("^[A-Za-z][A-Za-z0-9]{5,15}$"))
       this.userNameFieldError = Messages.getMessage( IGlobalConstants.MSG_LOGIN_INV );
    else
    {  // valida que sea unico
       UserService svc = new UserService();
       String mail = "";
       if ( this.userActionID == IGlobalConstants.ACN_SAVE_EDIT_RECORD )
          mail = this.userMail;
       if ( !svc.isUniqueUser( this.userName, this.userID, this.userActionID == IGlobalConstants.ACN_SAVE_NEW_RECORD ))
          this.userNameFieldError = Messages.getMessage( IGlobalConstants.MSG_LOGIN_NON_UNIQUE );
    }
  }

  private void validateMail() {

    if ( !this.userMail.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
       this.userMailFieldError = Messages.getMessage( IGlobalConstants.MSG_MAIL_INV );
    else
    {  // valida que sea unico
       UserService svc = new UserService();
       String login = "";
       if ( this.userActionID == IGlobalConstants.ACN_SAVE_EDIT_RECORD )
          login = this.userName;
       if ( !svc.isUniqueMail( this.userMail, this.userID, this.userActionID == IGlobalConstants.ACN_SAVE_NEW_RECORD ))
          this.userMailFieldError = Messages.getMessage( IGlobalConstants.MSG_MAIL_NON_UNIQUE );
    }
  }

  private void validateSecret() {

    boolean isRequired = ( this.userActionID == IGlobalConstants.ACN_CREATE_RECORD ) ||
                         ( this.userActionID == IGlobalConstants.ACN_UPDATE_RECORD &&
                           ( this.userSecret != null || !this.userSecret.isEmpty()));
    if ( isRequired )
       if ( !this.userSecret.matches("^[^\\s]{8,16}$"))
         this.userSecretFieldError = Messages.getMessage( IGlobalConstants.MSG_PWD_INV );
  }

  private void validateUserLevel() {

    String tmp = this.userLevel.toString();
    Integer lvl = (Integer) session.get( IGlobalConstants.SESS_USER_LEVEL );
    if ( lvl == null )
       lvl = IGlobalConstants.DEFAULT_USER_LEVEL;

    if ( tmp == null || !tmp.matches("^[1-3]$") || this.userLevel < lvl )
       this.userLevelFieldError = Messages.getMessage( IGlobalConstants.MSG_LEVEL_INV );
  }

  private void validateUserStatus() {

    if ( this.userStatus == null || !this.userStatus.matches("^[ABS]$"))
       this.userStatusFieldError = Messages.getMessage( IGlobalConstants.MSG_STATUS_INV );
  }

  /// Getters y setters

  public int getUserActionID() {

    return userActionID;
  }

  public int getUserID() {

    return userID;
  }

  public String getUserName() {

    return userName;
  }

  public String getUserSecret() {

    return userSecret;
  }

  public String getUserMail() {

    return userMail;
  }

  public Integer getUserLevel() {

    return userLevel;
  }

  public String getUserStatus() {

    return userStatus;
  }

  public String getMessage() {

    return message;
  }

  public String getUserNameFieldError() {

    return userNameFieldError;
  }

  public String getUserSecretFieldError() {

    return userSecretFieldError;
  }

  public String getUserMailFieldError() {

    return userMailFieldError;
  }

  public String getUserLevelFieldError() {

    return userLevelFieldError;
  }

  public String getUserStatusFieldError() {

    return userStatusFieldError;
  }

  public boolean getRedirect() {

    return redirect;
  }

  public void setUserActionID( int action ) {

    this.userActionID = action;
  }

  public void setUserID( int id ) {

    this.userID = id;
  }

  public void setUserName( String userName ) {

    this.userName = userName;
  }

  public void setUserSecret( String userSecret ) {

    this.userSecret = userSecret;
  }

  public void setUserMail( String userMail ) {

    this.userMail = userMail;
  }

  public void setUserLevel( Integer userLevel ) {

    this.userLevel = userLevel;
  }

  public void setUserStatus( String userStatus ) {

    this.userStatus = userStatus;
  }

  public void setMessage( String message ) {

    this.message = message;
  }

  public void setUserNameFieldError( String userNameFieldError ) {

    this.userNameFieldError = userNameFieldError;
  }

  public void setUserSecretFieldError( String userSecretFieldError ) {

    this.userSecretFieldError = userSecretFieldError;
  }

  public void setUserMailFieldError( String userMailFieldError ) {

    this.userMailFieldError = userMailFieldError;
  }

  public void setUserLevelFieldError( String userLevelFieldError ) {

    this.userLevelFieldError = userLevelFieldError;
  }

  public void setUserStatusFieldError( String userStatusFieldError ) {

    this.userStatusFieldError = userStatusFieldError;
  }

  public void setRedirect( boolean redirect ) {

    this.redirect = redirect;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

}
