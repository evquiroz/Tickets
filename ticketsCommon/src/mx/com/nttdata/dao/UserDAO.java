package mx.com.nttdata.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import mx.com.nttdata.beans.User;
import mx.com.nttdata.util.DateUtils;
import mx.com.nttdata.util.IGlobalConstants;

/**
 * DAO manejo de usuarios
 * @version 1.0.0
 */
public class UserDAO extends AbstractDAO implements IUserDAO {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -4889685350268640377L;

  private final static String SQL_CREATE   = "INSERT INTO Tck_LocalUsers( LoginName, Secret, eMail, UserLevel, Status, CreatedBy, CreatedOn, UpdatedBy ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";
  private final static String SQL_READ     = "SELECT * FROM Tck_LocalUsers WHERE LoginName = ?";
  private final static String SQL_DELETE   = "DELETE FROM Tck_LocalUsers WHERE LoginName = ?";
  private final static String SQL_LIST     = "SELECT * FROM Tck_LocalUsers WHERE UserLevel > 1 ORDER BY LoginName";
  private final static String SQL_LOGIN    = "SELECT LoginName FROM Tck_LocalUsers WHERE LoginName = ? AND Secret = ? AND Status = 'A'";
  private final static String SQL_LOG_SESS = "INSERT INTO Tck_LogSessions( LoginName, SessionDate ) VALUES( ?, ? )";
  private final static String SQL_UPDATE_1 = "UPDATE Tck_LocalUsers SET eMail = ?, UserLevel = ?, Status = ?, UpdatedBy = ? WHERE RecordID = ?";
  private final static String SQL_UPDATE_2 = "UPDATE Tck_LocalUsers SET eMail = ?, UserLevel = ?, Status = ?, UpdatedBy = ?, Secret = ? WHERE RecordID = ?";
  private final static String SQL_USER_LVL = "SELECT UserLevel FROM Tck_LocalUsers WHERE LoginName = ? ";

  /**
   * Constructor predeterminado
   */
  public UserDAO() {

    super();
  }

  /**
   * Constructor preferido
   * @param ds Datasource a ser utilizado en la conexion a la base de datos
   */
  public UserDAO( DataSource ds ) {

    this();
    this.dataSource = ds;
  }

