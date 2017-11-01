package mx.com.nttdata.remedy.api;

import java.util.List;
import java.util.Map;

import com.bmc.arsys.api.*;

import org.apache.log4j.Logger;

import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.WorkOrder;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

/**
 * Class to post tickets to Remedy
 */
public class RemedyConsumer implements ApiConsumer {

  /** Remedy Server Connector */
  private ARServerUser apiServer;
  /** Bitacora de sucesos */
  private Logger logger;
  

  public RemedyConsumer() {
    
    logger = Logger.getLogger( this.getClass());        
  }
  
  public void connect() { 
      
    String host  = Properties.getString( IGlobalConstants.PROP_BMCAPI_HOST );
    String port  = Properties.getString( IGlobalConstants.PROP_BMCAPI_PORT );
    int    iPort = 0;
    String usr   = Properties.getString( IGlobalConstants.PROP_BMCAPI_USER );
    String pwd   = Properties.getString( IGlobalConstants.PROP_BMCAPI_PWD );
        
    if ( port != null && !port.isEmpty()) { 
       try {
         iPort = Integer.parseInt( port );
         
       } catch ( Exception ex ) {
         
         logger.error( "RemedyCustomer::connect(). El puerto configurado es inv\u00e1lido", ex );
       }
    }
    String buffer = host + ( iPort > 0 ? ( ":" + port ) : "" );
    logger.debug("RemedyCustomer::connect(). Conect\u00e1ndose al servidor de Remedy: [" + buffer + "] con el usuario: [" + usr + "]" );
    
    apiServer = new ARServerUser();
    apiServer.setServer( host );
    if ( iPort > 0 )
       apiServer.setPort( iPort );
    apiServer.setUser( usr );
    apiServer.setPassword( pwd );      
  }
  
