package mx.com.nttdata.beans;

/**
 * Bean para manejar los parametros de una orden de trabajo
 * @version 1.0.0
 */
public class WorkOrderParams extends AbstractEntry {

  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 4856710510337053995L;
  
  protected String orderType;
  protected String managementGroup;

  
  public WorkOrderParams() { 
    
    super();
  }

  //// Getters y setters

  public String getOrderType() {
    
    return orderType;
  }

  public String getManagementGroup() {
    
    return managementGroup;
  }

  public void setOrderType( String orderType ) {
    
    this.orderType = orderType;
  }

  public void setManagementGroup( String managementGroup ) {
    
    this.managementGroup = managementGroup;
  }
  
}
