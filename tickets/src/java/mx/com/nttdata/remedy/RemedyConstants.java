package mx.com.nttdata.remedy;

/**
 * Constantes comunes a clases wue consumen los Servicios Web de Remedy 
 * @author NTT Data
 */
public interface RemedyConstants {
    
  final static String AUTH_NODE_NAME   = "AuthenticationInfo";
  final static String USER_NODE_NAME   = "userName";
  final static String PWD_NODE_NAME    = "password";

  
  // final static String DS_FIRST_NAME = "firstName";
  // final static String DS_LAST_NAME  = "lastName";
  // final static String DS_EMAIL      = "email";  
  
 
  /** Constante llave para los nombres propios recuperados */  
  final static String KEY_FIRST_NAME   = "firstName";
  /** Constante llave para los apellidos recuperados */
  final static String KEY_LAST_NAME    = "lastName";
  /** Constante llave para el correo */
  final static String KEY_EMAIL        = "email";  
  
  final static String DEF_AS_ORG       = "Assigned_Support_Organization";  
  final static String DEF_LAST_NAME    = "SIEM";  
    
}
