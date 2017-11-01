package mx.com.nttdata.beans;

/**
 * Bean para manejar una orden de trabajo
 * @version 1.0.0
 */
public class WorkOrder extends AbstractTicket {

  
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -1826031133306871703L;

  protected String orderType;
  protected String managementGroup;
  protected String statusReason;
  
  /**
   * Constructor predeterminado 
   */
  public WorkOrder() { 
    
    super();
  }
  
  //// Getters y setters   

  public static long getSerialVersionUID() {
    
    return serialVersionUID;
  }

  public String getOrderType() {
    
    return orderType;
  }

  public String getManagementGroup() {
    
    return managementGroup;
  }

  public String getStatusReason() {
    
    return statusReason;
  }

  public void setOrderType( String orderType ) {
    
    this.orderType = orderType;
  }

  public void setManagementGroup( String managementGroup ) {
    
    this.managementGroup = managementGroup;
  }

  public void setStatusReason( String statusReason ) {
    
    this.statusReason = statusReason;
  }

  @Override 
  public String toString() { 
    
    StringBuilder sb = new StringBuilder( super.toString());    
    sb.deleteCharAt( sb.length() -1  );
    
    sb.append(",orderType:").append( orderType ).append(",");
    sb.append("managementGroup:").append( managementGroup ).append(",");
    sb.append("statusReason:").append( statusReason ).append("]");
    
    return sb.toString();
  }
    
}