  @Override
  public int authenticate( String loginName, String secret ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;

    debug("authenticate", "Sql:       [" + SQL_LOGIN + "]");
    debug("authenticate", "LoginName: [" + loginName + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( SQL_LOGIN );
      st.setString( 1, loginName);
      st.setString( 2, secret );
      rs   = st.executeQuery();
      if ( rs.next())
      {
         PreparedStatement stLog = conn.prepareStatement( SQL_LOG_SESS );
         stLog.setString( 1, loginName );
         stLog.setDate( 2, DateUtils.convierteAFechaSQL( Calendar.getInstance().getTime()));
         stLog.execute();

         return IGlobalConstants.LOGIN_AUTHENTICATED_CODE;
      }
      else
         return IGlobalConstants.LOGIN_REJECTED_CODE;

    } catch ( Exception ex ) {

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return IGlobalConstants.LOGIN_NO_SERVICE_CODE;
  }

  @Override
  public int create( User record, String loggedUser ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    int               result    = 0;

    debug("create", "Sql:       [" + SQL_CREATE + "]");
    debug("create", "LoginName: [" + record.getLoginName() + "]");
    debug("create", "eMail:     [" + record.getMail() + "]");
    debug("create", "UserLevel: [" + record.getLevel() + "]");
    debug("create", "Status:    [" + record.getStatus() + "]");
    debug("create", "Usuario:   [" + loggedUser + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( SQL_CREATE );
      st.setString( 1, record.getLoginName());
      st.setString( 2, record.secure( record.getSecret()));
      st.setString( 3, record.getMail());
      st.setInt( 4, record.getLevel());
      st.setString( 5, record.getStatus());
      st.setString( 6, loggedUser );
      st.setDate(   7, DateUtils.convierteAFechaSQL( Calendar.getInstance().getTime()));
      st.setString( 8, loggedUser );

      st.execute();
      if ( st.getUpdateCount() < 1 )
         throw new Exception("No se creo el usuario '" + record.getLoginName() + "'" );

    } catch ( Exception ex ) {

      this.warn("create", "Ocurri\u00f3 un problema creando el usuario", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

  @Override
  public int delete( String loginName ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;

    debug("delete", "Sql:       [" + SQL_DELETE + "]");
    debug("delete", "loginName: [" + loginName + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( SQL_DELETE );
      st.setString( 1, loginName );
      st.execute();
      if ( st.getUpdateCount() >= 1 )
         return 1;

    } catch ( Exception ex ) {

      this.warn("delete", "Ocurri\u00f3 un problema borrando al usuario '" + loginName + "'", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return 0;
  }

  @Override
  public int getUserLevel( String login ) {

    Connection         conn   = null;
    PreparedStatement  st     = null;
    ResultSet          rs     = null;
    int                result = IGlobalConstants.DEFAULT_USER_LEVEL;
    debug("getUserLevel", "Sql: [" + SQL_USER_LVL + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( SQL_USER_LVL );
      st.setString( 1, login );
      rs   = st.executeQuery();
      if ( rs.next())
         result = rs.getInt( 1 );

    } catch ( Exception ex ) {

      this.warn("list", "Ocurri\u00f3 un problema recuperando el nivel de acceso del usuario: " + login, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public boolean isUniqueUser( String loginName, Integer id, boolean isNew ) {

    Connection        conn   = null;
    PreparedStatement st     = null;
    ResultSet         rs     = null;
    String            sql    = "SELECT LoginName FROM Tck_LocalUsers WHERE UPPER( LoginName ) = UPPER( ? ) ";
    boolean           result = false;

    if ( id != null )
       sql += " AND RecordID <> ?";

    debug("isUniqueUser", "Sql:   [" + sql + "]");
    debug("isUniqueUser", "Login: [" + loginName + "]");
    debug("isUniqueUser", "id:    [" + id + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY  );
      st.setString( 1, loginName );
      if ( id != null )
         st.setInt( 2, id );
      rs = st.executeQuery();
      if ( !rs.next())
         result = true;

    } catch ( Exception ex ) {

      this.warn("isUniqueUser", "Ocurri\u00f3 un problema verificando si solo existe un usuario: " + loginName, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public boolean isUniqueMail( String eMail, Integer id, boolean isNew ) {

    Connection        conn   = null;
    PreparedStatement st     = null;
    ResultSet         rs     = null;
    String            sql    = "SELECT eMail FROM Tck_LocalUsers WHERE UPPER( eMail ) = UPPER( ? ) ";
    boolean           result = false;

    if ( id != null )
       sql += " AND RecordID <> ?";

    debug("isUniqueMail", "Sql:   [" + sql + "]");
    debug("isUniqueMail", "eMail: [" + eMail + "]");
    debug("isUniqueMail", "ID:    [" + id + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY  );
      st.setString( 1, eMail );
      if ( id != null )
         st.setInt( 2, id );
      rs = st.executeQuery();
      if ( !rs.next())
         result = true;

    } catch ( Exception ex ) {

      this.warn("isUniqueMail", "Ocurri\u00f3 un problema verificando si solo existe un usuario con el correo: " + eMail, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public List<User> list( int currentUserLevel, String filter ) throws Exception {

    Connection conn   = null;
    Statement  st     = null;
    ResultSet  rs     = null;
    List<User> result = new ArrayList<>();
    User       item;

    debug("list", "Sql:    [" + SQL_LIST + "]");
    // TODO Hacer efectivos estos parametros
    debug("list", "Level:  [" + currentUserLevel + "]");
    debug("list", "Filter: [" + filter + "]");

    try {
      conn = this.getConnection();
      st   = conn.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
      rs   = st.executeQuery( SQL_LIST );
      while ( rs.next()) {

         item = this.parseRecord( rs );
         result.add( item );
      }

    } catch ( Exception ex ) {

      this.warn("list", "Ocurri\u00f3 un problema listando los usuarios", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  protected User parseRecord( ResultSet record ) throws Exception {

    User user = new User();

    user.setID( record.getInt("RecordID"));
    user.setLoginName( record.getString("LoginName"));
    user.setSecret( record.getString("Secret"));
    user.setMail( record.getString("eMail"));
    user.setLevel( record.getInt("UserLevel"));
    user.setStatus( record.getString("Status"));

    return user;
  }

  @Override
  public User read( String loginName ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    User              result    = new User();

    debug("read", "Sql:   [" + SQL_READ + "]");
    debug("read", "Login: [" + loginName + "]");


    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( SQL_READ );
      st.setString( 1, loginName );
      rs   = st.executeQuery();
      if ( rs.next())
         return this.parseRecord( rs );

    } catch ( Exception ex ) {

      this.warn("read", "Ocurri\u00f3 un problema leyendo el usuario '" + loginName + "'", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  @Override
  public int update( User record, String loggedUser ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    int               result = 0;
    boolean           nopass = record.getSecret() == null || record.getSecret().isEmpty();
    String            sql    = nopass ? SQL_UPDATE_1 : SQL_UPDATE_2;

    debug("update", "Sql:       [" + sql + "]");
    debug("update", "eMail:     [" + record.getMail() + "]");
    debug("update", "UserLevel: [" + record.getLevel() + "]");
    debug("update", "Status:    [" + record.getStatus() + "]");
    debug("update", "Usuario:   [" + loggedUser + "]");
    debug("update", "ID:        [" + record.getID() + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( sql );
      st.setString( 1, record.getMail());
      st.setInt(    2, record.getLevel());
      st.setString( 3, record.getStatus());
      st.setString( 4, loggedUser );

      if ( nopass )
         st.setInt( 5, record.getID());
      else
      {
         st.setString( 5, record.secure( record.getSecret()));
         st.setInt( 6, record.getID());
      }
      st.executeUpdate();
      result = st.getUpdateCount();

      if ( result <= 0 )
         throw new Exception("No se pudo actualizar el usuario");

    } catch ( Exception ex ) {

      this.warn("update", "Ocurri\u00f3 un problema actualizando el usuario '" + record.getLoginName() + "'", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

}
