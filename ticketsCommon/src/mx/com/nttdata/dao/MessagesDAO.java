package mx.com.nttdata.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import javax.sql.DataSource;

import mx.com.nttdata.beans.SiteMessage;
import mx.com.nttdata.util.DateUtils;

/**
 * DAO para administracikno de los mensajes de la aplicacion
 * @version 1.0.0
 */
public class MessagesDAO extends AbstractDAO implements IMessagesDAO {


  /** Auxiliar de serializacino */
  private static final long serialVersionUID = 9120666622000334308L;

  private String sqlCreate     = "INSERT INTO Tck_Messages( InfoMessage, StartDate, EndDate, MainMessage, CreatedBy, CreatedOn, UpdatedBy ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
  private String sqlRead       = "SELECT * FROM Tck_Messages WHERE MessageID = ?";
  private String sqlDelete     = "DELETE FROM Tck_Messages WHERE MessageID = ?";
  private String sqlList       = "SELECT * FROM Tck_Messages ORDER BY MessageID DESC";
  private String sqlUpdate     = "UPDATE Tck_Messages SET InfoMessage = ?, StartDate = ?, EndDate = ?, MainMessage = ?, UpdatedBy = ? WHERE MessageID = ? ";
  // private String sqlchkMainMsg = "SELECT COUNT( MessageID ) INTO Cnt FROM Tck_Messages WHERE MainMessage = 1";
  private String sqlGetMessage = "SELECT * FROM Tck_Messages WHERE MainMessage = 1";
  private String sqlTruncate   = "TRUNCATE TABLE Tck_Messages";


  /**
   * Constructor predeterminado
   */
  public MessagesDAO() {

    super();
  }

  /**
   * Constructor preferido
   * @param ds Datasource a ser utilizado en la conexion a la base de datos
   */
  public MessagesDAO( DataSource ds ) {

    this();
    this.dataSource = ds;
  }

