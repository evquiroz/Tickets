package mx.com.gentera.helpdesk.wo;

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
 * WOI:WorkOrderInterface_Create
 *
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "WOI_WorkOrderInterface_Create_WS", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS", wsdlLocation = "file:/public/Gentera/WOI_WorkOrderInterface_Create_WS.wsdl")
public class WOIWorkOrderInterfaceCreateWSService extends Service
{

/*
    private final static URL WOIWORKORDERINTERFACECREATEWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException WOIWORKORDERINTERFACECREATEWSSERVICE_EXCEPTION;
*/
    private final static QName WOIWORKORDERINTERFACECREATEWSSERVICE_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "WOI_WorkOrderInterface_Create_WS");

/*
    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/public/Gentera/WOI_WorkOrderInterface_Create_WS.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WOIWORKORDERINTERFACECREATEWSSERVICE_WSDL_LOCATION = url;
        WOIWORKORDERINTERFACECREATEWSSERVICE_EXCEPTION = e;
    }

    public WOIWorkOrderInterfaceCreateWSService() {
        super(__getWsdlLocation(), WOIWORKORDERINTERFACECREATEWSSERVICE_QNAME);
    }

    public WOIWorkOrderInterfaceCreateWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WOIWORKORDERINTERFACECREATEWSSERVICE_QNAME, features);
    }
*/
    public WOIWorkOrderInterfaceCreateWSService( URL wsdlLocation ) {

      super( wsdlLocation, WOIWORKORDERINTERFACECREATEWSSERVICE_QNAME );
    }

    public WOIWorkOrderInterfaceCreateWSService( String wsdlLocation ) throws Exception {

      super( new URL( wsdlLocation ), WOIWORKORDERINTERFACECREATEWSSERVICE_QNAME );
    }

/*
    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WOIWORKORDERINTERFACECREATEWSSERVICE_QNAME, features);
    }

    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }
*/
    /**
     *
     * @return
     *     returns WOIWorkOrderInterfaceCreateWSPortTypePortType
     */
    @WebEndpoint(name = "WOI_WorkOrderInterface_Create_WSPortTypeSoap")
    public WOIWorkOrderInterfaceCreateWSPortTypePortType getWOIWorkOrderInterfaceCreateWSPortTypeSoap() {

        return super.getPort( new QName("urn:WOI_WorkOrderInterface_Create_WS", "WOI_WorkOrderInterface_Create_WSPortTypeSoap"),
                              WOIWorkOrderInterfaceCreateWSPortTypePortType.class );
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WOIWorkOrderInterfaceCreateWSPortTypePortType
     */
/*
    @WebEndpoint(name = "WOI_WorkOrdertInterface_Create_WSPortTypeSoap")
    public WOIWorkOrderInterfaceCreateWSPortTypePortType getWOIWorkOrderInterfaceCreateWSPortTypeSoap(WebServiceFeature... features) {
        return super.getPort(new QName("urn:WOI_WorkOrderInterface_Create_WS", "WOI_WorkOrdertInterface_Create_WSPortTypeSoap"), WOIWorkOrderInterfaceCreateWSPortTypePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WOIWORKORDERINTERFACECREATEWSSERVICE_EXCEPTION!= null) {
            throw WOIWORKORDERINTERFACECREATEWSSERVICE_EXCEPTION;
        }
        return WOIWORKORDERINTERFACECREATEWSSERVICE_WSDL_LOCATION;
    }
*/

}
