package mx.com.nttdata.web.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Action;

import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.service.CIncidentService;

import mx.com.nttdata.util.IGlobalConstants;

/**
 * Accion que maneja el listado de incidentes criticos
 * @version 1.0.0
 */
public class CIncidentsAction extends ActionSupport implements SessionAware {

  
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -5646131485352867217L;
  
  
  private Map<String,Object> session;
  
  /** Lista de los usuarios del sistema */
  private List<CriticalIncident> incList;
  
 
  @Override
  public String execute() throws Exception {
    
    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       session.put( IGlobalConstants.SESS_TARGET_URL, IGlobalConstants.PAGE_INC_LIST );
       return "notValid";
    }

    CIncidentService svc = new CIncidentService();    
    incList = svc.getIncidentList( true );
    session.put( IGlobalConstants.SESS_CI_LIST, incList );
    
    return Action.SUCCESS;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

  /// Getters y setters

}
