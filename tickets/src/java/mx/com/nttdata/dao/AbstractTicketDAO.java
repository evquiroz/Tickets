package mx.com.nttdata.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.WorkOrder;

/**
 * DAO que provee metodos genericos a los daos que manejan los
 * @version 1.0.0
 */
public abstract class AbstractTicketDAO extends AbstractDAO implements ITicketDAO {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 9022349100494032168L;

  /** Texto a buscar para ser reemplazado con el nombre de la tabla */
  public final static String TABLE_MARKER = "##TABLE_NAME##";
  /** Texto a buscar para ser reemplazado con el nombre de la llave primaria de la tabla */
  public final static String KEY_MARKER = "##PRIMARY_KEY##";

  /** Query global para consultar un registro registros */
  protected final static String SQL_READ = "SELECT * FROM ##TABLE_NAME## WHERE ##PRIMARY_KEY## = ?";
  /** Query global para eliminar registros */
  protected final static String SQL_DELETE = "DELETE FROM ##TABLE_NAME## WHERE ##PRIMARY_KEY## = ?";
  /** Query global para consultar varios registros */
  protected final static String SQL_LIST = "SELECT * FROM ##TABLE_NAME##";

  /** Nombre de la tabla que maneja los datos */
  protected String tableName;
  /** Nombre de la columna llave primaria de la tabla */
  protected String tableKey;
  /** Etiqueta con el tipo de ticket a usar con el nombre del tipo de ticket */
  protected String ticketLabel;

  /** query para insertar registros */
  protected String sqlCreate;
  /** Query para recuperar registros */
  protected String sqlRead;
  /** Query para actualizar registros */
  protected String sqlUpdate;
  /** Query para eliminar registros */
  protected String sqlDelete;
  /** Query para listar registros */
  protected String sqlList;


  /**
   * Constructor predeterminado
   * @param ds DataSource que provee las conexiones a las base de datos
   * @param tableName Nombre de la tabla a la que se acceden con los registros
   * @param tableKey Llave primaria de la tabla
   */
  public AbstractTicketDAO( DataSource ds, String tableName, String tableKey ) {

    super();
    this.dataSource  = ds;
    this.tableName   = tableName;
    this.tableKey    = tableKey;
    this.sqlDelete   = SQL_DELETE.replaceAll( TABLE_MARKER, tableName ).replaceAll( KEY_MARKER, tableKey );
    this.sqlRead     = SQL_READ.replaceAll( TABLE_MARKER, tableName ).replaceAll( KEY_MARKER, tableKey );
    this.sqlList     = SQL_LIST.replaceAll( TABLE_MARKER, tableName );
    this.ticketLabel = this.tableName.equalsIgnoreCase( INCIDENTS_TABLE )
                     ? LBL_INCIDENT : LBL_WORK_ORDER;
  }

