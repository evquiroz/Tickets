package mx.com.nttdata.ldap;

import mx.com.nttdata.util.IGlobalConstants;

/**
 * Interface para proveer algunas constantes de LDAP
 * @version 1.0.0
 */
public interface IConnectionParams {

    /** Constante que se devuelve cuando se valido el acceso al directorio satisfactoriamente */
    final static int LDAP_VALID_USER         = IGlobalConstants.LOGIN_AUTHENTICATED_CODE;
    /** Constante que se devuelve cuando el usuario existe pero no coicide su password */
    final static int LDAP_INVALID_SECRET     = IGlobalConstants.LOGIN_REJECTED_CODE;
    /** Constante que se devuelve cuando el usuario no existe en el directorio */
    final static int LDAP_INVALID_USER       = 503;
    /** Constante que se devuelve cuando la rama o grupo donde se busca no existe */
    final static int LDAP_INVALID_BRANCH     = 502;
    /** Constante que se devuelve cuando hay un error de conexion con el servidor */
    final static int LDAP_CONN_ERROR         = IGlobalConstants.LOGIN_NO_SERVICE_CODE;
    /** Constante que se devuelve cuando el servicio no esta disponbile */
    final static int LDAP_SERVICE_UNVAILABLE = -9999;

    /** Contexto inicial de conexion al LDAP */
    final static String DEFAULT_CONTEXT      = "com.sun.jndi.ldap.LdapCtxFactory";
    /** Paquete de las clases de JNDI que carga dinamicamente */
    final static String DEFAULT_PACKAGE      = "com.sun.jndi.url";
    /** Modo de validar las referencias entre nodos */
    final static String DEFAULT_REFERRAL     = "ignore";
    /** Modo de autenticacion */
    final static String DEFAULT_AUTH_TYPE    = "simple";
    /** Prefijo de conexion, protocolo */
    final static String URL_PREFIX           = "ldap://";

    /** Puerto estandar de LDAP */
    final static String LDAP_DEFAULT_PORT    = "389";
}
