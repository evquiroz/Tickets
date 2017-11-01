package mx.com.nttdata;

import mx.com.nttdata.beans.Incident;
import mx.com.nttdata.beans.ITicket;
import mx.com.nttdata.beans.WorkOrder;
import mx.com.nttdata.remedy.RemedyConector;
import mx.com.nttdata.service.TicketService;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;
import mx.com.nttdata.util.TicketUtils;

/**
 *
 * @author flozada
 */
public class TestMain {

  private TicketService svc;    
  
  
  public TestMain() { 
      
    super();   
  }
    
  public void testIncident() {
      
    Incident incident = new Incident();  
    incident.setCompanyName("Gentera");
    incident.setCustomer("flozada01");
    incident.setTitle("Resumen del incidente");
    incident.setNotes("Ejemplo de las notas del incidente");
    incident.setSource("Web");
    incident.setStatus("Assigned");
    incident.setServiceType("Service Restoration");
    incident.setImpact("4-Minor/Localized");
    incident.setUrgency("Baja");
    incident.setPriority("Low");
    incident.setReason("Initial Status");
    incident.setAssignedGroup("Mesa de servicio");
    incident.setSupportGroup("Back End");
    incident.setCategoryLevel01("Otros");
    incident.setCategoryLevel02("Falla");
    incident.setCategoryLevel03("Portal Web");
    incident.setProductLevel01("Servicios");
    incident.setProductLevel02("Software BackOffice");
    incident.setProductLevel03("Remedy");
    incident.setLastName("SIEM");
    incident.setPersonID("PPL000000287901");
    incident.setAction("CREATE");
    
    String id = svc.createRemedyTicket( IGlobalConstants.TICKET_INCIDENT, incident );
    System.out.println("El incidente se creo con el ID: " + id );
  }
  
  public void testWorkOrder() {
      
    WorkOrder wo = new WorkOrder();
    wo.setCompanyName("Gentera");
    wo.setCustomer("flozada02");
    wo.setTitle("Resumen de la requisici\u00f3n");
    wo.setNotes("Ejemplo de las notas de la requisici\u00f3n");
    wo.setSource("Web");
    wo.setStatus("Assigned");
    wo.setLastName("SIEM");
    wo.setPersonID("PPL000000287901");
    wo.setAction("CREATE");
    wo.setOrderType("General");
    wo.setSupportGroup("Mesa de servicio");
    wo.setManagementGroup("Mesa de servicio");
    wo.setReason("Initial Status");
    wo.setPriority("Low");

    wo.setSupportGroup("Back End");
    wo.setCategoryLevel01("Otros");
    wo.setCategoryLevel02("Falla");
    wo.setCategoryLevel03("Portal Web");
    wo.setProductLevel01("Servicios");
    wo.setProductLevel02("Software BackOffice");
    wo.setProductLevel03("Remedy");
        
    String id = svc.createRemedyTicket( IGlobalConstants.TICKET_WORKORDER, wo );
    System.out.println("La requisici\u00f3 se creo con el ID: " + id );
  }

  public void run() {
      
    this.svc = new TicketService();
    // this.testIncident();  
    this.testWorkOrder();
  }

  public static void main( String[] args )  {
      
    TestMain m = new TestMain();
    m.run(); 
  }   
  
}
