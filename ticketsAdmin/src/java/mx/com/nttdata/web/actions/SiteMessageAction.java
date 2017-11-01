package mx.com.nttdata.web.actions;

import java.util.Map;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import mx.com.nttdata.beans.SiteMessage;
import mx.com.nttdata.service.MessageService;
import mx.com.nttdata.util.IGlobalConstants;
import mx.com.nttdata.util.Messages;
// import org.apache.batik.util.Messages;
// import org.apache.struts2.ServletActionContext;

/**
 * Accion que maneja el mensje actual del sistema 
 * @version 1.0.0
 */
public class SiteMessageAction extends ActionSupport implements SessionAware  {

  
  /** Auxiliar de serializaacion */
  private static final long serialVersionUID = -6808677550373300235L;

  private Map<String,Object> session;
  
  // private SiteMessage siteMessage;
  private Integer actionMessageID;

  private String  siteMessage;
    

  @Override
  public String execute() throws Exception {
    
    String loginName = (String) session.get( IGlobalConstants.SESS_LOGIN_NAME );
    if ( loginName == null || loginName.isEmpty()) {
       return "notValid";
    }
    
    MessageService      svc  = new MessageService();
    // HttpServletRequest  req  = ServletActionContext.getRequest();
    // HttpServletResponse resp = ServletActionContext.getResponse();    
    
    String  buffer  = svc.getCurrentMessage();
    String  defMsg  = Messages.getMessage( IGlobalConstants.APP_DEFAULT_MSG );
    boolean isEmpty = buffer == null || buffer.isEmpty() || buffer.equalsIgnoreCase( defMsg );
    
    if ( this.actionMessageID == null )
       this.actionMessageID = isEmpty ? IGlobalConstants.ACN_CREATE_RECORD : IGlobalConstants.ACN_UPDATE_RECORD;
    
    switch ( this.actionMessageID ) {
      
      case IGlobalConstants.ACN_CREATE_RECORD : 
           this.siteMessage = IGlobalConstants.EMPTY_STRING;
           break;
           
      case IGlobalConstants.ACN_UPDATE_RECORD : 
           this.siteMessage = isEmpty ? IGlobalConstants.EMPTY_STRING : buffer;
           break;
           
      case IGlobalConstants.ACN_SAVE_NEW_RECORD:     
      case IGlobalConstants.ACN_SAVE_EDIT_RECORD: {
           
           String info;
           SiteMessage bean = new SiteMessage();
           bean.setMessage( this.siteMessage );
           bean.setMain( true );
           if ( this.siteMessage == null || this.siteMessage.isEmpty())
              this.actionMessageID = IGlobalConstants.ACN_DELETE_RECORD;

           if ( this.actionMessageID == IGlobalConstants.ACN_DELETE_RECORD ) 
              info = svc.cleanMessages();
           else 
           { 
              if ( this.actionMessageID == IGlobalConstants.ACN_SAVE_EDIT_RECORD ) 
                 svc.cleanMessages();
              info = svc.createMessage( bean, loginName );
           }
           session.put( IGlobalConstants.SESS_ERROR_MSG, info );
       
           return Action.SUCCESS;
      }           
    }
            
    session.put( IGlobalConstants.SESS_ERROR_MSG, IGlobalConstants.EMPTY_STRING );
    this.actionMessageID = isEmpty ? IGlobalConstants.ACN_CREATE_RECORD : IGlobalConstants.ACN_UPDATE_RECORD;
    this.session.put( IGlobalConstants.SESS_APP_MSG, this.siteMessage );
    this.session.put( IGlobalConstants.SESS_APP_MSG_ACN, this.actionMessageID );
    
    return Action.INPUT;
  }

  @Override
  public void setSession( Map<String, Object> session ) {

    this.session = session;
  }
  
  /// Getters y setters
  
  public Integer getActionMessageID() { 
    
    return this.actionMessageID;
  }
  
  public String getSiteMessage() {
    
    return this.siteMessage;
  }

  public void setActionMessageID( Integer action ) { 
    
    this.actionMessageID = action;
  }
    
  public void setSiteMessage( String msg ) { 
    
    this.siteMessage = msg;
  }
  
}
