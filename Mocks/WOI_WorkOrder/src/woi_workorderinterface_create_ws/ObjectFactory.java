package woi_workorderinterface_create_ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the woi_workorderinterface_create_ws package. 
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

    private final static QName _WorkOrderSubmitService_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "WorkOrder_Submit_Service");
    private final static QName _AuthenticationInfo_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "AuthenticationInfo");
    private final static QName _WorkOrderSubmitServiceResponse_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "WorkOrder_Submit_ServiceResponse");
    private final static QName _InputMapping1StatusReason_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Status_Reason");
    private final static QName _InputMapping1Priority_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Priority");
    private final static QName _InputMapping1WorkOrderType_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Work_Order_Type");
    private final static QName _InputMapping1SetManagerUsing_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Set_Manager_using");
    private final static QName _InputMapping1CreatedFromFlag_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Created_From_flag");
    private final static QName _InputMapping1AddRequestFor_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Add_Request_For_");
    private final static QName _InputMapping1ContactSensitivity_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Contact_Sensitivity");
    private final static QName _InputMapping1SRWorkInfoType_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "SRWorkInfoType");
    private final static QName _InputMapping1VIP_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "VIP");
    private final static QName _InputMapping1Z1DViewAccess_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "z1D_View_Access");
    private final static QName _InputMapping1SecureWorkLog_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Secure_Work_Log");
    private final static QName _InputMapping1Z1DCommunicationSource_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "z1D_CommunicationSource");
    private final static QName _InputMapping1CreatedFromBackEndSynchWI_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "CreatedFromBackEndSynchWI");
    private final static QName _InputMapping1AssignmentAcceleratorAssignee_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Assignment_Accelerator_Assignee");
    private final static QName _InputMapping1SecureWorkLog2_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "Secure_Work_Log2");
    private final static QName _InputMapping1ViewAccess_QNAME = new QName("urn:WOI_WorkOrderInterface_Create_WS", "View_Access");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: woi_workorderinterface_create_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutputMapping1 }
     * 
     */
    public OutputMapping1 createOutputMapping1() {
        return new OutputMapping1();
    }

    /**
     * Create an instance of {@link AuthenticationInfo }
     * 
     */
    public AuthenticationInfo createAuthenticationInfo() {
        return new AuthenticationInfo();
    }

    /**
     * Create an instance of {@link InputMapping1 }
     * 
     */
    public InputMapping1 createInputMapping1() {
        return new InputMapping1();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputMapping1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "WorkOrder_Submit_Service")
    public JAXBElement<InputMapping1> createWorkOrderSubmitService(InputMapping1 value) {
        return new JAXBElement<InputMapping1>(_WorkOrderSubmitService_QNAME, InputMapping1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "AuthenticationInfo")
    public JAXBElement<AuthenticationInfo> createAuthenticationInfo(AuthenticationInfo value) {
        return new JAXBElement<AuthenticationInfo>(_AuthenticationInfo_QNAME, AuthenticationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputMapping1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "WorkOrder_Submit_ServiceResponse")
    public JAXBElement<OutputMapping1> createWorkOrderSubmitServiceResponse(OutputMapping1 value) {
        return new JAXBElement<OutputMapping1>(_WorkOrderSubmitServiceResponse_QNAME, OutputMapping1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusReasonType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Status_Reason", scope = InputMapping1 .class)
    public JAXBElement<StatusReasonType> createInputMapping1StatusReason(StatusReasonType value) {
        return new JAXBElement<StatusReasonType>(_InputMapping1StatusReason_QNAME, StatusReasonType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriorityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Priority", scope = InputMapping1 .class)
    public JAXBElement<PriorityType> createInputMapping1Priority(PriorityType value) {
        return new JAXBElement<PriorityType>(_InputMapping1Priority_QNAME, PriorityType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkOrderTypeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Work_Order_Type", scope = InputMapping1 .class)
    public JAXBElement<WorkOrderTypeType> createInputMapping1WorkOrderType(WorkOrderTypeType value) {
        return new JAXBElement<WorkOrderTypeType>(_InputMapping1WorkOrderType_QNAME, WorkOrderTypeType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetManagerUsingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Set_Manager_using", scope = InputMapping1 .class)
    public JAXBElement<SetManagerUsingType> createInputMapping1SetManagerUsing(SetManagerUsingType value) {
        return new JAXBElement<SetManagerUsingType>(_InputMapping1SetManagerUsing_QNAME, SetManagerUsingType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatedFromFlagType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Created_From_flag", scope = InputMapping1 .class)
    public JAXBElement<CreatedFromFlagType> createInputMapping1CreatedFromFlag(CreatedFromFlagType value) {
        return new JAXBElement<CreatedFromFlagType>(_InputMapping1CreatedFromFlag_QNAME, CreatedFromFlagType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRequestForType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Add_Request_For_", scope = InputMapping1 .class)
    public JAXBElement<AddRequestForType> createInputMapping1AddRequestFor(AddRequestForType value) {
        return new JAXBElement<AddRequestForType>(_InputMapping1AddRequestFor_QNAME, AddRequestForType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactSensitivityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Contact_Sensitivity", scope = InputMapping1 .class)
    public JAXBElement<ContactSensitivityType> createInputMapping1ContactSensitivity(ContactSensitivityType value) {
        return new JAXBElement<ContactSensitivityType>(_InputMapping1ContactSensitivity_QNAME, ContactSensitivityType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SRWorkInfoTypeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "SRWorkInfoType", scope = InputMapping1 .class)
    public JAXBElement<SRWorkInfoTypeType> createInputMapping1SRWorkInfoType(SRWorkInfoTypeType value) {
        return new JAXBElement<SRWorkInfoTypeType>(_InputMapping1SRWorkInfoType_QNAME, SRWorkInfoTypeType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "VIP", scope = InputMapping1 .class)
    public JAXBElement<SecureWorkLogType> createInputMapping1VIP(SecureWorkLogType value) {
        return new JAXBElement<SecureWorkLogType>(_InputMapping1VIP_QNAME, SecureWorkLogType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Z1DViewAccessType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "z1D_View_Access", scope = InputMapping1 .class)
    public JAXBElement<Z1DViewAccessType> createInputMapping1Z1DViewAccess(Z1DViewAccessType value) {
        return new JAXBElement<Z1DViewAccessType>(_InputMapping1Z1DViewAccess_QNAME, Z1DViewAccessType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Secure_Work_Log", scope = InputMapping1 .class)
    public JAXBElement<SecureWorkLogType> createInputMapping1SecureWorkLog(SecureWorkLogType value) {
        return new JAXBElement<SecureWorkLogType>(_InputMapping1SecureWorkLog_QNAME, SecureWorkLogType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Z1DCommunicationSourceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "z1D_CommunicationSource", scope = InputMapping1 .class)
    public JAXBElement<Z1DCommunicationSourceType> createInputMapping1Z1DCommunicationSource(Z1DCommunicationSourceType value) {
        return new JAXBElement<Z1DCommunicationSourceType>(_InputMapping1Z1DCommunicationSource_QNAME, Z1DCommunicationSourceType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatedFromBackEndSynchWIType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "CreatedFromBackEndSynchWI", scope = InputMapping1 .class)
    public JAXBElement<CreatedFromBackEndSynchWIType> createInputMapping1CreatedFromBackEndSynchWI(CreatedFromBackEndSynchWIType value) {
        return new JAXBElement<CreatedFromBackEndSynchWIType>(_InputMapping1CreatedFromBackEndSynchWI_QNAME, CreatedFromBackEndSynchWIType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignmentAcceleratorAssigneeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Assignment_Accelerator_Assignee", scope = InputMapping1 .class)
    public JAXBElement<AssignmentAcceleratorAssigneeType> createInputMapping1AssignmentAcceleratorAssignee(AssignmentAcceleratorAssigneeType value) {
        return new JAXBElement<AssignmentAcceleratorAssigneeType>(_InputMapping1AssignmentAcceleratorAssignee_QNAME, AssignmentAcceleratorAssigneeType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "Secure_Work_Log2", scope = InputMapping1 .class)
    public JAXBElement<SecureWorkLogType> createInputMapping1SecureWorkLog2(SecureWorkLogType value) {
        return new JAXBElement<SecureWorkLogType>(_InputMapping1SecureWorkLog2_QNAME, SecureWorkLogType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Z1DViewAccessType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "View_Access", scope = InputMapping1 .class)
    public JAXBElement<Z1DViewAccessType> createInputMapping1ViewAccess(Z1DViewAccessType value) {
        return new JAXBElement<Z1DViewAccessType>(_InputMapping1ViewAccess_QNAME, Z1DViewAccessType.class, InputMapping1 .class, value);
    }

}
