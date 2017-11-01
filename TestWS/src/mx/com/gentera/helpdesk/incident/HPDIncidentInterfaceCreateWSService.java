package mx.com.gentera.helpdesk.incident;

// import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
// import javax.xml.ws.WebServiceException;
// import javax.xml.ws.WebServiceFeature;

/**
 *
 * HelpDesk_Submit_Service Create
 *
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "HPD_IncidentInterface_Create_WS", targetNamespace = "urn:HPD_IncidentInterface_Create_WS", wsdlLocation = "http://localhost/wsdl/HPD_IncidentInterface_Create_WS.wsdl")
public class HPDIncidentInterfaceCreateWSService extends Service
{

    // private final static URL HPDINCIDENTINTERFACECREATEWSSERVICE_WSDL_LOCATION;
    // private final static WebServiceException HPDINCIDENTINTERFACECREATEWSSERVICE_EXCEPTION;
    private final static QName HPDINCIDENTINTERFACECREATEWSSERVICE_QNAME = new QName("urn:HPD_IncidentInterface_Create_WS", "HPD_IncidentInterface_Create_WS");

    /*
    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/public/Gentera/HPD_IncidentInterface_Create_WS.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HPDINCIDENTINTERFACECREATEWSSERVICE_WSDL_LOCATION = url;
        HPDINCIDENTINTERFACECREATEWSSERVICE_EXCEPTION = e;
    }
    */

    /*
    public HPDIncidentInterfaceCreateWSService() {
        super(__getWsdlLocation(), HPDINCIDENTINTERFACECREATEWSSERVICE_QNAME);
    }

    public HPDIncidentInterfaceCreateWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HPDINCIDENTINTERFACECREATEWSSERVICE_QNAME, features);
    }
    */

    public HPDIncidentInterfaceCreateWSService(URL wsdlLocation) {

        super(wsdlLocation, HPDINCIDENTINTERFACECREATEWSSERVICE_QNAME);
    }

    public HPDIncidentInterfaceCreateWSService( String wsdlLocation ) throws Exception {

        super( new URL( wsdlLocation ), HPDINCIDENTINTERFACECREATEWSSERVICE_QNAME);
    }

    /*
    public HPDIncidentInterfaceCreateWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HPDINCIDENTINTERFACECREATEWSSERVICE_QNAME, features);
    }

    public HPDIncidentInterfaceCreateWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HPDIncidentInterfaceCreateWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }
    */

    /**
     *
     * @return
     *     returns HPDIncidentInterfaceCreateWSPortTypePortType
     */
    @WebEndpoint(name = "HPD_IncidentInterface_Create_WSPortTypeSoap")
    public HPDIncidentInterfaceCreateWSPortTypePortType getHPDIncidentInterfaceCreateWSPortTypeSoap() {

        return super.getPort( new QName("urn:HPD_IncidentInterface_Create_WS", "HPD_IncidentInterface_Create_WSPortTypeSoap"), HPDIncidentInterfaceCreateWSPortTypePortType.class );
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HPDIncidentInterfaceCreateWSPortTypePortType
     */
    /*
    @WebEndpoint(name = "HPD_IncidentInterface_Create_WSPortTypeSoap")
    public HPDIncidentInterfaceCreateWSPortTypePortType getHPDIncidentInterfaceCreateWSPortTypeSoap(WebServiceFeature... features) {
        return super.getPort(new QName("urn:HPD_IncidentInterface_Create_WS", "HPD_IncidentInterface_Create_WSPortTypeSoap"), HPDIncidentInterfaceCreateWSPortTypePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HPDINCIDENTINTERFACECREATEWSSERVICE_EXCEPTION!= null) {
            throw HPDINCIDENTINTERFACECREATEWSSERVICE_EXCEPTION;
        }
        return HPDINCIDENTINTERFACECREATEWSSERVICE_WSDL_LOCATION;
    }
    */

}