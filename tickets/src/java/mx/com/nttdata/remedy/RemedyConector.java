package mx.com.nttdata.remedy;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.WorkOrder;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

import mx.com.gentera.helpdesk.incident.HPDIncidentInterfaceCreateWSService;
import mx.com.gentera.helpdesk.incident.HPDIncidentInterfaceCreateWSPortTypePortType;
import mx.com.gentera.helpdesk.incident.ReportedSourceType;
import mx.com.gentera.helpdesk.incident.ServiceTypeType;
import mx.com.gentera.helpdesk.wo.PriorityType;

import mx.com.gentera.helpdesk.wo.WOIWorkOrderInterfaceCreateWSService;
import mx.com.gentera.helpdesk.wo.WOIWorkOrderInterfaceCreateWSPortTypePortType;
import mx.com.gentera.helpdesk.wo.WorkOrderTypeType;
import mx.com.gentera.helpdesk.wo.Z1DCommunicationSourceType;

import mx.com.gentera.people.CTMPeopleGetInfoWSService;
import mx.com.gentera.people.CTMPeopleWSPortTypePortType;

/**
 * Remedy Connection. Notas, faltan campos con defaults con respecto a la defincion original
 * (vease los defaults abajo ) y Priority solo afecta a la requisiciones y source solo 
 * a los incidentes.
 * @version 1.0.0
 */
public class RemedyConector implements RemedyConstants {
 
  private final static PriorityType       DEF_PRIORITY          = PriorityType.LOW;
  private final static ReportedSourceType DEF_REPORTED_SOURCE   = ReportedSourceType.WEB;
  private final static ServiceTypeType    DEF_SERVICE_TYPE      = ServiceTypeType.USER_SERVICE_RESTORATION;
  // Ejemplo de como NO se deben de hacer las cosas, 2 objetos con el mismo nombre en diferentes paquetes 
  // ya que tienen los mismos valores debieron usar uno general o heredar los especificos 
  private final static mx.com.gentera.helpdesk.incident.StatusType 
                                          DEF_INC_STATUS = mx.com.gentera.helpdesk.incident.StatusType.ASSIGNED;
  private final static mx.com.gentera.helpdesk.wo.StatusType       
                                          DEF_WO_STATUS = mx.com.gentera.helpdesk.wo.StatusType.ASSIGNED;
  private final static WorkOrderTypeType  DEF_WORK_ORDER_TYPE   = WorkOrderTypeType.GENERAL;

  
  
  /** Log de la aplicacion */
  private Logger logger;

  private String incidentEndPoint;

  private String woEndPoint;

  private String peopleEndPoint;
  
  private String user;
  
  private String secret;
  
  private boolean soapDebugger; 


  /**
   * Constructor predeterminado 
   */
  public RemedyConector() {

    super();
    this.logger           = Logger.getLogger( this.getClass());
    this.soapDebugger     = Properties.getInt( IGlobalConstants.PROP_SOAP_DEBUG, 0 ) == 1;
    this.incidentEndPoint = Properties.getString( IGlobalConstants.PROP_WSI_URL );
    this.woEndPoint       = Properties.getString( IGlobalConstants.PROP_WSWO_URL );
  }
  
  /**
   * Constructor del conector
   * @param incidentUrl URL del endpoint de Ws de incidentes
   * @param woUrl URL del endpoint de Ws de requisiciones
   * @param user Autentication user if needed
   * @param secret Password user if needed
   */
  public RemedyConector( String incidentUrl, String woUrl, String user, String secret ) {

    super();
    this.logger = Logger.getLogger( this.getClass());
    this.incidentEndPoint = incidentUrl;
    this.woEndPoint = woUrl;
    this.user = user;
    this.secret = secret;
  }

