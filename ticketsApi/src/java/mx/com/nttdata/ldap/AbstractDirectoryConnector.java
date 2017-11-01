package mx.com.nttdata.ldap;


import mx.com.nttdata.util.IGlobalConstants;
import org.apache.log4j.Logger;

/**
 * Clase abstracta que provee codigo comun a los conectores de LDAP
 * @version 1.0.0
 */
public abstract class AbstractDirectoryConnector implements IDirectoryConnector, IConnectionParams {

          
  /** Log de la aplicacion */
  protected Logger logger;

  /** Hostname o IP address del servidor por omision, incluye el puerto */
  protected String serviceHost;
  /** Puerto de conexion */
  protected String port;
  /** Nombre del usuario de conexion al servicio de directorio, usualmente 'root' */
  protected String ldapUser;
  /** Contrasenna del usuario de conexion al directorio */
  protected String ldapSecret;
  /** Organizacion */
  protected String organization;
  /** Rama de base de busqueda */
  protected String initialBranch;
  /** Grupo de inicio para todos los usuarios */
  protected String initialGroup;
  /** Directorio cuando usamos Active Directory */
  protected String domain;
  
  /** Cadena con el resto de atributos de la conexion al arbol para las operaciones */
  protected String suffix;


  /**
   * Constructor predeterminado
   */
  public AbstractDirectoryConnector() {

    super();
    this.logger = Logger.getLogger( this.getClass());
    this.port   = LDAP_DEFAULT_PORT;
    this.domain = IGlobalConstants.EMPTY_STRING;
  }

  /**
   * Constructor preferido
   * @param host Servidor de LDAP
   * @param user usario a conectarse
   * @param secret Contrasenna del usuario
   * @param org Nodo de la organizacion
   * @param branch Ramo inicial de la conexion
   * @param group Grupo inicial de la conexion
   */
  public AbstractDirectoryConnector( String host, String user, String secret, String org, String branch, String group ) {

    this();
    this.serviceHost = host;
    this.ldapUser = user;
    this.ldapSecret = secret;
    this.initialBranch = branch;
    this.initialGroup = group;
    this.organization = org;

    this.suffix = IGlobalConstants.EMPTY_STRING;
    if ( group != null && !group.isEmpty())
       this.suffix += TAG_SEP + TAG_GROUP + TAG_ASSIGN + group;
    this.suffix += TAG_SEP + TAG_ORG + TAG_ASSIGN + this.organization;
  }

  /**
   * Devuelve el ID interno de LDAP para el usuario
   * @param userDN Entrada DN del usuario
   * @return Una cadena con el valor LDAP para el usuario
   */
  protected String extractUserID( String userDN ) {

    int start = userDN.indexOf( TAG_ASSIGN );
    int end = userDN.indexOf( TAG_SEP );

    if ( end == -1 )
       end = userDN.length();
    return userDN.substring( start + 1, end );
  }

  //// Getters y setters

  public String getHost() {

   return serviceHost;
  }

  public String getPort() {

    return port;
  }
  
  public String getDomain() { 
      
    return domain;
  }

  public String getQuaifiedUser( String user ) { 
      
    StringBuilder cn = new StringBuilder( user );
    if ( this.domain != null && !this.domain.isEmpty())
       cn.append( TAG_AT ).append( this.domain );
    return cn.toString();
  }
  
  public String getUser() {

    return ldapUser;
  }

  public String getUserSecret() {

    return ldapSecret;
  }

  public String getOrganization() {

    return this.organization;
  }

  public String getInitialBranch() {

    return initialBranch;
  }

  public String getInitialGroup() {

    return initialGroup;
  }

  public void setHost( String host ) {

    this.serviceHost = host;
  }

  public void setPort( String port ) {

    this.port = port;
  }
  
  public void setDomain( String domain ) { 
      
    this.domain = domain;
  }

  public void setUser( String user ) {

    this.ldapUser = user;
  }

  public void setUserSecret( String secret ) {

    this.ldapSecret = secret;
  }

  public void setOrganization( String org ) {

    this.organization = org;
  }

  public void setInitialBranch( String initialBranch ) {

    this.initialBranch = initialBranch;
  }

  public void setInitialGroup( String initialGroup ) {

    this.initialGroup = initialGroup;
  }

}
