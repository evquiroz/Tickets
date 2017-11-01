package mx.com.nttdata.dao;

import java.util.List;

import mx.com.nttdata.beans.ITicket;

/**
 * Interfaz que modela los DAOS que crean tickets
 * @version 1.0.0
 */
public interface ITicketDAO {

  /** Nombre de la tabla de incidentes */
  final static String INCIDENTS_TABLE   = "Tck_Incidents";
  /** Nombre de la tabla de ordenes de trabajo */
  final static String WORK_ORDERS_TABLE = "Tck_WorkOrders";
  /** Nombre de la llave primaria de la tabla de incidentes */
  final static String INCIDENTS_KEY     = "IncidentID";
  /** Nombre de la llave primaria de la tabla de ordenes de trabajo */
  final static String WORK_ORDERS_KEY   = "WorkOrderID";

  /** Etiqueta para los incidentes */
  final static String LBL_INCIDENT      = "incidente";
  /** Etiqueta para las ordenes de trabajo */
  final static String LBL_WORK_ORDER    = "orden de trabajo";


  // Nombres de columnas de las incidencias y ordenes de trabajo

  final static String COL_INCIDENT_ID   = "IncidentID";
  final static String COL_REMEDY_ID     = "RemedyID";
  final static String COL_CNAME         = "CompanyName";
  final static String COL_CUSTOMER      = "Customer";
  final static String COL_TITLE         = "Title";
  final static String COL_NOTES         = "Notes";
  final static String COL_IMPACT        = "Impact";
  final static String COL_URGENCY       = "Urgency";
  final static String COL_PRIORITY      = "Priority";
  final static String COL_SOURCE        = "Source";
  final static String COL_ASSIGN_GROUP  = "AssignedGroup";
  final static String COL_CAT_LVL_01    = "Category_Lvl01";
  final static String COL_CAT_LVL_02    = "Category_Lvl02";
  final static String COL_CAT_LVL_03    = "Category_Lvl03";
  final static String COL_PRODLVL_01    = "Product_Lvl01";
  final static String COL_PRODLVL_02    = "Product_Lvl02";
  final static String COL_PRODLVL_03    = "Product_Lvl03";
  final static String COL_WO_ID         = "WorkOrderID";
  final static String COL_ORDER_TYPE    = "Order_Type";
  final static String COL_MGMT_GROUP    = "Mngmt_Group";
  final static String COL_SUPP_GROUP    = "Support_Group";
  final static String COL_ORDER_STATUS  = "Order_Status";
  final static String COL_ST_REASON     = "Status_Reason";


  /**
   * Inserta un registro en la base de datos
   * @param record Bean con la informacion del registro a insertar
   * @return Codigo de retorno de la operacion
   * @throws Exception En caso de que algo falle
   */
  int create( ITicket record ) throws Exception;

  /**
   * Elimina un registro de la base de datos
   * @param ticketID ID del ticket a eliminar
   * @return Codigo de retorno de la operacion
   * @throws Exception En caso de que algo falle
   */
  int delete( Integer ticketID ) throws Exception;

  /**
   * Devuelve una lista de los tickets
   * @param criteria Crietrio de filtracion de los tickets (Sige sintaxis SQL)
   * @param order Lista de campos que complementan la clausula ORDER
   * @return Lista de beans con los registro recuperados
   * @throws Exception En caso de que algo falle
   */
  List<ITicket> list( String criteria, String order ) throws Exception;

  /**
   * Devuelve un registro de la base de datos
   * @param ticketID ID del registro a recuperar
   * @return Un bean con los datos recuperados
   * @throws Exception En caso de que algo falle
   */
  ITicket read( Integer ticketID ) throws Exception;

  /**
   * Actualiza un registro en la base de datos
   * @param record Bean con la informacion a actualizar
   * @return Codigo de retorno de la operacion
   * @throws Exception En caso de que algo falle
   */
  int update( ITicket record ) throws Exception;

}
