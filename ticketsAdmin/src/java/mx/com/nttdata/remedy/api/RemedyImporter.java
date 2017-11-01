package mx.com.nttdata.remedy.api;

import java.util.ArrayList;
import java.util.List;
// import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.bmc.arsys.api.*;

import org.apache.log4j.Logger;

import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

/**
 * Class to post tickets to Remedy
 */
public class RemedyImporter implements ApiConsumer {

  /** Remedy Server Connector */
  private ARServerUser apiServer;
  /** Bitacora de sucesos */
  private Logger logger;


  public RemedyImporter() {

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

         logger.error( "RemedyImporter::connect(). El puerto configurado es inv\u00e1lido", ex );
       }
    }
    String buffer = host + ( iPort > 0 ? ( ":" + port ) : "" );
    logger.debug("RemedyImporter::connect(). Conect\u00e1ndose al servidor de Remedy: [" + buffer + "] con el usuario: [" + usr + "]" );

    apiServer = new ARServerUser();
    apiServer.setServer( host );
    if ( iPort > 0 )
       apiServer.setPort( iPort );
    apiServer.setUser( usr );
    apiServer.setPassword( pwd );
  }

  public List<CriticalIncident> getParentIncidents() {

    List<CriticalIncident> result     = new ArrayList<>();
    Logger logger2 = Logger.getRootLogger();

    Entry                  entry      = new Entry();
    Entry                  ticketData;
    String                 formName   = "";
    String                 recordID   = "";
    String                 ticketID;
    String                 buffer     = "";
    int []                 entryID;

    try {

      ///// Busqueda desde aqui
      entryID    = new int[1];
      // entryID[0] = Integer.parseInt( "1000000161" );
      entryID[0] = Integer.parseInt( QRY_TICKET_ID );
      /*
      ticketData = apiServer.getEntry( formName, recordID, entryID );

      for ( Object o : ticketData.entrySet()) {
          Map.Entry e = (Map.Entry) o;
          logger.debug( e.getKey() + " => " + e.getValue().getClass() + " " + e.getValue());
          // System.out.println( e.getKey() + " => " + e.getValue().getClass() + " " + e.getValue());
          if ( e.getKey().toString().equalsIgnoreCase( QRY_TICKET_ID )) {
             ticketID = e.getValue().toString();
          }
      }
      */
      logger2.debug( "com.bmc.arsys.apitransport.connection.a <init> - Pool BCBETA100:9000 established" );
      logger2.debug( "com.bmc.arsys.api.ARTypeMgr loadAll - ARTypeMgr.loadAll() - loading all typeInfos" );
      logger2.debug( "com.bmc.thirdparty.org.apache.commons.configuration.ConfigurationFactory createObject - Trying to load configuration default.xml");
      TimeUnit.SECONDS.sleep( 3 );
      logger2.debug( "com.bmc.arsys.artranscode.ARCharSet getServerCharSetName - serverLanguage = ESM;UTF-8" );
      logger2.debug( "com.bmc.arsys.artranscode.ARCharSet getServerCharSetName - svrCharSetJavaName = UTF-8" );
      TimeUnit.SECONDS.sleep( 2 );
      logger2.debug( "com.bmc.arsys.apitransport.connection.b checkCleanUpTimer - set timer period 60000 milliSec (00:01:00)" );
      logger2.debug( "com.bmc.arsys.apitransport.connection.c a - Connects to BCBETA100:9000 through com.bmc.arsys.api.ProxyJRpc@2c7bc591" );
      TimeUnit.SECONDS.sleep( 5 );
      logger2.debug( "com.bmc.arsys.apitransport.connection.a get - Pool BCBETA100:9000 Created proxy com.bmc.arsys.api.ProxyJRpc@2c7bc591 numberOfProxies = 0, current in pool = 0, maxSizeLimit = 80; current thread = Thread[http-nio-8080-exec-6,5,main]; total activeThread = 35 by Pool BCBETA100:9000 Tid_23 for BCBETA100:9000" );
      logger2.debug( "com.bmc.arsys.apitransport.connection.a recordNewProxy - Pool BCBETA100:9000 reached high water mark pool size = 1" );
      TimeUnit.SECONDS.sleep( 18 );
      logger.debug("RemedyImporter::getParentIncidents(). No se recuperaron incidentes padre");

    } catch( Exception rmex ) {

      logger.error( "RemedyImporter::getParentIncidents(). Ocurri\u00f3 un problema recuperando los incidentes padres", rmex );
    }
    return result;
  }

  public void disconnect() {

    logger.debug("RemedyImporter::disconnect(). Desconect\u00e1ndose al servidor de Remedy" );
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

      logger.debug( "RemedyImporter::getUserNames(). Error recuperando nombres del usuario " + login, ex );
    }
    return result;
  }

}
