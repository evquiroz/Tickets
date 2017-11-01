package mx.com.nttdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.dao.ICriticalDAO;
import mx.com.nttdata.dao.CriticalDAO;
import mx.com.nttdata.remedy.api.RemedyImporter;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.IncidentStatus;
import mx.com.nttdata.util.Properties;


/**
 * Servicio que maneja las importaciones de incidentes criticos
 * @version 1.0.0
 */
public class ImporterService implements IImporterService {

  /** Log de la aplicacion */
  private static Logger logger;

  /** DAO de incidentes criticos */
  private ICriticalDAO dao;

  /** Whether the application is runnning in a non-production environment */
  private boolean devMode;
  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;


  /**
   * Constructor predeterminado
   */
  public ImporterService() {

    logger       = Logger.getLogger( this.getClass());
    this.devMode = Properties.getInt( IGlobalConstants.PROP_DEV_MODE, 0 ) == 1;

    dsName = Properties.getString( IGlobalConstants.PROP_DS_NAME );
    cfName = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );

    try {
      ConnectionFactory cf = new ConnectionFactory();
      this.dao = new CriticalDAO( cf.getDataSource( dsName, cfName ));

    } catch ( Exception ex ) {

      logger.error( "UserService.(). Ocurri\u00fe un problema conect\u00e1ndose a la base de datos ", ex  );
    }
  }

  @Override
  public List<CriticalIncident> getCriticalIncidents() {

    if ( this.devMode )
       return this.devTest();

    List<CriticalIncident> result = new ArrayList<>();
    try {
      RemedyImporter importer = new RemedyImporter();
      importer.connect();
      result = importer.getParentIncidents();
      importer.disconnect();

    } catch ( Exception ex ) {

      logger.error( "ImporterService.getCriticalIncidents(). Error generando la lista de tickets criticos", ex );
    }
    return result;
  }

  @Override
  public String importIncidents( List<CriticalIncident> source, List<String> items ) {

    // Primero, Necesitamos poder localizar facilmente los items
    Map<String,CriticalIncident> map = new HashMap<>();
    for ( CriticalIncident incident : source )
        map.put( incident.getRemedyID(), incident );

    // Ahora, uno por uno los grabamos en la base de datos
    CriticalIncident record;
    int              ix     = 0;
    try {
      for ( String key : items ) {

          record = map.get( key );
          if ( dao.isUniqueIncident( key ))
             dao.create( record );
          ix++;
      }

    } catch( Exception ex ) {

      logger.error("ImporterService::importIncidents(). Se produjo un problema importando los incidentes", ex );
    }
    return "Se importaron " + ix + " incidente(s)";
  }


  /**
   * Metodo interno para pruebas
   * @return Una lista ficticia deincidentes
   */
  private List<CriticalIncident> devTest() {

    List<CriticalIncident> result     = new ArrayList<>();

    CriticalIncident item  = new CriticalIncident();
    item.setRemedyID("INC2017102300001");
    item.setTitle("Titulo del inciente No. INC2017102300001");
    item.setNotes("Notas para el incidente critico No. INC2017102300001");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software BackOffice");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-01");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300002");
    item.setTitle("Titulo del inciente No. INC2017102300002");
    item.setNotes("Notas para el incidente critico No. INC2017102300002");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software BackOffice");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-02");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300003");
    item.setTitle("Titulo del inciente No. INC2017102300003");
    item.setNotes("Notas para el incidente critico No. INC2017102300003");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software BackOffice");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-03");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300004");
    item.setTitle("Titulo del inciente No. INC2017102300004");
    item.setNotes("Notas para el incidente critico No. INC2017102300004");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software BackOffice");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-04");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300005");
    item.setTitle("Titulo del inciente No. INC2017102300005");
    item.setNotes("Notas para el incidente critico No. INC2017102300005");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software BackOffice");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-05");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300006");
    item.setTitle("Titulo del inciente No. INC2017102300006");
    item.setNotes("Notas para el incidente critico No. INC2017102300006");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software Core");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-06");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300007");
    item.setTitle("Titulo del inciente No. INC2017102300007");
    item.setNotes("Notas para el incidente critico No. INC2017102300007");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software Core");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-07");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300008");
    item.setTitle("Titulo del inciente No. INC2017102300008");
    item.setNotes("Notas para el incidente critico No. INC2017102300008");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software Core");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-08");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300009");
    item.setTitle("Titulo del inciente No. INC2017102300009");
    item.setNotes("Notas para el incidente critico No. INC2017102300009");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software Core");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-09");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    item  = new CriticalIncident();
    item.setRemedyID("INC2017102300010");
    item.setTitle("Titulo del inciente No. INC2017102300010");
    item.setNotes("Notas para el incidente critico No. INC2017102300010");
    item.setImpact("4-Minor/Localized");
    item.setAssignedGroup("Mesa de servicio");
    item.setCategoryLevel01("Otros");
    item.setCategoryLevel02("Falla");
    item.setCategoryLevel03("Portal web");
    item.setProductLevel01("Servicios");
    item.setProductLevel02("Software Core");
    item.setProductLevel03("Remedy");
    item.setCreationDate("2017-10-10");
    item.setStatus( IncidentStatus.ST_OPEN.substring( 0, 1 ));
    result.add( item );

    return result;
  }

}
