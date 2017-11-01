package mx.com.nttdata.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import mx.com.nttdata.beans.User;
import mx.com.nttdata.service.UserService;
import mx.com.nttdata.util.IGlobalConstants;


/**
 * Accion que maneja el listado de usuarios
 * @version 1.0.0
 */
public class UserListAction extends ActionSupport implements SessionAware {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 112235617392873178L;

  private Map<String,Object> session;

  /** Lista de los usuarios del sistema */
  private List<User> userlist;


  @Override
  public String execute() throws Exception {

    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
    session.remove( IGlobalConstants.LOGIN_ERROR_MSG );

    Integer uLevel = (Integer) session.get( IGlobalConstants.SESS_USER_LEVEL );
    if ( uLevel == null )
       uLevel = IGlobalConstants.DEFAULT_USER_LEVEL;

    UserService svc = new UserService();
    userlist = svc.getUserList( uLevel, "" );
    session.put( IGlobalConstants.SESS_USER_LIST, userlist );

    return Action.SUCCESS;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

  /// Getters y setters

  public List<User> getUserList() {

    if (  this.userlist == null  )
       this.userlist = new ArrayList<>();
    return this.userlist;
  }

  public void setUsetList( List<User> usuarios ) {

    this.userlist = usuarios;
    if (  this.userlist == null  )
       this.userlist = new ArrayList<>();
  }

}
