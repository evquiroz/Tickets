package mx.com.nttdata.dao;

import java.sql.Connection;
import javax.sql.DataSource;

/**
 * Utileria para obtener las conexiones a la base de datos desde datasources
 * @version 1.0.0
 */
public interface IConnectionFactory {

  /**
   * Devuelve una conexion a la base de datos con el nombre JNDI del datasource
   * @param dsName Nombre del data source a utilizqr
   * @return Conexion a la base de datos
   * @throws Exception Si no se puede conectar
   */
  Connection getConnection( String dsName ) throws Exception;

  /**
   * Devuelve una conexion a la base de datos con el nombre JNDI del datasource
   * @param dsName Nombre del data source a utilizqr
   * @param factoryName Nombre del data source a utilizqr
   * @return Conexion a la base de datos
   * @throws Exception Si no se puede conectar
   */
  Connection getConnection( String dsName, String factoryName ) throws Exception;

  /**
   * Devuelve un data source a la base de datos
   * @param dsName Nombre JNDI del datasource a buscar
   * @return Una fuente de datos
   * @throws Exception Si no logra conectarse
   */
  DataSource getDataSource( String dsName ) throws Exception;

  /**
   * Devuelve un data source a la base de datos
   * @param dsName Nombre JNDI del datasource a buscar
   * @param factoryName Si se llena, nombre de la fabrica de conexiones
   * @return Una fuente de datos
   * @throws Exception Si no logra conectarse
   */
  DataSource getDataSource( String dsName, String factoryName ) throws Exception;

}
