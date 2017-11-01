package mx.com.nttdata.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.TicketComparator;
import mx.com.nttdata.beans.WorkOrder;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.dao.ITicketDAO;
import mx.com.nttdata.dao.IncidentDAO;
import mx.com.nttdata.dao.WorkOrderDAO;
import mx.com.nttdata.mail.MailSender;
import mx.com.nttdata.remedy.RemedyConector;
import mx.com.nttdata.util.DateUtils;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;
import mx.com.nttdata.util.TicketUtils;

import  mx.com.nttdata.remedy.api.RemedyConsumer;

import org.apache.log4j.Logger;

/**
 * Servicio de administracion de tickets
 * @version 1.0.0
 * @todo Conectar a los WS Remedy para generar los Tickets
 */
public class TicketService implements ITicketService {


  /** Log de la aplicacion */
  private static Logger logger;

  private ITicketDAO     daoIncidents;
  private ITicketDAO     daoWorkOrders;

  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;
  /** Whether the application is runnning in a non-production environment */
  private boolean devMode;


  /**
   * Constructor predeterminado
   */
  public TicketService() {

    logger       = Logger.getLogger( this.getClass());
    dsName       = Properties.getString( IGlobalConstants.PROP_DS_NAME );    
    cfName       = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );
    this.devMode = Properties.getInt( IGlobalConstants.PROP_DEV_MODE, 0 ) == 1;

