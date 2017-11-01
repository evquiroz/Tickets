package mx.com.nttdata.service;

// import org.apache.commons.codec.binary.Hex;
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
public class UserService implements IUserService {

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

  //// Getters y setters

}
