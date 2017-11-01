package mx.com.nttdata.web.actions;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.WorkOrder;
import mx.com.nttdata.service.ITicketService;
import mx.com.nttdata.service.TicketService;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Messages;


/**
 * Accion que administra el procesamiento de tickets (incidencias/requerimientos)
 * de la aplicacion
 * @version 1.0.0
 */
public class TicketAction extends ActionSupport implements SessionAware  {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 2054321651053156100L;

  /** Logger de la aplicacion */
  private Logger logger = Logger.getLogger( this.getClass());

  /** Variables de la sesion */
  private Map<String,Object> session;

  private String ticketID;
  private int    ticketType;
  private String remedyID;
  private String companyName;
  private String customer;
  private String urgency;
  private String priority;
  private String lastname;
  private String personID;
  private String remedyAction;
  private String source;
  private String title;
  private String notes;
  private String impact;
  private String orderType;
  private String serviceType;
  private String assignedGroup;
  private String mngmtGroup;
  private String supportGroup;
  private String status;
  private String reason;
  private String categoryLevel01;
  private String categoryLevel02;
  private String categoryLevel03;
  private String productLevel01;
  private String productLevel02;
  private String productLevel03;

  private String titleFieldErrror;
  private String notesFieldErrror;
  private String message;


  public String addTicket() throws Exception {

    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }

    if (( title == null || title.isEmpty()) || ( notes == null || notes.isEmpty())) {
       
       return Action.INPUT;
    }

    // todo Validar todos los campos aqui

    ITicket bean = ( this.ticketType == IGlobalConstants.TICKET_INCIDENT
                                     ? new Incident() : new WorkOrder());
    bean.setCompanyName( companyName );
    bean.setCustomer( customer );
    bean.setTitle( title );
    bean.setNotes( notes );

    bean.setPriority( priority );
    bean.setSource( source );

    bean.setSupportGroup( supportGroup );
    bean.setStatus( status );
    bean.setReason( reason );
    bean.setPersonID( personID );
    bean.setAction( remedyAction );
    bean.setLastName( lastname );
    
    bean.setCategoryLevel01( categoryLevel01 );
    bean.setCategoryLevel02( categoryLevel02 );
    bean.setCategoryLevel03( categoryLevel03 );

    bean.setProductLevel01( productLevel01 );
    bean.setProductLevel02( productLevel02 );
    bean.setProductLevel03( productLevel03 );

    if ( this.ticketType == IGlobalConstants.TICKET_INCIDENT )
    {
       ((Incident) bean).setImpact( impact );
       ((Incident) bean).setUrgency( urgency );
       ((Incident) bean).setServiceType( serviceType );
       ((Incident) bean).setAssignedGroup( assignedGroup );
    }
    else
    {
       ((WorkOrder) bean).setOrderType( orderType );
       ((WorkOrder) bean).setManagementGroup( mngmtGroup );
       ((WorkOrder) bean).setStatusReason( reason );
    }

    ITicketService svc = new TicketService();
    String rID = svc.createTicket( ticketType, bean );