    this.setConnections();
  }

  /**
   * Obtiene el ID de Remedy
   * @param ticketType Si es incidente u orden de trabajo
   * @param record Bean con el la informacion del ticket
   */
  private String createRemedyTicket( Integer ticketType, ITicket record ) {

    String mock   = Properties.getString( IGlobalConstants.PROP_MOCK_REMEDY );
    String result = IGlobalConstants.EMPTY_STRING;

    if ( mock.equals( IGlobalConstants.BOOL_STRING_TRUE ))
    {
       logger.debug("TicketService.createRemedyTicket(). Simulando creación de ticket" );
       result = getMockRemedyID( ticketType, record );
    }
    else
    {
/*        
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
*/   
      try {
        RemedyConsumer consumer = new RemedyConsumer();
        consumer.connect();
        result = consumer.createTicket( record, record.getPersonID());
        consumer.disconnect();
        
      } catch ( Exception ex ) {
          
        logger.error( "TicketService.createRemedyTicket(). Error dande de alta el ticket", ex );
      }
    }
    return result;
  }

  @Override
  public String createTicket( Integer ticketType, ITicket record ) {

    String remedyID = this.createRemedyTicket( ticketType, record );
    record.setRemedyID( remedyID );

    if ( remedyID == null || remedyID.isEmpty())
       return null; 
    
    ITicketDAO dao  = this.getDAO( ticketType );
    try {
      dao.create( record );

    } catch ( Exception ex ) {

      logger.error( "TicketService.createTicket(). Error creando " +
                    TicketUtils.getTicketTypeName( ticketType ), ex  );
      return null;
    }
    if ( this.devMode )
       this.sendMail( record.getCustomer(), ticketType, remedyID  );

    return remedyID;
  }

  @Override
  public String deleteTicket( Integer ticketType, Integer ticketID ) {

    ITicketDAO dao = this.getDAO( ticketType );
    try {
      dao.delete( ticketID );

    } catch ( Exception ex ) {

      logger.error( "TicketService.deleteTicket(). Error eliminando el ticket", ex  );
      return "No se pudo eliminar el ticket";
    }
    return "Hubo un problema eliminando el ticket";
  }

  private ITicketDAO getDAO( Integer ticketType ) {

    ITicketDAO dao = ticketType != IGlobalConstants.TICKET_WORKORDER
                   ? this.daoIncidents : this.daoWorkOrders;
    return dao;
  }

  private String getMockRemedyID( Integer ticketType, ITicket record ) {

    String result = ticketType == IGlobalConstants.TICKET_INCIDENT
                  ? "IN001000" : "WO002000";
    Calendar cal  = Calendar.getInstance();
    result += cal.get( Calendar.MINUTE ) + cal.get( Calendar.SECOND );

    return result;
  }

  @Override
  public List<ITicket> listTickets( String customer ) {

    List<ITicket> result  = new ArrayList<>();

    try {
      result.addAll(  this.daoIncidents.list( "Customer = '" + customer + "'", customer ));
      result.addAll(  this.daoWorkOrders.list( "Customer = '" + customer + "'", customer ));
      Collections.sort( result, new TicketComparator());

    } catch ( Exception ex ) {

      logger.error( "TicketService.listTickets(). No se encontraron mensajes para el cliente/usuario: " + customer, ex  );
    }
    return result;
  }

  @Override
  public ITicket readTicket( Integer ticketType, Integer ticketID ) {

    ITicketDAO dao = this.getDAO( ticketType );
    try {
      return dao.read( ticketID );

    } catch ( Exception ex ) {

      logger.error( "TicketService.readTicket(). No se encontr\u00f3 el ticket " + ticketID, ex  );
    }
    return null;
  }

  private String getUserMail( String login ) {

    String result = Properties.getString( "mail.fakeTo", "compartamos.mx" );
    /*
    String umail  = null;
    
    try {
      RemedyDataSearcher search = new RemedyDataSearcher();
      umail = search.getCustomerMail( login );
        
    } catch ( Exception ex ) {
        
      logger.error("TicketsService.getUserMail(). Error recuperando el correo del usuario: " + login, ex );
    }    
    return ( umail == null || umail.isEmpty()) ? result : umail;
    */
    return result;
  }

  private void sendMail( String login, int ticketType, String remedyID ) {

    String  to    = this.getUserMail( login );
    String  from  = Properties.getString( IGlobalConstants.PROP_MAIL_FROM );
    String  host  = Properties.getString( IGlobalConstants.PROP_MAIL_HOST );
    String  port  = Properties.getString( IGlobalConstants.PROP_MAIL_PORT, IGlobalConstants.DEFAULT_SMTP_PORT );
    String  user  = Properties.getString( IGlobalConstants.PROP_MAIL_USER );
    String  pwd   = Properties.getString( IGlobalConstants.PROP_MAIL_PWD );
    String  sec   = Properties.getString( IGlobalConstants.PROP_MAIL_SSL, IGlobalConstants.DEFAULT_SMTP_SSL );
    String  subj  = Properties.getString( IGlobalConstants.PROP_MAIL_SUBJ );
    String  body  = Properties.getString( IGlobalConstants.PROP_MAIL_BODY );

    boolean ssl   = sec.equals( IGlobalConstants.BOOL_STRING_TRUE );

    if (( to   != null && !to.isEmpty())   && ( from != null && !from.isEmpty()) &&
        ( host != null && !host.isEmpty()) && ( body != null && !body.isEmpty()) &&
        ( subj != null && !subj.isEmpty())) {

       body = body.replaceAll( IGlobalConstants.MARKER_TICKET_NO, remedyID );
       body = body.replaceAll( IGlobalConstants.MARKER_TICKET_DATE, DateUtils.getISODate( Calendar.getInstance().getTime()));

       try {
         MailSender agent = new MailSender();

         agent.setSmtpHost( host );
         agent.setSmtpPort( port );
         agent.setUseSecurity( ssl );
         if ( user != null && !user.isEmpty())
            agent.setSmtpUser( user );
         if ( pwd != null && !pwd.isEmpty())
            agent.setUserSecret( pwd );
         agent.sendMessage( from, to, subj, body );

       } catch ( Exception ex ) {

         // No nos importa que el usuario no se le notifique que no se mando el mensaje
         // por lo manejamos la excepcion de manera silente
         logger.error( "TicketService.sendMail() Ocurri\u00f3 un problema notificando del ticket '" + remedyID +
                       "al usuario: " + to, ex );
       }
    }
  }

  private void setConnections() {

    try {
      ConnectionFactory cf = new ConnectionFactory();
      this.daoIncidents  = new IncidentDAO( cf.getDataSource( dsName, cfName ));
      this.daoWorkOrders = new WorkOrderDAO( cf.getDataSource( dsName, cfName ));

    } catch ( Exception ex ) {

      logger.error( "TicketService.setConnections(). Ocurri\u00fe un problema conect\u00e1ndose a la base de datos ", ex  );
    }
  }

  @Override
  public String updateTicket( Integer ticketType, ITicket record ) {

    ITicketDAO dao = this.getDAO( ticketType );
    try {
      dao.update( record );
      return "El mensaje se actualiz\u00f3 exitos\u00e1mente";

    } catch ( Exception ex ) {

      logger.error( "TicketService.updateMessage(). No se pudo actualizar el ticket " + record.getID(), ex  );
      return "Ocurri\u00f3 un error inesperado al actualizar el ticket";
    }
  }

}
