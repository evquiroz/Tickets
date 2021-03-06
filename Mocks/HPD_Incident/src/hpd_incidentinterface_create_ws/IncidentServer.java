package hpd_incidentinterface_create_ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import java.util.Calendar;

@WebService(targetNamespace = "urn:HPD_IncidentInterface_Create_WS",
            name = "HPD_IncidentInterface_Create_WSPortType",
            serviceName="HPD_IncidentInterface_Create_WS",
            portName="HPD_IncidentInterface_Create_WSPortTypeSoap"
            )
public class IncidentServer implements HPDIncidentInterfaceCreateWSPortTypePortType {

  @WebMethod(operationName = "HelpDesk_Submit_Service", action = "urn:HPD_IncidentInterface_Create_WS/HelpDesk_Submit_Service")
  @RequestWrapper(localName = "HelpDesk_Submit_Service", targetNamespace = "urn:HPD_IncidentInterface_Create_WS", className = "hpd_incidentinterface_create_ws.CreateInputMap")
  @WebResult(name = "Incident_Number", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
  @ResponseWrapper(localName = "HelpDesk_Submit_ServiceResponse", targetNamespace = "urn:HPD_IncidentInterface_Create_WS", className = "hpd_incidentinterface_create_ws.CreateOutputMap")
  @Override
  public String helpDeskSubmitService(

      @WebParam(name = "Assigned_Group", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String assignedGroup,
      @WebParam(name = "Assigned_Group_Shift_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String assignedGroupShiftName,
      @WebParam(name = "Assigned_Support_Company", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String assignedSupportCompany,
      @WebParam(name = "Assigned_Support_Organization", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String assignedSupportOrganization,
      @WebParam(name = "Assignee", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String assignee,
      @WebParam(name = "Categorization_Tier_1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String categorizationTier1,
      @WebParam(name = "Categorization_Tier_2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String categorizationTier2,
      @WebParam(name = "Categorization_Tier_3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String categorizationTier3,
      @WebParam(name = "CI_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String ciName,
      @WebParam(name = "Closure_Manufacturer", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String closureManufacturer,
      @WebParam(name = "Closure_Product_Category_Tier1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String closureProductCategoryTier1,
      @WebParam(name = "Closure_Product_Category_Tier2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String closureProductCategoryTier2,
      @WebParam(name = "Closure_Product_Category_Tier3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String closureProductCategoryTier3,
      @WebParam(name = "Closure_Product_Model_Version", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String closureProductModelVersion,
      @WebParam(name = "Closure_Product_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String closureProductName,
      @WebParam(name = "Department", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String department,
      @WebParam(name = "First_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String firstName,
      @WebParam(name = "Impact", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String impact,
      @WebParam(name = "Last_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String lastName,
      @WebParam(name = "Lookup_Keyword", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String lookupKeyword,
      @WebParam(name = "Manufacturer", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String manufacturer,
      @WebParam(name = "Product_Categorization_Tier_1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String productCategorizationTier1,
      @WebParam(name = "Product_Categorization_Tier_2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String productCategorizationTier2,
      @WebParam(name = "Product_Categorization_Tier_3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String productCategorizationTier3,
      @WebParam(name = "Product_Model_Version", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String productModelVersion,
      @WebParam(name = "Product_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String productName,
      @WebParam(name = "Reported_Source", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      ReportedSourceType reportedSource,
      @WebParam(name = "Resolution", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String resolution,
      @WebParam(name = "Resolution_Category_Tier_1", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String resolutionCategoryTier1,
      @WebParam(name = "Resolution_Category_Tier_2", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String resolutionCategoryTier2,
      @WebParam(name = "Resolution_Category_Tier_3", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String resolutionCategoryTier3,
      @WebParam(name = "Service_Type", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      ServiceTypeType serviceType,
      @WebParam(name = "Status", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      StatusType status,
      @WebParam(name = "Action", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String action,
      @WebParam(name = "Create_Request", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      CreateRequestType createRequest,
      @WebParam(name = "Summary", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String summary,
      @WebParam(name = "Notes", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String notes,
      @WebParam(name = "Urgency", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String urgency,
      @WebParam(name = "Work_Info_Summary", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String workInfoSummary,
      @WebParam(name = "Work_Info_Notes", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String workInfoNotes,
      @WebParam(name = "Work_Info_Type", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      WorkInfoTypeType workInfoType,
      @WebParam(name = "Work_Info_Date", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      XMLGregorianCalendar workInfoDate,
      @WebParam(name = "Work_Info_Source", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      WorkInfoSourceType workInfoSource,
      @WebParam(name = "Work_Info_Locked", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      CreateRequestType workInfoLocked,
      @WebParam(name = "Work_Info_View_Access", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      WorkInfoViewAccessType workInfoViewAccess,
      @WebParam(name = "Middle_Initial", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String middleInitial,
      @WebParam(name = "Status_Reason", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      StatusReasonType statusReason,
      @WebParam(name = "Direct_Contact_First_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String directContactFirstName,
      @WebParam(name = "Direct_Contact_Middle_Initial", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String directContactMiddleInitial,
      @WebParam(name = "Direct_Contact_Last_Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String directContactLastName,
      @WebParam(name = "TemplateID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String templateID,
      @WebParam(name = "ServiceCI", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String serviceCI,
      @WebParam(name = "ServiceCI_ReconID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String serviceCIReconID,
      @WebParam(name = "HPD_CI", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String hpdCI,
      @WebParam(name = "HPD_CI_ReconID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String hpdCIReconID,
      @WebParam(name = "HPD_CI_FormName", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String hpdCIFormName,
      @WebParam(name = "WorkInfoAttachment1Name", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String workInfoAttachment1Name,
      @WebParam(name = "WorkInfoAttachment1Data", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      byte[] workInfoAttachment1Data,
      @WebParam(name = "WorkInfoAttachment1OrigSize", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      Integer workInfoAttachment1OrigSize,
      @WebParam(name = "Login_ID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String loginID,
      @WebParam(name = "Customer_Company", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String customerCompany,
      @WebParam(name = "Corporate_ID", targetNamespace = "urn:HPD_IncidentInterface_Create_WS")
      String corporateID

      ) {

    Calendar cal    = Calendar.getInstance();
    String   result = "IN001000" + cal.get( Calendar.MINUTE ) + cal.get( Calendar.SECOND );
    System.out.println("Se genero el incidente No: " + result );

    return result;
  }

}
