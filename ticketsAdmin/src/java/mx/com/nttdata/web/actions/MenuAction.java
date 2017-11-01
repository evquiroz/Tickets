package mx.com.nttdata.web.actions;

import java.util.Map;

import com.opensymphony.xwork2.Action;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

import mx.com.nttdata.util.IGlobalConstants;

/**
 * Accion para que la pagina principal pida siempre pria login si el usuario no
 * se ha autenticado
 * @version 1.0.0
 */
public class MenuAction extends ActionSupport implements SessionAware {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 112235617392873178L;

  private Map<String,Object> session;


  @Override
  public String execute() throws Exception {

    Logger logger = Logger.getLogger( this.getClass());
    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    logger.debug("MenuAction.execute(). Validando sesi\u00fen");
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
    return Action.SUCCESS;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

}
