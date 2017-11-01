package mx.com.nttdata.util;

// import java.util.Properties;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;


/**
 * Clase que maneja el recuperar los mensajes que se recuperan de las propiedades
 * para enviar al usuario
 * @version 1.0.0
 */
public class Messages {

  /** Log de la aplicacion */
  private static Logger logger = Logger.getLogger( Messages.class );

  /** Etiquetas globales */
  private static Configuration messages;

  public static String getMessage( String key ) {

    if ( key == null || key.isEmpty())
       return IGlobalConstants.EMPTY_STRING;

    String fileName = IGlobalConstants.WEBAPP_BASE_PATH + IGlobalConstants.MESSAGES_FILE;
    try {
      if ( messages == null ) {
         messages = new PropertiesConfiguration( fileName );
         logger.debug("#### Cargandos los mensages desde: [" + fileName + "]");
      }
      return messages.getString( key, IGlobalConstants.EMPTY_STRING );

    } catch ( ConfigurationException ex ) {

      logger.error( "Ocurri\u00f3 un problema cargando los mensajes del archivo: " + fileName, ex );
    }
    return IGlobalConstants.EMPTY_STRING;
  }

}
