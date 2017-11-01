package mx.com.nttdata.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;

/**
 * Simple eMail Sender for text
 * @version 1.0.0
 */
public class MailSender extends AbstractMailSender {

  /** Host de SMTP a ser utilizado */
  protected String host;
  /** Puerto de SMTP a emplear */
  protected String port;
  /** Usuario para conectarse al host de SMTP */
  protected String user;
  /** Secreto del usuario de conexion */
  protected String secret;


  /**
   * Constructor predeterminado
   */
  public MailSender() {

    super();
  }

  /**
   * Constructor completo
   * @param host Servidor de envio de mensajes
   * @param port Puerto de SMTP
   * @param user Usuario de conexion al servidor
   * @param secret Secreto del usuario de conexion
   */
  public MailSender( String host, String port, String user, String secret ) {

    super( host, port, user, secret );
  }

  /*
   * Metodo de enviar un simple correo de texto
   * @param from Remitente
   * @param to Destinatario
   * @param subject Asunto
   * @param msg Mensaje
   * @return el codigo resultado del intento de envio
   */
  public int sendMessage( String from, String to, String subject, String msg ) {

    Email email = new SimpleEmail();
    email.setHostName( this.smtpHost );
    email.setSmtpPort( this.getSmtpPortNumber());
    if ( this.smtpUser != null && !this.smtpUser.isEmpty() )
       email.setAuthenticator( new DefaultAuthenticator( this.smtpUser, this.userSecret ));
    else
    {
       email.setDebug( true );
       logger.debug( "MailSender::sendMessage(). Sin autenticaci\u00f3n, activando mail debug" );
    }
            
    email.setSubject( subject );
    try {
      email.setSSLOnConnect( this.getUseSecurity());
      email.setFrom( from );
      email.setMsg( msg );
      email.addTo( to );
      email.send();

    } catch ( Exception ex ) {

      logger.error( "MailSender::sendMessage(). Ocurri\u00f3 un problema enviando el mensaje", ex );
      return SMTP_SENT_ERR;
    }
    return SMTP_MAIL_SENT;
  }

}
