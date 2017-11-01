package mx.com.nttdata.mail;

import org.apache.log4j.Logger;

/**
 * Clase abstracta que provee comportamiento compatido de para el envio de mensahes
 * por e-Mail
 * @version 1.0.0
 */
public class AbstractMailSender implements IMailSender {

   
  /** Log de la aplicacion */
  protected Logger logger;
  
  /** Servidor de envio de mensajes */
  protected String smtpHost;
  /** Puerto de SMTP */
  protected String smtpPort;  
  /** Usuario de conexion al servidor */
  protected String smtpUser;
  /** Secreto del usuario de conexion */
  protected String userSecret;
  /** Si se usa o no securidad */
  protected boolean enableSsl;
  
  
  /**
   * Constructor predeterminado 
   */
  public AbstractMailSender() {
    
    super();
    this.logger = Logger.getLogger( this.getClass());
    this.enableSsl = false;
  }

  /**
   * Constructor completo
   * @param host Servidor de envio de mensajes
   * @param port Puerto de SMTP
   * @param user Usuario de conexion al servidor 
   * @param secret Secreto del usuario de conexion
   */
  public AbstractMailSender( String host, String port, String user, String secret ) { 
    
    this();
    this.smtpHost = host;
    this.smtpPort = port;
    this.smtpUser = user;
    this.userSecret = secret;
    this.logger = Logger.getLogger( this.getClass());
  }
  
  //// Getters y setters  

  public String getSmtpHost() {
    
    return smtpHost;
  }

  public String getSmtpPort() {
    
    return smtpPort;
  }

  public int getSmtpPortNumber() { 
    
    return Integer.parseInt( this.smtpPort );
  }
  
  public String getSmtpUser() {
    
    return smtpUser;
  }

  public String getUserSecret() {
    
    return userSecret;
  }
  
  public boolean getUseSecurity() {
      
    return this.enableSsl;
  }

  public void setSmtpHost( String smtpHost ) {
    
    this.smtpHost = smtpHost;
  }

  public void setSmtpPort( String smtpPort ) {
    
    this.smtpPort = smtpPort;
  }

  public void setSmtpUser( String smtpUser ) {
    
    this.smtpUser = smtpUser;
  }

  public void setUserSecret( String userSecret ) {
    
    this.userSecret = userSecret;
  }

  public void setUseSecurity( boolean enabled ) { 
      
    this.enableSsl = enabled;  
  }
  
}