  /**
   * Elimina un registro de la base de datos
   * @param ticketID ID del ticket a eliminar
   * @return Codigo de retorno de la operacion
   * @throws Exception En caso de que algo falle
   */
  @Override
  public int delete( Integer ticketID ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;

    debug("delete", "Sql: [" + this.sqlDelete + "]");
    debug("delete", "ID:  [" + ticketID + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlDelete );
      st.setInt( 1, ticketID );
      st.execute();
      if ( st.getUpdateCount() >= 1 )
         return 1;

    } catch ( Exception ex ) {

      this.warn("delete", "Ocurri\u00f3 un problema borrando el " + ticketLabel + "  '" + ticketID + "'", ex );

    } finally {

      this.freeJdbc( conn, st );
    }
    return 0;
  }

  /**
   * Crea un objeto nuevo depeniendo de que tipo de tabla se esta usando
   * @return Objeto nuevo derevidado de ITicket
   */
  public ITicket getNewTicket() {

    return this.tableName.equalsIgnoreCase( INCIDENTS_TABLE ) ? new Incident() : new WorkOrder();
  }

  /**
   * Devuelve una lista de los tickets
   * @param criteria Crietrio de filtracion de los tickets (Sige sintaxis SQL)
   * @param order Lista de campos que complementan la clausula ORDER
   * @return Lista de beans con los registro recuperados
   * @throws Exception En caso de que algo falle
   */
  @Override
  public List<ITicket> list( String criteria, String order ) throws Exception {

    Connection    conn   = null;
    Statement     st     = null;
    ResultSet     rs     = null;
    List<ITicket> result = new ArrayList<>();
    ITicket       item;
    String        sql    = this.sqlList;
    if ( criteria != null && !criteria.isEmpty())
       sql += " WHERE " + criteria;
    if ( order != null && !order.isEmpty())
       sql += " ORDER BY " + order;

    debug("list", "Sql: [" + sql + "]");

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
         this.warn( "list", "No se encontraron registro de: " + this.ticketLabel );

    } catch ( Exception ex ) {

      this.warn("list", "Ocurri\u00f3 un problema listando los registros de tipo: " + this.ticketLabel, ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

  /**
   * Recupera los valores del ResultSet y los pone en el objeto correspondiente
   * @param record Registro a utilizar
   * @return Bean con la informacion extraida
   * @throws Exception En caso de que algo falle
   */
  protected ITicket parseRecord( ResultSet record ) throws Exception {

    ITicket bean = this.getNewTicket();
    bean.setID( record.getInt( this.tableKey ));
    bean.setRemedyID( record.getString( COL_REMEDY_ID ));
    bean.setCompanyName( record.getString( COL_CNAME ));
    bean.setCustomer( record.getString( COL_CUSTOMER ));
    bean.setTitle( record.getString( COL_TITLE ));
    bean.setNotes( record.getString( COL_NOTES ));
    bean.setPriority( record.getString( COL_PRIORITY ));

    if ( this.tableName.equalsIgnoreCase( INCIDENTS_TABLE ))
    {
       ((Incident) bean).setImpact( COL_IMPACT );
       ((Incident) bean).setUrgency( COL_URGENCY );
       ((Incident) bean).setAssignedGroup( COL_ASSIGN_GROUP );
    }
    else
    {
       ((WorkOrder) bean).setOrderType( COL_ORDER_TYPE );
       ((WorkOrder) bean).setManagementGroup( COL_MGMT_GROUP );
       ((WorkOrder) bean).setSupportGroup( COL_SUPP_GROUP );
       ((WorkOrder) bean).setStatus( COL_ORDER_STATUS );
       ((WorkOrder) bean).setStatusReason( COL_ST_REASON );
    }

    bean.setSource( record.getString( COL_SOURCE ));
    bean.setCategoryLevel01( record.getString( COL_CAT_LVL_01 ));
    bean.setCategoryLevel02( record.getString( COL_CAT_LVL_02 ));
    bean.setCategoryLevel03( record.getString( COL_CAT_LVL_03 ));
    bean.setProductLevel01( record.getString( COL_PRODLVL_01 ));
    bean.setProductLevel02( record.getString( COL_PRODLVL_02 ));
    bean.setProductLevel03( record.getString( COL_PRODLVL_03 ));

    return bean;
  }

  /**
   * Devuelve un registro de la base de datos
   * @param ticketID ID del registro a recuperar
   * @return Un bean con los datos recuperados
   * @throws Exception En caso de que algo falle
   */
  @Override
  public ITicket read( Integer ticketID ) throws Exception {

    Connection        conn      = null;
    PreparedStatement st        = null;
    ResultSet         rs        = null;
    ITicket           result    = this.getNewTicket();

    debug("read", "Sql: [" + this.sqlRead + "]");
    debug("read", "ID:  [" + ticketID + "]");

    try {
      conn = this.getConnection();
      st   = conn.prepareStatement( this.sqlRead );
      st.setInt( 1, ticketID );
      rs   = st.executeQuery();
      if ( rs.next())
         return this.parseRecord( rs );

    } catch ( Exception ex ) {

      this.warn("read", "Ocurri\u00f3 un problema leyendo el " + this.ticketLabel +  " '" + ticketID + "'", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

}