  public int create( SiteMessage record, String user ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    int               result    = 0;

    debug("create", "Sql:       [" + this.sqlCreate + "]");
    debug("create", "Mensaje:   [" + record.getMessage() + "]");
    debug("create", "Inicia:    [" + DateUtils.getISODate( record.getStartDate()) + "]");
    debug("create", "Finaliza:  [" + DateUtils.getISODate( record.getEndDate()) + "]");
    debug("create", "Principal: [" + ( record.getMain() ? "Si" : "No" ) + "]");
    debug("create", "Usuario:   [" + user + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlCreate, PreparedStatement.RETURN_GENERATED_KEYS );
      st.setString( 1, record.getMessage());
      if ( record.getStartDate() != null )
         st.setDate( 2, DateUtils.convierteAFechaSQL( record.getStartDate()));
      else
         st.setNull( 2, Types.DATE );
      if ( record.getEndDate() != null )
         st.setDate( 3, DateUtils.convierteAFechaSQL( record.getEndDate()));
      else 
         st.setNull( 3, Types.DATE );
      st.setInt( 4, record.getMain() ? 1 : 0 );
      st.setString( 5, user );
      st.setDate( 6, DateUtils.convierteAFechaSQL( Calendar.getInstance().getTime()));
      st.setString( 7, user );

      int rows = st.executeUpdate();
      
      if ( rows > 0 ) {
         rs = st.getGeneratedKeys();
         if ( rs.next())
            result = rs.getInt( 1 );
      }
      if ( result <= 0 ) 
         throw new Exception("No se obtuvo un ID para el mensaje");

    } catch ( Exception ex ) {

      this.warn("create", "Ocurri\u00f3 un problema creando el mensaje ", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public int delete( Integer id ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;

    debug("delete", "Sql: [" + this.sqlDelete + "]");
    debug("delete", "id:  [" + id + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlDelete );
      st.setInt( 1, id );
      st.execute();
      if ( st.getUpdateCount() >= 1 )
         return 1;

    } catch ( Exception ex ) {

      this.warn("delete", "Ocurri\u00f3 un problema borrando el mensaje " + id, ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return 0;
  }

  @Override
  public SiteMessage getCurrentMessage() throws Exception {

    Connection        conn   = null;
    Statement         st     = null;
    ResultSet         rs     = null;
    SiteMessage       result = null;

    debug("getCurrentMessage", "Sql: [" + this.sqlGetMessage + "]");

    try {
      conn = this.getConnection();
      st   = conn.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
      rs   = st.executeQuery( this.sqlGetMessage );
      if ( rs.next())
         return this.parseRecord( rs );

    } catch ( Exception ex ) {

      this.warn("getCurrentMessage", "Ocurri\u00f3 un problema recuperando el mensaje vigente", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public List<SiteMessage> list() throws Exception {

    Connection        conn   = null;
    Statement         st     = null;
    ResultSet         rs     = null;
    List<SiteMessage> result = new ArrayList<>();
    SiteMessage       item;

    debug("list", "Sql: [" + this.sqlList + "]");

    try {
      conn = this.getConnection();
      st   = conn.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
      rs   = st.executeQuery( this.sqlList );
      if ( rs.next())
      {
         item = this.parseRecord( rs );
         result.add( item );
      }
      else
         throw new Exception("No se encontraron mensajes");

    } catch ( Exception ex ) {

      this.warn("list", "Ocurri\u00f3 un problema listando los mensajes", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  protected SiteMessage parseRecord( ResultSet record ) throws Exception {

    SiteMessage item = new SiteMessage();

    item.setId( record.getInt("MessageID"));
    item.setMessage( record.getString("InfoMessage"));
    item.setStartDate( record.getDate("StartDate"));
    item.setEndDate(record.getDate("EndDate"));
    item.setMain( record.getInt("MainMessage") == 1 );

    return item;
  }

  @Override
  public SiteMessage read( Integer id ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    SiteMessage       result    = new SiteMessage();

    debug("read", "Sql: [" + this.sqlRead + "]");
    debug("read", "id:  [" + id + "]");


    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlRead );
      st.setInt( 1, id );
      rs   = st.executeQuery();
      if ( rs.next())
         return this.parseRecord( rs );

    } catch ( Exception ex ) {

      this.warn("read", "Ocurri\u00f3 un problema leyendo el mensaje " + id, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public int update( SiteMessage record, String user ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    ResultSet         rs     = null;
    int               result = 0;

    debug("update", "Sql:       [" + this.sqlUpdate + "]");
    debug("update", "Mensaje:   [" + record.getMessage() + "]");
    debug("update", "Inicia:    [" + DateUtils.getISODate( record.getStartDate()) + "]");
    debug("update", "Finaliza:  [" + DateUtils.getISODate( record.getEndDate()) + "]");
    debug("update", "Principal: [" + ( record.getMain() ? "Si" : "No" ) + "]");
    debug("update", "Usuario:   [" + user + "]");
    debug("update", "ID:        [" + record.getId() + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlUpdate );
      st.setString( 1, record.getMessage());
      st.setDate( 2, DateUtils.convierteAFechaSQL( record.getStartDate()));
      st.setDate( 3, DateUtils.convierteAFechaSQL( record.getEndDate()));
      st.setInt( 4, record.getMain() ? 1 : 0 );
      st.setString( 5, user );
      st.setInt( 6, record.getId());

      st.executeQuery();
      result = st.getUpdateCount();

      if ( result <= 0 )
         throw new Exception("No se pudo actualizar el mensaje");

    } catch ( Exception ex ) {

      this.warn("update", "Ocurri\u00f3 un problema actualizando el mensaje " + record.getId(), ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }
  
  @Override
  public boolean truncate() throws Exception { 

    Connection        conn      = null;
    PreparedStatement st        = null;

    debug("truncate", "Sql: [" + this.sqlTruncate + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlTruncate );
      st.execute();
      return true;

    } catch ( Exception ex ) {

      this.warn("truncate", "Ocurri\u00f3 un problema limpiando los mensahes", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return false;
  }


}
