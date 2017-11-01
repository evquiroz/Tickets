package mx.com.nttdata.web.actions;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.ServletActionContext;

import mx.com.nttdata.service.CIncidentService;
import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.service.IGlobalService;
import mx.com.nttdata.service.ICIncidentService;
import mx.com.nttdata.service.GlobalService;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.IncidentStatus;
import mx.com.nttdata.util.Messages;
import mx.com.nttdata.util.TicketUtils;

/**
 * Clase que maneja la captura de incidentes criticos
 * @author Fabrizio Lozada
 * @todo Agregar validaciones 
 * @todo Agregar campos de error para los 8 ultimos campos que pidieron
 */
public class CIncidentAction extends ActionSupport implements SessionAware {

  
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 8627267248203480377L;
  
  /** Nombre del parametro para saber si se reabre o se cierra un incidente n*/
  private final static String MODE_PARAM  = "s";
  
  private final static String DEF_MODE    = "0";
  private final static String CLOSE_MODE  = "0";
  private final static String REOPEN_MODE = "1";
  
  /** Logger de la aplicacion */
  private Logger logger = Logger.getLogger( this.getClass());

  /** Variables de la sesion */
  private Map<String,Object> session;
  
  //// Field Properties 
  
  private Integer actionID;

  /** Database Row ID */
  private String  incidentID;
  /** Remedy Incident ID */
  private String  remedyID;
  /** Descripcion corta del incidente */
  private String  title;
  /** Descripcion larga del incidente */
  private String  notes;
  /** Impacto del incidente */
  private String  impact;
  /** Grupo de soporte asignado */
  private String  assignedGroup;
  /** Categoria del incidente nivel 01 */
  protected String categoryLevel01;
  /** Categoria del incidente nivel 02 */
  protected String categoryLevel02;
  /** Categoria del incidente nivel 03 */
  protected String categoryLevel03;
  /** Producto del incidente nivel 01 */
  protected String productLevel01;
  /** Producto del incidente nivel 02 */
  protected String productLevel02;
  /** Producto del incidente nivel 03 */
  protected String productLevel03;  
  /** Estado del incidente */
  private String  status;
  /** Fecha de creacion del incidente */
  private String  creationDate;
  /** Fecha de cierre del incidente */
  private String  closeDate;

  private String  message;
  
  private String  remedyFieldError;  
  private String  titleFieldError;
  private String  notesFieldError;
  private String  creationFieldError;
  private String  closeFieldError;  
  
  private Boolean redirect = false;

