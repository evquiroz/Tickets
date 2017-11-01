package mx.com.nttdata.ldap;

/**
 * Interfaz que modela el comportamiento de los conectores a servicios de LDAP
 * @version 1.0.0
 */
public interface IDirectoryConnector {

  // Misc constants    
  final static String TAG_SEP    = ",";  
  final static String TAG_ASSIGN = "=";
  final static String TAG_UIN    = "uid";  
  final static String TAG_ORG    = "o";
  final static String TAG_GROUP  = "ou";
  final static String TAG_AT     = "@";
    
  /**
   * Valida si el usuario y su contrasenna son validos para el ldap
   * @param login Nombre de usuario a validar
   * @param pwd Contrasenna a validad
   * @return El codigo correspondiente al resultado de la validacion 
   */
  int authenticate( String login, String pwd );

}
