
package mx.com.nttdata.service;

import java.util.ArrayList;
import java.util.List;

import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.dao.ICriticalDAO;
import mx.com.nttdata.dao.CriticalDAO;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

import org.apache.log4j.Logger;

/**
 * Servicio que adminitra los incidentes criticos
 * @version 1.0.0
 */
public class CIncidentService implements ICIncidentService {

  /** Log de la aplicacion */
  private static Logger logger;

  /** Comunicacion a la base detos para recuperacion de mensjes */
  private ICriticalDAO dao;

  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;
  
  
  /**
   * Constructor predeterminado
   */
  public CIncidentService() {

    logger = Logger.getLogger( this.getClass());
    dsName = Properties.getString( IGlobalConstants.PROP_DS_NAME );
    cfName = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );

    try {
      ConnectionFactory cf = new ConnectionFactory();
      this.dao             = new CriticalDAO( cf.getDataSource( dsName, cfName ));

    } catch ( Exception ex ) {

      logger.error( "CIncidentService(). Ocurri\u00fe un problema conect\u00e1ndose a la base de datos ", ex  );
    }
  }

  @Override
  public String closeIncident( Integer incidentID ) {
    
    try {
      this.dao.closeIncident( incidentID );

    } catch ( Exception ex ) {

      logger.error( "CIncidentService.closeIncident(). Ocurri\u00fe un problema cerrando el incidente cr\u00edtico " + incidentID, ex );
      return "El incidente cr\u00edtico no pudo ser cerrado";
    }
    return "Se cerr\u00f3 el incidente cr\u00edtico existosamente";    
  }
  
  @Override
  public String createIncident( CriticalIncident bean ) {

    String incidentID;
    try {
      
      incidentID = dao.create( bean );
      logger.debug("CIncidentService.createIncident(). Se creo un registro con el ID '" + incidentID + "' para el incident de Remedy: " + bean.getRemedyID());
      
    } catch ( Exception ex ) { 
      
      logger.error( "CIncidentService.createIncident(). Ocurri\u00fe un problema un registro para el incidente " + bean.getRemedyID(), ex  );
      return "El incidente no pudo ser creado";
    }
    return "Se creo el registrio del incidente: " + bean.getRemedyID() + ", existosamente";
  }
    
  @Override
  public String deleteIncident( int id ) {
    
    String result = "";
    try {
      
      result = this.dao.delete( id );
          
    } catch ( Exception ex ) {
      
      logger.error( "CIncidentService.deleteIncidents(). Error al eliminar el incidente: " + id, ex );
    }    
    return result;
  }
  
  @Override
  public Integer deleteIncidents( List<Integer> incidentList ) {
    
    StringBuilder sb = new StringBuilder();
    int deletedCnt = 0;
    try {            
      deletedCnt = dao.delete( incidentList );
      
    } catch ( Exception ex ) { 
      
      logger.error( "CIncidentService.deleteIncidents(). Error al eliminar los incidentes: " + sb.toString(), ex );
    }
    return deletedCnt;
  }
  
  @Override
  public CriticalIncident getIncident( Integer incidentID ) {
    
    try {
      return this.dao.read( incidentID );

    } catch( Exception ex ) {

      logger.error( "CIncidentService.getIncident(). Error recuperando el registro del incidente con ID '" + incidentID + "'", ex  );
    }
    return null;    
  }
  
  @Override
  public List<CriticalIncident> getIncidentList( boolean openOnly ) { 
    
    List<CriticalIncident> result = new ArrayList<>();
    try {
      result = dao.list( openOnly );

    } catch ( Exception ex ) {

      logger.error( "CIncidentService.getIncidentList(). No se pudo recuperar informaci\u00f3n de los usuarios", ex  );
    }
    return result;
  }

  @Override
  public String reopenIncident( Integer incidentID ) {
    
    try {
      this.dao.reopenIncident( incidentID );

    } catch ( Exception ex ) {

      logger.error( "CIncidentService.reopenIncident(). Ocurri\u00fe un problema reabriendo el incidente cr\u00edtico " + incidentID, ex );
      return "El incidente cr\u00edtico no pudo ser reabierto";
    }
    return "Se reabri\u00f3 el incidente cr\u00edtico existosamente";
  }
  
  @Override
  public String updateIncident( CriticalIncident bean ) {
    
    int cnt = 0;
    try {
      cnt = this.dao.update( bean );

    } catch ( Exception ex ) {

      logger.error( "CIncidentService.updateIncident(). Ocurri\u00fe un problema actualizando el incidente cr\u00edtico " + bean.getRemedyID(), ex );
      return "El incidente cr\u00edtico no pudo ser actualizado";
    }
    return "Se actualiz\u00f3 el incidente cr\u00edtico '" + bean.getRemedyID() + "' existosamente";    
  }
     
}
