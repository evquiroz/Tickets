package hpd_incidentinterface_create_ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2017-05-27T00:40:57.297-05:00
 * Generated source version: 2.6.10
 *
 */
@WebService(targetNamespace = "urn:HPD_IncidentInterface_Create_WS", name = "HPD_IncidentInterface_Create_WSPortTypePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface HPDIncidentInterfaceCreateWSPortTypePortType {

    @WebResult(name = "Incident_Number", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
    @RequestWrapper(localName = "HelpDesk_Submit_Service", targetNamespace = "urn:HPD_IncidentInterface_Create_WS", className = "hpd_incidentinterface_create_ws.CreateInputMap")
    @WebMethod(operationName = "HelpDesk_Submit_Service", action = "urn:HPD_IncidentInterface_Create_WS/HelpDesk_Submit_Service")
    @ResponseWrapper(localName = "HelpDesk_Submit_ServiceResponse", targetNamespace = "urn:HPD_IncidentInterface_Create_WS", className = "hpd_incidentinterface_create_ws.CreateOutputMap")
    public java.lang.String helpDeskSubmitService(
        @WebParam(name = "Assigned_Group", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String assignedGroup,
        @WebParam(name = "Assigned_Group_Shift_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String assignedGroupShiftName,
        @WebParam(name = "Assigned_Support_Company", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String assignedSupportCompany,
        @WebParam(name = "Assigned_Support_Organization", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String assignedSupportOrganization,
        @WebParam(name = "Assignee", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String assignee,
        @WebParam(name = "Categorization_Tier_1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String categorizationTier1,
        @WebParam(name = "Categorization_Tier_2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String categorizationTier2,
        @WebParam(name = "Categorization_Tier_3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String categorizationTier3,
        @WebParam(name = "CI_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String ciName,
        @WebParam(name = "Closure_Manufacturer", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String closureManufacturer,
        @WebParam(name = "Closure_Product_Category_Tier1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String closureProductCategoryTier1,
        @WebParam(name = "Closure_Product_Category_Tier2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String closureProductCategoryTier2,
        @WebParam(name = "Closure_Product_Category_Tier3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String closureProductCategoryTier3,
        @WebParam(name = "Closure_Product_Model_Version", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String closureProductModelVersion,
        @WebParam(name = "Closure_Product_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String closureProductName,
        @WebParam(name = "Department", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String department,
        @WebParam(name = "First_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String firstName,
        @WebParam(name = "Impact", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String impact,
        @WebParam(name = "Last_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String lastName,
        @WebParam(name = "Lookup_Keyword", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String lookupKeyword,
        @WebParam(name = "Manufacturer", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String manufacturer,
        @WebParam(name = "Product_Categorization_Tier_1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String productCategorizationTier1,
        @WebParam(name = "Product_Categorization_Tier_2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String productCategorizationTier2,
        @WebParam(name = "Product_Categorization_Tier_3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String productCategorizationTier3,
        @WebParam(name = "Product_Model_Version", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String productModelVersion,
        @WebParam(name = "Product_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String productName,
        @WebParam(name = "Reported_Source", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.ReportedSourceType reportedSource,
        @WebParam(name = "Resolution", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String resolution,
        @WebParam(name = "Resolution_Category_Tier_1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String resolutionCategoryTier1,
        @WebParam(name = "Resolution_Category_Tier_2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String resolutionCategoryTier2,
        @WebParam(name = "Resolution_Category_Tier_3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String resolutionCategoryTier3,
        @WebParam(name = "Service_Type", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.ServiceTypeType serviceType,
        @WebParam(name = "Status", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.StatusType status,
        @WebParam(name = "Action", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String action,
        @WebParam(name = "Create_Request", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.CreateRequestType createRequest,
        @WebParam(name = "Summary", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String summary,
        @WebParam(name = "Notes", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String notes,
        @WebParam(name = "Urgency", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String urgency,
        @WebParam(name = "Work_Info_Summary", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String workInfoSummary,
        @WebParam(name = "Work_Info_Notes", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String workInfoNotes,
        @WebParam(name = "Work_Info_Type", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.WorkInfoTypeType workInfoType,
        @WebParam(name = "Work_Info_Date", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar workInfoDate,
        @WebParam(name = "Work_Info_Source", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.WorkInfoSourceType workInfoSource,
        @WebParam(name = "Work_Info_Locked", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.CreateRequestType workInfoLocked,
        @WebParam(name = "Work_Info_View_Access", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.WorkInfoViewAccessType workInfoViewAccess,
        @WebParam(name = "Middle_Initial", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String middleInitial,
        @WebParam(name = "Status_Reason", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        hpd_incidentinterface_create_ws.StatusReasonType statusReason,
        @WebParam(name = "Direct_Contact_First_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String directContactFirstName,
        @WebParam(name = "Direct_Contact_Middle_Initial", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String directContactMiddleInitial,
        @WebParam(name = "Direct_Contact_Last_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String directContactLastName,
        @WebParam(name = "TemplateID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String templateID,
        @WebParam(name = "ServiceCI", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String serviceCI,
        @WebParam(name = "ServiceCI_ReconID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String serviceCIReconID,
        @WebParam(name = "HPD_CI", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String hpdCI,
        @WebParam(name = "HPD_CI_ReconID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String hpdCIReconID,
        @WebParam(name = "HPD_CI_FormName", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String hpdCIFormName,
        @WebParam(name = "WorkInfoAttachment1Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String workInfoAttachment1Name,
        @WebParam(name = "WorkInfoAttachment1Data", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        byte[] workInfoAttachment1Data,
        @WebParam(name = "WorkInfoAttachment1OrigSize", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.Integer workInfoAttachment1OrigSize,
        @WebParam(name = "Login_ID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String loginID,
        @WebParam(name = "Customer_Company", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String customerCompany,
        @WebParam(name = "Corporate_ID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
        java.lang.String corporateID
    );
}