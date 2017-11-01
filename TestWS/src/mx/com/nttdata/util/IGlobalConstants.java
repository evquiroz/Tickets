package mx.com.nttdata.util;

/**
 * Interface para compartir constantes globales
 * @author version 1.0.0
 */
public interface IGlobalConstants {

  ////

  //// Archivos de propiedades

  final static String PROPERTIES_FILE       = "tickets.properties";
  final static String MESSAGES_FILE         = "labelsResources.properties";

  //// Codigos y mensajes de errror

  final static int    LOGIN_AUTHENTICATED_CODE = 200;
  final static int    LOGIN_REJECTED_CODE      = 404;
  final static int    LOGIN_NO_SERVICE_CODE    = 500;

  final static String LOGIN_ERROR_MSG       = "msg.login.accessDenied";
  final static String LOGIN_REJECTED_MSG    = "msg.login.accessDenied";
  final static String LOGIN_NO_SERVICE_MSG  = "msg.login.serviceUnavailable";

  //// Mensajes internos

  final static String LOGIN_REQUIRED_MSG    = "fld.login.required";
  final static String LOGIN_NAME_INV_MSG    = "fld.login.invalid";
  final static String SECRET_REQUIRED_MSG   = "fld.secret.required";
  final static String SECRET_VAL_INV_MSG    = "fld.secret.invalid";
  final static String APP_DEFAULT_MSG       = "msg.app.default";
  final static String TITLE_REQUIRED_MSG    = "fld.title.required";
  final static String NOTES_REQUIRED_MSG    = "fld.title.required";
  final static String POST_ERROR_MSG        = "msg.post.error";
  final static String INVALID_ACTION_MSG    = "msg.action.invalid";
  final static String INVALID_REC_ID_MSG    = "msg.recid.invalid";

  //// Nombres de las variables de sesion

  final static String SESS_LOGIN_NAME       = "appLoginName";
  final static String SESS_USER_NAME        = "appLocalUser";
  final static String SESS_USER_LEVEL       = "appLocalLvl";
  final static String SESS_ERROR_MSG        = "sessionErrorMsg";
  final static String SESS_ERROR_LOGIN      = "loginMsg";
  final static String SESS_ERROR_SECRET     = "secretMsg";
  final static String SESS_USER_LIST        = "userlist";
  final static String SESS_APP_MSG          = "appGlobalMsg";
  final static String SESS_APP_MSG_ACN      = "appMsgActionID";

  //// Valores en sesion
  final static String SESSION_APP_PARAMS    = "appParams";

  //// Propiedades a recuperar

  final static String PROP_DS_NAME          = "datasource.name";
  final static String PROP_DS_FACTORY       = "datasource.factory";

  final static String PROP_MAIL_HOST        = "mail.host";
  final static String PROP_MAIL_PORT        = "mail.port";
  final static String PROP_MAIL_USER        = "mail.user";
  final static String PROP_MAIL_PWD         = "mail.secret";
  final static String PROP_MAIL_SSL         = "mail.secure";
  final static String PROP_MAIL_FROM        = "mail.from";
  final static String PROP_MAIL_SUBJ        = "mail.subject";
  final static String PROP_MAIL_BODY        = "mail.body";

  final static String PROP_LDAP_HOST        = "ldap.host";
  final static String PROP_LDAP_PORT        = "ldap.port";
  final static String PROP_LDAP_USER        = "ldap.user";
  final static String PROP_LDAP_PWD         = "ldap.secret";
  final static String PROP_LDAP_BRANCH      = "ldap.branch";
  final static String PROP_LDAP_GROUP       = "ldap.group";
  final static String PROP_LDAP_EMAIL       = "ldap.email";
  final static String PROP_LDAP_DOMAIN      = "ldap.domain";

  final static String PROP_WS_TIMEOUT       = "ws.timeout";
  
  final static String PROP_WSI_URL          = "ws.inc.url";
  final static String PROP_WSI_PID          = "ws.inc.pid";
  final static String PROP_WSI_USER         = "ws.inc.user";
  final static String PROP_WSI_PWD          = "ws.inc.pwd";
  final static String PROP_WSI_ANAME        = "ws.inc.aname";
  final static String PROP_WSI_ACTION       = "ws.inc.action";