  private Integer loginLevel;

   
  public String addIncident() throws Exception {

    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
    session.remove( IGlobalConstants.LOGIN_ERROR_MSG );

    loginLevel = (Integer) session.get( IGlobalConstants.SESS_USER_LEVEL );
    if ( loginLevel == null )
       loginLevel = IGlobalConstants.DEFAULT_USER_LEVEL;
    HttpServletResponse resp = ServletActionContext.getResponse();
    HttpServletRequest  req  = ServletActionContext.getRequest();

    String bufferAc = req.getParameter( IGlobalConstants.WEB_PARAM_ACTION );
    String bufferID = req.getParameter( IGlobalConstants.WEB_PARAM_ID );

    session.put( IGlobalConstants.SESS_LOGIN_NAME, loginName );
    session.put( IGlobalConstants.SESS_USER_LEVEL, loginLevel );
    
    if ( bufferAc == null || bufferAc.isEmpty()) {

       this.redirect = false;
       if ( this.actionID != null ) {

          bufferAc = this.actionID.toString();
          if ( this.actionID != IGlobalConstants.ACN_SAVE_NEW_RECORD  &&
               this.actionID != IGlobalConstants.ACN_SAVE_EDIT_RECORD &&
               this.actionID != IGlobalConstants.ACN_DELETE_RECORD )
             redirect = true;
       }
       if ( this.redirect ) {

          this.message = Messages.getMessage( IGlobalConstants.INVALID_ACTION_MSG );
          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
          return Action.SUCCESS;
       }
    }
    this.actionID = Integer.parseInt( bufferAc );
    IGlobalService gsvc = new GlobalService();
    Map<String,String> impactMap = gsvc.getImpactData();
    session.put("impactMap", impactMap );
  
    if ( this.actionID == IGlobalConstants.ACN_DELETE_RECORD    ||
         this.actionID == IGlobalConstants.ACN_SAVE_EDIT_RECORD )
    {
       if ( bufferID == null || bufferID.isEmpty()) {
          this.message = Messages.getMessage( IGlobalConstants.INVALID_REC_ID_MSG );
          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
          return Action.SUCCESS;
       }
       incidentID = TicketUtils.uncloackData( bufferID );
       int id  = Integer.parseInt( incidentID );
       ICIncidentService svc = new CIncidentService();
       
       if ( this.actionID == IGlobalConstants.ACN_DELETE_RECORD )
       {
          message = svc.deleteIncident( id );

          List<CriticalIncident> incList = svc.getIncidentList( false );
          session.put( "incidentList", incList );
          return Action.SUCCESS;
       }
       else
       {
          // this.message = svc.closeIncident( id );
          String s = req.getParameter( MODE_PARAM );
          if ( s == null || s.isEmpty())
             s = DEF_MODE;
          
          if ( s.equalsIgnoreCase( CLOSE_MODE ))
             this.message = svc.closeIncident( id );
          else
             this.message = svc.reopenIncident( id );
         
          List<CriticalIncident> incList = svc.getIncidentList( false );
          session.put( "incidentList", incList );
          return Action.SUCCESS;
       }
    }   
    else if ( this.actionID == IGlobalConstants.ACN_SAVE_NEW_RECORD )
    {
       CriticalIncident bean = new CriticalIncident();
       bean.setRemedyID( this.remedyID.toUpperCase());
       bean.setTitle( this.title );
       bean.setNotes( this.notes );
       bean.setImpact( this.impact );
       bean.setAssignedGroup( this.assignedGroup );
       bean.setCategoryLevel01( this.categoryLevel01 );
       bean.setCategoryLevel02( this.categoryLevel02 );
       bean.setCategoryLevel03( this.categoryLevel03 );
       bean.setProductLevel01( this.productLevel01 );
       bean.setProductLevel02( this.productLevel02 );
       bean.setProductLevel03( this.productLevel03 );
       String st = IncidentStatus.ST_OPEN.substring( 0, 1 );
       bean.setStatus( st );
       bean.setCreationDate( creationDate );
      
       if ( !this.isValidated()) {

          this.message = "Hay errores en sus datos";

          session.put( "userBean", bean );
          session.put( "recordAction", this.actionID );

          session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );          
          session.put( "rmdyError",     this.remedyFieldError );
          session.put( "titleError",    this.titleFieldError );
          session.put( "notesError",    this.notesFieldError );
          
          // TODO Impact Error
          // TODO Assigned Error
          // TODO Category Errors
          // TODO Product Errors
          
          session.put( "creationError", this.creationFieldError );
          
          return Action.INPUT;
       }
       
       ICIncidentService svc = new CIncidentService();
       this.message = svc.createIncident( bean );              
       List<CriticalIncident> incList = svc.getIncidentList( false );
       session.put( "incidentList", incList );
       session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
       return Action.SUCCESS;
    }
    else
    {
       CriticalIncident bean = new CriticalIncident();
       bean.setCreationDate( Calendar.getInstance().getTime());
       session.put( IGlobalConstants.SESS_CI_BEAN, bean );
       this.resetMessages();
    }
    return Action.INPUT;
  }
    
  //// Metodos a sobrecargar de Struts

  private boolean isValidated() {
    
    // TODO
    return true;
  }

  private void resetMessages() {

    this.message            = IGlobalConstants.EMPTY_STRING;

    this.remedyFieldError   = IGlobalConstants.EMPTY_STRING;
    this.titleFieldError    = IGlobalConstants.EMPTY_STRING;
    this.notesFieldError    = IGlobalConstants.EMPTY_STRING;
    this.creationFieldError = IGlobalConstants.EMPTY_STRING;
    this.closeFieldError    = IGlobalConstants.EMPTY_STRING;
    
    session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
    session.put( "rmdyError",     this.remedyFieldError );
    session.put( "titleError",    this.titleFieldError );
    session.put( "notesError",    this.notesFieldError );
    session.put( "creationError", this.creationFieldError );
  }  
  
  @Override
  public void validate() {
    
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

  //// Validate notes

  public Map<String, Object> getSession() {
    
    return session;
  }
  
  public int getActionID() { 
    
    return actionID;
  }

  public String getIncidentID() {
    
    return incidentID;
  }

  public String getRemedyID() {
    
    return remedyID;
  }

  public String getTitle() {
    
    return title;
  }

  public String getNotes() {
    
    return notes;
  }

  public String getImpact() {
    
    return impact;
  }

  public String getAssignedGroup() {
    
    return assignedGroup;
  }
  
  public String getCategoryLevel01() {
    
    return categoryLevel01;
  }

  public String getCategoryLevel02() {
    
    return categoryLevel02;
  }

  public String getCategoryLevel03() {
    
    return categoryLevel03;
  }

  public String getProductLevel01() {
    
    return productLevel01;
  }

  public String getProductLevel02() {
    
    return productLevel02;
  }

  public String getProductLevel03() {
    
    return productLevel03;
  }
  
  public String getStatus() {
    
    return status;
  }

  public String getCreationDate() {
    
    return creationDate;
  }

  public String getCloseDate() {
    
    return closeDate;
  }

  public String getRemedyFieldError() {
    
    return remedyFieldError;
  }

  public String getTitleFieldError() {
    
    return titleFieldError;
  }

  public String getNotesFieldError() {
    
    return notesFieldError;
  }

  public String getCreationFieldError() {
    
    return creationFieldError;
  }

  public String getCloseFieldError() {
    
    return closeFieldError;
  }
  
  public String getmesssage() { 
    
    return message;
  }

  public void setActionID( int actionID ) {
    
    this.actionID = actionID;
  }

  public void setIncidentID( String incidentID ) {
    
    this.incidentID = incidentID;
  }

  public void setRemedyID( String remedyID ) {
    
    this.remedyID = remedyID;
  }

  public void setTitle( String title ) {
    
    this.title = title;
  }

  public void setNotes( String notes ) {
    
    this.notes = notes;
  }

  public void setImpact( String impact ) {
    
    this.impact = impact;
  }

  public void setAssignedGroup( String assignedGroup ) {
    
    this.assignedGroup = assignedGroup;
  }

  public void setCategoryLevel01( String category ) {
    
    this.categoryLevel01 = category;
  }

  public void setCategoryLevel02( String category ) {
    
    this.categoryLevel02 = category;
  }

  public void setCategoryLevel03( String category ) {
    
    this.categoryLevel03 = category;
  }

  public void setProductLevel01( String product ) {
    
    this.productLevel01 = product;
  }

  public void setProductLevel02( String product ) {
    
    this.productLevel02 = product;
  }

  public void setProductLevel03( String product ) {
    
    this.productLevel03 = product;
  }
  
  public void setStatus( String status ) {
    
    this.status = status;
  }

  public void setCreationDate( String creationDate ) {
    
    this.creationDate = creationDate;
  }

  public void setCloseDate( String closeDate ) {
    
    this.closeDate = closeDate;
  }

  public void setRemedyFieldError( String remedyFieldError ) {
    
    this.remedyFieldError = remedyFieldError;
  }

  public void setTitleFieldError( String titleFieldError ) {
    
    this.titleFieldError = titleFieldError;
  }

  public void setNotesFieldError( String notesFieldError ) {
    
    this.notesFieldError = notesFieldError;
  }

  public void setCreationFieldError( String creationFieldError ) {
    
    this.creationFieldError = creationFieldError;
  }

  public void setCloseFieldError( String closeFieldError ) {
    
    this.closeFieldError = closeFieldError;
  }
  
  public void setMessage( String msg ) { 
    
    this.message = msg;
  }
    
}
