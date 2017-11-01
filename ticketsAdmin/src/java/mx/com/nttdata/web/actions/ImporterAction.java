package mx.com.nttdata.web.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Action;

import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.service.ICIncidentService;
import mx.com.nttdata.service.CIncidentService;
import mx.com.nttdata.service.ImporterService;

import mx.com.nttdata.util.IGlobalConstants;

/**
 * Accion que maneja el listado de incidentes padres a importar
 * @version 1.0.0
 */
public class ImporterAction extends ActionSupport implements SessionAware  {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -4704466798893220681L;


  /** Variables de sesion, manipulada por struts */
  private Map<String,Object> session;

  /** Accesor a la bitacora de la aplicacion */
  private Logger logger;

  /** Lista de Identificadores de los tickets de incidentes a importar */
  private List<String> incidents;

  /** Nivel de seguridad del usuario actual */
  private Integer loginLevel;


  @Override
  public String execute() throws Exception {

    logger = Logger.getLogger(this.getClass().getName());
    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
    session.remove( IGlobalConstants.LOGIN_ERROR_MSG );

    loginLevel = (Integer) session.get( IGlobalConstants.SESS_USER_LEVEL );
    if ( loginLevel == null )
       loginLevel = IGlobalConstants.DEFAULT_USER_LEVEL;
    HttpServletRequest  req  = ServletActionContext.getRequest();

    ImporterService importer = new ImporterService();
    List<CriticalIncident> importList;

    if ( this.incidents == null || this.incidents.isEmpty()) {

       importList = importer.getCriticalIncidents();
       session.put("importList", importList );
       return Action.INPUT;
    }

    importList = (List<CriticalIncident>) session.get("importList");
    importer.importIncidents( importList, incidents );
    session.remove( "importList" );

    ICIncidentService svcCIs = new CIncidentService();
    List<CriticalIncident> incList = svcCIs.getIncidentList( true );
    session.put( "incidentList", incList );

    return Action.SUCCESS;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

  /// Getters y setters

  public List<String> getIncidents() {

    if ( incidents == null )
       incidents = new ArrayList<>();
    return incidents;
  }

  public void setIncidents( List<String> itemKeys ) {

    if ( itemKeys == null )
       this.incidents = new ArrayList<>();
    else
       this.incidents = itemKeys;
  }

}
