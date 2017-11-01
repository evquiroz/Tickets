package mx.com.nttdata.beans;

import java.util.Map;
import java.util.TreeMap;

/**
 * Enumeracion para el estado de los usuarios
 * @author flozada
 */
public enum UserStatus {

  STATUS_ACTIVE("A"),
  STATUS_SUSPENDED("S"),
  STATUS_DELETED("B");


  public final static String STATUS_NAME_ACTIVE    = "Activo";
  public final static String STATUS_NAME_SUSPENDED = "Suspendido";
  public final static String STATUS_NAME_DELETED   = "Eliminado";

  public final static String STATUS_ID_ACTIVE      = "A";
  public final static String STATUS_ID_SUSPENDED   = "S";
  public final static String STATUS_ID_DELETED     = "B";


  private String userStatus;


  UserStatus( String status ) {

    this.userStatus = status;
  }

  public final String getUserStatus() {

    return userStatus;
  }

  public String getStatusName() {

    return getStatusName( this );
  }

  public final static String getStatusName( String status ) {

    if ( status.equals( STATUS_ID_ACTIVE ))
       return STATUS_NAME_ACTIVE;
    if ( status.equals( STATUS_ID_SUSPENDED ))
       return STATUS_NAME_SUSPENDED;
    return STATUS_NAME_DELETED;
  }

  public final static String getStatusName( UserStatus status ) {

    if ( status.equals( STATUS_ACTIVE ))
       return STATUS_NAME_ACTIVE;
    if ( status.equals( STATUS_SUSPENDED ))
       return STATUS_NAME_SUSPENDED;
    return STATUS_NAME_DELETED;
  }

  public final static Map<String,String> getStatusList() {

    Map<String,String> result = new TreeMap<>();

    result.put( STATUS_ID_ACTIVE,    STATUS_NAME_ACTIVE );
    result.put( STATUS_ID_SUSPENDED, STATUS_NAME_SUSPENDED );
    result.put( STATUS_ID_DELETED,   STATUS_NAME_DELETED );

    return result;
  }

}