  /**
   * Crea un incident en el web service de Remedy
   * @param bean Detalle a incluir en el incidente 
   * @return El numero de ticket de Remeddy
   * @throws Exception En caso de cualquier problema 
   */
  public String createincident( Incident bean ) throws Exception {

    HPDIncidentInterfaceCreateWSService svc;
    HPDIncidentInterfaceCreateWSPortTypePortType port;
    String ticket    = IGlobalConstants.EMPTY_STRING;
        
    final String u1  = Properties.getString( IGlobalConstants.PROP_WSI_USER );
    final String p1  = Properties.getString( IGlobalConstants.PROP_WSI_PWD );

    Map<String, Object> ctx;
    int timeout = Properties.getInt( IGlobalConstants.PROP_WS_TIMEOUT, -1 );
    
    String firstName = bean.getCustomer();
    String lastName  = DEF_LAST_NAME; 
    Map<String,String> userNames = this.getUserNames( bean.getCustomer(), firstName,  lastName );
    
    firstName = userNames.get( KEY_FIRST_NAME );
    lastName  = userNames.get( KEY_LAST_NAME );
        
    this.printTicket( bean );  
        
    logger.debug("Incidente. Conect\u00e1ndose al servicio: " + this.incidentEndPoint );
    setDebugger( this.soapDebugger );
    try {
      svc   = new HPDIncidentInterfaceCreateWSService( this.incidentEndPoint );            
      logger.debug("Incidente. Agregando Handler");
      svc.setHandlerResolver( new HandlerResolver() {
        
        @Override
        public List<Handler> getHandlerChain( PortInfo portInfo ) {
          
          List<Handler> handlerList = new ArrayList<>();
          handlerList.add( new RemedyHandler( u1, p1 ));
          return handlerList;
        }
        
      });      

      logger.debug("Incidente. Recuperando WS Proxy");
      port  = svc.getHPDIncidentInterfaceCreateWSPortTypeSoap();
      try {
        ctx = ((BindingProvider) port).getRequestContext();
        ctx.put( "javax.xml.ws.client.connectionTimeout", timeout );
        ctx.put( "javax.xml.ws.client.receiveTimeout", timeout );
  
      } catch ( Exception ex ) {
        
        logger.warn( "No se pudo establecer el timeout a: " + timeout, ex );  
      }        
      logger.debug("Incidente. Generando ticket");      
      ticket = port.helpDeskSubmitService(  
          bean.getAssignedGroup(), //  assignedGroup,
          null, //  assignedGroupShiftName,
          bean.getCompanyName(), //  assignedSupportCompany,
          DEF_AS_ORG, //  assignedSupportOrganization, No estaba en la definición original
          null, //  assignee,
          bean.getCategoryLevel01(), //  categorizationTier1,
          bean.getCategoryLevel02(), //  categorizationTier2,
          bean.getCategoryLevel03(), //  categorizationTier3,
          null, //  ciName,
          null, //  closureManufacturer,
          null, //  closureProductCategoryTier1,
          null, //  closureProductCategoryTier2,
          null, //  closureProductCategoryTier3,
          null, //  closureProductModelVersion,
          null, //  closureProductName,
          null, //  department,
          firstName, //  firstName,
          bean.getImpact(), //  impact,
          lastName, //  lastName, Se uso el mismo que en el ejemplo
          null, //  lookupKeyword,
          null, //  manufacturer,
          bean.getProductLevel01(), //  productCategorizationTier1,
          bean.getProductLevel02(), //  productCategorizationTier2,
          bean.getProductLevel03(), //  productCategorizationTier3,
          null, //  productModelVersion,
          null, //  productName,
          DEF_REPORTED_SOURCE, //  reportedSource,
          null, //  resolution,
          null, //  resolutionCategoryTier1,
          null, //  resolutionCategoryTier2,
          null, //  resolutionCategoryTier3,
          DEF_SERVICE_TYPE, //  serviceType,
          DEF_INC_STATUS, //  status,
          bean.getAction(), //  action,
          null, //  createRequest,
          bean.getTitle(), //  summary,
          bean.getNotes(), //  notes,
          bean.getUrgency(), //  urgency,
          null, //  workInfoSummary,
          null, //  workInfoNotes,
          null, //  workInfoType,
          null, //  workInfoDate,
          null, //  workInfoSource,
          null, //  workInfoLocked,
          null, //  workInfoViewAccess,
          null, //  middleInitial,
          null, //  statusReason,
          null, //  directContactFirstName,
          null, //  directContactMiddleInitial,
          null, //  directContactLastName,
          null, //  templateID,
          null, //  serviceCI,
          null, //  serviceCIReconID,
          null, //  hpdCI,
          null, //  hpdCIReconID,
          null, //  hpdCIFormName,
          null, //  workInfoAttachment1Name,
          null, //  workInfoAttachment1Data,
          null, //  workInfoAttachment1OrigSize,
          null, //  loginID,
          null, //  customerCompany,
          null  //  corporateID
      );

    } catch ( Exception ex ) {

      logger.error( "RemedyConector().createincident. Se present\u00f3 un problema creando el incidente." + bean.toString(), ex );      
      throw new Exception("Error generando el ticket para su incidente");
      
    } finally {
        
      setDebugger( false );
    }
    return ticket;
  }

