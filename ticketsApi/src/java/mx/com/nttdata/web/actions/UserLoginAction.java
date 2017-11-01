package mx.com.nttdata.web.actions;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import mx.com.nttdata.service.IUserService;
import mx.com.nttdata.service.UserService;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Messages;


/**
 * Accion para manejar el ingreso de los usuatios locales
 * @version 1.0.0
 */
public class UserLoginAction extends ActionSupport implements SessionAware, ApplicationActions {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 1924886397802904635L;

  /** Logger de la aplicacion */
  private Logger logger = Logger.getLogger( this.getClass());

  /** Variables de la sesion */
  private Map<String,Object> session;

  private String login;
  private String loginFieldError;
  private String secret;
  private String secretFieldError;
  private String message;
  private Boolean redirect;


  public String login() throws Exception {

    if (( login == null || login.isEmpty()) || ( secret == null || secret.isEmpty()))
       return Action.INPUT;

    IUserService svc = new UserService();
    Integer loginResult = svc.authenticate( login, secret );

    String result;
    session.remove( IGlobalConstants.LOGIN_ERROR_MSG );

    switch ( loginResult ) {

      case IGlobalConstants.LOGIN_AUTHENTICATED_CODE:
           try {
             String goTo = (String) session.get( IGlobalConstants.SESS_TARGET_URL );
             ((SessionMap) this.session ).invalidate();
             session.put( IGlobalConstants.SESS_LOGIN_NAME, login );
/*
             if ( goTo.equalsIgnoreCase( IGlobalConstants.PAGE_INC_LIST ))
                result = ACTION_INCIDENT_LIST;
             else if ( goTo.equalsIgnoreCase( IGlobalConstants.PAGE_DERIVED_FORM ))
                result = ACTION_NEW_DERIVED;
             else if ( goTo.equalsIgnoreCase( IGlobalConstants.PAGE_INCIDENT_FORM ))
                result = ACTION_NEW_INCIDENT;
             else if ( goTo.equalsIgnoreCase( IGlobalConstants.PAGE_WORKORDER_FORM ))
                result = ACTION_NEW_WORKORDER;
             else
*/
                result = Action.SUCCESS;

           } catch ( Exception ex ) {

             result = Action.INPUT;
           }
           break;

      case IGlobalConstants.LOGIN_REJECTED_CODE:
           this.message = Messages.getMessage( IGlobalConstants.LOGIN_REJECTED_MSG );
           result = Action.INPUT;
           break;

      case IGlobalConstants.LOGIN_NO_SERVICE_CODE:
           this.message = Messages.getMessage( IGlobalConstants.LOGIN_NO_SERVICE_MSG );
           result = Action.INPUT;
           break;

      default:
           result = Action.ERROR;
           break;
    }

    if ( loginResult != IGlobalConstants.LOGIN_AUTHENTICATED_CODE ) {

       this.login  = IGlobalConstants.EMPTY_STRING;
       this.secret = IGlobalConstants.EMPTY_STRING;

       session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
       session.put( IGlobalConstants.SESS_ERROR_LOGIN, this.loginFieldError );
       session.put( IGlobalConstants.SESS_ERROR_SECRET, this.secretFieldError );
    }

    return result;
  }

  @Override
  public void validate() {

    session.remove( IGlobalConstants.SESS_ERROR_MSG );
    session.remove( IGlobalConstants.SESS_ERROR_LOGIN );
    session.remove( IGlobalConstants.SESS_ERROR_SECRET );

    this.validateLogin();
    this.validateSecret();

    if ( this.loginFieldError != null || this.secretFieldError != null ) {

       this.login = null;
       this.secret = null;
    }
  }

  /**
   * Valida que el nombre de usuario no sea invalido ni este vacio
   * @return Nada si es valido, un mensaje de error si no cumple con los requisitos
   */
  public final String validateLogin() {

    if ( this.login == null || this.login.isEmpty())
       return Messages.getMessage( IGlobalConstants.LOGIN_REQUIRED_MSG );
    else if ( this.login.matches("^[A-Za-z0-9]{6,16}$"))
       return Messages.getMessage( IGlobalConstants.LOGIN_NAME_INV_MSG );
    return null;
  }

  /**
   * Valida que el password del usuario no sea invalido ni este vacio
   * @return Nada si es valido, un mensaje de error si no cumple con los requisitos
   */
  public final String validateSecret() {

    if ( this.secret == null || this.secret.isEmpty())
       return Messages.getMessage( IGlobalConstants.SECRET_REQUIRED_MSG );
    else if ( this.secret.matches("^[^\\s]{8,16}$"))
       return Messages.getMessage( IGlobalConstants.SECRET_VAL_INV_MSG );
    return null;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

  //// Getters y setters

  public String getLogin() {

    return login;
  }

  public String getLoginFieldError() {

    return loginFieldError;
  }

  public String getSecret() {

    return secret;
  }

  public String getSecretFieldError() {

    return secretFieldError;
  }

  public String getMessage() {

    return message;
  }

  public Boolean getRedirect() {

    return redirect;
  }

  public void setLogin( String login ) {

    this.login = login;
  }

  public void setLoginFieldError( String loginFieldError ) {

    this.loginFieldError = loginFieldError;
  }

  public void setSecret( String secret ) {

    this.secret = secret;
  }

  public void setSecretFieldError( String secretFieldError ) {

    this.secretFieldError = secretFieldError;
  }

  public void setMessage( String message ) {

    this.message = message;
  }

  public void setRedirect( Boolean redirect ) {

    this.redirect = redirect;
  }

}