    if ( rID != null && !rID.isEmpty())
    {
       this.remedyID = rID;
       return Action.SUCCESS;
    }
    else
    {
       this.message = Messages.getMessage( IGlobalConstants.POST_ERROR_MSG );
       session.put( IGlobalConstants.SESS_ERROR_MSG, this.message );
       return Action.ERROR;
    }
  }

  //// Metodos a sobrecargar de Struts

  @Override
  public void validate() {

    session.remove( IGlobalConstants.SESS_ERROR_MSG );
    session.remove( IGlobalConstants.SESS_ERROR_LOGIN );
    session.remove( IGlobalConstants.SESS_ERROR_SECRET );

    this.validateTitle();
    this.validateNotes();
  }

  /**
   * Valida que el resumen no este vacio
   * @return Nada si es valido, un mensaje de error si no cumple con los requisitos
   */
  public final String validateTitle() {

    if ( this.title == null || this.title.isEmpty())
       return Messages.getMessage( IGlobalConstants.TITLE_REQUIRED_MSG );
    return null;
  }

  /**
   * Valida que las notas no esten vacias
   * @return Nada si es valido, un mensaje de error si no cumple con los requisitos
   */
  public final String validateNotes() {

    if ( this.notes == null || this.notes.isEmpty())
       return Messages.getMessage( IGlobalConstants.NOTES_REQUIRED_MSG );
    return null;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }

  //// Getters y setters

  public String getTicketID() {

    return ticketID;
  }

  public int getTicketType() {

    return ticketType;
  }

  public String getRemedyID() {

    return this.remedyID;
  }

  public String getCompanyName() {

    return companyName;
  }

  public String getCustomer() {

    return customer;
  }

  public String getUrgency() {

    return urgency;
  }

  public String getPriority() {

    return priority;
  }

  public String getSource() {

    return source;
  }

  public String getLastName() {
	  
    return lastname;
  }
  
  public String getPersonID() {

    return personID;
  }
	  
  public String getRemedyAction() {
	  
    return remedyAction; 
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

  public String getOrderType() {

    return orderType;
  }
  
  public String getServiceType() {
    
    return serviceType;
  }

  public String getAssignedGroup() {

    return assignedGroup;
  }

  public String getMngmtGroup() {

    return mngmtGroup;
  }

  public String getSupportGroup() {

    return supportGroup;
  }

  public String getStatus() {

    return status;
  }

  public String getReason() {

    return reason;
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

  public String getTitleFieldErrror() {

    return titleFieldErrror;
  }

  public String getNotesFieldErrror() {

    return notesFieldErrror;
  }

  public String getMessage() {

    return message;
  }

  public void setTicketID( String id ) {

    this.ticketID = id;
  }

  public void setTicketType( int ticketType ) {

    this.ticketType = ticketType;
  }

  public void setRemedyID( String id ) {

    this.remedyID = id;
  }

  public void setCompanyName( String companyName ) {

    this.companyName = companyName;
  }

  public void setCustomer( String customer ) {

    this.customer = customer;
  }

  public void setUrgency( String urgency ) {

    this.urgency = urgency;
  }

  public void setPriority( String priority ) {

    this.priority = priority;
  }

  public void setSource( String source ) {

    this.source = source;
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

  public void setLastName( String lastname ) {
	  
    this.lastname = lastname;
  }
  
  public void setPersonID( String id ) {
	  
    this.personID = id;
  }
	  
  public void setRemedyAction( String remedyAction ) {
	  
    this.remedyAction = remedyAction;
  }
  
  public void setOrderType( String orderType ) {

    this.orderType = orderType;
  }
  
  public void setServiceType( String serviceType ) {
      
    this.serviceType = serviceType;
  }

  public void setAssignedGroup( String group ) {

    this.assignedGroup = group;
  }

  public void setMngmtGroup( String group ) {

    this.mngmtGroup = group;
  }

  public void setSupportGroup( String group ) {

    this.supportGroup = group;
  }

  public void setStatus( String status ) {

    this.status = status;
  }

  public void setReason( String reason ) {

    this.reason = reason;
  }

  public void setCategoryLevel01( String categoryLevel01 ) {

    this.categoryLevel01 = categoryLevel01;
  }

  public void setCategoryLevel02( String categoryLevel02 ) {

    this.categoryLevel02 = categoryLevel02;
  }

  public void setCategoryLevel03( String categoryLevel03 ) {

    this.categoryLevel03 = categoryLevel03;
  }

  public void setProductLevel01( String productLevel01 ) {

    this.productLevel01 = productLevel01;
  }

  public void setProductLevel02( String productLevel02 ) {

    this.productLevel02 = productLevel02;
  }

  public void setProductLevel03( String productLevel03 ) {

    this.productLevel03 = productLevel03;
  }

  public void setTitleFieldErrror( String titleFieldErrror ) {

    this.titleFieldErrror = titleFieldErrror;
  }

  public void setNotesFieldErrror( String notesFieldErrror ) {

    this.notesFieldErrror = notesFieldErrror;
  }

  public void setMessage( String message ) {

    this.message = message;
  }

}