  /**
   * Crea ticket para una requisicion  
   * @param bean Datos generales a usar con el ticket
   * @return
   * @throws Exception 
   */
  public String createWorkOrder( WorkOrder bean ) throws Exception {

    WOIWorkOrderInterfaceCreateWSService svc;
    WOIWorkOrderInterfaceCreateWSPortTypePortType port;
    WorkOrderTypeType workOrderType = DEF_WORK_ORDER_TYPE;
    String ticket = IGlobalConstants.EMPTY_STRING;

    final String u1 = Properties.getString( IGlobalConstants.PROP_WSWO_USER );
    final String p1 = Properties.getString( IGlobalConstants.PROP_WSWO_PWD );

    String firstName = bean.getCustomer();
    String lastName  = DEF_LAST_NAME; 
    
    Map<String,String> userNames = this.getUserNames( bean.getCustomer(), firstName,  lastName );    
    firstName = userNames.get( KEY_FIRST_NAME );
    lastName  = userNames.get( KEY_LAST_NAME );
    this.printTicket( bean );    
    
    logger.debug("WorkOrder. Conect\u00e1ndose al servicio: " + this.woEndPoint );
    setDebugger( this.soapDebugger );
    
    try {
      svc  = new WOIWorkOrderInterfaceCreateWSService( this.woEndPoint );
      logger.debug("WorkOrder. Agregando Handler");
      svc.setHandlerResolver( new HandlerResolver() {
        
        @Override
        public List<Handler> getHandlerChain( PortInfo portInfo ) {
          
          List<Handler> handlerList = new ArrayList<>();
          handlerList.add( new RemedyHandler( u1, p1 ));
          return handlerList;
        }
        
      });
      
      Holder<String> holder = new Holder<>();
      holder.value          = "";
      
      logger.debug("WorkOrder. Recuperando WS Proxy");
      port = svc.getWOIWorkOrderInterfaceCreateWSPortTypeSoap();
      logger.debug("WorkOrder. Generando ticket");
      port.workOrderSubmitService(
          bean.getLastName(), //  submitter,
          null, //  assignedTo,
          DEF_WO_STATUS, //  status,
          bean.getTitle(), //  shortDescription,
          null, //  assigneeGroups,
          null, //  instanceId,
          null, //  vendorAssigneeGroups,
          null, //  z1GGlobalASTProductionDataSetID,
          null, //  department,
          null, //  siteGroup,
          null, //  region,
          null, //  ciName,
          null, //  schemaName,
          null, //  lookupKeyword,
          null, //  site,
          null, //  woTypeField01,
          null, //  woTypeField02,
          null, //  woTypeField03,
          null, //  woTypeField04,
          null, //  woTypeField05,
          null, //  woTypeField06,
          null, //  woTypeField07,
          null, //  woTypeField08,
          null, //  woTypeField09,
          null, //  templateName,
          null, //  attachmentAttachmentName,
          null, //  attachmentAttachmentData,
          null, //  attachmentAttachmentOrigSize,
          null, //  customerMiddleName,
          null, //  command,
          null, //  z1DWorklogDetails,
          null, //  srInstanceID,
          null, //  zTmpEventGUID,
          null, //  customerFullName,
          null, //  z1DSummary,
          null, //  z1DDetails,
          null, //  secureWorkLog,
          null, //  z1DViewAccess,
          null, //  z2AFActAttachment1AttachmentName,
          null, //  z2AFActAttachment1AttachmentData,
          null, //  z2AFActAttachment1AttachmentOrigSize,
          null, //  z2AFActAttachment2AttachmentName,
          null, //  z2AFActAttachment2AttachmentData,
          null, //  z2AFActAttachment2AttachmentOrigSize,
          null, //  z2AFActAttachment3AttachmentName,
          null, //  z2AFActAttachment3AttachmentData,
          null, //  z2AFActAttachment3AttachmentOrigSize,
          bean.getStatusReason(), //  statusReasonString,
          null, //  assignmentAcceleratorAssignee,
          null, //  setManagerUsing,
          null, //  srmsRegistryInstanceID,
          null, //  srmsaoiGuid,
          null, //  srid,
          null, //  headline,
          null, //  templateID,
          bean.getCustomer(), //  requesterLoginID,
          null, //  statusString,
          Z1DCommunicationSourceType.WEB, //  z1DCommunicationSource,
          null, //  z1DActivityDateTab,
          null, //  createdFromFlag,
          null, //  z1DSRMCommand,
          null, //  customCFGFormInstanceId,
          null, //  customRecordInstanceId,
          null, //  clientLocale,
          null, //  woTypeField10,
          null, //  woTypeField11,
          null, //  woTypeField12,
          null, //  woTypeField13,
          null, //  woTypeField14,
          null, //  woTypeField15,
          null, //  woTypeField16,
          null, //  woTypeField17,
          null, //  woTypeField18,
          null, //  woTypeField19,
          null, //  woTypeField20,
          null, //  woTypeField21,
          null, //  woTypeField22,
          null, //  woTypeField23,
          null, //  woTypeField24,
          null, //  woTypeField25,
          null, //  woTypeField26,
          null, //  woTypeField27,
          null, //  woTypeField28,
          null, //  woTypeField29,
          null, //  woTypeField30,
          null, //  woTypeField10Label,
          null, //  woTypeField11Label,
          null, //  woTypeField12Label,
          null, //  woTypeField13Label,
          null, //  woTypeField14Label,
          null, //  woTypeField15Label,
          null, //  woTypeField16Label,
          null, //  woTypeField17Label,
          null, //  woTypeField18Label,
          null, //  woTypeField19Label,
          null, //  woTypeField20Label,
          null, //  woTypeField21Label,
          null, //  woTypeField22Label,
          null, //  woTypeField23Label,
          null, //  woTypeField24Label,
          null, //  woTypeField25Label,
          null, //  woTypeField26Label,
          null, //  woTypeField27Label,
          null, //  woTypeField28Label,
          null, //  woTypeField29Label,
          null, //  woTypeField30Label,
          null, //  srWorkInfoType,
          null, //  z1DConfirmGroup,
          null, //  createdFromBackEndSynchWI,
          null, //  woTypeField48,
          null, //  woTypeField49,
          null, //  woTypeField50,
          null, //  woTypeField51,
          null, //  woTypeField48Label,
          null, //  woTypeField49Label,
          null, //  woTypeField50Label,
          null, //  woTypeField51Label,
          null, //  workOrderTemplateInstanceID,
          null, //  woTypeField01Label,
          null, //  woTypeField02Label,
          null, //  woTypeField03Label,
          null, //  woTypeField04Label,
          null, //  woTypeField05Label,
          null, //  woTypeField06Label,
          null, //  woTypeField07Label,
          null, //  woTypeField08Label,
          null, //  woTypeField09Label,
          null, //  datasetId,
          null, //  reconciliationIdentity,
          bean.getTitle(), //  summary,
          null, //  locationCompany,
          null, //  organization,
          null, //  managerSupportOrganization,
          bean.getManagementGroup(), //  managerSupportGroupName,
          lastName, //  lastName,
          firstName, //  firstName,
          null, //  middleInitial,
          null, //  vip,
          null, //  contactSensitivity,
          null, //  chgLocationAddress,
          null, //  internetEMail,
          null, //  phoneNumber,
          null, //  z1DChar01,
          bean.getCategoryLevel01(), //  categorizationTier1,
          bean.getCategoryLevel02(), //  categorizationTier2,
          bean.getCategoryLevel03(), //  categorizationTier3,
          bean.getAction(), //  z1DAction,
          null, //  z1DInteger01,
          bean.getPersonID(), //  personID,
          bean.getCompanyName(), //  company,
          null, //  addRequestFor,
          null, //  z1DInteger02,
          null, //  z1DInteger03,
          null, //  z1DChar10,
          null, //  statusReason, // TODO bean.getStatusReason()
          bean.getNotes(), //  detailedDescription,
          // TODO 
          DEF_PRIORITY, //  priority,
          workOrderType, //  workOrderType,
          //// Se supone que regresa el valor aqui, en la practica no funciona
          holder, //  workOrderID,
          null, //  requestManagerCompany,
          bean.getSupportGroup(), //  requesterSupportOrganization,
          null, //  requestManager,
          null, //  cabManagerLogin,
          null, //  viewAccess,
          null, //  z1DStatusReason,
          null, //  requestedByPersonID,
          bean.getProductLevel01(), //  productCatTier12,
          bean.getProductLevel02(), //  productCatTier22,
          bean.getProductLevel03(), //  productCatTier32,
          null, //  secureWorkLog2,
          null, //  z1DPermissionGroupID,
          null, //  productName2,
          null, //  productModelVersion2,
          null, //  manufacturer2,
          null, //  workOrderEntryID,
          bean.getSupportGroup(), //  supportOrganization,
          bean.getCompanyName(), //  supportCompany,
          bean.getSupportGroup(), //  supportGroupName,
          null, //  requestAssignee,
          null, //  customerPersonID,
          firstName, //  customerFirstName,
          lastName, //  customerLastName,
          bean.getCompanyName(), //  customerCompany,
          bean.getCompanyName(), //  customerOrganization,
          null, //  customerDepartment,
          null, //  customerInternetEMail,
          null  //  customerPhoneNumber
      );
      ticket = holder.value;
      
    } catch ( Exception ex ) {

      logger.error( "RemedyConector().createWorkOrder. Se present\u00f3 un problema creando la requisici\u00f3n." + bean.toString(), ex );      
      throw new Exception("Error generando el ticket para su requisici\u00fen");
      
    } finally {
        
      setDebugger( false );
    }
    return ticket;
  }
  
