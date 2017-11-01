package mx.com.nttdata.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 * Administrador de conexiones a la base de datos
 * @version 1.0.0
 */
public class ConnectionFactory implements IConnectionFactory {

/** Initial context to the application */
private Context ctx;
/** context to the application environment */
private Context envCtx;


   public ConnectionFactory() {

     this.ctx    = null;
     this.envCtx = null;
   }

  /**
   * Devuelve una conexion a la base de datos con el nombre JNDI del datasource
   * @param dsName Nombre del data source a utilizqr
   * @return Conexion a la base de datos
   * @throws Exception Si no se puede conectar
   */
  @Override
  public Connection getConnection( String dsName ) throws Exception {

    return this.getConnection( dsName, null );
  }

  /**
   * Devuelve una conexion a la base de datos con el nombre JNDI del datasource
   * @param dsName Nombre del data source a utilizqr
   * @param factoryName Nombre del data source a utilizqr
   * @return Conexion a la base de datos
   * @throws Exception Si no se puede conectar
   */
  @Override
  public Connection getConnection( String dsName, String factoryName )
         throws Exception {

    DataSource ds   = this.getDataSource( dsName, factoryName );
    return ds.getConnection();
  }

  /**
   * Devuelve un data source a la base de datos
   * @param dsName Nombre JNDI del datasource a buscar
   * @return Una fuente de datos
   * @throws Exception Si no logra conectarse
   */
  @Override
  public DataSource getDataSource( String dsName ) throws Exception {

    return this.getDataSource( dsName, null );
  }

  /**
   * Devuelve un data source a la base de datos
   * @param dsName Nombre JNDI del datasource a buscar
   * @param factoryName Si se llena, nombre de la fabrica de conexiones
   * @return Una fuente de datos
   * @throws Exception Si no logra conectarse
   */
  @Override
  public DataSource getDataSource( String dsName, String factoryName ) throws Exception {

    Logger     logger = Logger.getLogger( this.getClass());
    DataSource ds;
    try {
      this.ctx    = new InitialContext();
      logger.debug( "ConnectionFactory.getDataSource(). DataSource: " + dsName  );
      logger.debug( "ConnectionFactory.getDataSource(). Factory: "    + factoryName );
      if ( factoryName != null  && !factoryName.equals(""))          // Tomcat Strange Thing
      {
         this.envCtx = (Context) ctx.lookup( factoryName );
         ds          = (DataSource) envCtx.lookup( dsName );
      }
      else
         ds         = (DataSource) ctx.lookup( dsName );
      logger.debug( "ConnectionFactory.getDataSource(). Conectado al DataSource: " + dsName  );

    } catch ( Exception ex ) {

      logger.error( "ConnectionFactory.getDataSource(). Error conect\u00e1ndose al Data Source: " + dsName, ex );
      ds = null;
    }
    return ds;
  }

}
