package mx.com.nttdata.beans;

import java.io.Serializable;

/**
 * bean de informacion basica de un incidente
 * @author flozada
 */
public abstract class AbstractIncident implements Serializable {

  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 1L;
  
  /** titulo del incidente */
  private String title;
  /** descripcion del incidente */
  private String notes;
    
  
  /**
   * Constructor predeterminado 
   */
  public AbstractIncident() { 
    
    super();
  }

  public String getTitle() {
    
    return title;
  }

  public String getNotes() {
    
    return notes;
  }

  public void setTitle( String title ) {
    
    this.title = title;
  }

  public void setNotes( String notes ) {
    
    this.notes = notes;
  }
      
}
