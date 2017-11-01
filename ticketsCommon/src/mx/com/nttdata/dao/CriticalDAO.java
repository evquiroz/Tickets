package mx.com.nttdata.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;

import javax.sql.DataSource;

import mx.com.nttdata.beans.CriticalIncident;
import mx.com.nttdata.util.DateUtils;
import mx.com.nttdata.util.IncidentStatus;


/**
 * DAO que maneja los datos de los incidentes criticos
 * @version 1.0.0
 */
public class CriticalDAO extends AbstractDAO implements ICriticalDAO {

  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 5658672044701930703L;

  private String sqlCreate     = "INSERT INTO Tck_CriticalIncidents( RemedyID, Title, Notes, Impact, AssignedGroup, Category_Lvl01, Category_Lvl02, Category_Lvl03, Product_Lvl01, Product_Lvl02, Product_Lvl03, Ticket_State, CreationDate ) VALUES ( ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ? )";
  private String sqlRead       = "SELECT * FROM Tck_CriticalIncidents WHERE IncidentID = ?";
  private String sqlDelete     = "DELETE FROM Tck_CriticalIncidents WHERE IncidentID = ?";
  private String sqlDeleteMany = "DELETE FROM Tck_CriticalIncidents WHERE IncidentID IN ( ? )";
  private String sqlList       = "SELECT * FROM Tck_CriticalIncidents ";
  private String sqlListWhere  = "WHERE Close_Date IS NULL ";
  private String sqlListOrder  = " ORDER BY RemedyID";
  private String sqlUpdate     = "UPDATE Tck_CriticalIncidents SET Title = ?, Notes = ?, Impact = ?, AssignedGroup = ?, "  +
                                 "Category_Lvl01 = ?, Category_Lvl03 = ?, Category_Lvl03 = ?, " +
                                 "Product_Lvl01 = ?, Product_Lvl03 = ?, Product_Lvl03 = ?, " +
                                 "Ticket_State = ?, CreationDate = ?, Close_Date = ? WHERE IncidentID = ? ";
  private String sqlCloseInc   = "UPDATE Tck_CriticalIncidents SET Ticket_State = 'C', Close_Date = ? WHERE IncidentID = ?";
  private String sqlReopenInc  = "UPDATE Tck_CriticalIncidents SET Ticket_State = 'A', Close_Date = NULL WHERE IncidentID = ?";
  // private String sqlChangeInc  = "UPDATE Tck_CriticalIncidents SET Ticket_State = ?, Close_Date = ? WHERE IncidentID = ?";
  private String sqlUnique     = "SELECT COUNT( RemedyID ) AS cnt FROM Tck_CriticalIncidents WHERE RemedyID = ?";

  /**
   * Constructor predeterminado
   */
  public CriticalDAO() {

    super();
  }

  /**
   * Constructor preferido
   * @param ds Datasource a ser utilizado en la conexion a la base de datos
   */
  public CriticalDAO( DataSource ds ) {

    this();
    this.dataSource = ds;
  }

