package mx.com.nttdata.beans;

import  java.io.Serializable;
import mx.com.nttdata.util.IGlobalConstants;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Bean para el manejo de usuarios locales de la aplicacion. Para la administracion
 * del usuarios. Existe uno y solo un administrador, adicionalmente, todos los
 * passwords son convertidos a MD5 para que esten en modo claro lo menos posible
 * @version 1.0.0
 */
public class User implements Serializable {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -8907771744140172042L;

  /** Cadena vacia */
  // public final static String BLANK_STRING = "";
  /** Estado predeterminado de los usuarios */
  // public final static String DEFAULT_USER_STATUS = "A";
  /** Nivel predeterminaado de los usuarios */
  // public final static int DEFAULT_USER_LEVEL = 3;

  /** Estados posibles para los usuarios Activo, Baja, Suspendido */
  private final static String[] USER_STATES = { "A", "B", "S" };
  /** Niveles posibles para los usuarios: 1 Admin, 2 Supervisor, 3 Usuario */
  private final static int[]    USER_LEVELS = { 1, 2, 3 };


  private String  loginName;
  private String  secret;
  private String  email;
  private Integer level;
  private String  status;


  /**
   * Constructor predeterminado
   */
  public User() {

    super();
  }

  /**
   * Metodo para oscurecer las contrasennas y evitar asi riesgos de seguridad
   * @param cleanText Contrasenna a ocultar
   * @return Una cadena con la contrasenna asegurada
   */
  public final String secure( String cleanText ) {

    if ( cleanText == null || cleanText.isEmpty())
       return IGlobalConstants.EMPTY_STRING;
    return DigestUtils.md5Hex( cleanText );
  }

  //// Getters y setters

  public String getLoginName() {

    return loginName;
  }

  public String getSecret() {

    return secret;
  }

  public String getMail() {

    return email;
  }

  public Integer getLevel() {

    return level;
  }

  public String getStatus() {

    return status;
  }

  public void setLoginName( String loginName ) {

    this.loginName = loginName;
  }

  public void setSecret( String secret ) {

    this.secret = secret;
  }

  public void setMail( String email ) {

    this.email = email;
  }

  public void setLevel( Integer level ) {

    this.level = ArrayUtils.contains( USER_LEVELS, level )   ? level  : IGlobalConstants.DEFAULT_USER_LEVEL;
  }

  public void setStatus( String status ) {

    this.status = ArrayUtils.contains( USER_STATES, status ) ? status : IGlobalConstants.DEFAULT_USER_STATUS;
  }

}
