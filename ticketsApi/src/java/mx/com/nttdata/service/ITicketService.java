package mx.com.nttdata.service;

import java.util.List;

import mx.com.nttdata.beans.ITicket;

/**
 * Interfaz que modela el servicio de tickets
 * @version 1.0.0
 */
public interface ITicketService {

  String createTicket( Integer ticketType, ITicket msg );

  String deleteTicket( Integer ticketType, Integer TicketID );

  List<ITicket> listTickets( String customer );

  ITicket readTicket( Integer ticketType, Integer TicketID );

  String updateTicket( Integer ticketType, ITicket msg );

}
