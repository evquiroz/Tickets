package mx.com.nttdata.web.actions;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.service.CIncidentService;
import mx.com.nttdata.util.IGlobalConstants;

import org.apache.struts2.interceptor.SessionAware;

/**
 * Accion para que la pagina principal pida siempre pria login si el usuario no
 * se ha autenticado
 * @version 1.0.0
 */
public class MainAction extends ActionSupport implements SessionAware {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 112235617392873178L;

  /** Mapa para paso de datos de la sesion */
  private Map<String,Object> session;

  /** Lista de los usuarios del sistema */
  private List<CriticalIncident> incList;

  @Override
  public String execute() throws Exception {

/*
    Logger logger = Logger.getLogger( this.getClass());
    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    logger.debug("TicketAction.execute(). Validando sesi\u00fen");
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
*/
    CIncidentService svc = new CIncidentService();
    incList = svc.getIncidentList( true );
    session.put( IGlobalConstants.SESS_CI_LIST, incList );

    return Action.SUCCESS;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

}
