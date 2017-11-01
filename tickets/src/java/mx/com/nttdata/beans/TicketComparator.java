package mx.com.nttdata.beans;

import java.util.Comparator;

/**
 * Objeto para yudar en el ordenamiento de los tidkets cuando se genera un listado
 * tanto de incidentes como de ordenes de trabajo
 * @version 1.0.0
 */
public class TicketComparator implements Comparator<ITicket> {

  @Override
  public int compare( ITicket src, ITicket tgt ) {

    return src.getRemedyID().compareTo( tgt.getRemedyID());
  }

}
