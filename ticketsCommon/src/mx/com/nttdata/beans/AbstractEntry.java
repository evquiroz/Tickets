package mx.com.nttdata.beans;

import java.io.Serializable;

/**
 * Datos comunes a todos los tipos de tickets
 * @version 1.0.0
 */
public class AbstractEntry implements IEntry, Serializable {

    
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -5142696336920355291L;

  protected String action;  
  protected String priority;
  protected String status;
  protected String reason;
  protected String lastname;
  protected String personID;
  protected String source;
  protected String supportGroup;
  protected String categoryLevel01;
  protected String categoryLevel02;
  protected String categoryLevel03;
  protected String productLevel01;
  protected String productLevel02;
  protected String productLevel03;
  
  
  /**
   * Constructor predeterminado 
   */
  public AbstractEntry() { 
    
    super();
  }

  //// Getters y setters

  @Override
  public String getAction() {
    
    return action;
  }
  
  @Override
  public String getPriority() {
    
    return priority;
  }

  @Override
  public String getStatus() {
      
    return status;
  }
  
  @Override
  public String getReason() {
      
    return reason;
  }
  
  @Override
  public String getLastName() {
      
    return lastname;
  }
  
  @Override
  public String getPersonID() {
      
    return personID;
  }
  
  @Override
  public String getSource() {
    
    return source;
  }

  @Override
  public String getSupportGroup() {
    
    return supportGroup;
  }
  
  @Override
  public String getCategoryLevel01() {
    
    return categoryLevel01;
  }

  @Override
  public String getCategoryLevel02() {
    
    return categoryLevel02;
  }

  @Override
  public String getCategoryLevel03() {
    
    return categoryLevel03;
  }

  @Override
  public String getProductLevel01() {
    
    return productLevel01;
  }

  @Override
  public String getProductLevel02() {
    
    return productLevel02;
  }

  @Override
  public String getProductLevel03() {
    
    return productLevel03;
  }

  @Override  
  public void setAction( String action ) {
      
    this.action = action;
  }
    
  @Override
  public void setPriority( String priority ) {
  
    this.priority = priority;
  }

  @Override
  public void setSource( String source ) {
    
    this.source = source;
  }
  
  @Override
  public void setStatus( String status ) {
      
    this.status = status;
  }
  
  @Override
  public void setReason( String reason ) {
      
    this.reason = reason;
  }
          
  @Override
  public void setLastName( String lastname ) {
      
    this.lastname = lastname;
  }
  
  @Override
  public void setPersonID( String id ) {
      
    this.personID = id;
  }
  
  @Override
  public void setSupportGroup( String supportGroup ) {
    
    this.supportGroup = supportGroup;
  }
  
  @Override
  public void setCategoryLevel01( String category ) {
    
    this.categoryLevel01 = category;
  }

  @Override
  public void setCategoryLevel02( String category ) {
    
    this.categoryLevel02 = category;
  }

  @Override
  public void setCategoryLevel03( String category ) {
    
    this.categoryLevel03 = category;
  }

  @Override
  public void setProductLevel01( String product ) {
    
    this.productLevel01 = product;
  }

  @Override
  public void setProductLevel02( String product ) {
    
    this.productLevel02 = product;
  }

  @Override
  public void setProductLevel03( String product ) {
    
    this.productLevel03 = product;
  }

  @Override  
  public String toString() {
    
    StringBuilder sb = new StringBuilder("[");
    
    sb.append("action:").append( action ).append(",");
    sb.append("priority:").append( priority ).append(",");
    sb.append("status:").append( status ).append(",");
    sb.append("reason:").append( reason ).append(",");
    sb.append("lastname:").append( lastname ).append(",");
    sb.append("personID:").append( personID ).append(",");
    sb.append("source:").append( source ).append(",");
    sb.append("supportGroup:").append( supportGroup ).append(",");
    sb.append("categoryLevel01:").append( categoryLevel01 ).append(",");
    sb.append("categoryLevel02:").append( categoryLevel02 ).append(",");
    sb.append("categoryLevel03:").append( categoryLevel03 ).append(",");
    sb.append("productLevel01:").append( productLevel01 ).append(",");
    sb.append("productLevel02:").append( productLevel02 ).append(",");
    sb.append("productLevel03:").append( productLevel03 ).append("]");
        
    return sb.toString();
  }
  
}
