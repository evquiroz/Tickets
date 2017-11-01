package mx.com.nttdata.beans;

/**
 * Bean para manejar un incidente
 * @version 1.0.0
 */
public class Incident extends AbstractTicket {

  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -1476017080148302511L;
  
  protected String impact;
  protected String urgency;
  protected String assignedGroup;
  protected String serviceType;
    
  /**
   * Constructor predeterminado 
   */
  public Incident() { 
    
    super();
  }

  //// Getters y setters 

  public String getImpact() {
    
    return impact;
  }

  public String getUrgency() {
    
    return urgency;
  }

  public String getAssignedGroup() {
    
    return assignedGroup;
  }
  
  public String getServiceType() {
      
    return serviceType;
  }

  public void setAssignedGroup( String assignedGroup ) {
    
    this.assignedGroup = assignedGroup;
  }

  public void setImpact( String impact ) {
    
    this.impact = impact;
  }

  public void setUrgency( String urgency ) {
    
    this.urgency = urgency;
  }
  
  public void setServiceType( String serviceType ) {
      
    this.serviceType = serviceType;  
  }

  @Override 
  public String toString() { 
    
    StringBuilder sb = new StringBuilder( super.toString());    
    sb.deleteCharAt( sb.length() -1  );
    
    sb.append(",impact:").append( impact ).append(",");
    sb.append("urgency:").append( urgency ).append(",");
    sb.append("assignedGroup:").append( assignedGroup ).append(",");
    sb.append("serviceType:").append( serviceType ).append("]");
    
    return sb.toString();
  }
  
}
