package mx.com.nttdata.dao;

import java.util.Map;

/**
 * Interfaz para acceder a todos esos datos de catalago que no necesitan un DAO
 * completo
 * @version 1.0.0
 */
public interface ICatalogsDAO {
    
  Map<String,String> getImpactMap();
      
}
