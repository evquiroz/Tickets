package mx.com.nttdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.Types;
import javax.sql.DataSource;

import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.Incident;

/**
 * DAO para el manejo de informacion de incidentes
 * @version 1.0.0
 */
public class IncidentDAO extends AbstractTicketDAO {

  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 2635208269703521720L;

  /**
   * Constructor predeterminado
   * @param ds DataSource que provee las conexiones a las base de datos
   */
  public IncidentDAO( DataSource ds ) {

    super( ds, INCIDENTS_TABLE, INCIDENTS_KEY );
    this.sqlCreate = "INSERT INTO Tck_Incidents ( RemedyID, CompanyName, Customer, Title, Notes, Priority, Impact, " +
                     "Urgency, AssignedGroup, Source, Category_Lvl01, Category_Lvl02, Category_Lvl03, " +
                     "Product_Lvl01, Product_Lvl02, Product_Lvl03, Main_TicketID ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
    this.sqlUpdate = "UPDATE Tck_Incidents SET Title = ?, Notes = ?, Priority = ?, Impact = ?, " +
                     "Urgency = ?, AssignedGroup = ?, Category_Lvl01 = ?, Category_Lvl02 = ?, " +
                     "Category_Lvl03 = ?, Product_Lvl01 = ?, Product_Lvl02 = ?, Product_Lvl03 " +
                     "WHERE IncidentID = ?";
  }

  /**
   * Inserta un registro en la base de datos
   * @param record Bean con la informacion del registro a insertar
   * @return Codigo de retorno de la operacion
   * @throws Exception En caso de que algo falle
   */
  @Override
  public int create( ITicket record ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    int               result    = 0;

    Incident          iticket   = ((Incident) record);
    String            parentID  = iticket.getPArentID();

    debug("create", "Sql:       [" + this.sqlCreate + "]");
    debug("create", "Remedy ID: [" + record.getRemedyID() + "]");
    debug("create", "Empresa:   [" + record.getCompanyName() + "]");
    debug("create", "Empleado:  [" + record.getCustomer() + "]");
    debug("create", "Resumen:   [" + record.getTitle() + "]");
    debug("create", "Prioridad: [" + record.getPriority() + "]");
    debug("create", "Impacto:   [" + ((Incident) record).getImpact() + "]");
    debug("create", "Urgencia:  [" + ((Incident) record).getUrgency() + "]");
    debug("create", "Grupo:     [" + ((Incident) record).getAssignedGroup() + "]");
    debug("create", "Categoria: [" + record.getCategoryLevel01() + "->" + record.getCategoryLevel02() + "->" + record.getCategoryLevel03() + "]" );
    debug("create", "Producto:  [" + record.getProductLevel01() + "->" + record.getProductLevel02() + "->" + record.getProductLevel03() + "]" );
    debug("create", "ParentID:  [" + parentID + "]" );

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlCreate, PreparedStatement.RETURN_GENERATED_KEYS );

      st.setString(  1, record.getRemedyID());
      st.setString(  2, record.getCompanyName());
      st.setString(  3, record.getCustomer());
      st.setString(  4, record.getTitle());
      st.setString(  5, record.getNotes());
      st.setString(  6, record.getPriority());
      st.setString(  7, ((Incident) record).getImpact());
      st.setString(  8, ((Incident) record).getUrgency() );
      st.setString(  9, ((Incident) record).getAssignedGroup() );
      st.setString( 10, record.getSource());
      st.setString( 11, record.getCategoryLevel01());
      st.setString( 12, record.getCategoryLevel02());
      st.setString( 13, record.getCategoryLevel03());
      st.setString( 14, record.getProductLevel01());
      st.setString( 15, record.getProductLevel02());
      st.setString( 16, record.getProductLevel03());
      if ( parentID == null || parentID.isEmpty())
         st.setNull( 17, Types.VARCHAR );
      else
         st.setString( 17, parentID );
      int rows = st.executeUpdate();

      if ( rows > 0 ) {
         rs = st.getGeneratedKeys();
         if ( rs.next()) {
            // result = rs.getInt( 1 );
            RowId rid = rs.getRowId( 1 );
            this.debug( "create", "Se cre\u00f3 un incidente con ID " + rid.toString());
            result = 1;
         }
      }
      if ( result <= 0 )
         throw new Exception("No se obtuvo un ID para el incidente con ID de Remedy: " + record.getRemedyID());

    } catch ( Exception ex ) {

      this.warn("create", "Ocurri\u00f3 un problema el registro del incidente", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  /**
   * Actualiza un registro en la base de datos
   * @param record Bean con la informacion a actualizar
   * @return Codigo de retorno de la operacion
   * @throws Exception En caso de que algo falle
   */
  @Override
  public int update( ITicket record ) throws Exception {

    Connection        conn   = null;
    PreparedStatement st     = null;
    int               result = 0;

    debug("update", "Sql:       [" + this.sqlUpdate + "]");
    debug("create", "Resumen:   [" + record.getTitle() + "]");
    debug("create", "Prioridad: [" + record.getPriority() + "]");
    debug("create", "Impacto:   [" + ((Incident) record).getImpact() + "]");
    debug("create", "Urgencia:  [" + ((Incident) record).getUrgency() + "]");
    debug("create", "Grupo:     [" + ((Incident) record).getAssignedGroup() + "]");
    debug("create", "Categoria: [" + record.getCategoryLevel01() + "->" + record.getCategoryLevel02() + "->" + record.getCategoryLevel03() + "]" );
    debug("create", "Producto:  [" + record.getProductLevel01() + "->" + record.getProductLevel02() + "->" + record.getProductLevel03() + "]" );

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlUpdate );
      st.setString(  1, record.getTitle());
      st.setString(  2, record.getNotes());
      st.setString(  3, record.getPriority());
      st.setString(  4, ((Incident) record).getImpact());
      st.setString(  5, ((Incident) record).getUrgency() );
      st.setString(  6, ((Incident) record).getAssignedGroup() );
      st.setString(  7, record.getCategoryLevel01());
      st.setString(  8, record.getCategoryLevel02());
      st.setString(  9, record.getCategoryLevel03());
      st.setString( 10, record.getProductLevel01());
      st.setString( 11, record.getProductLevel02());
      st.setString( 12, record.getProductLevel03());
      st.setInt( 13, record.getID());

      st.executeQuery();
      result = st.getUpdateCount();

      if ( result <= 0 )
         throw new Exception("No se pudo actualizar el ticket del incidente " + record.getRemedyID());

    } catch ( Exception ex ) {

      this.warn("update", "Ocurri\u00f3 un problema actualizando el ticket del incidente", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

}
