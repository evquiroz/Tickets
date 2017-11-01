package mx.com.nttdata.beans;

/**
 * Bean para listar los incidentes padre
 * @author flozada
 */
public class SimpleIncident extends AbstractIncident {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = 3718882214655571411L;

  /** ID en Remedy del incidente */
  private String remedyID;


  /**
   * Constructor predeterminado
   */
  public SimpleIncident() {

    super();
  }

  //// Getters & Setters

  public String getRemedyID() {

    return remedyID;
  }

  public void setRemedyID( String id ) {

    this.remedyID = id;
  }
}
