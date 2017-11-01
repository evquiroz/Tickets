package mx.com.nttdata.service;

import mx.com.nttdata.beans.Parameters;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.dao.IParamsDAO;
import mx.com.nttdata.dao.ParamsDAO;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;

import org.apache.log4j.Logger;

/**
 * Servicio que maneja los parametros de la aplicacion
 * @version 1.0.0
 */
public class ParametersService implements IParametersService {

  /** Log de la aplicacion */
  private static Logger logger;

  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;


  /**
   * Constructor predterminado
   */
  public ParametersService() {

    logger = Logger.getLogger( this.getClass());
    dsName = Properties.getString( IGlobalConstants.PROP_DS_NAME );
    cfName = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );
  }

  /**
   * Devuelve los parametros de la base de datos
   * @return Un bean con los parametros globales de la aplicacion
   */
  @Override
  public Parameters getParams() {

    ConnectionFactory cf;
    IParamsDAO        dao;
    Parameters        result = new Parameters();

    try {
      cf     = new ConnectionFactory();
      dao    = new ParamsDAO( cf.getDataSource( dsName, cfName ));
      result = dao.read();

    } catch ( Exception ex ) {

      logger.error("ParametersService.getParams(). Error leyendo los parametros de la base.", ex );
    }
    return result;
  }

}