  public String createTicket( ITicket bean, String submitter ) {
      
    String ticketID = "";
    String formName = bean instanceof Incident ? FORM_INCIDENT : FORM_WORKORDER;
    
    try {         
      logger.debug( "RemedyCustomer::createTicket(). Detalles del ticket:\n" + bean.toString());
        
    } catch ( Exception ex ) {
      
      logger.error( "RemedyCustomer::createTicket(). Ocurri\u00f3 un problema imprimiendo los detalles del ticket", ex );
    }

    Entry  entry          = new Entry();
    String lastName       = LAST_NAME;
    String firstName      = bean.getCustomer();
    String fullName;
    
    String buffer;
    String supportCompany = "Servicios";
    String supportOrg     = "BACK-END";
    String supportGroup   = "Mesa de servicio";
    String recordID;
    int [] entryID;
    Entry  ticketData;
    
    bean.setSupportGroup( supportGroup );

    try {

      buffer = this.getUserNames( bean.getCustomer());
      if (( buffer != null && !buffer.isEmpty()) && buffer.indexOf( NAMES_SEPARATOR ) > 0 ) {
          
         lastName  = buffer.substring( 0, buffer.indexOf( NAMES_SEPARATOR ));
         firstName = buffer.substring( buffer.indexOf( NAMES_SEPARATOR ) + 1 );
      }
      fullName = firstName + " " + lastName;
             
      entry.put( Constants.AR_CORE_SUBMITTER, new Value( submitter ));
      entry.put( Constants.AR_CORE_ASSIGNED_TO, new Value( bean.getCompanyName())); 
      
      entry.put( REM_SUMMARY,      new Value( bean.getTitle()));
      entry.put( REM_DESCRIPTION,  new Value( bean.getNotes()));      
      
      if ( bean instanceof Incident )
      { 
         Incident iBean = (Incident) bean;
         entry.put( INC_FIRST_NAME,      new Value( firstName ));
         entry.put( INC_LAST_NAME,       new Value( lastName ));
         
         entry.put( INC_SUP_COMPANY,     new Value( supportCompany  ));
         entry.put( INC_SUPP_ORG,        new Value( supportOrg )); // INC_SUPPORT_ORG
         entry.put( INC_ASSIGNED_GROUP,  new Value( supportGroup )); // iBean.getAssignedGroup()
         
         entry.put( INC_IMPACT,          new Value( RemedyConverter.convertImpact( iBean.getImpact()), DataType.ENUM ));
         entry.put( INC_URGENCY,         new Value( RemedyConverter.convertUrgency( iBean.getUrgency()), DataType.ENUM ));
         entry.put( INC_SERVICE_TYPE,    new Value( RemedyConverter.convertServiceType( iBean.getServiceType()), DataType.ENUM )); 
         entry.put( INC_SOURCE,          new Value( INC_SOURCE_VALUE ));
         entry.put( INC_PROD_CAT_TIER_1, new Value( iBean.getProductLevel01()));
         entry.put( INC_PROD_CAT_TIER_2, new Value( iBean.getProductLevel02()));
         entry.put( INC_PROD_CAT_TIER_3, new Value( iBean.getProductLevel03()));
      }
      else
      {
         WorkOrder iOrder = (WorkOrder) bean;
       
         entry.put( WO_CONTACT_COMPANY,  new Value( iOrder.getCompanyName()));
         entry.put( WO_FIRST_NAME,       new Value( firstName ));
         entry.put( WO_LAST_NAME,        new Value( lastName ));
         
         entry.put( WO_SUP_COMPANY,      new Value( supportCompany.toUpperCase())); // iOrder.getCompanyName())
         entry.put( WO_SUPP_ORG,         new Value( supportOrg.toUpperCase())); // INC_SUPPORT_ORG         
         entry.put( WO_ASSIGNED_GROUP,   new Value( supportGroup.toUpperCase())); //
         
         entry.put( WO_PRIORITY,         new Value( RemedyConverter.convertPriority( iOrder.getPriority())));
         entry.put( WO_TYPE,             new Value( RemedyConverter.convertOrderType( iOrder.getOrderType())));
         entry.put( WO_PROD_CAT_TIER_1,  new Value( iOrder.getProductLevel01()));
         entry.put( WO_PROD_CAT_TIER_2,  new Value( iOrder.getProductLevel02()));
         entry.put( WO_PROD_CAT_TIER_3,  new Value( iOrder.getProductLevel03()));
         entry.put( WO_LOCATION_COMPANY, new Value( iOrder.getCompanyName()));
         entry.put( WO_PETITION_MGR,     new Value( WO_PET_MGR_NAME ));
         entry.put( WO_ASSIGNED_USER,    new Value( fullName ));
         
         entry.put( WO_CUST_COMPANY,     new Value( iOrder.getCompanyName()));
         entry.put( WO_CUST_FIRST_NAME,  new Value( firstName ));
         entry.put( WO_CUST_LAST_NAME,   new Value( lastName ));         
         // entry.put( INC_SUPP_ORG,        new Value( supportGroup )); // INC_SUPPORT_ORG

         entry.put( WO_REQ_MGR_ID,       new Value( WO_REQ_MGR_NAME ));
         
         logger.debug( "#### Petitiion Manager:     [" + WO_PET_MGR_NAME + "]" );
         logger.debug( "#### Request Manager:       [" + WO_REQ_MGR_NAME + "]" );
      }
      logger.debug( "#### Customer First Name:  [" + firstName + "]" );
      logger.debug( "#### Customer Last Name:   [" + lastName  + "]" );
      logger.debug( "#### Support Company:      [" + supportCompany.toUpperCase() + "]" );
      logger.debug( "#### Support Organization: [" + supportOrg.toUpperCase() + "]" );
      logger.debug( "#### Support Group:        [" + supportGroup.toUpperCase() + "]" );
            
      entry.put( REM_CAT_TIER_1,   new Value( bean.getCategoryLevel01()));
      entry.put( REM_CAT_TIER_2,   new Value( bean.getCategoryLevel02()));
      entry.put( REM_CAT_TIER_3,   new Value( bean.getCategoryLevel03()));
      
      entry.put( REM_ACTION,       new Value( TICKET_ACTION ));
      entry.put( REM_STATUS,       new Value( RemedyConverter.convertStatus( bean.getStatus()), DataType.ENUM ));

      logger.debug( "#### Category Level 01:    [" + bean.getCategoryLevel01() + "]" );
      logger.debug( "#### Category Level 02:    [" + bean.getCategoryLevel02() + "]" );
      logger.debug( "#### Category Level 03:    [" + bean.getCategoryLevel03() + "]" );

      logger.debug( "#### Product Level 01:     [" + bean.getProductLevel01() + "]" );
      logger.debug( "#### Product Level 02:     [" + bean.getProductLevel02() + "]" );
      logger.debug( "#### Product Level 03:     [" + bean.getProductLevel03() + "]" );
      
      recordID   = apiServer.createEntry( formName, entry );
      logger.debug( "#-#-# Record ID del " + ( bean instanceof Incident ? "incidente" : "requisici\u00f3n" ) + 
                    " : [" + recordID + "]" );
      
      entryID    = new int[1];
      // entryID[0] = Integer.parseInt( "1000000161" );
      entryID[0] = Integer.parseInt( QRY_TICKET_ID );      
      ticketData = apiServer.getEntry( formName, recordID, entryID );
            
      for ( Object o : ticketData.entrySet()) {
          Map.Entry e = (Map.Entry) o;             
          logger.debug( e.getKey() + " => " + e.getValue().getClass() + " " + e.getValue());
          // System.out.println( e.getKey() + " => " + e.getValue().getClass() + " " + e.getValue());
          if ( e.getKey().toString().equalsIgnoreCase( QRY_TICKET_ID )) {
             ticketID = e.getValue().toString();
          }
      }
            
      if ( ticketID == null || ticketID.isEmpty())    
         throw new Exception("No se encontr\u00F3 el n\u00famero de ticket v\u00e1lido para el registro: " + recordID );
      logger.debug( "#-#-# No. Ticket generado para " + ( bean instanceof Incident ? "incidente" : "requisici\u00f3n" ) + 
                    " : [" + ticketID + "]" );
             
    } catch( Exception rmex ) {
      
      logger.error( "RemedyCustomer::createTicket(). Ocurri\u00f3 un problema regitrando el ticket", rmex );
    }
    return ticketID;
  }
  
  public void disconnect() { 
      
    logger.debug("RemedyCustomer::disconnect(). Desconect\u00e1ndose al servidor de Remedy" );
    apiServer.logout();
  }
  
  public String getUserNames( String login ) throws Exception { 
      
    String query  = QRY_QUALIFIER.replaceAll( QRY_LOGIN_TAG, login );
    String result = "";
    Value  value;
    
    try { 
      QualifierInfo qual = apiServer.parseQualification( FORM_QUERY, query );
      List<EntryListInfo> eListInfos = apiServer.getListEntry( FORM_QUERY, qual, 0, 0, null, null, false, null); 
      
      for ( EntryListInfo eListInfo : eListInfos ) { 
          
          Entry record = apiServer.getEntry( QRY_SCHEMA, eListInfo.getEntryID(), null ); 
          if ( record.containsKey( QRY_LAST_NAME )) { 
              
             value   = record.get( QRY_LAST_NAME );
             result  = value.toString() + ",";
             value   = record.get( QRY_FIRST_NAME );
             result += value.toString();
             break;
          }             
      } 
      
    } catch ( Exception ex ) { 

      logger.debug( "RemedyConsumer::getUserNames(). Error recuperando nombres del usuario " + login, ex );
    }         
    return result;
  }
    
}
