package mx.com.nttdata.ldap;


import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import mx.com.nttdata.util.IGlobalConstants;


/**
 * Manejador de conexiones LDAP
 * @version 1.0.0
 */
public class DirectoryConnector extends AbstractDirectoryConnector {

  /**
   * Constructor predeterminado
   */
  public DirectoryConnector() {

    super();
    this.port = LDAP_DEFAULT_PORT;
  }

  /**
   * Constructor completo
   * @param host Servidor de LDAP
   * @param user usario a conectarse
   * @param secret Contrasenna del usuario
   * @param org Nodo de la organizacion
   * @param branch Ramo inicial de la conexion
   * @param group Grupo inicial de la conexion
   */
  public DirectoryConnector( String host, String user, String secret, String org, String branch, String group ) {

    super( host, user, secret, org, branch, group );
  }

  /**
   * Valida si el usuario y su contrasenna son validos para el ldap
   * @param login Nombre de usuario a validar
   * @param pwd Contrasenna a validad
   * @return El codigo correspondiente al resultado de la validacion
   */
  @Override
  public int authenticate( String login, String pwd ) {

    Properties props = new Properties();
    props.setProperty( Context.INITIAL_CONTEXT_FACTORY, DEFAULT_CONTEXT );

    String url    = URL_PREFIX + this.serviceHost;
    if ( !( LDAP_DEFAULT_PORT.equals( this.port )))
       url +=  ":" + this.port;
    props.setProperty( Context.PROVIDER_URL,  url );
    props.setProperty( Context.URL_PKG_PREFIXES, DEFAULT_PACKAGE );

    props.setProperty( Context.REFERRAL, DEFAULT_REFERRAL );
    props.setProperty( Context.SECURITY_AUTHENTICATION, DEFAULT_AUTH_TYPE );

    String principalName;
    
    if ( this.domain != null && !this.domain.isEmpty())
        principalName = this.getQuaifiedUser( login );
    else
    {    
        principalName = TAG_UIN + TAG_ASSIGN + login;
        principalName += TAG_SEP + this.getInitialBranch();
    }
    logger.debug("Autenticando a: " + principalName);

    props.setProperty( Context.SECURITY_PRINCIPAL, principalName  );
    props.setProperty( Context.SECURITY_CREDENTIALS, this.ldapSecret );

    DirContext ctx;
    try {

      ctx = new InitialDirContext( props );
      logger.debug("LDAP. Authentication succeeded for: " + login );

    } catch ( Exception ex ) {

      logger.error("LDAP. error autenticando al usuario: " + login, ex );
      return IGlobalConstants.LOGIN_REJECTED_CODE;

    }
    return IGlobalConstants.LOGIN_AUTHENTICATED_CODE;
  }

}
