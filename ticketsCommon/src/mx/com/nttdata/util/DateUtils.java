package mx.com.nttdata.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Rutinas utiles para el manejo de fecha
 * @author flozada
 */
public class DateUtils {

  
  /** Formato general de fecha */
  public final static String DU_DATE_FORMAT     = "yyyy-MM-dd";
  /** Formato general de fecha y hora */
  public final static String DU_DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
  
  
  /**
   * Convierte de una fecha normal a una de base de datos
   * @param date Fecha a convertir
   * @return Fecha SQL
   */
  public final static java.sql.Date convierteAFechaSQL( java.util.Date date ) {

    return new java.sql.Date( date.getTime());
  }
  
  /**
   * Genera la representacion de fecha en formato ISO
   * @param fecha Fecha a ser formateada
   * @return Cadena con la fecha en formato ISO
   */
  public final static String formateFechaISO( Date fecha ) {
    
    if ( fecha == null )
       return "";
    SimpleDateFormat sdf = new SimpleDateFormat( DU_DATE_FORMAT );
    return sdf.format( fecha );
  }
  
  /**
   * Genera la representacion de fecha y hora en formato ISO
   * @param fecha Fecha a ser formateada
   * @return Cadena con la fecha y hora en formato ISO
   */
  public final static String formateaFechaHoraISO( Date fecha ) {
    
    if ( fecha == null )
       return "";
    SimpleDateFormat sdf = new SimpleDateFormat( DU_DATETIME_FORMAT );
    return sdf.format( fecha );
  }
   
  /**
   * Formatea un fecha para su presentacion con formato ISO
   * @param date Fecha a ser formateada
   * @return Una cadena con la fecha en formato ISO
   */
  public final static String getISODate( Date date ) {

    if ( date == null )
       return "";
    SimpleDateFormat sdf = new SimpleDateFormat( DU_DATE_FORMAT );
    return sdf.format( date );
  }
    
  /**
   * Convierte de manera sencilla una fecha en formato ISO a un Date
   * @param fechaISO Texto con la fehca a convertir
   * @return Una fecha 
   */
  public final static Date parseaFechaISO( String fechaISO ) {

    SimpleDateFormat sdf    = new SimpleDateFormat( DU_DATE_FORMAT );
    Date             result = Calendar.getInstance().getTime();
    try {
      result = sdf.parse( fechaISO );
      
    } catch ( Exception ex ) {

      Logger.getRootLogger().warn("DateUtils.parseaFechaISO(). Problema convirtiendo la fecha:" + fechaISO, ex );
    }
    return result;
  }
  
  
}
