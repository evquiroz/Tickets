package mx.com.nttdata.beans;

/**
 *
 * @author flozada
 */
public class AbstractTicket extends AbstractEntry implements ITicket {

  
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 5938630790845251118L;
 
  protected Integer id;
  protected String  remedyID;  
  protected String  companyName;
  protected String  customer;
  protected String  title;
  protected String  notes;
 
  
  /**
   * Constructor predeterminado 
   */
  public AbstractTicket() { 

    super();    
  }
  
  //// Getters y setters
  
  @Override
  public Integer getID() { 
    
    return this.id;
  }
  
  @Override
  public String getRemedyID() { 
    
    return this.remedyID;
  }

  @Override
  public String getCompanyName() {
    
    return companyName;
  }
  
  @Override
  public String getCustomer() {
    
    return this.customer;
  }
  
  @Override
  public String getTitle() { 
    
    return this.title;
  }
  
  @Override
  public String getNotes() { 
    
    return this.notes;
  }

  @Override
  public void setID( Integer id ) { 
    
    this.id = id;
  }
  
  @Override
  public void setRemedyID( String id ) {
    
    this.remedyID = id;
  }

  @Override
  public void setCompanyName( String companyName ) {
    
    this.companyName = companyName;
  }
  
  @Override
  public void setCustomer( String customer ) { 
    
    this.customer = customer;
  }
  
  @Override
  public void setTitle( String title ) {
    
    this.title = title;
  }
  
  @Override
  public void setNotes( String notes ) { 
    
    this.notes = notes;
  }
  
  @Override 
  public String toString() { 
    
    StringBuilder parent = new StringBuilder( super.toString());    
    parent.deleteCharAt( 0 );
    StringBuilder sb     = new StringBuilder();
    
    sb.append("[id:").append( id ).append(",");
    sb.append("remedyID:").append( remedyID ).append(",");
    sb.append("companyName:").append( companyName ).append(",");
    sb.append("customer:").append( customer ).append(",");
    sb.append("title:").append( title ).append(",");
    sb.append("notes:").append( notes ).append(",");
    sb.append( parent );
        
    return sb.toString();
  }
  
}
