package mx.com.nttdata.service;

import java.util.List;

import mx.com.nttdata.beans.CriticalIncident;

/**
 * Interfaz que modela el servicio de importacion de incidentes criticos
 * @version 1.0.0
 */
public interface IImporterService {

  List<CriticalIncident> getCriticalIncidents();

  String importIncidents( List<CriticalIncident> source, List<String> items );

}
