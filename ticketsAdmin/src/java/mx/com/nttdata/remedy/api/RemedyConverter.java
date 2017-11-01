package mx.com.nttdata.remedy.api;

/**
 * Conviert los valores de como se usan con el WebService/Interface web a los 
 * valores usados por la API
 * @version 1.0.0
 * @todo Pasar todos lo valores a constantes
 */
public class RemedyConverter {
    
  public static int convertStatus( String statusName ) { 

   if ( statusName.equalsIgnoreCase("New"))
      return 0;
   if ( statusName.equalsIgnoreCase("Assigned"))
      return 1;
   if ( statusName.equalsIgnoreCase("In Course"))
      return 2;
   if ( statusName.equalsIgnoreCase("Pendant"))
      return 3;
   if ( statusName.equalsIgnoreCase("Solved"))
      return 4;
   if ( statusName.equalsIgnoreCase("Closed"))
      return 5;
   return 6; // Cancelado
  }  
    
  public static int convertStatusReason( String reason ) {
      
    if ( reason.equalsIgnoreCase("User Request") || reason.equalsIgnoreCase("Initial Status"))  
       return 2200;
    return 25800;
  }
  
  public static int convertImpact( String impact ) { 
      
    if ( impact.equalsIgnoreCase("1-Extenso/Generalizado") || impact.equalsIgnoreCase("1-Extensive/Generalized"))  
       return 1000; 
    if ( impact.equalsIgnoreCase("2-Significativo/Amplio") || impact.equalsIgnoreCase("2-Meaningful/Wide"))  
       return 2000; 
    if ( impact.equalsIgnoreCase("3-Moderado/Limitado")    || impact.equalsIgnoreCase("3-Moderated/Limited"))  
       return 3000;
    return 4000; // Menor/Localizado - 4-Minor/Localized 
  }
  
  public static int convertUrgency( String urgency ) { 
      
    if ( urgency.equalsIgnoreCase("Cr\u00edtica") || urgency.equalsIgnoreCase("Critical"))  
       return 1000;
    if ( urgency.equalsIgnoreCase("Alta") || urgency.equalsIgnoreCase("High"))  
       return 2000;
    if ( urgency.equalsIgnoreCase("Medio") || urgency.equalsIgnoreCase("Medium"))  
       return 3000;
    return 4000;  // Baja - Low
  }
  
  public static int convertPriority( String priority ) { 
      
    if ( priority.equalsIgnoreCase("Cr\u00edtica") || priority.equalsIgnoreCase("Critical"))  
       return 0;
    if ( priority.equalsIgnoreCase("Alta") || priority.equalsIgnoreCase("High"))  
       return 1;
    if ( priority.equalsIgnoreCase("Medio") || priority.equalsIgnoreCase("Medium"))  
       return 2;
    return 3;  // Baja - Low
  }
  
  public static int convertServiceType( String serviceType ) {
      
    if ( serviceType.equalsIgnoreCase("Petici\u00f3n de servicio por el usuario") || 
         serviceType.equalsIgnoreCase("User Service Request"))  
       return 0;
    if ( serviceType.equalsIgnoreCase("Restauraci\u00f3n de infraestructura") || 
         serviceType.equalsIgnoreCase("Infrastructure Restoration"))  
       return 1;
    if ( serviceType.equalsIgnoreCase("Evento de infraestructura") || 
         serviceType.equalsIgnoreCase("Infrastructure Event"))  
       return 2;
    return 3;  // Restauracion de servicio a usuario - User Service Restoration
  }
  
  public static int convertOrderType( String orderType ) { 
      
    if ( orderType.equalsIgnoreCase("Control de acceso") || orderType.equalsIgnoreCase("Access Control"))  
       return 2001;
    if ( orderType.equalsIgnoreCase("Solicitud de informaci\u00f3n") || orderType.equalsIgnoreCase("Information Request"))  
       return 2002;
    if ( orderType.equalsIgnoreCase("Servicio nuevo o modificado") || orderType.equalsIgnoreCase("New or Modified Service"))  
       return 2003;
    if ( orderType.equalsIgnoreCase("Instalaci\u00f3n y Configuraci\u00f3n") || orderType.equalsIgnoreCase("Installation and Configuration"))  
       return 2004;
    return 2000;  // General
  }
  
}
