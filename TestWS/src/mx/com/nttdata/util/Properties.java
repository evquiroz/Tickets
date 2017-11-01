package mx.com.nttdata.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

/**
 * Manejador de las propiedades de la aplicacion
 * @version 1.0.0
 */
public class Properties {

    
  /** Valor por default para usar con los valores de texto */
  private final static String DEF_STRING_VALUE  = "";
  /** Valor por default para usar con los valores enteros */
  private final static int    DEF_INT_VALUE     = 0;
      
  /** Log de la aplicacion */
  private static Logger logger = Logger.getLogger( Messages.class );

  /** Configuraciones locales */
  private static Configuration props;

  
  public static int getInt( String key ) {
      
    return getInt( key, DEF_INT_VALUE );    
  }

  public static int getInt( String key, int defValue ) {
      
    int result = defValue;    
    String buffer = getString( key, Integer.toString( defValue ));
    if ( buffer != null && !buffer.isEmpty()) { 
       if ( buffer.matches("[-0-9]+"))
          return Integer.parseInt( buffer );
    }
    return result;
  }
  
  public static String getString( String key ) {

    return getString( key, DEF_STRING_VALUE );
  }

  public static String getString( String key, String defValue ) {

    if ( key == null || key.isEmpty())
       return IGlobalConstants.EMPTY_STRING;
    // String fileName = IGlobalConstants.WEBAPP_BASE_PATH + IGlobalConstants.PROPERTIES_FILE;
    String fileName = IGlobalConstants.PROPERTIES_FILE;

    try {
      if ( props == null ) {
         props = new PropertiesConfiguration( fileName );
         logger.debug("#### Cargando la configuraci\u00F3n local desde: [" + fileName + "]");
      }
      return props.getString( key, defValue );

    } catch ( Exception ex ) {

      logger.error( "Ocurri\u00F3 un problema cargando configuraci\u00F3n local del archivo: " + fileName, ex );
    }
    return IGlobalConstants.EMPTY_STRING;
  }

}
