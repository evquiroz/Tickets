package mx.com.nttdata.beans;

import java.util.Map;
import java.util.TreeMap;

/**
 * Bean que maneja los niveles de los usuarios locales 
 * @version 1.0.0
 */
public enum UserLevel {
  
  ADMINISTRATOR( 1 ), 
  SUPERVISOR( 2 ), 
  REVIEWER( 3 ),
  USER( 4 );

  public final static String USER_ADMINISTRATOR    = "Administrador";
  public final static String USER_SUPERVISOR       = "Supervisor";
  public final static String USER_REVIEWER         = "Revisor";
  public final static String USER_USER             = "Usuario";

  public final static int    USER_ID_ADMINISTRATOR = 1;
  public final static int    USER_ID_SUPERVISOR    = 2;
  public final static int    USER_ID_REVIEWER      = 3;
  public final static int    USER_ID_USER          = 4;
  
  private int userLevel;

  
  UserLevel( int level ) {
    
    this.userLevel = level;
  }
  
  public int getUserLevel() { 
    
    return this.userLevel;
  }

  public String getUserLevelName() { 

   return getUserLevelName( this );
  }
  
  public final static String getUserLevelName( int level ) { 
        
    Map<Integer,String> map = getLevelsList();
    if ( map.containsKey( level ))
       return map.get( level );    
    return UserLevel.USER_USER;
  }
  
  public final static String getUserLevelName( UserLevel level ) { 
    
    switch( level ) {
      case ADMINISTRATOR : return USER_ADMINISTRATOR;
      case SUPERVISOR    : return USER_SUPERVISOR;
      case REVIEWER      : return USER_REVIEWER;
    }
    return USER_USER;
  }
  
  public final static Map<Integer,String> getLevelsList() {

    Map<Integer,String> result = new TreeMap<>();
    
    result.put( USER_ID_ADMINISTRATOR,    USER_ADMINISTRATOR );
    result.put( USER_ID_SUPERVISOR, USER_SUPERVISOR );
    result.put( USER_ID_REVIEWER,   USER_REVIEWER );
    
    return result;
  }
    
}
