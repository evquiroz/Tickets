package mx.com.nttdata.beans;
    
import java.io.Serializable;

/**
 * Datos comunes a todos los tipos de tickets
 * @version 1.0.0
 */
public class Parameters implements Serializable {

  
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 2900310449482010813L;
  
  protected Boolean sendSMS;
  protected String companyName;
  protected IncidentParams incidentDefaults;
  protected WorkOrderParams orderDefaults;
  
  
  /**
   * Constructor predeterminado 
   */
  public Parameters() { 
  
    super();
    this.incidentDefaults = new IncidentParams();
    this.orderDefaults    = new WorkOrderParams();
  }
 
  //// Getters y setters

  public Boolean getSendSMS() {
    
    return sendSMS;
  }
  
  public String getCompanyName() {
    
    return companyName;
  }
  
  public IncidentParams getIncidentDefaults() {
    
    return incidentDefaults;
  }

  public WorkOrderParams getOrderDefaults() {
    
    return orderDefaults;
  }

  public void setSendSMS( Boolean sendSMS ) {
    
    this.sendSMS = sendSMS;
  }
  
  public void setCompanyName( String companyName ) {
    
    this.companyName = companyName;
  }
  
  public void setIncidentDefaults( IncidentParams incidentDefaults ) {
    
    this.incidentDefaults = incidentDefaults;
  }

  public void setOrderDefaults( WorkOrderParams orderDefaults ) {
    
    this.orderDefaults = orderDefaults;
  }
  
}
