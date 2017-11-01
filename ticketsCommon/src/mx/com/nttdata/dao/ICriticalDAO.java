package mx.com.nttdata.dao;

import java.util.List;

import mx.com.nttdata.beans.CriticalIncident;

/**
 * Interfaz para manejar los datos de los incidentes 
 * @version 1.0.0
 */
public interface ICriticalDAO {

  int changeIncident( Integer recordID, boolean isClosed ) throws Exception;
  
  int closeIncident( Integer recordID ) throws Exception;
  
  String create( CriticalIncident record ) throws Exception;
  
  String delete( int id ) throws Exception;
  
  int delete( List<Integer> incidentList ) throws Exception;
        
  boolean isUniqueIncident( String remedyID );
  
  List<CriticalIncident> list( boolean onlyOpen ) throws Exception;
  
  CriticalIncident read( Integer recordID ) throws Exception;

  int reopenIncident( Integer recordID ) throws Exception;
  
  int update( CriticalIncident record ) throws Exception;
  
}
