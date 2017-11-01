package mx.com.nttdata.dao;

import mx.com.nttdata.beans.Parameters;

/**
 * Interfaz que modela el comportamiento del DAO de manejo de parametros de la
 * aplicacion
 * @version 1.0.0
 */
public interface IParamsDAO {

    //// Nombre dea las columnas de las tablas de parametros
    
    public final static String PAR_COL_SEND_MSGS       = "SendMessages";     
    public final static String PAR_COL_COMPANY         = "CompanyName";       
    public final static String PAR_COL_INC_SOURCE      = "Def_Inc_Source";   
    public final static String PAR_COL_INC_STATUS      = "Def_Inc_Status"; 
    public final static String PAR_COL_INC_ST_REASON   = "Def_Inc_StReason"; 
    public final static String PAR_COL_INC_STYPE       = "Def_Inc_ServType";
    public final static String PAR_COL_INC_IMPACT      = "Def_Inc_Impact";   
    public final static String PAR_COL_INC_URGENCY     = "Def_Inc_Urgency";   
    public final static String PAR_COL_INC_PRIORITY    = "Def_Inc_Priority"; 
    public final static String PAR_COL_INC_GROUP       = "Def_Inc_Group";  
    public final static String PAR_COL_INC_SUPP_ORG    = "Def_Inc_SuppOrg";  
    public final static String PAR_COL_INC_ACTION      = "Def_Inc_Action"; 
    public final static String PAR_COL_INC_CAT_LVL_01  = "Def_Inc_CLvl01";   
    public final static String PAR_COL_INC_CAT_LVL_02  = "Def_Inc_CLvl02";    
    public final static String PAR_COL_INC_CAT_LVL_03  = "Def_Inc_CLvl03";   
    public final static String PAR_COL_INC_PROD_LVL_01 = "Def_Inc_PLvl01"; 
    public final static String PAR_COL_INC_PROD_LVL_02 = "Def_Inc_PLvl02";   
    public final static String PAR_COL_INC_PROD_LVL_03 = "Def_Inc_PLvl03";
    public final static String PAR_COL_INC_LASTNAME    = "Def_Inc_LastName"; 
    public final static String PAR_COL_INC_PERSON_ID   = "Def_Inc_Person_ID"; 
    public final static String PAR_COL_WO_ORDER_TYPE   = "Def_WO_OrdType";   
    public final static String PAR_COL_WO_GRP_ADMIN    = "Def_WO_GrpAdm";     
    public final static String PAR_COL_WO_SUPP_GROUP   = "Def_WO_GrpSop"; 
    public final static String PAR_COL_WO_STATUS       = "Def_WO_Status"; 
    public final static String PAR_COL_WO_ST_REASON    = "Def_WO_StReason"; 
    public final static String PAR_COL_WO_PRIORITY     = "Def_WO_Priority"; 
    public final static String PAR_COL_WO_ACTION       = "Def_WO_Action";    
    public final static String PAR_COL_WO_SOURCE       = "Def_WO_Source";  
    public final static String PAR_COL_WO_CAT_LVL_01   = "Def_WO_CLvl01";    
    public final static String PAR_COL_WO_CAT_LVL_02   = "Def_WO_CLvl02";     
    public final static String PAR_COL_WO_CAT_LVL_03   = "Def_WO_CLvl03"; 
    public final static String PAR_COL_WO_PROD_LVL_01  = "Def_WO_PLvl01"; 
    public final static String PAR_COL_WO_PROD_LVL_02  = "Def_WO_PLvl02"; 
    public final static String PAR_COL_WO_PROD_LVL_03  = "Def_WO_PLvl03";
    public final static String PAR_COL_WO_LASTNAME     = "Def_WO_LastName";  
    public final static String PAR_COL_WO_PERSON_ID    = "Def_WO_Person_ID";

  /**
   * Recupera de la base de datos parametyros generales de la aplicacion
   * @return Un bean con los parametros de la aplicacion
   * @throws Exception  Si no se puede conetcar a la base de datos
   */
  Parameters read() throws Exception;

}
