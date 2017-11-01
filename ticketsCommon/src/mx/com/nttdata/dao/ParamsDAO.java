package mx.com.nttdata.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import mx.com.nttdata.beans.Parameters;
import mx.com.nttdata.beans.IncidentParams;
import mx.com.nttdata.beans.WorkOrderParams;

/**
 * DAO para el manejo de los parametros de la aplicacion
 * @version 1.0.0
 */
public class ParamsDAO extends AbstractDAO implements IParamsDAO {


  /** Auxiliar de serialiacion */
  private static final long serialVersionUID = -6038877064712452284L;

  /** Query de lectura de los parametros */
  private final static String SQL_READ = "SELECT * FROM Tck_Params";


  /**
   * Constructor predeterminado
   */
  public ParamsDAO() {

    super();
  }

  /**
   * Constructor preferido
   * @param ds Datasource a ser utilizado en la conexion a la base de datos
   */
  public ParamsDAO( DataSource ds ) {

    this();
    this.dataSource = ds;
  }

  @Override
  public Parameters read() throws Exception {

    Connection      conn      = null;
    Statement       st        = null;
    ResultSet       rs        = null;
    Parameters      result    = new Parameters();
    IncidentParams  incParams = result.getIncidentDefaults();
    WorkOrderParams woParams  = result.getOrderDefaults();

    debug("read", "Sql: [" + SQL_READ + "]");

    try {
      conn = this.getConnection();
      st   = conn.createStatement(  ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
      rs   = st.executeQuery( SQL_READ );
      if ( rs.next())
      {
         result.setSendSMS( rs.getInt( PAR_COL_SEND_MSGS ) == 1 );
         result.setCompanyName( rs.getString( PAR_COL_COMPANY ));

         incParams.setSource( rs.getString( PAR_COL_INC_SOURCE ));
         incParams.setStatus( rs.getString( PAR_COL_INC_STATUS ));
         incParams.setReason( rs.getString( PAR_COL_INC_ST_REASON ));
         incParams.setServiceType( rs.getString( PAR_COL_INC_STYPE ));
         incParams.setImpact( rs.getString( PAR_COL_INC_IMPACT ));
         incParams.setUrgency( rs.getString( PAR_COL_INC_URGENCY ));
         incParams.setPriority( rs.getString( PAR_COL_INC_PRIORITY ));
         incParams.setGroup( rs.getString( PAR_COL_INC_GROUP ));
         incParams.setSupportGroup( rs.getString( PAR_COL_INC_SUPP_ORG ));
         incParams.setAction( rs.getString( PAR_COL_INC_ACTION ));
         incParams.setCategoryLevel01( rs.getString( PAR_COL_INC_CAT_LVL_01 ));
         incParams.setCategoryLevel02( rs.getString( PAR_COL_INC_CAT_LVL_02 ));
         incParams.setCategoryLevel03( rs.getString( PAR_COL_INC_CAT_LVL_03 ));
         incParams.setProductLevel01( rs.getString( PAR_COL_INC_PROD_LVL_01 ));
         incParams.setProductLevel02( rs.getString( PAR_COL_INC_PROD_LVL_02 ));
         incParams.setProductLevel03( rs.getString( PAR_COL_INC_PROD_LVL_03 ));
         incParams.setLastName( rs.getString( PAR_COL_INC_LASTNAME ));
         incParams.setPersonID( rs.getString( PAR_COL_INC_PERSON_ID ));

         woParams.setOrderType( rs.getString( PAR_COL_WO_ORDER_TYPE ));
         woParams.setManagementGroup( rs.getString( PAR_COL_WO_GRP_ADMIN ));
         woParams.setSupportGroup( rs.getString( PAR_COL_WO_SUPP_GROUP ));
         woParams.setStatus( rs.getString( PAR_COL_WO_STATUS ));
         woParams.setReason( rs.getString( PAR_COL_WO_ST_REASON ));
         woParams.setPriority( rs.getString( PAR_COL_WO_PRIORITY ));
         woParams.setAction( rs.getString( PAR_COL_WO_ACTION ));
         woParams.setSource( rs.getString( PAR_COL_WO_SOURCE ));
         woParams.setCategoryLevel01( rs.getString( PAR_COL_WO_CAT_LVL_01 ));
         woParams.setCategoryLevel02( rs.getString( PAR_COL_WO_CAT_LVL_02 ));
         woParams.setCategoryLevel03( rs.getString( PAR_COL_WO_CAT_LVL_03 ));
         woParams.setProductLevel01( rs.getString( PAR_COL_WO_PROD_LVL_01 ));
         woParams.setProductLevel02( rs.getString( PAR_COL_WO_PROD_LVL_02 ));
         woParams.setProductLevel03( rs.getString( PAR_COL_WO_PROD_LVL_03 ));
         woParams.setLastName( rs.getString( PAR_COL_WO_LASTNAME ));
         woParams.setPersonID( rs.getString( PAR_COL_WO_PERSON_ID ));
         
         result.setIncidentDefaults( incParams );
         result.setOrderDefaults( woParams );
      }
      else
         throw new Exception("No se encontraron par\u00e1metros para la aplicaci\u00f3n");

    } catch ( Exception ex ) {

      this.warn("read", "Ocurri\u00f3 un problema leyendo los par\u00e1metros de la aplicaci\u00f3", ex );

    } finally {

      this.freeJdbc( conn, st, rs );
    }
    return result;
  }

}
