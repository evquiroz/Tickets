package mx.com.nttdata.service;

import java.util.List;
import mx.com.nttdata.beans.SiteMessage;

/**
 * Interfaz que modela el servicio de mensajes de la aplicacion
 * @version 1.0.0
 */
public interface IMessageService {

  String cleanMessages();
  
  String createMessage( SiteMessage msg, String login );

  String deleteMessage( Integer messageID );

  String getCurrentMessage();

  List<SiteMessage> listMessages();

  SiteMessage readMessage( Integer messageID );

  
  String updateMessage( SiteMessage msg, String login );
  
}
