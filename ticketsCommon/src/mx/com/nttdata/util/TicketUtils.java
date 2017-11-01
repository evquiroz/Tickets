package mx.com.nttdata.util;

import org.apache.commons.codec.binary.Base64;

/**
 * Clase con rutnias utiles a las aplicaciones de Tickets
 * @version 1.0.0
 */
public class TicketUtils {

  /**
   * Devuelve el nombre del tipo de ticket
   * @param ticketType Tipo de ticket
   * @return Cadena con el nombre
   */
  public static String getTicketTypeName( int ticketType ) {

    return ticketType == IGlobalConstants.TICKET_WORKORDER
           ? IGlobalConstants.INCIDENT_LABEL : IGlobalConstants.WOPRKORDER_LABEL;
  }
  
  /**
   * Obscurece los datos 
   * @param data Datos a oscurecer
   * @return Cadena base 64 
   */
  public static String cloackData( String data ) { 
    
    return Base64.encodeBase64String( data.getBytes());    
  }
  
  /**
   * Revela los datos previamente oscurecidos
   * @param data Datos a exponer
   * @return Cadena de datos originales
   */
  public static String uncloackData( String data ) { 
    
    return new String( Base64.decodeBase64( data ));
  }

}
