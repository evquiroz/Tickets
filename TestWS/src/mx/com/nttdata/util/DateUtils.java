package mx.com.nttdata.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Rutinas utiles para el manejo de fecha
 * @author flozada
 */
public class DateUtils {

 
  /**
   * Formatea un fecha para su presentacion con formato ISO
   * @param date Fecha a ser formateada
   * @return Una cadena con la fecha en formato ISO
   */
  public final static String getISODate( Date date ) {

    if ( date == null )
       return "";
    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
    return sdf.format( date );
  }
  
  /**
   * Convierte de una fecha normal a una de base de datos
   * @param date Fecha a convertir
   * @return Fecha SQL
   */
  public final static java.sql.Date convierteAFechaSQL( java.util.Date date ) {

    return new java.sql.Date( date.getTime());
  }
  
}
