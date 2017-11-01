package mx.com.nttdata.service;

import mx.com.nttdata.beans.Parameters;

/**
 * Intefaz que modela el servicio de parametros de la aplicacion
 * @version 1.0.0
 */
public interface IParametersService {

  /**
   * Devuelve los parametros de la base de datos
   * @return Un bean con los parametros globales de la aplicacion
   */
  public Parameters getParams();

}
