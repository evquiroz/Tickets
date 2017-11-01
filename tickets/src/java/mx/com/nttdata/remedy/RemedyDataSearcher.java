package mx.com.nttdata.remedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.PortInfo;

import org.apache.log4j.Logger;

import mx.com.gentera.people.CTMPeopleGetInfoWSService;
import mx.com.gentera.people.CTMPeopleWSPortTypePortType;
import mx.com.gentera.people.OutputMapping3.GetListValues;

import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

/**
 * Recupera informacion de LDAP para un usuario
 * @version 1.0.0
 */
public class RemedyDataSearcher implements RemedyConstants {
        
  private final static String SEACH_FOR    = "'Corporate ID' = \"##LOGIN##\"";
  private final static String LOGIN_MASKER = "##LOGIN##";
  private final static String START_VALUE  = "0"; 
  private final static String LIMIT_VALUE  = "20";
        
  private Logger logger;
  
  private String url;
  private String svcUser;
  private String svcSecret;
  
  public RemedyDataSearcher() { 
  
    super();
    this.logger     = Logger.getLogger( this.getClass());
    this.url        = Properties.getString( IGlobalConstants.PROP_PEOPLE_URL );
    this.svcUser    = Properties.getString( IGlobalConstants.PROP_PEOPLE_USER );
    this.svcSecret  = Properties.getString( IGlobalConstants.PROP_PEOPLE_PWD );
  }
  
  @SuppressWarnings("null")
  public Map<String,String> getCustomerInfo( String customer ) { 

    Map<String,String> result = new HashMap<>();
    String eMail     = Properties.getString( "mail.fakeTo" );
    @SuppressWarnings("UnusedAssignment")
    String eMailRead = null;
    String firstName = "";
    String lastName  = "";
    String             startNode = Properties.getString( IGlobalConstants.PROP_LDAP_BRANCH );
    String             limit     = Properties.getString( IGlobalConstants.PROP_LDAP_GROUP );
    List<GetListValues> values;
    int cnt;
    String qualification = SEACH_FOR.replaceAll( LOGIN_MASKER, customer );
    
    final String u1 = Properties.getString( IGlobalConstants.PROP_WSWO_USER );
    final String p1 = Properties.getString( IGlobalConstants.PROP_WSWO_PWD );    
    
    try {
      CTMPeopleGetInfoWSService svc = new CTMPeopleGetInfoWSService( this.url );  
      logger.debug("Busqueda de usuarios. Agregando Handler");
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
        
      CTMPeopleWSPortTypePortType port = this.getPeopleServicePort();
                    
      logger.debug("RemedyDataSearcher.getCustomerMail(). Recuperando correo del login: " + customer );
      logger.debug("RemedyDataSearcher.getCustomerMail(). Qualification: [" + qualification + "]");
      values = port.ctmGetPeopleInfo( qualification, START_VALUE, LIMIT_VALUE );      
      cnt    = ( values != null ) ? values.size() : 0 ;
      logger.debug("RemedyDataSearcher.getCustomerMail(). conjuntos de datos recuperados " + cnt );
      
      if ( cnt > 0 ) { 
         eMailRead = values.get( 1 ).getCorreoElectronico();
         firstName = values.get( 1 ).getNombreS();
         lastName  = values.get( 1 ).getApellidoS();
         if ( eMailRead != null && !eMailRead.isEmpty())
            eMail = eMailRead; 
      }   
      result.put( KEY_EMAIL,      eMail );
      result.put( KEY_FIRST_NAME, firstName );
      result.put( KEY_LAST_NAME,  lastName );
      
    } catch ( Exception ex ) { 
    
      logger.error( "RemedyAutenticator.getCustomerMail(). No se puede conectar al servicio", ex );
    }
    return result;
  }
  
  public CTMPeopleWSPortTypePortType getPeopleServicePort() throws Exception { 
    
    CTMPeopleGetInfoWSService   svc;
    final String u1 = this.svcUser;
    final String p1 = this.svcSecret;
    Map<String, Object> ctx;
    int timeout = Properties.getInt( IGlobalConstants.PROP_WS_TIMEOUT, -1 );
    
    logger.debug("RemedyDataSearcher.getPeopleServicePort(). Conect\u00e1ndose al servicio");
    try {
      svc = new CTMPeopleGetInfoWSService( this.url );
      logger.debug("RemedyDataSearcher.getPeopleServicePort(). Obteniendo WS Procy");
      svc.setHandlerResolver( new HandlerResolver() {
        
        @Override  
        public List<Handler> getHandlerChain( PortInfo portInfo ) {
          
          List<Handler> handlerList = new ArrayList<>();
          handlerList.add( new RemedyHandler( u1, p1 ));
          return handlerList;
        }        
      });      
      CTMPeopleWSPortTypePortType port = svc.getCTMPeopleWSPortTypeSoap();
      try {
        ctx = ((BindingProvider) port).getRequestContext();
        ctx.put( "javax.xml.ws.client.connectionTimeout", timeout );
        ctx.put( "javax.xml.ws.client.receiveTimeout", timeout );
  
      } catch ( Exception ex ) {
        
        logger.warn( "No se pudo establecer el timeout a: " + timeout, ex );  
      }        
      return port;
            
    } catch ( Exception ex ) {

      logger.error( "RemedyAutenticator.getPeopleServicePort(). No se puede conectar al servicio", ex );
      throw new Exception("Ocurri\u00f3 un error conectandose al servicio de autenticaci\u00f3n");
    }
  }
  
}