  @Override
  public int changeIncident( Integer recordID, boolean isClosed ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    //  FIX This
    IncidentStatus    ist    = isClosed ? IncidentStatus.CERRADO : IncidentStatus.ABIERTO;
    String            status = ist.toString();
    int               result = 0;

    debug("changeIncident", "Sql:      [" + this.sqlCloseInc + "]");
    debug("changeIncident", "ID:       [" + recordID + "]");
    debug("changeIncident", "isClosed: [" + ( ist.getStatusName()) + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlCloseInc );
      st.setString( 1, status );
      if ( isClosed )
         // st.setDate( 2, DateUtils.convierteAFechaSQL( Calendar.getInstance().getTime()));
         st.setTimestamp( 2, new Timestamp( Calendar.getInstance().getTimeInMillis()));
      else
         st.setNull( 2, Types.TIMESTAMP );
      st.setInt( 3, recordID );

      st.execute();
      result = st.getUpdateCount();
      if ( result >= 1 )
         return result;
      else
         throw new Exception("No se pudo cambiar el estado del incidente cr\u00edtico a " +
                             ( isClosed ? "Activo" : "Inactivo"  ));

    } catch ( Exception ex ) {

      this.warn("closeIncident", "Ocurri\u00f3 un problema actualizando el estado del incidente cr\u00edtico " + recordID, ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

  @Override
  public int closeIncident( Integer recordID ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    int               result = 0;

    debug("closeIncident", "Sql: [" + this.sqlCloseInc + "]");
    debug("closeIncident", "ID:  [" + recordID + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlCloseInc );
      st.setTimestamp( 1, new Timestamp( Calendar.getInstance().getTimeInMillis()));
      st.setInt(  2, recordID );

      st.execute();
      result = st.getUpdateCount();
      if ( result >= 1 )
         return result;
      else
         throw new Exception("No se pudo cerrar el incidente cr\u00edtico ");

    } catch ( Exception ex ) {

      this.warn("closeIncident", "Ocurri\u00f3 un problema actualizando el incidente cr\u00edtico " + recordID, ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

  @Override
  public String create( CriticalIncident record ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    String            result    = "";

    debug("create", "Sql:         [" + this.sqlCreate + "]");
    debug("create", "RemedyID:    [" + record.getRemedyID() + "]");
    debug("create", "Titulo:      [" + record.getTitle() + "]");
    debug("create", "Descripcion: [" + record.getNotes() + "]");
    debug("create", "Impacto:     [" + record.getImpact() + "]");
    debug("create", "Grupo:       [" + record.getAssignedGroup() + "]");
    debug("create", "Categor\u00eda 1: [" + record.getCategoryLevel01() + "]");
    debug("create", "Categor\u00eda 2: [" + record.getCategoryLevel02() + "]");
    debug("create", "Categor\u00eda 3: [" + record.getCategoryLevel03() + "]");
    debug("create", "Producto 1:  [" + record.getProductLevel01() + "]");
    debug("create", "Producto 2:  [" + record.getProductLevel02() + "]");
    debug("create", "Producto 3:  [" + record.getProductLevel03() + "]");
    debug("create", "Estado:      [" + record.getStatus() + "]");
    debug("create", "Creado en:   [" + DateUtils.getISODate( record.getCreationDate()) + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlCreate, PreparedStatement.RETURN_GENERATED_KEYS );

      st.setString( 1, record.getRemedyID());
      st.setString( 2, record.getTitle());
      st.setString( 3, record.getNotes());
      st.setString( 4, record.getImpact());
      st.setString( 5, record.getAssignedGroup());
      st.setString( 6, record.getCategoryLevel01());
      st.setString( 7, record.getCategoryLevel02());
      st.setString( 8, record.getCategoryLevel03());
      st.setString( 9, record.getProductLevel01());
      st.setString(10, record.getProductLevel02());
      st.setString(11, record.getProductLevel03());
      st.setString(12, record.getStatus());
      st.setTimestamp(13, new Timestamp( record.getCreationDate().getTime()));
      // st.setTimestamp( 13, record.getCreationDate());

      int rows = st.executeUpdate();
      if ( rows > 0 ) {
         rs = st.getGeneratedKeys();
         if ( rs.next())
            result = rs.getString( 1 );
      }
      if ( result == null || result.isEmpty() )
         throw new Exception("No se obtuvo un ID para el incidente cr\u00edtico");


    } catch ( Exception ex ) {

      this.warn("create", "Ocurri\u00f3 un problema creando un incidente cr\u00edtico", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public String delete( int id ) throws Exception {

    Connection        conn    = null;
    PreparedStatement st      = null;
    StringBuilder     sb      = new StringBuilder();
    int               cnt     = -1;

    debug("delete", "Sql:     [" + this.sqlDelete + "]");
    debug("delete", "ID: [" +id + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlDelete );
      st.setInt( 1, id );
      st.execute();
      cnt = st.getUpdateCount();
      if ( cnt < 1 )
         throw new Exception("No se elimin\u00f3 el incidente");

    } catch ( Exception ex ) {

      this.warn("delete", "Ocurri\u00f3 un problema borrando los incidentes cr\u00edticos con ID: " + sb.toString(), ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return "Se elimin\u00f3 el incidente " + id;
  }

  @Override
  public int delete( List<Integer> incidentList ) throws Exception {

    Connection        conn    = null;
    PreparedStatement st      = null;
    StringBuilder     sb      = new StringBuilder();
    int               records = 0;

    for ( Integer each : incidentList )
        sb.append( each ).append( ", " );
    sb.setLength( sb.length() - 2 );

    debug("delete", "Sql:     [" + this.sqlDeleteMany + "]");
    debug("delete", "ID List: [" + sb.toString() + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlDeleteMany );
      st.setString( 1, sb.toString() );
      st.execute();
      records = st.getUpdateCount();

    } catch ( Exception ex ) {

      this.warn("delete", "Ocurri\u00f3 un problema borrando los incidentes cr\u00edticos con ID: " + sb.toString(), ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return records;
  }

  @Override
  public boolean isUniqueIncident( String remedyID ) {

    Connection         conn   = null;
    PreparedStatement  st     = null;
    ResultSet          rs     = null;
    int                cnt;

    debug("isUniqueIncident", "Sql: [" + sqlUnique + "]");
    debug("isUniqueIncident", "ID:  [" + remedyID + "]");

    try {
      conn = this.getConnection();
      st   =  conn.prepareStatement( sqlUnique );
      st.setString( 1, remedyID );
      rs   = st.executeQuery();
      if ( rs.next()) {
         cnt = rs.getInt( 1 );
         return cnt == 0;
      }

    } catch ( Exception ex ) {

      this.warn("isUniqueIncident", "Ocurri\u00f3 un verificando la unicidad del numero de incidente remedy: " + remedyID, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return false;
  }

  @Override
  public List<CriticalIncident> list( boolean onlyOpen ) throws Exception {

    Connection             conn   = null;
    Statement              st     = null;
    ResultSet              rs     = null;
    List<CriticalIncident> result = new ArrayList<>();
    CriticalIncident       item;
    String                 qry    = this.sqlList;
    if ( onlyOpen ) {

       qry += this.sqlListWhere;
    }
    qry += this.sqlListOrder;

    debug("list", "Sql: [" + qry + "]");

    try {
      conn = this.getConnection();
      st   = conn.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
      rs   = st.executeQuery( qry );
      while ( rs.next()) {

         item = this.parseRecord( rs );
         result.add( item );
      }

    } catch ( Exception ex ) {

      this.warn("list", "Ocurri\u00f3 un problema listando los incidentes cr\u00edticos", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  protected CriticalIncident parseRecord( ResultSet record ) throws Exception {

    CriticalIncident item = new CriticalIncident();

    item.setIncidentID( record.getInt("IncidentID"));
    item.setRemedyID( record.getString("RemedyID"));
    item.setTitle( record.getString("Title"));
    item.setNotes( record.getString("Notes"));
    item.setImpact( record.getString("Impact"));
    item.setAssignedGroup( record.getString("AssignedGroup"));
    item.setCategoryLevel01( record.getString("Category_Lvl01"));
    item.setCategoryLevel02( record.getString("Category_Lvl02"));
    item.setCategoryLevel03( record.getString("Category_Lvl03"));
    item.setProductLevel01( record.getString("Product_Lvl01"));
    item.setProductLevel02( record.getString("Product_Lvl02"));
    item.setProductLevel03( record.getString("Product_Lvl03"));
    item.setStatus( record.getString("Ticket_State"));
    Timestamp ts = record.getTimestamp("CreationDate");
    item.setCreationDate( ts );
    ts = record.getTimestamp("Close_Date");
    item.setCloseDate( ts );

    return item;
  }

  @Override
  public CriticalIncident read( Integer recordID ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    CriticalIncident  result    = new CriticalIncident();

    debug("read", "Sql: [" + this.sqlRead + "]");
    debug("read", "id:  [" + recordID + "]");


    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlRead );
      st.setInt( 1, recordID );
      rs   = st.executeQuery();
      if ( rs.next())
         return this.parseRecord( rs );

    } catch ( Exception ex ) {

      this.warn("read", "Ocurri\u00f3 un problema leyendo el incidente cr\u00edtico con ID:" + recordID, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public int reopenIncident( Integer recordID ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    int               result = 0;

    debug("closeIncident", "Sql: [" + this.sqlReopenInc + "]");
    debug("closeIncident", "ID:  [" + recordID + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlReopenInc );
      st.setInt(  1, recordID );

      st.execute();
      result = st.getUpdateCount();
      if ( result >= 1 )
         return result;
      else
         throw new Exception("No se pudo reabrir el incidente cr\u00edtico ");

    } catch ( Exception ex ) {

      this.warn("reopenIncident", "Ocurri\u00f3 un problema actualizando el incidente cr\u00edtico " + recordID, ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

  @Override
  public int update( CriticalIncident record ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    ResultSet         rs     = null;
    int               result = 0;

    debug("update", "Sql:       [" + this.sqlUpdate + "]");
    debug("update", "RemedyID:    [" + record.getRemedyID() + "]");
    debug("update", "Titulo:      [" + record.getTitle() + "]");
    debug("update", "Descripcion: [" + record.getNotes() + "]");
    debug("update", "Impacto:     [" + record.getImpact() + "]");
    debug("update", "Grupo:       [" + record.getAssignedGroup() + "]");
    debug("update", "Categor\u00eda 1: [" + record.getCategoryLevel01() + "]");
    debug("update", "Categor\u00eda 2: [" + record.getCategoryLevel02() + "]");
    debug("update", "Categor\u00eda 3: [" + record.getCategoryLevel03() + "]");
    debug("update", "Producto 1:  [" + record.getProductLevel01() + "]");
    debug("update", "Producto 2:  [" + record.getProductLevel02() + "]");
    debug("update", "Producto 3:  [" + record.getProductLevel03() + "]");
    debug("update", "Estado:      [" + record.getStatus() + "]");
    debug("update", "Creado en:   [" + DateUtils.getISODate( record.getCreationDate()) + "]");
    debug("update", "Cerrado en:  [" + DateUtils.getISODate( record.getCloseDate()) + "]");
    debug("update", "ID:          [" + record.getIncidentID() + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlUpdate );

      st.setString( 1, record.getTitle());
      st.setString( 2, record.getNotes());
      st.setString( 3, record.getImpact());
      st.setString( 4, record.getAssignedGroup());
      st.setString( 5, record.getCategoryLevel01());
      st.setString( 6, record.getCategoryLevel02());
      st.setString( 7, record.getCategoryLevel03());
      st.setString( 8, record.getProductLevel01());
      st.setString( 9, record.getProductLevel02());
      st.setString(10, record.getProductLevel03());
      st.setString(11, record.getStatus());
      st.setTimestamp(  12, new Timestamp( record.getCreationDate().getTime()));

      if ( record.getCloseDate() != null )
      {
         // java.sql.Date dt = DateUtils.convierteAFechaSQL( record.getCloseDate());
         // st.setDate( 13, dt );
        st.setTimestamp( 13, new Timestamp( record.getCloseDate().getTime()));
      }
      else
         st.setNull( 13, Types.DATE );
      st.setInt( 14, record.getIncidentID());

      st.execute();
      if ( st.getUpdateCount() >= 1 )
         return 1;
      else
         throw new Exception("No se pudo actualizar el incidente cr\u00edtico ");

    } catch ( Exception ex ) {

      this.warn("update", "Ocurri\u00f3 un problema actualizando el incidente cr\u00edtico " + record.getIncidentID(), ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

}
