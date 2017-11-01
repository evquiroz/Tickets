package mx.com.nttdata.beans;

import java.util.Calendar;
import java.util.Date;

import mx.com.nttdata.util.IncidentStatus;
import mx.com.nttdata.util.DateUtils;

/**
 * Incidente critico que sirve de padre a los otros
 * @version 1.0.0
 */
public class CriticalIncident extends AbstractIncident {

  
  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -3371385036842885588L;

  /** Limite del campo de notas */
  public final static int MAX_LEN = 255;
  
  /** ID en la base de datos del incidente */
  private Integer incidentID;
  /** ID en Remedy del incidente */
  private String remedyID;
  
  /** Valor del impacto del incidente */
  private String impact;
  /** Grupo de soporte asignado */
  private String assignedGroup;
  /** Categoria del incidente nivel 1 */
  private String categoryLevel01;
  /** Categoria del incidente nivel 2 */
  private String categoryLevel02;
  /** Categoria del incidente nivel 3 */
  private String categoryLevel03;
  /** Producto del incidente nivel 1 */
  private String productLevel01;
  /** Producto del incidente nivel 2 */
  private String productLevel02;
  /** Producto del incidente nivel 3 */
  private String productLevel03;
    
  /** estado del incidente */
  private String status; 
  /** Fecha de creacion del incidente */
  private Date creationDate;
  /** Fecha de cierre del incidente*/ 
  private Date closeDate;
  
  
  /**
   * Constructoer predeterminado
   */
  public CriticalIncident() { 
    
    super();
  }
  
  //// Getters y setters

  public Integer getIncidentID() {
    
    return incidentID;
  }

  public String getRemedyID() {
    
    return remedyID;
  }
  
  public String getAssignedGroup() { 
      
    return assignedGroup;  
  }
  
  public String getImpact() { 
      
    return impact;  
  }

  public String getCategoryLevel01() {
    
    return categoryLevel01;
  }
  
  public String getCategoryLevel02() {
    
    return categoryLevel02;
  }
  
  public String getCategoryLevel03() {
    
    return categoryLevel03;
  }

  public String getProductLevel01() {
    
    return productLevel01;
  }

  public String getProductLevel02() {
    
    return productLevel02;
  }

  public String getProductLevel03() {
    
    return productLevel03;
  }
  
  public String getStatus() {
    
    return status;
  }
  
  public String getStatusName() { 
    
    return IncidentStatus.getStatusName( status );
  }

  public Date getCreationDate() {
    
    return creationDate;
  }

  public String getCreationFormatedDate() { 
    
    return DateUtils.formateFechaISO( creationDate );
  }
  
  public String getCreationTimestamp() { 
    
    return DateUtils.formateaFechaHoraISO( creationDate );
  }

  public Date getCloseDate() {
    
    return closeDate;
  }
  
  public String getCloseFormatedDate() {
    
    return DateUtils.formateFechaISO( closeDate );
  }
  
  public String getCloseTimestamp() { 
    
    return DateUtils.formateaFechaHoraISO( closeDate );
  }
  
  public String getPreNotes() {
    
    StringBuilder sb = new StringBuilder("# ");
    sb.append( this.remedyID ).append(". ").append( this.getNotes());
    if ( sb.length() > MAX_LEN )
       sb.setLength( MAX_LEN );
    
    return sb.toString();
  }

  public void setIncidentID( Integer incidentID ) {
    
    this.incidentID = incidentID;
  }

  public void setRemedyID( String remedyID ) {
    
    this.remedyID = remedyID;
  }

  public String setAssignedGroup( String group) { 
      
    return this.assignedGroup = group;  
  }
 
  public void setImpact( String impact ) { 
      
    this.impact = impact;    
  }
  
  public void setStatus( String status ) {
    
    this.status = status;
  }

  public void setCategoryLevel01( String category ) {
    
    this.categoryLevel01 = category;
  }

  public void setCategoryLevel02( String category ) {
    
    this.categoryLevel02 = category;
  }

  public void setCategoryLevel03( String category ) {
    
    this.categoryLevel03 = category;
  }

  public void setProductLevel01( String product ) {
    
    this.productLevel01 = product;
  }

  public void setProductLevel02( String product ) {
    
    this.productLevel02 = product;
  }

  public void setProductLevel03( String product ) {
    
    this.productLevel03 = product;
  }
  
  public void setCreationDate( Date createdDate ) {
    
    this.creationDate = createdDate;
  }

  public void setCreationDate( String createdDate ) {
    
    Date dt = DateUtils.parseaFechaISO( createdDate );
    
    Calendar calT = Calendar.getInstance();
    Calendar calS = Calendar.getInstance();
    calS.setTime( dt );
    calT.set( Calendar.YEAR,         calS.get( Calendar.YEAR ));
    calT.set( Calendar.MONTH,        calS.get( Calendar.MONTH ) );
    calT.set( Calendar.DAY_OF_MONTH, calS.get( Calendar.DAY_OF_MONTH ));
    
    this.creationDate = calT.getTime();
  }
  
  public void setCloseDate( Date closeDate ) {
    
    this.closeDate = closeDate;
  }  
 
}
