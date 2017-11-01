package mx.com.nttdata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import mx.com.nttdata.beans.User;
import mx.com.nttdata.dao.ConnectionFactory;
import mx.com.nttdata.dao.IUserDAO;
import mx.com.nttdata.dao.UserDAO;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Properties;


/**
 * Clase que implementa el manejo de los usuarios de la aplicacion
 * @version 1.0.0
 */
public class UserService implements ILocalUserService {

  /** Log de la aplicacion */
  private static Logger logger;

  private IUserDAO dao;

  /** Nombre del datasource a utilizar */
  private static String dsName;
  /** Nombre de la fabrica de conexiones */
  private static String cfName;


  /**
   * Constructor predeterminado
   */
  public UserService() {

    super();
    logger = Logger.getLogger( this.getClass());
    dsName = Properties.getString( IGlobalConstants.PROP_DS_NAME );
    cfName = Properties.getString( IGlobalConstants.PROP_DS_FACTORY );

    try {
      ConnectionFactory cf = new ConnectionFactory();
      this.dao             = new UserDAO( cf.getDataSource( dsName, cfName ));

    } catch ( Exception ex ) {

      logger.error( "UserService.(). Ocurri\u00fe un problema conect\u00e1ndose a la base de datos ", ex  );
    }
  }

  /**
   * Verifica si la combinacion de usuario y password son validos para acceso al
   * sistema
   * @param login Usuario a registrar
   * @param secret Password del usuario
   * @return el codigo resultante de la operacion
   */
  @Override
  public Integer authenticate( String login, String secret ) {

    String pwd = DigestUtils.md5Hex( secret  );
    int result = IGlobalConstants.LOGIN_REJECTED_CODE;

    try {
      result = dao.authenticate( login, pwd );

    } catch ( Exception ex ) {

      logger.error( "UserService.authenticate(). Ocurri\u00fe un problema autenticando el login " + login, ex  );
    }
    return result;
  }

  @Override
  public String createUser( User bean, String login ) {

    int cnt = 0;
    try {
      cnt = this.dao.create( bean, login );

    } catch ( Exception ex ) {

      logger.error( "UserService.createUser(). Ocurri\u00fe un problema creando al usuario " + bean.getLoginName(), ex  );
      return "El usuario no pudo ser creado";
    }
    return "Se creo al usuario '" + bean.getLoginName() + "' existosamente";
  }

  @Override
  public String disableUser( String userID, String login ) {

    return "";
  }

  @Override
  public String enableUser( String userID, String login ) {

    return "";
  }

  @Override
  public String deleteUser( String userID, String login ) {

    try {
      dao.delete( userID );
      return "Se elimin\u00f3 el usuario '" + userID + "'";

    } catch ( Exception ex ) {

      logger.error( "UserService.deleteUser(). Error al eliminar el usuario '" + userID + "'", ex  );
    }
    return "Error";
  }

  @Override
  public User getUser( String userID ) {

    try {
      return this.dao.read( userID );

    } catch( Exception ex ) {

      logger.error( "UserService.getUser(). Error recuperando el usuario '" + userID + "'", ex  );
    }
    return null;
  }

  /**
   * Devuelve el nivel de acceso del usuario solicitado
   * @param login Nombre del usuario a recuperar
   * @return Nivel de acceso del usuario
   */
  @Override
  public int getUserLevel( String login ) {

    return this.dao.getUserLevel( login );
  }

  @Override
  public List<User> getUserList( Integer userLevel, String filter ) {

    List<User> result = new ArrayList<>();
    try {
      result = dao.list( userLevel, filter );

    } catch ( Exception ex ) {

      logger.error( "UserService.getUserList(). No se pudo recuperar informaci\u00f3n de los usuarios", ex  );
    }
    return result;
  }

  @Override
  public boolean isUniqueUser( String loginName, Integer id, boolean isNew ) {

    return this.dao.isUniqueUser( loginName, id, isNew );
  }

  @Override
  public boolean isUniqueMail( String loginName, Integer id, boolean isNew ) {

    return this.dao.isUniqueMail( loginName, id, isNew );
  }

  @Override
  public String updateUser( User bean, String login ) {

    int cnt = 0;
    try {
      cnt = this.dao.update( bean, login );

    } catch ( Exception ex ) {

      logger.error( "UserService.updateUser(). Ocurri\u00fe un problema actualizando al usuario " + bean.getLoginName(), ex );
      return "El usuario no pudo ser actualizado";
    }
    return "Se actualiz\u00f3 al usuario '" + bean.getLoginName() + "' existosamente";
  }

}
