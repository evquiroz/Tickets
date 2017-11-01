package mx.com.nttdata.service;

/**
 * Interfaz que modela el servicio de administracion de usuarios
 * @version 1.0.0
 */
public interface IUserService {

    
  /**
   * Verifica si la combinacion de usuario y password son validos para acceso al
   * sistema
   * @param login Usuario a registrar
   * @param secret Password del usuario
   * @return el codigo resultante de la operacion
   */
  Integer authenticate( String login, String secret );
  
}
