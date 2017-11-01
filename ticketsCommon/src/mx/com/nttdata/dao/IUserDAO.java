package mx.com.nttdata.dao;

import java.util.List;
import mx.com.nttdata.beans.User;

/**
 * interfaz que modela el DAO de usuarios locales
 * @version 1.0.0
 */
public interface IUserDAO {

  int authenticate( String loginName, String secret ) throws Exception;

  int create( User record, String loggedUser ) throws Exception;

  int delete( String loginName ) throws Exception;

  int getUserLevel( String login );

  List<User> list( int currentUserLevel, String filter ) throws Exception;

  boolean isUniqueUser( String loginName, Integer id, boolean isNew );

  boolean isUniqueMail( String eMail, Integer id, boolean isNew );

  User read( String loginName ) throws Exception;

  int update( User record, String loggedUser ) throws Exception;

}
