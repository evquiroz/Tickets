package mx.com.nttdata.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * DAO que provee funciones comunes a todos los DAOs
 * @author flozada
 */
public abstract class AbstractDAO implements Serializable {
  
  
  /** Fuente de datos */
  protected DataSource dataSource;
  
  /** Bitacora de la aplicacion */
  protected Logger logger;  
  
  
  /**
   * Constructor predeterminado
   */
  public AbstractDAO() {
    
    super();
    this.logger = Logger.getLogger(  this.getClass());
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   * @param ex Excepcion que fue lanzada
   */
  public void debug( String origin, String data, Throwable ex ) {

    log( Level.DEBUG, origin, data, ex );
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   */
  public void debug( String origin, String data ) {

    log( Level.DEBUG, origin, data, null );
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   * @param ex Excepcion que fue lanzada
   */
  public void error( String origin, String data, Throwable ex ) {

    log( Level.DEBUG, origin, data, ex );
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   * @param ex Excepcion que fue lanzada
   */
  public void fatal( String origin, String data, Throwable ex ) {

    log( Level.DEBUG, origin, data, ex );
  }
  
  /**
   * Cierra los recursos de JDBC 
   * @param conn Connexion a ser liberado
   */
  public void freeJdbc( Connection conn ) {

    try {
      if ( conn != null && !conn.isClosed())
        conn.close();

    } catch ( Exception ex ) {

      this.warn( "freeJdbc", "Ocurri\u00f3 un problema cerrando recursos JDBC", ex );
    }
  }

  /**
   * Cierra los recursos de JDBC 
   * @param rs Resultset a ser liberado
   */
  public void freeJdbc( ResultSet rs ) {

    try {
      if ( rs != null && !rs.isClosed())
         rs.close();

    } catch ( Exception ex ) {

      this.warn( "freeJdbc", "Ocurri\u00f3 un problema cerrando recursos JDBC", ex );
    }
  }

  /**
   * Cierra los recursos de JDBC 
   * @param st Statement a ser liberado
   */
  public void freeJdbc( Statement st ) {

    try {
      if ( st != null && !st.isClosed())
         st.close();

    } catch ( Exception ex ) {

      this.warn( "freeJdbc", "Ocurri\u00f3 un problema cerrando recursos JDBC", ex );
    }
  }

  /**
   * Cierra los recursos de JDBC 
   * @param st Statement a ser liberado
   * @param rs Resultset a ser liberado
   */
  public void freeJdbc( Statement st, ResultSet rs ) {

    freeJdbc( rs );
    freeJdbc( st );
  }

  /**
   * Cierra los recursos de JDBC 
   * @param conn Connexion a ser cerrada
   * @param st Statement a ser cerrado
   */
  public void freeJdbc( Connection conn, Statement st ) {

    freeJdbc( st );
    freeJdbc( conn );
  }

  /**
   * Cierra los recursos de JDBC 
   * @param conn Connexion a ser cerrada
   * @param st Statement a ser cerrado
   * @param rs Resultset a ser cerrado
   */
  public void freeJdbc( Connection conn, Statement st, ResultSet rs ) {

    freeJdbc( rs );
    freeJdbc( st );
    freeJdbc( conn );
  }
  
  /**
   * Devuelve una conexion a la base de datos dandole manejo a los errores
   * @return Conexion abierta a la base de datos
   * @throws Exception En caso de no poder realizar la conexion
   */
  protected Connection getConnection() throws Exception {

    Connection conn;
    try {
      conn = dataSource.getConnection();
      return conn;

    } catch ( Exception ex ) {

      this.error( "getConnection", "Ocurri\u00f3 un problema obteniendo conexiones a la base de datos", ex );
      throw new Exception( ex );
    }
  }

  /**
   * Devuelve el DataSource utilizado en el DAO
   * @return Datasource del DAO
   */
  public DataSource getDatasource() {

    return dataSource;
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   * @param ex Excepcion que fue lanzada
   */
  public void info( String origin, String data, Throwable ex ) {

    log( Level.DEBUG, origin, data, ex );
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Nombre del metodo que donde se invoco el registro
   * @param data Informacion a ser guardada en el log
   */
  public void info( String origin, String data ) {

    log( Level.DEBUG, origin, data, null );
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param level Nivel de advertencia de la entrada
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   * @param ex Excepcion que fue lanzada
   */
  public void log( Level level, String origin, String data, Throwable ex ) {

    logger.log( level, "[" + this.getClass().getName() + "]." + origin + "():" + data, ex );
  }
  
  /**
   * Establece la fuente de datos que utilizara el DAO
   * @param ds Datasource a usar
   */
  public void setDataSource( DataSource ds ) {

    this.dataSource = ds;
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   * @param ex Excepcion que fue lanzada
   */
  public void warn( String origin, String data, Throwable ex ) {

    log( Level.DEBUG, origin, data, ex );
  }

  /**
   * Agrega informacion a la bitacora de la aplicacion
   * @param origin Metodo donde se origino el problema 
   * @param data Datos personalizables del problema
   */
  public void warn( String origin, String data ) {

    log( Level.DEBUG, origin, data, null );
  }
  
}
