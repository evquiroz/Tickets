package mx.com.nttdata.service;

import java.util.HashMap;
import java.util.Map;

import mx.com.nttdata.dao.ICatalogsDAO;
import mx.com.nttdata.dao.CatalogsDAO;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

import org.apache.log4j.Logger;


/**
 * Servicio que da acceso a los datos globales de la aplicacion
 * @version 1.0.0
 */
public class GlobalService implements IGlobalService {

  /** Log de la aplicacion */
  private static Logger logger;

  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;


  /**
   * Constructor predterminado
   */
  public GlobalService() { 

    logger = Logger.getLogger( this.getClass());
    dsName = Properties.getString( IGlobalConstants.PROP_DS_NAME );
    cfName = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );
  }

  /**
   * Devuelve los valores a usar en los combos de seleccion de impacto del incidente 
   * @return un mapa con las clave y las descripciones de los impactos
   */
  public Map<String, String> getImpactData() {
    
    ConnectionFactory   cf;
    ICatalogsDAO        dao;
    Map<String, String> result = new HashMap<>();

    try {
      cf     = new ConnectionFactory();
      dao    = new CatalogsDAO( cf.getDataSource( dsName, cfName ));
      result = dao.getImpactMap();

    } catch ( Exception ex ) {

      logger.error("ParametersService.getParams(). Error leyendo los parametros de la base.", ex );
    }
    return result;
  }
  
}