  /**
   * Pide a un servicio web ligado a Remedy el usuario y devuelve los nombres de este 
   * @param login Usuario de LDAP con el que se inicio sesion
   * @param defFirstName Nombre a usar en caso de no poder recuperar el del usuario
   * @param defLastName Apellido a usar en caso de no poder recuperar el del usuario
   * @return Un mapa con los valoes recuperados o en su defecto los predeterminados
   */
  public Map<String,String> getUserNames( String login, String defFirstName, String defLastName ) { 

    Map<String,String> result   = new HashMap<>();      
    Map<String,String> resultEx = new HashMap<>();
    
    resultEx.put( KEY_FIRST_NAME, defFirstName );
    resultEx.put( KEY_LAST_NAME, defLastName );
    
    // final String u1 = Properties.getString( IGlobalConstants.PROP_WSWO_USER );
    // final String p1 = Properties.getString( IGlobalConstants.PROP_WSWO_PWD );
    
    logger.debug("getUserNames. Conect\u00e1ndose al servicio: " + this.peopleEndPoint );
    setDebugger( this.soapDebugger );
    
    try { 
      RemedyDataSearcher ds = new RemedyDataSearcher();
      result                = ds.getCustomerInfo( login );
      return result;
            
    } catch ( Exception ex ) {
       
      logger.debug("RemedyConnector.getUserNames(). Error consultando el nombre y apellidos del usuario '" +
                   login + "':\n", ex );
    } 
    return resultEx;
  }
  
  public void printTicket( ITicket ticket ) { 
      
    try {        
      logger.debug("RemedyConnector.printTicket(). Datos del Ticket a crear:\n" +
                   ticket.toString());
      
    } catch ( Exception ex ) {
        
      logger.debug("RemedyConnector.printTicket(). Error imprimiendo los datos del ticket", ex );
    }
  }
  
  public void setDebugger() {
      
    this.setDebugger( this.soapDebugger );
  }

  public void setDebugger( boolean debug) {
      
    String mode = debug ? "true" : "false";  
    System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", mode );
    System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", mode );
    System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", mode );
    System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", mode );  
  }
  
  //// Getters y setters 

  public String getUser() {
    
    return user;
  }

  public String getSecret() {
    
    return secret;
  }

  public boolean getSoapDebugger() {
      
    return this.soapDebugger;      
  }
  
  public void setUser(String user) {
    
    this.user = user;
  }

  public void setSecret(String secret) {
    
    this.secret = secret;
  }
  
  public void setSoapDebugger( boolean debug ) {
      
    this.soapDebugger = debug;      
  }
  
}
