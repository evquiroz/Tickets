package mx.com.nttdata.service;

import org.apache.log4j.Logger;

import mx.com.nttdata.ldap.DirectoryConnector;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;



/**
 * Servicio que hace el login contra el servicio de LDAP
 * @version 1.0.0
 */
public class LoginService implements IUserService {

  Logger logger;   

  /**
   * Constructor predeterminado
   */
  public LoginService() {

    super();
    this.logger = Logger.getLogger( this.getClass());
  }

  // TODO Dependiendo de lo que te den en Gentera
  public String getUserMail( String login, String secret ) {

    return null;
  }

  /**
   * Verifica si la combinacion de usuario y password son validos para acceso al
   * sistema
   * @param login Usuario a registrar
   * @param secret Password del usuario
   * @return el codigo resultante de la operacion
   */
  @Override
  public Integer authenticate( String login, String secret ) {

    String host   = Properties.getString( IGlobalConstants.PROP_LDAP_HOST   );
    String port   = Properties.getString( IGlobalConstants.PROP_LDAP_PORT,  IGlobalConstants.DEFAULT_LDAP_PORT );
    String branch = Properties.getString( IGlobalConstants.PROP_LDAP_BRANCH );
    String group  = Properties.getString( IGlobalConstants.PROP_LDAP_GROUP, IGlobalConstants.EMPTY_STRING );
    String domain = Properties.getString( IGlobalConstants.PROP_LDAP_DOMAIN, IGlobalConstants.EMPTY_STRING );

    if (( host == null || host.isEmpty() ) || ( branch == null || branch.isEmpty() ))
       return IGlobalConstants.LOGIN_NO_SERVICE_CODE;

    DirectoryConnector dc = new DirectoryConnector();
    logger.debug( "LoginService.authenticate. Hst: " + host );
    dc.setHost( host );
    dc.setPort( port );
    
    if ( domain != null && !domain.isEmpty()) { 
       dc.setDomain( domain );     
       logger.debug( "LoginService.authenticate. Usando ActiveDirectory: " + domain );
    }

    dc.setInitialBranch( branch );
    if ( !group.isEmpty())
       dc.setInitialGroup( group );
    dc.setDomain( domain );     
    dc.setUser( login );
    dc.setUserSecret( secret );
    int result = dc.authenticate( login, secret );

    return result;
  }

}
