package mx.com.nttdata.beans;

/**
 * Bean para manejar los parametros de un incidente
 * @version 1.0.0
 */
public class IncidentParams extends AbstractEntry {

  
  /** Auxiliar de serializacionn */
  private static final long serialVersionUID = 9201985640389339231L;
  
  protected String impact;
  protected String urgency;
  protected String group;
  protected String serviceType;
  
  
  public IncidentParams() { 
  
    super();
  }

  //// Getters y setters

  public String getImpact() {
    
    return impact;
  }

  public String getUrgency() {
    
    return urgency;
  }

  public String getGroup() {
    
    return group;
  }
  
  public String getServiceType() {
      
    return serviceType;
  }

  public void setImpact( String impact ) {
    
    this.impact = impact;
  }

  public void setUrgency( String urgency ) {
    
    this.urgency = urgency;
  }

  public void setGroup( String group ) {
    
    this.group = group;
  }
  
  public void setServiceType( String serviceType ) {
      
    this.serviceType = serviceType;   
  }
      
}
