package mx.com.nttdata.service;

import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.WorkOrder;
import mx.com.nttdata.remedy.RemedyConector;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;
import mx.com.nttdata.util.TicketUtils;

import org.apache.log4j.Logger;

/**
 * Servicio de administracion de tickets
 * @version 1.0.0
 * @todo Conectar a los WS Remedy para generar los Tickets
 */
public class TicketService {


  /** Log de la aplicacion */
  private static Logger logger;

  /** Si la aplicacion esta en modo de desarrollo */
  private boolean devMode;

  /**
   * Constructor predeterminado
   */
  public TicketService() {

    logger = Logger.getLogger( this.getClass());
  }

  /**
   * Obtiene el ID de Remedy
   * @param ticketType Si es incidente u orden de trabajo
   * @param record Bean con el la informacion del ticket
   */
  public String createRemedyTicket( Integer ticketType, ITicket record ) {

    String result = IGlobalConstants.EMPTY_STRING;
    try {
      RemedyConector rc = new RemedyConector();
      if ( ticketType == IGlobalConstants.TICKET_INCIDENT )
      {    
         logger.debug("TicketService.createRemedyTicket(). Creando ticket para incidente" );
	 result = rc.createincident((Incident) record );
      }   
      else
      {    
	     logger.debug("TicketService.createRemedyTicket(). Creando ticket para requisici\u00f3n" );
	     result = rc.createWorkOrder((WorkOrder) record );
      }   
    } catch ( Exception ex ) {
	    
      logger.error( "TicketService.createRemedyTicket(). Error dande de alta el ticket", ex );
    }   
    return result;
  }  

}
