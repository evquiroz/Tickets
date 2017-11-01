package mx.com.nttdata.service;

import java.util.ArrayList;
import java.util.List;

import mx.com.nttdata.beans.SiteMessage;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.dao.IMessagesDAO;
import mx.com.nttdata.dao.MessagesDAO;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Messages;
import mx.com.nttdata.util.Properties;

import org.apache.log4j.Logger;


/**
 * Servicio que maneja alas interacciones con los mensajes de la aplicacion
 * @version 1.0.0
 */
public class MessageService implements IMessageService {

  /** Log de la aplicacion */
  private static Logger logger;

  /** Comunicacion a la base detos para recuperacion de mensjes */
  private IMessagesDAO dao;

  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;


  /**
   * Constructor predeterminado
   */
  public MessageService() {

    logger = Logger.getLogger( this.getClass());
    dsName = Properties.getString( IGlobalConstants.PROP_DS_NAME );
    cfName = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );

    try {
      ConnectionFactory cf = new ConnectionFactory();
      this.dao             = new MessagesDAO( cf.getDataSource( dsName, cfName ));

    } catch ( Exception ex ) {

      logger.error( "MessageService.(). Ocurri\u00fe un problema conect\u00e1ndose a la base de datos ", ex  );
    }
  }

  @Override
  public String createMessage( SiteMessage msg, String login ) {

    try {
      dao.create( msg, login );

    } catch ( Exception ex ) {

      logger.error( "MessageService.createMessage(). Error adicionando mensaje", ex  );
      return "No se pudo crear el mensaje";
    }
    return "El mensaje se agreg\u00f3 satisfactoriamente";
  }
  
  @Override
  public String cleanMessages() { 
    
    try {
      if ( dao.truncate())
         return "Se elimin\u00f3 el mensaje";

    } catch ( Exception ex ) {

      logger.error( "MessageService.cleanMessages(). Error eliminando el mensaje", ex  );
      return "No se pudo eliminar el mensaje";
    }
    return "Hubo un problema al eliminar el mensaje";
  }

  @Override
  public String deleteMessage( Integer messageID ) {

    try {
      if ( dao.delete( messageID ) > 1 )
         return "Se elimin\u00f3 el mensaje";

    } catch ( Exception ex ) {

      logger.error( "MessageService.deleteMessage(). Error eliminando el mensaje", ex  );
      return "No se pudo eliminar el mensaje";
    }
    return "Hubo un problema al eliminar el mensaje";
  }

  /**
   * Devuelve el mensaje actual de la aplicacion
   * @return Cadena con un mensaje
   */
  @Override
  public String getCurrentMessage() {

    SiteMessage msg;
    // String      result = Messages.getMessage( IGlobalConstants.APP_DEFAULT_MSG );
    String result = ""; // Messages.getMessage( IGlobalConstants.APP_DEFAULT_MSG );

    try {
      if ( this.dao != null ) {
         msg = dao.getCurrentMessage();
         if ( msg != null )
            result = msg.getMessage();
      }

    } catch ( Exception ex ) {

      logger.error( "MessageService.getCurrentMessage(). No se encontraron mensajes, usando el predeterminado", ex  );
    }
    return result;
  }

  @Override
  public List<SiteMessage> listMessages() {

    List<SiteMessage> result = new ArrayList<>();
    try {
      result = dao.list();

    } catch ( Exception ex ) {

      logger.error( "MessageService.listMessages(). No se encontraron mensajes", ex  );
    }
    return result;
  }

  @Override
  public SiteMessage readMessage( Integer messageID ) {

    try {
      return dao.read( messageID );

    } catch ( Exception ex ) {

      logger.error( "MessageService.readMessage(). No se encontr\u00f3 el mensaje " + messageID, ex  );
    }
    return null;
  }

  @Override
  public String updateMessage( SiteMessage msg, String login ) {

    try {
      dao.update( msg, login );
      return "El mensaje se actualiz\u00f3 exitos\u00e1mente";

    } catch ( Exception ex ) {

      logger.error( "MessageService.updateMessage(). No se pudo actualizar el mensaje " + msg.getId(), ex  );
      return "Ocurri\u00f3 un error inesperado al actualizar el mensaje";
    }
  }
    
}
