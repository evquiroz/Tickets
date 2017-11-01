package mx.com.nttdata.service;

import java.util.List;

import mx.com.nttdata.beans.CriticalIncident;

/**
 * Interfaz que define el comportamiento del servicio de incidentes criticps
 * @version 1.0.0
 */
public interface ICIncidentService {

  String createIncident( CriticalIncident bean );
  
  String closeIncident( Integer incidentID );

  String deleteIncident( int incidentID );
  
  Integer deleteIncidents( List<Integer> incidentList );
    
  CriticalIncident getIncident( Integer incidentID );
  
  List<CriticalIncident> getIncidentList( boolean openOnly );

  String reopenIncident( Integer incidentID );

  String updateIncident( CriticalIncident bean );
  
}
