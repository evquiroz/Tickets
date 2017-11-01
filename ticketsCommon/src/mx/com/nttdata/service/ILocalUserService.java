package mx.com.nttdata.service;

import java.util.List;

import mx.com.nttdata.beans.User;

/**
 * Interfaz de servicio completo de manipulacion de usuarios
 * @version 1.0.0
 */
public interface ILocalUserService extends IUserService {


  String createUser( User bean, String login );

  String disableUser( String userID, String login );

  String enableUser( String userID, String login );

  String deleteUser( String userID, String login );

  User getUser( String userID );

  /**
   * Devuelve el nivel de acceso del usuario solicitado
   * @param login Nombre del usuario a recuperar
   * @return Nivel de acceso del usuario
   */
  int getUserLevel( String login );

  List<User> getUserList( Integer userLevel, String filter );

  boolean isUniqueUser( String loginName, Integer id, boolean isNew );

  boolean isUniqueMail( String eMail, Integer id, boolean isNew  );

  String updateUser( User bean, String login );

}
