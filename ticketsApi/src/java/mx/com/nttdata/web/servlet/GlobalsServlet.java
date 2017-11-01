package mx.com.nttdata.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import mx.com.nttdata.beans.Parameters;
import mx.com.nttdata.service.IParametersService;
import mx.com.nttdata.service.ParametersService;
import mx.com.nttdata.util.IGlobalConstants;

/**
 * Servlet que carga los datos globales para ternerlos siempre disponibles
 * @author flozada
 */
public class GlobalsServlet extends HttpServlet {


  /** Auxiliar de serializacion */
  private static final long serialVersionUID = -8548397634654149938L;


  @Override
  public void init() throws ServletException {

    Logger             logger  = Logger.getLogger(GlobalsServlet.class );
    ServletContext     ctx     = this.getServletConfig().getServletContext();
    IParametersService svc     = new ParametersService();
    Parameters         params;

    try {
      params = svc.getParams();
      ctx.setAttribute( IGlobalConstants.SESSION_APP_PARAMS, params );
      logger.info( "GlobalesListener::init(). Se cargaron los par\u00e1metros de la aplicaci\u00f3n" );


    } catch ( Exception ex ) {

      logger.error( "GlobalesListener::init(). Ocurri\u00f3 un problema cargando los par\u00e1metros de la aplicaci\u00f3n",  ex );
    }
  }

}
