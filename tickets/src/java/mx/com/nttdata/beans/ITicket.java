package mx.com.nttdata.beans;

/**
 * Interfaz que modela los objetos usados para levantar tickets
 * @version 1.0.0 
 */
public interface ITicket extends IEntry {
  
  Integer getID();
  
  String getRemedyID();

  String getCompanyName();
      
  String getCustomer();
    
  String getTitle();
    
  String getNotes(); 
    
  void setID( Integer id );
    
  void setRemedyID( String id );
    
  void setCompanyName( String companyName );
    
  void setCustomer( String customer );
    
  void setTitle( String title );
    
  void setNotes( String notes );
        
}
