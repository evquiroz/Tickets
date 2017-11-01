package ctm_people_getinfo_ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ctm_people_getinfo_ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuthenticationInfo_QNAME = new QName("urn:CTM_People_GetInfo_WS", "AuthenticationInfo");
    private final static QName _CTMGetPeopleInfo_QNAME = new QName("urn:CTM_People_GetInfo_WS", "CTM_GetPeopleInfo");
    private final static QName _CTMGetPeopleInfoResponse_QNAME = new QName("urn:CTM_People_GetInfo_WS", "CTM_GetPeopleInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ctm_people_getinfo_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutputMapping3 }
     * 
     */
    public OutputMapping3 createOutputMapping3() {
        return new OutputMapping3();
    }

    /**
     * Create an instance of {@link InputMapping3 }
     * 
     */
    public InputMapping3 createInputMapping3() {
        return new InputMapping3();
    }

    /**
     * Create an instance of {@link AuthenticationInfo }
     * 
     */
    public AuthenticationInfo createAuthenticationInfo() {
        return new AuthenticationInfo();
    }

    /**
     * Create an instance of {@link OutputMapping3 .GetListValues }
     * 
     */
    public OutputMapping3 .GetListValues createOutputMapping3GetListValues() {
        return new OutputMapping3 .GetListValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:CTM_People_GetInfo_WS", name = "AuthenticationInfo")
    public JAXBElement<AuthenticationInfo> createAuthenticationInfo(AuthenticationInfo value) {
        return new JAXBElement<AuthenticationInfo>(_AuthenticationInfo_QNAME, AuthenticationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputMapping3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:CTM_People_GetInfo_WS", name = "CTM_GetPeopleInfo")
    public JAXBElement<InputMapping3> createCTMGetPeopleInfo(InputMapping3 value) {
        return new JAXBElement<InputMapping3>(_CTMGetPeopleInfo_QNAME, InputMapping3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputMapping3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:CTM_People_GetInfo_WS", name = "CTM_GetPeopleInfoResponse")
    public JAXBElement<OutputMapping3> createCTMGetPeopleInfoResponse(OutputMapping3 value) {
        return new JAXBElement<OutputMapping3>(_CTMGetPeopleInfoResponse_QNAME, OutputMapping3 .class, null, value);
    }

}
