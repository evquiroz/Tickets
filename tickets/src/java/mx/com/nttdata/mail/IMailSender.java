package mx.com.nttdata.mail;

/**
 * Intefaz que modela el comportamiento generico de envio de mensajes
 * @author flozada
 */
public interface IMailSender {
  
  /** Error general de conexion al servidor de SMTP */
  final static int SMTP_CONN_ERR = 501; 
  /** Error de autenticacion al servidor de SMTP */
  final static int SMTP_AUTH_ERR = 502;
  /** Error de envio de mensaje */
  final static int SMTP_SENT_ERR = 503;
  /** Codigo para envio de mensaje exitoso */
  final static int SMTP_MAIL_SENT = 200;
}
