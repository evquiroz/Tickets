package woi_workorderinterface_create_ws;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * WOI:WorkOrderInterface_Create  
 *
 * This class was generated by Apache CXF 2.6.10
 * 2017-05-27T00:41:19.373-05:00
 * Generated source version: 2.6.10
 * 
 */
@WebServiceClient(name = "WOI_WorkOrderInterface_Create_WSService", 
                  wsdlLocation = "WOI_WorkOrderInterface_Create_WS.wsdl",
                  targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS") 
public class WOIWorkOrderInterfaceCreateWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:WOI_WorkOrderInterface_Create_WS", "WOI_WorkOrderInterface_Create_WSService");
    public final static QName WOIWorkOrdertInterfaceCreateWSPortTypeSoap = new QName("urn:WOI_WorkOrderInterface_Create_WS", "WOI_WorkOrdertInterface_Create_WSPortTypeSoap");
    static {
        URL url = WOIWorkOrderInterfaceCreateWSService.class.getResource("WOI_WorkOrderInterface_Create_WS.wsdl");
        if (url == null) {
            url = WOIWorkOrderInterfaceCreateWSService.class.getClassLoader().getResource("WOI_WorkOrderInterface_Create_WS.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(WOIWorkOrderInterfaceCreateWSService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "WOI_WorkOrderInterface_Create_WS.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WOIWorkOrderInterfaceCreateWSService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WOIWorkOrderInterfaceCreateWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WOIWorkOrderInterfaceCreateWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns WOIWorkOrdertInterfaceCreateWSPortTypePortType
     */
    @WebEndpoint(name = "WOI_WorkOrdertInterface_Create_WSPortTypeSoap")
    public WOIWorkOrdertInterfaceCreateWSPortTypePortType getWOIWorkOrdertInterfaceCreateWSPortTypeSoap() {
        return super.getPort(WOIWorkOrdertInterfaceCreateWSPortTypeSoap, WOIWorkOrdertInterfaceCreateWSPortTypePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WOIWorkOrdertInterfaceCreateWSPortTypePortType
     */
    @WebEndpoint(name = "WOI_WorkOrdertInterface_Create_WSPortTypeSoap")
    public WOIWorkOrdertInterfaceCreateWSPortTypePortType getWOIWorkOrdertInterfaceCreateWSPortTypeSoap(WebServiceFeature... features) {
        return super.getPort(WOIWorkOrdertInterfaceCreateWSPortTypeSoap, WOIWorkOrdertInterfaceCreateWSPortTypePortType.class, features);
    }

}
