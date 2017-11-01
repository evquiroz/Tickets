package mx.com.nttdata.remedy.api;

/**
 * Interface para soportar operaciones estandar de la API de Remedy
 * @version 1.0.0
 */
public interface ApiConsumer {
  
  
  /** Nombre de la forma usada con los incidentes */
  final static String FORM_INCIDENT     = "HPD:IncidentInterface_Create";
  /** Nombre de la forma usada con las requisiciones */
  final static String FORM_WORKORDER    = "WOI:WorkOrderInterface_Create";
  /** Nombre de la forma para recuperar nombre en base al usuario */ 
  final static String FORM_QUERY        = "CTM:People";
  
  /** Accion predeterminada para los tickets */
  final static String TICKET_ACTION     = "CREATE";
  /** Valor para usar como apellido del cliente */
  final static String LAST_NAME         = "SIEM";
  /** Organizacion de soporte para los incidentes */
  final static String INC_SUPPORT_ORG   = "Assigned_Support_Organization";
  final static String INC_SOURCE_VALUE  = "Web";
  
  //// Valores comunes
  
  final static int REM_STATUS           = 7;
  final static int REM_SUMMARY          = 1000000000;
  final static int REM_DESCRIPTION      = 1000000151;  
  final static int REM_CAT_TIER_1       = 1000000063;
  final static int REM_CAT_TIER_2       = 1000000064;
  final static int REM_CAT_TIER_3       = 1000000065;
  final static int REM_ACTION           = 1000000076;
  
  //// IDs de los campos requeridos para las requisiciones
  
  final static int INC_CONTACT_COMPANY  = 1000000082;
  final static int INC_FIRST_NAME       = 1000000019;
  final static int INC_LAST_NAME        = 1000000018;
  final static int INC_SUP_COMPANY      = 1000000251;
  final static int INC_SUPP_ORG         = 1000000014;
  final static int INC_ASSIGNED_GROUP   = 1000000217;
  final static int INC_IMPACT           = 1000000163;
  final static int INC_URGENCY          = 1000000162;
  final static int INC_SERVICE_TYPE     = 1000000099;
  final static int INC_SOURCE           = 1000000215;
  final static int INC_PROD_CAT_TIER_1  = 200000003;
  final static int INC_PROD_CAT_TIER_2  = 200000004;
  final static int INC_PROD_CAT_TIER_3  = 200000005;
      
  //// IDs de los campos requeridos para las ordenes de trabajo
  
  final static int WO_CONTACT_COMPANY   = 1000003299;
  final static int WO_FIRST_NAME        = 1000003297;
  final static int WO_LAST_NAME         = 1000003298;
  final static int WO_SUP_COMPANY       = 1000003228;
  final static int WO_SUPP_ORG          = 1000003227;
  final static int WO_ASSIGNED_GROUP    = 1000003229;
  final static int WO_PRIORITY          = 1000000164;
  final static int WO_TYPE              = 1000000181;
  final static int WO_PROD_CAT_TIER_1   = 1000001270; 
  final static int WO_PROD_CAT_TIER_2   = 1000001271;
  final static int WO_PROD_CAT_TIER_3   = 1000001272;
  final static int WO_LOCATION_COMPANY  = 1000000001;      
  final static int WO_PETITION_MGR      = 1000000403;
  final static int WO_ASSIGNED_USER     = 1000003230;

  final static int WO_CUST_COMPANY      = 1000000082;
  final static int WO_CUST_FIRST_NAME   = 1000000019;
  final static int WO_CUST_LAST_NAME    = 1000000018;  
  
  /** ID del usuario empleado para recuperar el nombre del usuario */
  final static int QRY_REMEDY_LOGIN_ID  = 4;
  /** ID del campo que tiene los apellidos del usuario */
  final static int QRY_LAST_NAME        = 1000000018;
  /** ID del campo que tiene los nombres del usuario */
  final static int QRY_FIRST_NAME       = 1000000019;

  final static String NAMES_SEPARATOR   = ",";
  final static String QRY_LOGIN_TAG     = "##LOGIN##";
  final static String QRY_QUALIFIER     = "'Remedy Login ID' = \"##LOGIN##\"";
  final static String QRY_SCHEMA        = "CTM:People";
  
  // final static int    QRY_TICKET_ID     = 1000000161;
  final static String QRY_TICKET_ID     = "1000000161";
                                           
                                           
  final static String WO_PET_MGR_NAME   = "G. ARTURO RAYA BERNAL";
  final static String WO_SUP_GROUP_NAME = "MESA DE SERVICIO";

  final static int    WO_REQ_MGR_ID     = 1000000015;                                          
  final static String WO_REQ_MGR_NAME   = "MESA DE SERVICIO";
  
}
