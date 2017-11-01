package mx.com.nttdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

/**
 * DAO para acceder a todos esos datos de catalago que no necesitan el suyo propio
 * completo
 * @version 1.0.0
 */
public class CatalogsDAO extends AbstractDAO implements ICatalogsDAO {

  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -3642204571273628366L;

  /**
   * Constructor predeterminado
   */
  public CatalogsDAO() {

    super();
  }

  /**
   * Constructor preferido
   * @param ds Datasource a ser utilizado en la conexion a la base de datos
   */
  public CatalogsDAO( DataSource ds ) {

    this();
    this.dataSource = ds;
  }
  
  /**
   * Metodo generico para recuperar mapas de datos, usualmente para combos
   * @param caller Nombre del metodo que llama a este
   * @param sql Query a utilizar
   * @param keyField Nombre del campo llave
   * @param valueField Nombre del campo con el valor 
   * @return 
   */  
  public Map<String,String> getDataMap( String caller, String sql, String keyField, String valueField ) {
      
    Connection         conn   = null;
    PreparedStatement  st     = null;
    ResultSet          rs     = null;
    Map<String,String> result = new HashMap<>();
    String             key;
    String             val;
    
    debug( caller, "Sql:         [" + sql + "]");
    debug( caller, "Key Field:   [" + keyField + "]");
    debug( caller, "Value Field: [" + valueField + "]");
    
    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY  );
      rs   = st.executeQuery();
      
      while ( rs.next()) {
          
        key = rs.getString( keyField );
        val = rs.getString( valueField );
        result.put( key, val );
      }  
        
    } catch ( Exception ex ) {
        
      this.warn( caller, "Ocurri\u00f3 un problema recuperando el mapa de valores", ex );
        
    } finally {
        
      this.freeJdbc( conn, st, rs );
    }
    return result;
  }
    
  public Map<String,String> getImpactMap() {
      
   return this.getDataMap( "getImpactMap", "SELECT ImpactID, ImpactName FROM Tck_Impactos ORDER BY 2 ", "ImpactID", "ImpactName");
  }
    
}
