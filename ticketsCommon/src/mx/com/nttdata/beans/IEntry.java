package mx.com.nttdata.beans;

/**
 * Interfaz que modela los objetos con niveles de categorias y productos
 * @version 1.0.0
 */
public interface IEntry {
  
  String getAction();  
    
  String getPriority();
  
  String getSource();
  
  String getStatus();
  
  String getReason();
  
  String getLastName();
  
  String getPersonID();
  
  String getSupportGroup();  
  
  String getCategoryLevel01();

  String getCategoryLevel02();

  String getCategoryLevel03();

  String getProductLevel01();

  String getProductLevel02();

  String getProductLevel03();
  
  void setAction( String action );

  void setPriority( String priority );
  
  void setSource( String source );

  void setStatus( String status );
  
  void setReason( String reason );
  
  void setLastName( String lastname );
  
  void setPersonID( String id );

  void setSupportGroup( String supportGroup );
  
  void setCategoryLevel01( String category );
    
  void setCategoryLevel02( String category );
    
  void setCategoryLevel03( String category );
    
  void setProductLevel01( String product );
    
  void setProductLevel02( String product );
    
  void setProductLevel03( String product );
      
}
