package mx.com.nttdata.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.WorkOrder;

/**
 * DAO para el manejo de informacion de ordenes de trabajo (requisiciones)
 * @version 1.0.0
 */
public class WorkOrderDAO extends AbstractTicketDAO  {

  /**
   * Constructor predeterminado
   * @param ds DataSource que provee las conexiones a las base de datos
   */
  public WorkOrderDAO( DataSource ds ) {

    super( ds, WORK_ORDERS_TABLE, WORK_ORDERS_KEY );
    this.sqlCreate = "INSERT INTO Tck_WorkOrders( RemedyID, CompanyName, Customer, Title, Notes, Priority, Order_Type, " +
                     "Mngmt_Group, Support_Group, Order_Status, Status_Reason, Source, Category_Lvl01, Category_Lvl02, " +
                     "Category_Lvl03, Product_Lvl01, Product_Lvl02, Product_Lvl03 ) " +
                     "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
    this.sqlUpdate = "UPDATE Tck_WorkOrders SET Title = ?, Notes = ?, Priority = ?, Order_Type = ?, " +
                     "Mngmt_Group = ?, Support_Group = ?, Order_Status = ?, Status_Reason = ?, " +
                     "Category_Lvl01 = ?, Category_Lvl02 = ?, Category_Lvl03 = ?, Product_Lvl01 = ?, " +
                     "Product_Lvl02 = ?, Product_Lvl03 WHERE IncidentID = ?";
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

    debug("create", "Sql:       [" + this.sqlCreate + "]");
    debug("create", "Remedy ID: [" + record.getRemedyID() + "]");
    debug("create", "Empresa:   [" + record.getCompanyName() + "]");
    debug("create", "Empleado:  [" + record.getCustomer() + "]");
    debug("create", "Resumen:   [" + record.getTitle() + "]");
    debug("create", "Prioridad: [" + record.getPriority() + "]");
    debug("create", "T. Orden:  [" + ((WorkOrder) record).getOrderType() + "]");
    debug("create", "Gpo. Admon:[" + ((WorkOrder) record).getManagementGroup() + "]");
    debug("create", "Gpo. Sop.: [" + ((WorkOrder) record).getSupportGroup() + "]");
    debug("create", "Status:    [" + ((WorkOrder) record).getStatus() + "]");
    debug("create", "Motivo St: [" + ((WorkOrder) record).getStatusReason() + "]");

    debug("create", "Categoria: [" + record.getCategoryLevel01() + "->" + record.getCategoryLevel02() + "->" + record.getCategoryLevel03() + "]" );
    debug("create", "Producto:  [" + record.getProductLevel01() + "->" + record.getProductLevel02() + "->" + record.getProductLevel03() + "]" );

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlCreate, PreparedStatement.RETURN_GENERATED_KEYS );

      st.setString(  1, record.getRemedyID());
      st.setString(  2, record.getCompanyName());
      st.setString(  3, record.getCustomer());
      st.setString(  4, record.getTitle());
      st.setString(  5, record.getNotes());
      st.setString(  6, record.getPriority());
      st.setString(  7, ((WorkOrder) record).getOrderType());
      st.setString(  8, ((WorkOrder) record).getManagementGroup());
      st.setString(  9, ((WorkOrder) record).getSupportGroup());
      st.setString( 10, ((WorkOrder) record).getStatus());
      st.setString( 11, ((WorkOrder) record).getStatusReason());
      st.setString( 12, record.getSource());
      st.setString( 13, record.getCategoryLevel01());
      st.setString( 14, record.getCategoryLevel02());
      st.setString( 15, record.getCategoryLevel03());
      st.setString( 16, record.getProductLevel01());
      st.setString( 17, record.getProductLevel02());
      st.setString( 18, record.getProductLevel03());
//      st.execute();

      int rows = st.executeUpdate();

      if ( rows > 0 ) {
         rs = st.getGeneratedKeys();
         if ( rs.next())
            result = rs.getInt( 1 );
      }
      if ( result <= 0 )
         throw new Exception("No se obtuvo un ID para el requerimiento con ID de Remedy: " + record.getRemedyID());

    } catch ( Exception ex ) {

      this.warn("create", "Ocurri\u00f3 un problema creando el registro del requerimiento", ex );

    } finally {

      this.freeJdbc( conn, st );
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

    debug("create", "Categoria: [" + record.getCategoryLevel01() + "->" + record.getCategoryLevel02() + "->" + record.getCategoryLevel03() + "]" );
    debug("create", "Producto:  [" + record.getProductLevel01() + "->" + record.getProductLevel02() + "->" + record.getProductLevel03() + "]" );

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlUpdate );
      st.setString(  1, record.getTitle());
      st.setString(  2, record.getNotes());
      st.setString(  3, record.getPriority());
      st.setString(  4, ((WorkOrder) record).getOrderType());
      st.setString(  5, ((WorkOrder) record).getManagementGroup());
      st.setString(  6, ((WorkOrder) record).getSupportGroup());
      st.setString(  7, ((WorkOrder) record).getStatus());
      st.setString(  8, ((WorkOrder) record).getStatusReason());
      st.setString(  9, record.getCategoryLevel01());
      st.setString( 10, record.getCategoryLevel02());
      st.setString( 11, record.getCategoryLevel03());
      st.setString( 12, record.getProductLevel01());
      st.setString( 13, record.getProductLevel02());
      st.setString( 14, record.getProductLevel03());
      st.setInt( 15, record.getID());

      st.executeQuery();
      result = st.getUpdateCount();

      if ( result <= 0 )
         throw new Exception("No se pudo actualizar el ticket del requerimiento " + record.getRemedyID());

    } catch ( Exception ex ) {

      this.warn("update", "Ocurri\u00f3 un problema actualizando el ticket del requerimiento", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return result;
  }

}
