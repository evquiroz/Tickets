package woi_workorderinterface_create_ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
// import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2017-05-27T00:41:19.264-05:00
 * Generated source version: 2.6.10
 *
 */
@WebService(targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS", name = "WOI_WorkOrdertInterface_Create_WSPortTypePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface WOIWorkOrdertInterfaceCreateWSPortTypePortType {

    @RequestWrapper(localName = "WorkOrder_Submit_Service", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS", className = "woi_workorderinterface_create_ws.InputMapping1")
    @WebMethod(operationName = "WorkOrder_Submit_Service", action = "urn:WOI_WorkOrderInterface_Create_WS/WorkOrder_Submit_Service")
    @ResponseWrapper(localName = "WorkOrder_Submit_ServiceResponse", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS", className = "woi_workorderinterface_create_ws.OutputMapping1")
    public void workOrderSubmitService(

        @WebParam(name = "Submitter", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String submitter,
        @WebParam(name = "Assigned_To", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String assignedTo,
        @WebParam(name = "Status", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.StatusType status,
        @WebParam(name = "Short_Description", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String shortDescription,
        @WebParam(name = "Assignee_Groups", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String assigneeGroups,
        @WebParam(name = "InstanceId", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String instanceId,
        @WebParam(name = "Vendor_Assignee_Groups", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String vendorAssigneeGroups,
        @WebParam(name = "z1G_Global_AST_ProductionDataSetID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1GGlobalASTProductionDataSetID,
        @WebParam(name = "Department", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String department,
        @WebParam(name = "Site_Group", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String siteGroup,
        @WebParam(name = "Region", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String region,
        @WebParam(name = "CI_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String ciName,
        @WebParam(name = "Schema_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String schemaName,
        @WebParam(name = "LookupKeyword", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String lookupKeyword,
        @WebParam(name = "Site", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String site,
        @WebParam(name = "WO_Type_Field_01", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField01,
        @WebParam(name = "WO_Type_Field_02", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField02,
        @WebParam(name = "WO_Type_Field_03", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField03,
        @WebParam(name = "WO_Type_Field_04", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField04,
        @WebParam(name = "WO_Type_Field_05", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField05,
        @WebParam(name = "WO_Type_Field_06", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar woTypeField06,
        @WebParam(name = "WO_Type_Field_07", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar woTypeField07,
        @WebParam(name = "WO_Type_Field_08", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer woTypeField08,
        @WebParam(name = "WO_Type_Field_09", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer woTypeField09,
        @WebParam(name = "Template_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String templateName,
        @WebParam(name = "Attachment_attachmentName", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String attachmentAttachmentName,
        @WebParam(name = "Attachment_attachmentData", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        byte[] attachmentAttachmentData,
        @WebParam(name = "Attachment_attachmentOrigSize", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer attachmentAttachmentOrigSize,
        @WebParam(name = "Customer_Middle_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerMiddleName,
        @WebParam(name = "Command", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String command,
        @WebParam(name = "z1D_WorklogDetails", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DWorklogDetails,
        @WebParam(name = "SRInstanceID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String srInstanceID,
        @WebParam(name = "zTmpEventGUID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String zTmpEventGUID,
        @WebParam(name = "CustomerFullName", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerFullName,
        @WebParam(name = "z1D_Summary", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DSummary,
        @WebParam(name = "z1D_Details", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DDetails,
        @WebParam(name = "Secure_Work_Log", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.SecureWorkLogType secureWorkLog,
        @WebParam(name = "z1D_View_Access", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.Z1DViewAccessType z1DViewAccess,
        @WebParam(name = "z2AF_Act_Attachment_1_attachmentName", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z2AFActAttachment1AttachmentName,
        @WebParam(name = "z2AF_Act_Attachment_1_attachmentData", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        byte[] z2AFActAttachment1AttachmentData,
        @WebParam(name = "z2AF_Act_Attachment_1_attachmentOrigSize", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z2AFActAttachment1AttachmentOrigSize,
        @WebParam(name = "z2AF_Act_Attachment_2_attachmentName", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z2AFActAttachment2AttachmentName,
        @WebParam(name = "z2AF_Act_Attachment_2_attachmentData", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        byte[] z2AFActAttachment2AttachmentData,
        @WebParam(name = "z2AF_Act_Attachment_2_attachmentOrigSize", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z2AFActAttachment2AttachmentOrigSize,
        @WebParam(name = "z2AF_Act_Attachment_3_attachmentName", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z2AFActAttachment3AttachmentName,
        @WebParam(name = "z2AF_Act_Attachment_3_attachmentData", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        byte[] z2AFActAttachment3AttachmentData,
        @WebParam(name = "z2AF_Act_Attachment_3_attachmentOrigSize", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z2AFActAttachment3AttachmentOrigSize,
        @WebParam(name = "StatusReasonString", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String statusReasonString,
        @WebParam(name = "Assignment_Accelerator_Assignee", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.AssignmentAcceleratorAssigneeType assignmentAcceleratorAssignee,
        @WebParam(name = "Set_Manager_using", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.SetManagerUsingType setManagerUsing,
        @WebParam(name = "SRMSRegistryInstanceID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String srmsRegistryInstanceID,
        @WebParam(name = "SRMSAOIGuid", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String srmsaoiGuid,
        @WebParam(name = "SRID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String srid,
        @WebParam(name = "Headline", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String headline,
        @WebParam(name = "TemplateID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String templateID,
        @WebParam(name = "RequesterLoginID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String requesterLoginID,
        @WebParam(name = "StatusString", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String statusString,
        @WebParam(name = "z1D_CommunicationSource", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.Z1DCommunicationSourceType z1DCommunicationSource,
        @WebParam(name = "z1D_ActivityDate_tab", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar z1DActivityDateTab,
        @WebParam(name = "Created_From_flag", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.CreatedFromFlagType createdFromFlag,
        @WebParam(name = "z1D_SRMCommand", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DSRMCommand,
        @WebParam(name = "Custom_CFG_Form_InstanceId", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customCFGFormInstanceId,
        @WebParam(name = "CustomRecordInstanceId", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customRecordInstanceId,
        @WebParam(name = "ClientLocale", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String clientLocale,
        @WebParam(name = "WO_Type_Field_10", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField10,
        @WebParam(name = "WO_Type_Field_11", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField11,
        @WebParam(name = "WO_Type_Field_12", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField12,
        @WebParam(name = "WO_Type_Field_13", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField13,
        @WebParam(name = "WO_Type_Field_14", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField14,
        @WebParam(name = "WO_Type_Field_15", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField15,
        @WebParam(name = "WO_Type_Field_16", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField16,
        @WebParam(name = "WO_Type_Field_17", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField17,
        @WebParam(name = "WO_Type_Field_18", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField18,
        @WebParam(name = "WO_Type_Field_19", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField19,
        @WebParam(name = "WO_Type_Field_20", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField20,
        @WebParam(name = "WO_Type_Field_21", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField21,
        @WebParam(name = "WO_Type_Field_22", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField22,
        @WebParam(name = "WO_Type_Field_23", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField23,
        @WebParam(name = "WO_Type_Field_24", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer woTypeField24,
        @WebParam(name = "WO_Type_Field_25", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer woTypeField25,
        @WebParam(name = "WO_Type_Field_26", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer woTypeField26,
        @WebParam(name = "WO_Type_Field_27", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer woTypeField27,
        @WebParam(name = "WO_Type_Field_28", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField28,
        @WebParam(name = "WO_Type_Field_29", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField29,
        @WebParam(name = "WO_Type_Field_30", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField30,
        @WebParam(name = "WO_Type_Field_10_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField10Label,
        @WebParam(name = "WO_Type_Field_11_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField11Label,
        @WebParam(name = "WO_Type_Field_12_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField12Label,
        @WebParam(name = "WO_Type_Field_13_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField13Label,
        @WebParam(name = "WO_Type_Field_14_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField14Label,
        @WebParam(name = "WO_Type_Field_15_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField15Label,
        @WebParam(name = "WO_Type_Field_16_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField16Label,
        @WebParam(name = "WO_Type_Field_17_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField17Label,
        @WebParam(name = "WO_Type_Field_18_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField18Label,
        @WebParam(name = "WO_Type_Field_19_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField19Label,
        @WebParam(name = "WO_Type_Field_20_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField20Label,
        @WebParam(name = "WO_Type_Field_21_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField21Label,
        @WebParam(name = "WO_Type_Field_22_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField22Label,
        @WebParam(name = "WO_Type_Field_23_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField23Label,
        @WebParam(name = "WO_Type_Field_24_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField24Label,
        @WebParam(name = "WO_Type_Field_25_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField25Label,
        @WebParam(name = "WO_Type_Field_26_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField26Label,
        @WebParam(name = "WO_Type_Field_27_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField27Label,
        @WebParam(name = "WO_Type_Field_28_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField28Label,
        @WebParam(name = "WO_Type_Field_29_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField29Label,
        @WebParam(name = "WO_Type_Field_30_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField30Label,
        @WebParam(name = "SRWorkInfoType", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.SRWorkInfoTypeType srWorkInfoType,
        @WebParam(name = "z1D_ConfirmGroup", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DConfirmGroup,
        @WebParam(name = "CreatedFromBackEndSynchWI", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.CreatedFromBackEndSynchWIType createdFromBackEndSynchWI,
        @WebParam(name = "WO_Type_Field_48", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar woTypeField48,
        @WebParam(name = "WO_Type_Field_49", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar woTypeField49,
        @WebParam(name = "WO_Type_Field_50", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar woTypeField50,
        @WebParam(name = "WO_Type_Field_51", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.datatype.XMLGregorianCalendar woTypeField51,
        @WebParam(name = "WO_Type_Field_48_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField48Label,
        @WebParam(name = "WO_Type_Field_49_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField49Label,
        @WebParam(name = "WO_Type_Field_50_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField50Label,
        @WebParam(name = "WO_Type_Field_51_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField51Label,
        @WebParam(name = "Work_Order_Template_Instance_ID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String workOrderTemplateInstanceID,
        @WebParam(name = "WO_Type_Field_01_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField01Label,
        @WebParam(name = "WO_Type_Field_02_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField02Label,
        @WebParam(name = "WO_Type_Field_03_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField03Label,
        @WebParam(name = "WO_Type_Field_04_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField04Label,
        @WebParam(name = "WO_Type_Field_05_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField05Label,
        @WebParam(name = "WO_Type_Field_06_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField06Label,
        @WebParam(name = "WO_Type_Field_07_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField07Label,
        @WebParam(name = "WO_Type_Field_08_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField08Label,
        @WebParam(name = "WO_Type_Field_09_Label", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String woTypeField09Label,
        @WebParam(name = "DatasetId", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String datasetId,
        @WebParam(name = "ReconciliationIdentity", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String reconciliationIdentity,
        @WebParam(name = "Summary", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String summary,
        @WebParam(name = "Location_Company", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String locationCompany,
        @WebParam(name = "Organization", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String organization,
        @WebParam(name = "Manager_Support_Organization", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String managerSupportOrganization,
        @WebParam(name = "Manager_Support_Group_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String managerSupportGroupName,
        @WebParam(name = "Last_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String lastName,
        @WebParam(name = "First_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String firstName,
        @WebParam(name = "Middle_Initial", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String middleInitial,
        @WebParam(name = "VIP", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.SecureWorkLogType vip,
        @WebParam(name = "Contact_Sensitivity", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.ContactSensitivityType contactSensitivity,
        @WebParam(name = "Chg_Location_Address", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String chgLocationAddress,
        @WebParam(name = "Internet_E-mail", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String internetEMail,
        @WebParam(name = "Phone_Number", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String phoneNumber,
        @WebParam(name = "z1D_Char01", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DChar01,
        @WebParam(name = "Categorization_Tier_1", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String categorizationTier1,
        @WebParam(name = "Categorization_Tier_2", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String categorizationTier2,
        @WebParam(name = "Categorization_Tier_3", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String categorizationTier3,
        @WebParam(name = "z1D_Action", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DAction,
        @WebParam(name = "z1D_Integer01", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z1DInteger01,
        @WebParam(name = "Person_ID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String personID,
        @WebParam(name = "Company", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String company,
        @WebParam(name = "Add_Request_For_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.AddRequestForType addRequestFor,
        @WebParam(name = "z1D_Integer02", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z1DInteger02,
        @WebParam(name = "z1D_Integer03", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z1DInteger03,
        @WebParam(name = "z1D_Char10", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DChar10,
        @WebParam(name = "Status_Reason", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.StatusReasonType statusReason,
        @WebParam(name = "Detailed_Description", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String detailedDescription,
        @WebParam(name = "Priority", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.PriorityType priority,
        @WebParam(name = "Work_Order_Type", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.WorkOrderTypeType workOrderType,
        @WebParam(mode = WebParam.Mode.INOUT, name = "WorkOrder_ID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        javax.xml.ws.Holder<java.lang.String> workOrderID,
        @WebParam(name = "Request_Manager_Company", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String requestManagerCompany,
        @WebParam(name = "Requester_Support_Organization", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String requesterSupportOrganization,
        @WebParam(name = "Request_Manager", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String requestManager,
        @WebParam(name = "CAB_Manager_Login", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String cabManagerLogin,
        @WebParam(name = "View_Access", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.Z1DViewAccessType viewAccess,
        @WebParam(name = "z1D_Status_Reason", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String z1DStatusReason,
        @WebParam(name = "Requested_By_Person_ID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String requestedByPersonID,
        @WebParam(name = "Product_Cat_Tier_1_2_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String productCatTier12,
        @WebParam(name = "Product_Cat_Tier_2__2_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String productCatTier22,
        @WebParam(name = "Product_Cat_Tier_3__2_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String productCatTier32,
        @WebParam(name = "Secure_Work_Log2", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        woi_workorderinterface_create_ws.SecureWorkLogType secureWorkLog2,
        @WebParam(name = "z1D_Permission_Group_ID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.Integer z1DPermissionGroupID,
        @WebParam(name = "Product_Name__2_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String productName2,
        @WebParam(name = "Product_Model_Version__2_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String productModelVersion2,
        @WebParam(name = "Manufacturer__2_", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String manufacturer2,
        @WebParam(name = "WorkOrder__EntryID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String workOrderEntryID,
        @WebParam(name = "Support_Organization", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String supportOrganization,
        @WebParam(name = "Support_Company", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String supportCompany,
        @WebParam(name = "Support_Group_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String supportGroupName,
        @WebParam(name = "Request_Assignee", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String requestAssignee,
        @WebParam(name = "Customer_Person_ID", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerPersonID,
        @WebParam(name = "Customer_First_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerFirstName,
        @WebParam(name = "Customer_Last_Name", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerLastName,
        @WebParam(name = "Customer_Company", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerCompany,
        @WebParam(name = "Customer_Organization", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerOrganization,
        @WebParam(name = "Customer_Department", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerDepartment,
        @WebParam(name = "Customer_Internet_E-mail", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerInternetEMail,
        @WebParam(name = "Customer_Phone_Number", targetNamespace = "urn:WOI_WorkOrderInterface_Create_WS")
        java.lang.String customerPhoneNumber

    );
}