  final static String PROP_WSWO_URL         = "ws.wo.url";
  final static String PROP_WSWO_PID         = "ws.wo.pid";
  final static String PROP_WSWO_USER        = "ws.wo.user";
  final static String PROP_WSWO_PWD         = "ws.wo.pwd";
  final static String PROP_WSWO_ANAME       = "ws.wo.aname";
  final static String PROP_WSWO_ACTION      = "ws.wo.action";

  final static String PROP_CHAT_ENABLED     = "app.chat.enabled";
  final static String PROP_SOAP_DEBUG       = "app.soap.debug";
  final static String PROP_MOCK_REMEDY      = "app.mock.remedy";
  final static String PROP_DEV_MODE         = "app.dev.mode";
  // 
  final static String PROP_PEOPLE_URL       = "ws.people.url";
  final static String PROP_PEOPLE_USER      = "ws.people.user";
  final static String PROP_PEOPLE_PWD       = "ws.people.pwd";
  

  // Validation Mensages
  final static String MSG_LOGIN_EMTPY       = "user.form.login.empty";
  final static String MSG_LOGIN_INV         = "user.form.login.invalid";
  final static String MSG_LOGIN_NON_UNIQUE  = "user.form.login.repeated";
  final static String MSG_MAIL_EMTPY        = "user.form.mail.empty";
  final static String MSG_MAIL_INV          = "user.form.mail.invalid";
  final static String MSG_MAIL_NON_UNIQUE   = "user.form.mail.repeated";
  final static String MSG_PWD_EMTPY         = "user.form.pwd.empty";
  final static String MSG_PWD_INV           = "user.form.pwd.invalid";
  final static String MSG_CONF_EMTPY        = "user.form.conf.empty";
  final static String MSG_CONF_INV          = "user.form.conf.invalid";
  final static String MSG_PWD_NOT_EQUAL     = "user.form.conf.notequal";
  final static String MSG_LEVEL_EMTPY       = "user.form.lvl.empty";
  final static String MSG_LEVEL_INV         = "user.form.lvl.invalid";
  final static String MSG_STATUS_EMTPY      = "user.form.status.empty";
  final static String MSG_STATUS_INV        = "user.form.status.invalid";;

  // Web Pages Parameters

  final static String WEB_PARAM_ACTION      = "ac";
  final static String WEB_PARAM_ID          = "id";

  // Edition Actions

  final static int   ACN_CREATE_RECORD      = 1;
  final static int   ACN_UPDATE_RECORD      = 2;
  final static int   ACN_DELETE_RECORD      = 3;
  final static int   ACN_SAVE_NEW_RECORD    = 4;
  final static int   ACN_SAVE_EDIT_RECORD   = 5;

  //// Miscelaneos

  final static String WEBAPP_BASE_PATH      = "classpath:/";
  final static String EMPTY_STRING          = "";
  final static String INCIDENT_LABEL        = "Incidente";
  /** Nivel predeterminado de los usuarios */
  final static int    DEFAULT_USER_LEVEL    = 2;
  /** Estado predeterminado de los usuarios */
  final static String DEFAULT_USER_STATUS   = "A";
  /** Estado predeterminado del modo de desarrollo */
  final static int    DEF_DEV_MODE          = 0;
  final static String WOPRKORDER_LABEL      = "Requisici\u00f3n;";
  final static int    TICKET_INCIDENT       = 1;
  final static int    TICKET_WORKORDER      = 2;
  final static String MARKER_TICKET_NO      = "#ticketNo#";
  final static String MARKER_TICKET_DATE    = "#fecha#";
  final static String DEFAULT_SMTP_PORT     = "25";
  final static String DEFAULT_SMTP_SSL      = "0";
  final static String DEFAULT_LDAP_PORT     = "389";
  final static String BOOL_STRING_TRUE      = "1";
  final static String BOOL_STRING_FALSE     = "0";

  final static String WS_CONN_TIMEOUT       = "javax.xml.ws.client.connectionTimeout";
  final static String WS_RECEIVE_TIMEOUT    = "javax.xml.ws.client.receiveTimeout";
    
}
