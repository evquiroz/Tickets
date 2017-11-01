package mx.com.nttdata.util;

/**
 * Enumeracion para procesar el estado de los incidentes 
 * @version 1.0.0
 */
public enum IncidentStatus {
  
  ABIERTO("A"),
  CERRADO("C"),
  INDETERMINADO("I");
  
  
  private final String estado;
  /** Nombre del estado abierto */
  public final static String ST_OPEN    = "Activo";
  /** Nombre del estado cerrado */
  public final static String ST_CLOSED  = "Inactivo";
  /** Nombre para cualquier estado que no sea abierto o cerrado */
  public final static String ST_UNKNOWN = "Indeterminado";
  
  
  /**
   * Constructor predeterminado
   * @param status Inicial del estado 
   */
  private IncidentStatus( final String status ) {
    
    this.estado = status;
  }
  
  public final String getStatusName() {
    
    return getStatusName( estado );
  }
  
  public final static String getStatusName( String status ) {
    
    if ( status.equals("A"))
       return ST_OPEN;
    else if ( status.equals("C"))
       return ST_CLOSED;
    return ST_UNKNOWN;
  }

  public final String getStatusID() {
    
    if ( this.equals( ABIERTO ))
       return "A";
    else if ( this.equals( CERRADO ))
       return "C";
    return "U";    
  }
  
  @Override 
  public String toString() { 
    
    return estado;
  }
  
}
