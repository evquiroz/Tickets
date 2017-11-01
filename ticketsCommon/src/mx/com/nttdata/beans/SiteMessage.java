package mx.com.nttdata.beans;

import java.io.Serializable;
import java.util.Date;


/**
 * Bean para manejar los mensajes del sitio
 * @version 1.0.0
 */
public class SiteMessage implements Serializable {
  
  private Integer id;
  private String  message;
  private Date    startDate;
  private Date    endDate;
  private Boolean main;


  public SiteMessage() {
  
    super();    
    this.main = Boolean.FALSE;
  }
    
  public SiteMessage( Integer id, String msg, Date startDate, Date endDate ) { 
     
    this();   
    this.id = id;
    this.message = msg;
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  public SiteMessage( Integer id, String msg, Date startDate, Date endDate, Boolean main ) { 

    this( id, msg, startDate, endDate );
    this.main = main;
  }
  
  //// Getters y setters 

  public Integer getId() {
    
    return id;
  }

  public String getMessage() {
    
    return message;
  }

  public Date getStartDate() {
    
    return startDate;
  }

  public Date getEndDate() {
    
    return endDate;
  }

  public Boolean getMain() {
    
    return main;
  }

  public void setId( Integer id ) {
    
    this.id = id;
  }

  public void setMessage( String message ) {
    
    this.message = message;
  }

  public void setStartDate( Date startDate ) {
    
    this.startDate = startDate;
  }

  public void setEndDate( Date endDate ) {
    
    this.endDate = endDate;
  }

  public void setMain( Boolean main ) {
    
    this.main = main;
  }
  
}
