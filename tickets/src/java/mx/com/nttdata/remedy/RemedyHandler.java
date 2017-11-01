package mx.com.nttdata.remedy;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;

/**
 * Intercepta los mensajes de salida agregandole el usuario y el password en el header
 * @version 1.0.0
 */
public class RemedyHandler implements SOAPHandler<SOAPMessageContext>, RemedyConstants {
  
  private Logger logger;
  
  private String authNodeName;
  private String userNodeName;
  private String pwdNodeName;
  
  private String user;
  private String secret;
  

  public RemedyHandler() { 
      
    super();
    this.logger       = Logger.getLogger( this.getClass());
    this.authNodeName = AUTH_NODE_NAME;
    this.userNodeName = USER_NODE_NAME;
    this.pwdNodeName  = PWD_NODE_NAME;
    
    this.user         = null;
    this.secret       = null;
  }
  
  public RemedyHandler( String user, String pwd ) { 

    this();
    this.user         = user;
    this.secret       = pwd;
  }
  
  @Override
  public Set<QName> getHeaders() {
      
    return new TreeSet();
  }
    
  @Override
  public boolean handleFault( SOAPMessageContext context ) {
      
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean handleMessage( SOAPMessageContext context ) {

    Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if ( outbound ) {
       SOAPMessage soapMsg = context.getMessage();
       try {
         SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
         SOAPFactory factory = SOAPFactory.newInstance();

         SOAPElement authTag = factory.createElement( this.authNodeName );
         SOAPElement userTag = factory.createElement( this.userNodeName );
         SOAPElement secTag  = factory.createElement( this.pwdNodeName );
         SOAPHeader header;
         if ( envelope.getHeader() == null )
            header = envelope.addHeader();
         else 
            header = envelope.getHeader();
         
         userTag.addTextNode( this.user );
         secTag.addTextNode( this.secret );           
           
         authTag.addChildElement( userTag );
         authTag.addChildElement( secTag );
         header.addChildElement( authTag );

       } catch ( Exception ex ) {

         logger.error( "RemedyHandler.handleMessage(). Ocurri\u00f3 un problema procesando un mensaje SOAP", ex );
       }
    }
    return true;
  }
    
  @Override
  public void close( MessageContext context ) {
      
    // 
  }    
    
  //// Getters y setters

  public String getUser() {
    
    return user;
  }

  public String getSecret() {
    
    return secret;
  }
  
  public String getAuthenticationNodeName() {
    
    return authNodeName;
  }

  public String getUserNodeName() {
    
    return userNodeName;
  }

  public String getPasswordNodeName() {
    
    return pwdNodeName;
  }

  public void setUser( String user ) {
    
    this.user = user;
  }

  public void setSecret( String secret ) {
    
    this.secret = secret;
  }
  
  public void setAuthNodeName( String authNodeName ) {
    
    this.authNodeName = authNodeName;
  }

  public void setUserNodeName( String userNodeName ) {
    
    this.userNodeName = userNodeName;
  }

  public void setPasswordNodeName( String pwdNodeName ) {
    
    this.pwdNodeName = pwdNodeName;
  }
  
}
