package mx.com.gentera.helpdesk.wo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for InputMapping1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputMapping1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Submitter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Assigned_To" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn:WOI_WorkOrderInterface_Create_WS}StatusType"/>
 *         &lt;element name="Short_Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Assignee_Groups" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vendor_Assignee_Groups" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1G_Global_AST_ProductionDataSetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Site_Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CI_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Schema_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LookupKeyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Site" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_06" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_07" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_08" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_09" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Template_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Attachment_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Customer_Middle_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Command" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_WorklogDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRInstanceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zTmpEventGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_Summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Secure_Work_Log" type="{urn:WOI_WorkOrderInterface_Create_WS}Secure_Work_LogType" minOccurs="0"/>
 *         &lt;element name="z1D_View_Access" type="{urn:WOI_WorkOrderInterface_Create_WS}z1D_View_AccessType" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_1_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_1_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_1_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_2_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_2_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_2_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_3_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_3_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="z2AF_Act_Attachment_3_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StatusReasonString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assignment_Accelerator_Assignee" type="{urn:WOI_WorkOrderInterface_Create_WS}Assignment_Accelerator_AssigneeType" minOccurs="0"/>
 *         &lt;element name="Set_Manager_using" type="{urn:WOI_WorkOrderInterface_Create_WS}Set_Manager_usingType" minOccurs="0"/>
 *         &lt;element name="SRMSRegistryInstanceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRMSAOIGuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Headline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TemplateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RequesterLoginID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_CommunicationSource" type="{urn:WOI_WorkOrderInterface_Create_WS}z1D_CommunicationSourceType" minOccurs="0"/>
 *         &lt;element name="z1D_ActivityDate_tab" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Created_From_flag" type="{urn:WOI_WorkOrderInterface_Create_WS}Created_From_flagType" minOccurs="0"/>
 *         &lt;element name="z1D_SRMCommand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Custom_CFG_Form_InstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomRecordInstanceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientLocale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_14" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_15" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_16" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_17" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_18" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_19" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_21" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_23" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_24" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_25" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_26" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_27" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_28" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_29" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_30" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_10_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_11_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_12_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_13_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_14_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_15_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_16_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_17_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_18_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_19_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_20_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_21_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_22_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_23_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_24_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_25_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_26_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_27_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_28_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_29_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_30_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SRWorkInfoType" type="{urn:WOI_WorkOrderInterface_Create_WS}SRWorkInfoTypeType" minOccurs="0"/>
 *         &lt;element name="z1D_ConfirmGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatedFromBackEndSynchWI" type="{urn:WOI_WorkOrderInterface_Create_WS}CreatedFromBackEndSynchWIType" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_48" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_49" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_50" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_51" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_48_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_49_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_50_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_51_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Work_Order_Template_Instance_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_01_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_02_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_03_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_04_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_05_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_06_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_07_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_08_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WO_Type_Field_09_Label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatasetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReconciliationIdentity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location_Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Manager_Support_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Manager_Support_Group_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Middle_Initial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VIP" type="{urn:WOI_WorkOrderInterface_Create_WS}Secure_Work_LogType" minOccurs="0"/>
 *         &lt;element name="Contact_Sensitivity" type="{urn:WOI_WorkOrderInterface_Create_WS}Contact_SensitivityType" minOccurs="0"/>
 *         &lt;element name="Chg_Location_Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Internet_E-mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_Char01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Categorization_Tier_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Categorization_Tier_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Categorization_Tier_3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_Action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="z1D_Integer01" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Person_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Add_Request_For_" type="{urn:WOI_WorkOrderInterface_Create_WS}Add_Request_For_Type" minOccurs="0"/>
 *         &lt;element name="z1D_Integer02" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="z1D_Integer03" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="z1D_Char10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status_Reason" type="{urn:WOI_WorkOrderInterface_Create_WS}Status_ReasonType" minOccurs="0"/>
 *         &lt;element name="Detailed_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{urn:WOI_WorkOrderInterface_Create_WS}PriorityType" minOccurs="0"/>
 *         &lt;element name="Work_Order_Type" type="{urn:WOI_WorkOrderInterface_Create_WS}Work_Order_TypeType" minOccurs="0"/>
 *         &lt;element name="WorkOrder_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Manager_Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requester_Support_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Manager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAB_Manager_Login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="View_Access" type="{urn:WOI_WorkOrderInterface_Create_WS}z1D_View_AccessType" minOccurs="0"/>
 *         &lt;element name="z1D_Status_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Requested_By_Person_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_Cat_Tier_1_2_" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_Cat_Tier_2__2_" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_Cat_Tier_3__2_" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Secure_Work_Log2" type="{urn:WOI_WorkOrderInterface_Create_WS}Secure_Work_LogType" minOccurs="0"/>
 *         &lt;element name="z1D_Permission_Group_ID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Product_Name__2_" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product_Model_Version__2_" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Manufacturer__2_" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkOrder__EntryID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Support_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Support_Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Support_Group_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Request_Assignee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Person_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_First_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Last_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Internet_E-mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer_Phone_Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputMapping1", propOrder = {
    "submitter",
    "assignedTo",
    "status",
    "shortDescription",
    "assigneeGroups",
    "instanceId",
    "vendorAssigneeGroups",
    "z1GGlobalASTProductionDataSetID",
    "department",
    "siteGroup",
    "region",
    "ciName",
    "schemaName",
    "lookupKeyword",
    "site",
    "woTypeField01",
    "woTypeField02",
    "woTypeField03",
    "woTypeField04",
    "woTypeField05",
    "woTypeField06",
    "woTypeField07",
    "woTypeField08",
    "woTypeField09",
    "templateName",
    "attachmentAttachmentName",
    "attachmentAttachmentData",
    "attachmentAttachmentOrigSize",
    "customerMiddleName",
    "command",
    "z1DWorklogDetails",
    "srInstanceID",
    "zTmpEventGUID",
    "customerFullName",
    "z1DSummary",
    "z1DDetails",
    "secureWorkLog",
    "z1DViewAccess",
    "z2AFActAttachment1AttachmentName",
    "z2AFActAttachment1AttachmentData",
    "z2AFActAttachment1AttachmentOrigSize",
    "z2AFActAttachment2AttachmentName",
    "z2AFActAttachment2AttachmentData",
    "z2AFActAttachment2AttachmentOrigSize",
    "z2AFActAttachment3AttachmentName",
    "z2AFActAttachment3AttachmentData",
    "z2AFActAttachment3AttachmentOrigSize",
    "statusReasonString",
    "assignmentAcceleratorAssignee",
    "setManagerUsing",
    "srmsRegistryInstanceID",
    "srmsaoiGuid",
    "srid",
    "headline",
    "templateID",
    "requesterLoginID",
    "statusString",
    "z1DCommunicationSource",
    "z1DActivityDateTab",
    "createdFromFlag",
    "z1DSRMCommand",
    "customCFGFormInstanceId",
    "customRecordInstanceId",
    "clientLocale",
    "woTypeField10",
    "woTypeField11",
    "woTypeField12",
    "woTypeField13",
    "woTypeField14",
    "woTypeField15",
    "woTypeField16",
    "woTypeField17",
    "woTypeField18",
    "woTypeField19",
    "woTypeField20",
    "woTypeField21",
    "woTypeField22",
    "woTypeField23",
    "woTypeField24",
    "woTypeField25",
    "woTypeField26",
    "woTypeField27",
    "woTypeField28",
    "woTypeField29",
    "woTypeField30",
    "woTypeField10Label",
    "woTypeField11Label",
    "woTypeField12Label",
    "woTypeField13Label",
    "woTypeField14Label",
    "woTypeField15Label",
    "woTypeField16Label",
    "woTypeField17Label",
    "woTypeField18Label",
    "woTypeField19Label",
    "woTypeField20Label",
    "woTypeField21Label",
    "woTypeField22Label",
    "woTypeField23Label",
    "woTypeField24Label",
    "woTypeField25Label",
    "woTypeField26Label",
    "woTypeField27Label",
    "woTypeField28Label",
    "woTypeField29Label",
    "woTypeField30Label",
    "srWorkInfoType",
    "z1DConfirmGroup",
    "createdFromBackEndSynchWI",
    "woTypeField48",
    "woTypeField49",
    "woTypeField50",
    "woTypeField51",
    "woTypeField48Label",
    "woTypeField49Label",
    "woTypeField50Label",
    "woTypeField51Label",
    "workOrderTemplateInstanceID",
    "woTypeField01Label",
    "woTypeField02Label",
    "woTypeField03Label",
    "woTypeField04Label",
    "woTypeField05Label",
    "woTypeField06Label",
    "woTypeField07Label",
    "woTypeField08Label",
    "woTypeField09Label",
    "datasetId",
    "reconciliationIdentity",
    "summary",
    "locationCompany",
    "organization",
    "managerSupportOrganization",
    "managerSupportGroupName",
    "lastName",
    "firstName",
    "middleInitial",
    "vip",
    "contactSensitivity",
    "chgLocationAddress",
    "internetEMail",
    "phoneNumber",
    "z1DChar01",
    "categorizationTier1",
    "categorizationTier2",
    "categorizationTier3",
    "z1DAction",
    "z1DInteger01",
    "personID",
    "company",
    "addRequestFor",
    "z1DInteger02",
    "z1DInteger03",
    "z1DChar10",
    "statusReason",
    "detailedDescription",
    "priority",
    "workOrderType",
    "workOrderID",
    "requestManagerCompany",
    "requesterSupportOrganization",
    "requestManager",
    "cabManagerLogin",
    "viewAccess",
    "z1DStatusReason",
    "requestedByPersonID",
    "productCatTier12",
    "productCatTier22",
    "productCatTier32",
    "secureWorkLog2",
    "z1DPermissionGroupID",
    "productName2",
    "productModelVersion2",
    "manufacturer2",
    "workOrderEntryID",
    "supportOrganization",
    "supportCompany",
    "supportGroupName",
    "requestAssignee",
    "customerPersonID",
    "customerFirstName",
    "customerLastName",
    "customerCompany",
    "customerOrganization",
    "customerDepartment",
    "customerInternetEMail",
    "customerPhoneNumber"
})
public class InputMapping1 {

    @XmlElement(name = "Submitter", required = true)
    protected String submitter;
    @XmlElement(name = "Assigned_To")
    protected String assignedTo;
    @XmlElement(name = "Status", required = true)
    protected StatusType status;
    @XmlElement(name = "Short_Description", required = true)
    protected String shortDescription;
    @XmlElement(name = "Assignee_Groups")
    protected String assigneeGroups;
    @XmlElement(name = "InstanceId")
    protected String instanceId;
    @XmlElement(name = "Vendor_Assignee_Groups")
    protected String vendorAssigneeGroups;
    @XmlElement(name = "z1G_Global_AST_ProductionDataSetID")
    protected String z1GGlobalASTProductionDataSetID;
    @XmlElement(name = "Department")
    protected String department;
    @XmlElement(name = "Site_Group")
    protected String siteGroup;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "CI_Name")
    protected String ciName;
    @XmlElement(name = "Schema_Name")
    protected String schemaName;
    @XmlElement(name = "LookupKeyword")
    protected String lookupKeyword;
    @XmlElement(name = "Site")
    protected String site;
    @XmlElement(name = "WO_Type_Field_01")
    protected String woTypeField01;
    @XmlElement(name = "WO_Type_Field_02")
    protected String woTypeField02;
    @XmlElement(name = "WO_Type_Field_03")
    protected String woTypeField03;
    @XmlElement(name = "WO_Type_Field_04")
    protected String woTypeField04;
    @XmlElement(name = "WO_Type_Field_05")
    protected String woTypeField05;
    @XmlElement(name = "WO_Type_Field_06")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar woTypeField06;
    @XmlElement(name = "WO_Type_Field_07")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar woTypeField07;
    @XmlElement(name = "WO_Type_Field_08")
    protected Integer woTypeField08;
    @XmlElement(name = "WO_Type_Field_09")
    protected Integer woTypeField09;
    @XmlElement(name = "Template_Name")
    protected String templateName;
    @XmlElement(name = "Attachment_attachmentName")
    protected String attachmentAttachmentName;
    @XmlElement(name = "Attachment_attachmentData")
    protected byte[] attachmentAttachmentData;
    @XmlElement(name = "Attachment_attachmentOrigSize")
    protected Integer attachmentAttachmentOrigSize;
    @XmlElement(name = "Customer_Middle_Name")
    protected String customerMiddleName;
    @XmlElement(name = "Command")
    protected String command;
    @XmlElement(name = "z1D_WorklogDetails")
    protected String z1DWorklogDetails;
    @XmlElement(name = "SRInstanceID")
    protected String srInstanceID;
    protected String zTmpEventGUID;
    @XmlElement(name = "CustomerFullName")
    protected String customerFullName;
    @XmlElement(name = "z1D_Summary")
    protected String z1DSummary;
    @XmlElement(name = "z1D_Details")
    protected String z1DDetails;
    @XmlElementRef(name = "Secure_Work_Log", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<SecureWorkLogType> secureWorkLog;
    @XmlElementRef(name = "z1D_View_Access", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<Z1DViewAccessType> z1DViewAccess;
    @XmlElement(name = "z2AF_Act_Attachment_1_attachmentName")
    protected String z2AFActAttachment1AttachmentName;
    @XmlElement(name = "z2AF_Act_Attachment_1_attachmentData")
    protected byte[] z2AFActAttachment1AttachmentData;
    @XmlElement(name = "z2AF_Act_Attachment_1_attachmentOrigSize")
    protected Integer z2AFActAttachment1AttachmentOrigSize;
    @XmlElement(name = "z2AF_Act_Attachment_2_attachmentName")
    protected String z2AFActAttachment2AttachmentName;
    @XmlElement(name = "z2AF_Act_Attachment_2_attachmentData")
    protected byte[] z2AFActAttachment2AttachmentData;
    @XmlElement(name = "z2AF_Act_Attachment_2_attachmentOrigSize")
    protected Integer z2AFActAttachment2AttachmentOrigSize;
    @XmlElement(name = "z2AF_Act_Attachment_3_attachmentName")
    protected String z2AFActAttachment3AttachmentName;
    @XmlElement(name = "z2AF_Act_Attachment_3_attachmentData")
    protected byte[] z2AFActAttachment3AttachmentData;
    @XmlElement(name = "z2AF_Act_Attachment_3_attachmentOrigSize")
    protected Integer z2AFActAttachment3AttachmentOrigSize;
    @XmlElement(name = "StatusReasonString")
    protected String statusReasonString;
    @XmlElementRef(name = "Assignment_Accelerator_Assignee", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<AssignmentAcceleratorAssigneeType> assignmentAcceleratorAssignee;
    @XmlElementRef(name = "Set_Manager_using", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<SetManagerUsingType> setManagerUsing;
    @XmlElement(name = "SRMSRegistryInstanceID")
    protected String srmsRegistryInstanceID;
    @XmlElement(name = "SRMSAOIGuid")
    protected String srmsaoiGuid;
    @XmlElement(name = "SRID")
    protected String srid;
    @XmlElement(name = "Headline", defaultValue = "Headline field")
    protected String headline;
    @XmlElement(name = "TemplateID")
    protected String templateID;
    @XmlElement(name = "RequesterLoginID", defaultValue = "$USER$")
    protected String requesterLoginID;
    @XmlElement(name = "StatusString")
    protected String statusString;
    @XmlElementRef(name = "z1D_CommunicationSource", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<Z1DCommunicationSourceType> z1DCommunicationSource;
    @XmlElement(name = "z1D_ActivityDate_tab")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar z1DActivityDateTab;
    @XmlElementRef(name = "Created_From_flag", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<CreatedFromFlagType> createdFromFlag;
    @XmlElement(name = "z1D_SRMCommand")
    protected String z1DSRMCommand;
    @XmlElement(name = "Custom_CFG_Form_InstanceId")
    protected String customCFGFormInstanceId;
    @XmlElement(name = "CustomRecordInstanceId")
    protected String customRecordInstanceId;
    @XmlElement(name = "ClientLocale")
    protected String clientLocale;
    @XmlElement(name = "WO_Type_Field_10")
    protected String woTypeField10;
    @XmlElement(name = "WO_Type_Field_11")
    protected String woTypeField11;
    @XmlElement(name = "WO_Type_Field_12")
    protected String woTypeField12;
    @XmlElement(name = "WO_Type_Field_13")
    protected String woTypeField13;
    @XmlElement(name = "WO_Type_Field_14")
    protected String woTypeField14;
    @XmlElement(name = "WO_Type_Field_15")
    protected String woTypeField15;
    @XmlElement(name = "WO_Type_Field_16")
    protected String woTypeField16;
    @XmlElement(name = "WO_Type_Field_17")
    protected String woTypeField17;
    @XmlElement(name = "WO_Type_Field_18")
    protected String woTypeField18;
    @XmlElement(name = "WO_Type_Field_19")
    protected String woTypeField19;
    @XmlElement(name = "WO_Type_Field_20")
    protected String woTypeField20;
    @XmlElement(name = "WO_Type_Field_21")
    protected String woTypeField21;
    @XmlElement(name = "WO_Type_Field_22")
    protected String woTypeField22;
    @XmlElement(name = "WO_Type_Field_23")
    protected String woTypeField23;
    @XmlElement(name = "WO_Type_Field_24")
    protected Integer woTypeField24;
    @XmlElement(name = "WO_Type_Field_25")
    protected Integer woTypeField25;
    @XmlElement(name = "WO_Type_Field_26")
    protected Integer woTypeField26;
    @XmlElement(name = "WO_Type_Field_27")
    protected Integer woTypeField27;
    @XmlElement(name = "WO_Type_Field_28")
    protected String woTypeField28;
    @XmlElement(name = "WO_Type_Field_29")
    protected String woTypeField29;
    @XmlElement(name = "WO_Type_Field_30")
    protected String woTypeField30;
    @XmlElement(name = "WO_Type_Field_10_Label")
    protected String woTypeField10Label;
    @XmlElement(name = "WO_Type_Field_11_Label")
    protected String woTypeField11Label;
    @XmlElement(name = "WO_Type_Field_12_Label")
    protected String woTypeField12Label;
    @XmlElement(name = "WO_Type_Field_13_Label")
    protected String woTypeField13Label;
    @XmlElement(name = "WO_Type_Field_14_Label")
    protected String woTypeField14Label;
    @XmlElement(name = "WO_Type_Field_15_Label")
    protected String woTypeField15Label;
    @XmlElement(name = "WO_Type_Field_16_Label")
    protected String woTypeField16Label;
    @XmlElement(name = "WO_Type_Field_17_Label")
    protected String woTypeField17Label;
    @XmlElement(name = "WO_Type_Field_18_Label")
    protected String woTypeField18Label;
    @XmlElement(name = "WO_Type_Field_19_Label")
    protected String woTypeField19Label;
    @XmlElement(name = "WO_Type_Field_20_Label")
    protected String woTypeField20Label;
    @XmlElement(name = "WO_Type_Field_21_Label")
    protected String woTypeField21Label;
    @XmlElement(name = "WO_Type_Field_22_Label")
    protected String woTypeField22Label;
    @XmlElement(name = "WO_Type_Field_23_Label")
    protected String woTypeField23Label;
    @XmlElement(name = "WO_Type_Field_24_Label")
    protected String woTypeField24Label;
    @XmlElement(name = "WO_Type_Field_25_Label")
    protected String woTypeField25Label;
    @XmlElement(name = "WO_Type_Field_26_Label")
    protected String woTypeField26Label;
    @XmlElement(name = "WO_Type_Field_27_Label")
    protected String woTypeField27Label;
    @XmlElement(name = "WO_Type_Field_28_Label")
    protected String woTypeField28Label;
    @XmlElement(name = "WO_Type_Field_29_Label")
    protected String woTypeField29Label;
    @XmlElement(name = "WO_Type_Field_30_Label")
    protected String woTypeField30Label;
    @XmlElementRef(name = "SRWorkInfoType", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<SRWorkInfoTypeType> srWorkInfoType;
    @XmlElement(name = "z1D_ConfirmGroup")
    protected String z1DConfirmGroup;
    @XmlElementRef(name = "CreatedFromBackEndSynchWI", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<CreatedFromBackEndSynchWIType> createdFromBackEndSynchWI;
    @XmlElement(name = "WO_Type_Field_48")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar woTypeField48;
    @XmlElement(name = "WO_Type_Field_49")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar woTypeField49;
    @XmlElement(name = "WO_Type_Field_50")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar woTypeField50;
    @XmlElement(name = "WO_Type_Field_51")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar woTypeField51;
    @XmlElement(name = "WO_Type_Field_48_Label")
    protected String woTypeField48Label;
    @XmlElement(name = "WO_Type_Field_49_Label")
    protected String woTypeField49Label;
    @XmlElement(name = "WO_Type_Field_50_Label")
    protected String woTypeField50Label;
    @XmlElement(name = "WO_Type_Field_51_Label")
    protected String woTypeField51Label;
    @XmlElement(name = "Work_Order_Template_Instance_ID")
    protected String workOrderTemplateInstanceID;
    @XmlElement(name = "WO_Type_Field_01_Label")
    protected String woTypeField01Label;
    @XmlElement(name = "WO_Type_Field_02_Label")
    protected String woTypeField02Label;
    @XmlElement(name = "WO_Type_Field_03_Label")
    protected String woTypeField03Label;
    @XmlElement(name = "WO_Type_Field_04_Label")
    protected String woTypeField04Label;
    @XmlElement(name = "WO_Type_Field_05_Label")
    protected String woTypeField05Label;
    @XmlElement(name = "WO_Type_Field_06_Label")
    protected String woTypeField06Label;
    @XmlElement(name = "WO_Type_Field_07_Label")
    protected String woTypeField07Label;
    @XmlElement(name = "WO_Type_Field_08_Label")
    protected String woTypeField08Label;
    @XmlElement(name = "WO_Type_Field_09_Label")
    protected String woTypeField09Label;
    @XmlElement(name = "DatasetId", defaultValue = "0")
    protected String datasetId;
    @XmlElement(name = "ReconciliationIdentity", defaultValue = "0")
    protected String reconciliationIdentity;
    @XmlElement(name = "Summary")
    protected String summary;
    @XmlElement(name = "Location_Company")
    protected String locationCompany;
    @XmlElement(name = "Organization")
    protected String organization;
    @XmlElement(name = "Manager_Support_Organization")
    protected String managerSupportOrganization;
    @XmlElement(name = "Manager_Support_Group_Name")
    protected String managerSupportGroupName;
    @XmlElement(name = "Last_Name")
    protected String lastName;
    @XmlElement(name = "First_Name")
    protected String firstName;
    @XmlElement(name = "Middle_Initial")
    protected String middleInitial;
    @XmlElementRef(name = "VIP", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<SecureWorkLogType> vip;
    @XmlElementRef(name = "Contact_Sensitivity", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<ContactSensitivityType> contactSensitivity;
    @XmlElement(name = "Chg_Location_Address")
    protected String chgLocationAddress;
    @XmlElement(name = "Internet_E-mail")
    protected String internetEMail;
    @XmlElement(name = "Phone_Number")
    protected String phoneNumber;
    @XmlElement(name = "z1D_Char01")
    protected String z1DChar01;
    @XmlElement(name = "Categorization_Tier_1")
    protected String categorizationTier1;
    @XmlElement(name = "Categorization_Tier_2")
    protected String categorizationTier2;
    @XmlElement(name = "Categorization_Tier_3")
    protected String categorizationTier3;
    @XmlElement(name = "z1D_Action", defaultValue = "CREATE")
    protected String z1DAction;
    @XmlElement(name = "z1D_Integer01")
    protected Integer z1DInteger01;
    @XmlElement(name = "Person_ID")
    protected String personID;
    @XmlElement(name = "Company")
    protected String company;
    @XmlElementRef(name = "Add_Request_For_", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<AddRequestForType> addRequestFor;
    @XmlElement(name = "z1D_Integer02")
    protected Integer z1DInteger02;
    @XmlElement(name = "z1D_Integer03")
    protected Integer z1DInteger03;
    @XmlElement(name = "z1D_Char10")
    protected String z1DChar10;
    @XmlElementRef(name = "Status_Reason", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<StatusReasonType> statusReason;
    @XmlElement(name = "Detailed_Description")
    protected String detailedDescription;
    @XmlElementRef(name = "Priority", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<PriorityType> priority;
    @XmlElementRef(name = "Work_Order_Type", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<WorkOrderTypeType> workOrderType;
    @XmlElement(name = "WorkOrder_ID")
    protected String workOrderID;
    @XmlElement(name = "Request_Manager_Company")
    protected String requestManagerCompany;
    @XmlElement(name = "Requester_Support_Organization")
    protected String requesterSupportOrganization;
    @XmlElement(name = "Request_Manager")
    protected String requestManager;
    @XmlElement(name = "CAB_Manager_Login")
    protected String cabManagerLogin;
    @XmlElementRef(name = "View_Access", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<Z1DViewAccessType> viewAccess;
    @XmlElement(name = "z1D_Status_Reason")
    protected String z1DStatusReason;
    @XmlElement(name = "Requested_By_Person_ID")
    protected String requestedByPersonID;
    @XmlElement(name = "Product_Cat_Tier_1_2_")
    protected String productCatTier12;
    @XmlElement(name = "Product_Cat_Tier_2__2_")
    protected String productCatTier22;
    @XmlElement(name = "Product_Cat_Tier_3__2_")
    protected String productCatTier32;
    @XmlElementRef(name = "Secure_Work_Log2", namespace = "urn:WOI_WorkOrderInterface_Create_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<SecureWorkLogType> secureWorkLog2;
    @XmlElement(name = "z1D_Permission_Group_ID")
    protected Integer z1DPermissionGroupID;
    @XmlElement(name = "Product_Name__2_")
    protected String productName2;
    @XmlElement(name = "Product_Model_Version__2_")
    protected String productModelVersion2;
    @XmlElement(name = "Manufacturer__2_")
    protected String manufacturer2;
    @XmlElement(name = "WorkOrder__EntryID")
    protected String workOrderEntryID;
    @XmlElement(name = "Support_Organization")
    protected String supportOrganization;
    @XmlElement(name = "Support_Company")
    protected String supportCompany;
    @XmlElement(name = "Support_Group_Name")
    protected String supportGroupName;
    @XmlElement(name = "Request_Assignee")
    protected String requestAssignee;
    @XmlElement(name = "Customer_Person_ID")
    protected String customerPersonID;
    @XmlElement(name = "Customer_First_Name")
    protected String customerFirstName;
    @XmlElement(name = "Customer_Last_Name")
    protected String customerLastName;
    @XmlElement(name = "Customer_Company")
    protected String customerCompany;
    @XmlElement(name = "Customer_Organization")
    protected String customerOrganization;
    @XmlElement(name = "Customer_Department")
    protected String customerDepartment;
    @XmlElement(name = "Customer_Internet_E-mail")
    protected String customerInternetEMail;
    @XmlElement(name = "Customer_Phone_Number")
    protected String customerPhoneNumber;

    /**
     * Gets the value of the submitter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitter() {
        return submitter;
    }

    /**
     * Sets the value of the submitter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitter(String value) {
        this.submitter = value;
    }

    /**
     * Gets the value of the assignedTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the value of the assignedTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignedTo(String value) {
        this.assignedTo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the shortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the value of the shortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    /**
     * Gets the value of the assigneeGroups property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssigneeGroups() {
        return assigneeGroups;
    }

    /**
     * Sets the value of the assigneeGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssigneeGroups(String value) {
        this.assigneeGroups = value;
    }

    /**
     * Gets the value of the instanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceId(String value) {
        this.instanceId = value;
    }

    /**
     * Gets the value of the vendorAssigneeGroups property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorAssigneeGroups() {
        return vendorAssigneeGroups;
    }

    /**
     * Sets the value of the vendorAssigneeGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorAssigneeGroups(String value) {
        this.vendorAssigneeGroups = value;
    }

    /**
     * Gets the value of the z1GGlobalASTProductionDataSetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1GGlobalASTProductionDataSetID() {
        return z1GGlobalASTProductionDataSetID;
    }

    /**
     * Sets the value of the z1GGlobalASTProductionDataSetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1GGlobalASTProductionDataSetID(String value) {
        this.z1GGlobalASTProductionDataSetID = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Gets the value of the siteGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteGroup() {
        return siteGroup;
    }

    /**
     * Sets the value of the siteGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteGroup(String value) {
        this.siteGroup = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the ciName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIName() {
        return ciName;
    }

    /**
     * Sets the value of the ciName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIName(String value) {
        this.ciName = value;
    }

    /**
     * Gets the value of the schemaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * Sets the value of the schemaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaName(String value) {
        this.schemaName = value;
    }

    /**
     * Gets the value of the lookupKeyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookupKeyword() {
        return lookupKeyword;
    }

    /**
     * Sets the value of the lookupKeyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookupKeyword(String value) {
        this.lookupKeyword = value;
    }

    /**
     * Gets the value of the site property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSite(String value) {
        this.site = value;
    }

    /**
     * Gets the value of the woTypeField01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField01() {
        return woTypeField01;
    }

    /**
     * Sets the value of the woTypeField01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField01(String value) {
        this.woTypeField01 = value;
    }

    /**
     * Gets the value of the woTypeField02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField02() {
        return woTypeField02;
    }

    /**
     * Sets the value of the woTypeField02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField02(String value) {
        this.woTypeField02 = value;
    }

    /**
     * Gets the value of the woTypeField03 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField03() {
        return woTypeField03;
    }

    /**
     * Sets the value of the woTypeField03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField03(String value) {
        this.woTypeField03 = value;
    }

    /**
     * Gets the value of the woTypeField04 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField04() {
        return woTypeField04;
    }

    /**
     * Sets the value of the woTypeField04 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField04(String value) {
        this.woTypeField04 = value;
    }

    /**
     * Gets the value of the woTypeField05 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField05() {
        return woTypeField05;
    }

    /**
     * Sets the value of the woTypeField05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField05(String value) {
        this.woTypeField05 = value;
    }

    /**
     * Gets the value of the woTypeField06 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWOTypeField06() {
        return woTypeField06;
    }

    /**
     * Sets the value of the woTypeField06 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWOTypeField06(XMLGregorianCalendar value) {
        this.woTypeField06 = value;
    }

    /**
     * Gets the value of the woTypeField07 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWOTypeField07() {
        return woTypeField07;
    }

    /**
     * Sets the value of the woTypeField07 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWOTypeField07(XMLGregorianCalendar value) {
        this.woTypeField07 = value;
    }

    /**
     * Gets the value of the woTypeField08 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWOTypeField08() {
        return woTypeField08;
    }

    /**
     * Sets the value of the woTypeField08 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWOTypeField08(Integer value) {
        this.woTypeField08 = value;
    }

    /**
     * Gets the value of the woTypeField09 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWOTypeField09() {
        return woTypeField09;
    }

    /**
     * Sets the value of the woTypeField09 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWOTypeField09(Integer value) {
        this.woTypeField09 = value;
    }

    /**
     * Gets the value of the templateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

    /**
     * Gets the value of the attachmentAttachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentAttachmentName() {
        return attachmentAttachmentName;
    }

    /**
     * Sets the value of the attachmentAttachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentAttachmentName(String value) {
        this.attachmentAttachmentName = value;
    }

    /**
     * Gets the value of the attachmentAttachmentData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachmentAttachmentData() {
        return attachmentAttachmentData;
    }

    /**
     * Sets the value of the attachmentAttachmentData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachmentAttachmentData(byte[] value) {
        this.attachmentAttachmentData = value;
    }

    /**
     * Gets the value of the attachmentAttachmentOrigSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAttachmentAttachmentOrigSize() {
        return attachmentAttachmentOrigSize;
    }

    /**
     * Sets the value of the attachmentAttachmentOrigSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAttachmentAttachmentOrigSize(Integer value) {
        this.attachmentAttachmentOrigSize = value;
    }

    /**
     * Gets the value of the customerMiddleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerMiddleName() {
        return customerMiddleName;
    }

    /**
     * Sets the value of the customerMiddleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerMiddleName(String value) {
        this.customerMiddleName = value;
    }

    /**
     * Gets the value of the command property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the value of the command property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommand(String value) {
        this.command = value;
    }

    /**
     * Gets the value of the z1DWorklogDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DWorklogDetails() {
        return z1DWorklogDetails;
    }

    /**
     * Sets the value of the z1DWorklogDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DWorklogDetails(String value) {
        this.z1DWorklogDetails = value;
    }

    /**
     * Gets the value of the srInstanceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRInstanceID() {
        return srInstanceID;
    }

    /**
     * Sets the value of the srInstanceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRInstanceID(String value) {
        this.srInstanceID = value;
    }

    /**
     * Gets the value of the zTmpEventGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZTmpEventGUID() {
        return zTmpEventGUID;
    }

    /**
     * Sets the value of the zTmpEventGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZTmpEventGUID(String value) {
        this.zTmpEventGUID = value;
    }

    /**
     * Gets the value of the customerFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerFullName() {
        return customerFullName;
    }

    /**
     * Sets the value of the customerFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerFullName(String value) {
        this.customerFullName = value;
    }

    /**
     * Gets the value of the z1DSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DSummary() {
        return z1DSummary;
    }

    /**
     * Sets the value of the z1DSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DSummary(String value) {
        this.z1DSummary = value;
    }

    /**
     * Gets the value of the z1DDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DDetails() {
        return z1DDetails;
    }

    /**
     * Sets the value of the z1DDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DDetails(String value) {
        this.z1DDetails = value;
    }

    /**
     * Gets the value of the secureWorkLog property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}
     *     
     */
    public JAXBElement<SecureWorkLogType> getSecureWorkLog() {
        return secureWorkLog;
    }

    /**
     * Sets the value of the secureWorkLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}
     *     
     */
    public void setSecureWorkLog(JAXBElement<SecureWorkLogType> value) {
        this.secureWorkLog = value;
    }

    /**
     * Gets the value of the z1DViewAccess property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Z1DViewAccessType }{@code >}
     *     
     */
    public JAXBElement<Z1DViewAccessType> getZ1DViewAccess() {
        return z1DViewAccess;
    }

    /**
     * Sets the value of the z1DViewAccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Z1DViewAccessType }{@code >}
     *     
     */
    public void setZ1DViewAccess(JAXBElement<Z1DViewAccessType> value) {
        this.z1DViewAccess = value;
    }

    /**
     * Gets the value of the z2AFActAttachment1AttachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ2AFActAttachment1AttachmentName() {
        return z2AFActAttachment1AttachmentName;
    }

    /**
     * Sets the value of the z2AFActAttachment1AttachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ2AFActAttachment1AttachmentName(String value) {
        this.z2AFActAttachment1AttachmentName = value;
    }

    /**
     * Gets the value of the z2AFActAttachment1AttachmentData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getZ2AFActAttachment1AttachmentData() {
        return z2AFActAttachment1AttachmentData;
    }

    /**
     * Sets the value of the z2AFActAttachment1AttachmentData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setZ2AFActAttachment1AttachmentData(byte[] value) {
        this.z2AFActAttachment1AttachmentData = value;
    }

    /**
     * Gets the value of the z2AFActAttachment1AttachmentOrigSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ2AFActAttachment1AttachmentOrigSize() {
        return z2AFActAttachment1AttachmentOrigSize;
    }

    /**
     * Sets the value of the z2AFActAttachment1AttachmentOrigSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ2AFActAttachment1AttachmentOrigSize(Integer value) {
        this.z2AFActAttachment1AttachmentOrigSize = value;
    }

    /**
     * Gets the value of the z2AFActAttachment2AttachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ2AFActAttachment2AttachmentName() {
        return z2AFActAttachment2AttachmentName;
    }

    /**
     * Sets the value of the z2AFActAttachment2AttachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ2AFActAttachment2AttachmentName(String value) {
        this.z2AFActAttachment2AttachmentName = value;
    }

    /**
     * Gets the value of the z2AFActAttachment2AttachmentData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getZ2AFActAttachment2AttachmentData() {
        return z2AFActAttachment2AttachmentData;
    }

    /**
     * Sets the value of the z2AFActAttachment2AttachmentData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setZ2AFActAttachment2AttachmentData(byte[] value) {
        this.z2AFActAttachment2AttachmentData = value;
    }

    /**
     * Gets the value of the z2AFActAttachment2AttachmentOrigSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ2AFActAttachment2AttachmentOrigSize() {
        return z2AFActAttachment2AttachmentOrigSize;
    }

    /**
     * Sets the value of the z2AFActAttachment2AttachmentOrigSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ2AFActAttachment2AttachmentOrigSize(Integer value) {
        this.z2AFActAttachment2AttachmentOrigSize = value;
    }

    /**
     * Gets the value of the z2AFActAttachment3AttachmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ2AFActAttachment3AttachmentName() {
        return z2AFActAttachment3AttachmentName;
    }

    /**
     * Sets the value of the z2AFActAttachment3AttachmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ2AFActAttachment3AttachmentName(String value) {
        this.z2AFActAttachment3AttachmentName = value;
    }

    /**
     * Gets the value of the z2AFActAttachment3AttachmentData property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getZ2AFActAttachment3AttachmentData() {
        return z2AFActAttachment3AttachmentData;
    }

    /**
     * Sets the value of the z2AFActAttachment3AttachmentData property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setZ2AFActAttachment3AttachmentData(byte[] value) {
        this.z2AFActAttachment3AttachmentData = value;
    }

    /**
     * Gets the value of the z2AFActAttachment3AttachmentOrigSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ2AFActAttachment3AttachmentOrigSize() {
        return z2AFActAttachment3AttachmentOrigSize;
    }

    /**
     * Sets the value of the z2AFActAttachment3AttachmentOrigSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ2AFActAttachment3AttachmentOrigSize(Integer value) {
        this.z2AFActAttachment3AttachmentOrigSize = value;
    }

    /**
     * Gets the value of the statusReasonString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusReasonString() {
        return statusReasonString;
    }

    /**
     * Sets the value of the statusReasonString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusReasonString(String value) {
        this.statusReasonString = value;
    }

    /**
     * Gets the value of the assignmentAcceleratorAssignee property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AssignmentAcceleratorAssigneeType }{@code >}
     *     
     */
    public JAXBElement<AssignmentAcceleratorAssigneeType> getAssignmentAcceleratorAssignee() {
        return assignmentAcceleratorAssignee;
    }

    /**
     * Sets the value of the assignmentAcceleratorAssignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AssignmentAcceleratorAssigneeType }{@code >}
     *     
     */
    public void setAssignmentAcceleratorAssignee(JAXBElement<AssignmentAcceleratorAssigneeType> value) {
        this.assignmentAcceleratorAssignee = value;
    }

    /**
     * Gets the value of the setManagerUsing property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SetManagerUsingType }{@code >}
     *     
     */
    public JAXBElement<SetManagerUsingType> getSetManagerUsing() {
        return setManagerUsing;
    }

    /**
     * Sets the value of the setManagerUsing property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SetManagerUsingType }{@code >}
     *     
     */
    public void setSetManagerUsing(JAXBElement<SetManagerUsingType> value) {
        this.setManagerUsing = value;
    }

    /**
     * Gets the value of the srmsRegistryInstanceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRMSRegistryInstanceID() {
        return srmsRegistryInstanceID;
    }

    /**
     * Sets the value of the srmsRegistryInstanceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRMSRegistryInstanceID(String value) {
        this.srmsRegistryInstanceID = value;
    }

    /**
     * Gets the value of the srmsaoiGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRMSAOIGuid() {
        return srmsaoiGuid;
    }

    /**
     * Sets the value of the srmsaoiGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRMSAOIGuid(String value) {
        this.srmsaoiGuid = value;
    }

    /**
     * Gets the value of the srid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRID() {
        return srid;
    }

    /**
     * Sets the value of the srid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRID(String value) {
        this.srid = value;
    }

    /**
     * Gets the value of the headline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Sets the value of the headline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadline(String value) {
        this.headline = value;
    }

    /**
     * Gets the value of the templateID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateID() {
        return templateID;
    }

    /**
     * Sets the value of the templateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateID(String value) {
        this.templateID = value;
    }

    /**
     * Gets the value of the requesterLoginID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequesterLoginID() {
        return requesterLoginID;
    }

    /**
     * Sets the value of the requesterLoginID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequesterLoginID(String value) {
        this.requesterLoginID = value;
    }

    /**
     * Gets the value of the statusString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusString() {
        return statusString;
    }

    /**
     * Sets the value of the statusString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusString(String value) {
        this.statusString = value;
    }

    /**
     * Gets the value of the z1DCommunicationSource property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Z1DCommunicationSourceType }{@code >}
     *     
     */
    public JAXBElement<Z1DCommunicationSourceType> getZ1DCommunicationSource() {
        return z1DCommunicationSource;
    }

    /**
     * Sets the value of the z1DCommunicationSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Z1DCommunicationSourceType }{@code >}
     *     
     */
    public void setZ1DCommunicationSource(JAXBElement<Z1DCommunicationSourceType> value) {
        this.z1DCommunicationSource = value;
    }

    /**
     * Gets the value of the z1DActivityDateTab property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZ1DActivityDateTab() {
        return z1DActivityDateTab;
    }

    /**
     * Sets the value of the z1DActivityDateTab property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZ1DActivityDateTab(XMLGregorianCalendar value) {
        this.z1DActivityDateTab = value;
    }

    /**
     * Gets the value of the createdFromFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreatedFromFlagType }{@code >}
     *     
     */
    public JAXBElement<CreatedFromFlagType> getCreatedFromFlag() {
        return createdFromFlag;
    }

    /**
     * Sets the value of the createdFromFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreatedFromFlagType }{@code >}
     *     
     */
    public void setCreatedFromFlag(JAXBElement<CreatedFromFlagType> value) {
        this.createdFromFlag = value;
    }

    /**
     * Gets the value of the z1DSRMCommand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DSRMCommand() {
        return z1DSRMCommand;
    }

    /**
     * Sets the value of the z1DSRMCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DSRMCommand(String value) {
        this.z1DSRMCommand = value;
    }

    /**
     * Gets the value of the customCFGFormInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomCFGFormInstanceId() {
        return customCFGFormInstanceId;
    }

    /**
     * Sets the value of the customCFGFormInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomCFGFormInstanceId(String value) {
        this.customCFGFormInstanceId = value;
    }

    /**
     * Gets the value of the customRecordInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomRecordInstanceId() {
        return customRecordInstanceId;
    }

    /**
     * Sets the value of the customRecordInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomRecordInstanceId(String value) {
        this.customRecordInstanceId = value;
    }

    /**
     * Gets the value of the clientLocale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientLocale() {
        return clientLocale;
    }

    /**
     * Sets the value of the clientLocale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientLocale(String value) {
        this.clientLocale = value;
    }

    /**
     * Gets the value of the woTypeField10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField10() {
        return woTypeField10;
    }

    /**
     * Sets the value of the woTypeField10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField10(String value) {
        this.woTypeField10 = value;
    }

    /**
     * Gets the value of the woTypeField11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField11() {
        return woTypeField11;
    }

    /**
     * Sets the value of the woTypeField11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField11(String value) {
        this.woTypeField11 = value;
    }

    /**
     * Gets the value of the woTypeField12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField12() {
        return woTypeField12;
    }

    /**
     * Sets the value of the woTypeField12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField12(String value) {
        this.woTypeField12 = value;
    }

    /**
     * Gets the value of the woTypeField13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField13() {
        return woTypeField13;
    }

    /**
     * Sets the value of the woTypeField13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField13(String value) {
        this.woTypeField13 = value;
    }

    /**
     * Gets the value of the woTypeField14 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField14() {
        return woTypeField14;
    }

    /**
     * Sets the value of the woTypeField14 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField14(String value) {
        this.woTypeField14 = value;
    }

    /**
     * Gets the value of the woTypeField15 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField15() {
        return woTypeField15;
    }

    /**
     * Sets the value of the woTypeField15 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField15(String value) {
        this.woTypeField15 = value;
    }

    /**
     * Gets the value of the woTypeField16 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField16() {
        return woTypeField16;
    }

    /**
     * Sets the value of the woTypeField16 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField16(String value) {
        this.woTypeField16 = value;
    }

    /**
     * Gets the value of the woTypeField17 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField17() {
        return woTypeField17;
    }

    /**
     * Sets the value of the woTypeField17 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField17(String value) {
        this.woTypeField17 = value;
    }

    /**
     * Gets the value of the woTypeField18 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField18() {
        return woTypeField18;
    }

    /**
     * Sets the value of the woTypeField18 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField18(String value) {
        this.woTypeField18 = value;
    }

    /**
     * Gets the value of the woTypeField19 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField19() {
        return woTypeField19;
    }

    /**
     * Sets the value of the woTypeField19 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField19(String value) {
        this.woTypeField19 = value;
    }

    /**
     * Gets the value of the woTypeField20 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField20() {
        return woTypeField20;
    }

    /**
     * Sets the value of the woTypeField20 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField20(String value) {
        this.woTypeField20 = value;
    }

    /**
     * Gets the value of the woTypeField21 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField21() {
        return woTypeField21;
    }

    /**
     * Sets the value of the woTypeField21 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField21(String value) {
        this.woTypeField21 = value;
    }

    /**
     * Gets the value of the woTypeField22 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField22() {
        return woTypeField22;
    }

    /**
     * Sets the value of the woTypeField22 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField22(String value) {
        this.woTypeField22 = value;
    }

    /**
     * Gets the value of the woTypeField23 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField23() {
        return woTypeField23;
    }

    /**
     * Sets the value of the woTypeField23 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField23(String value) {
        this.woTypeField23 = value;
    }

    /**
     * Gets the value of the woTypeField24 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWOTypeField24() {
        return woTypeField24;
    }

    /**
     * Sets the value of the woTypeField24 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWOTypeField24(Integer value) {
        this.woTypeField24 = value;
    }

    /**
     * Gets the value of the woTypeField25 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWOTypeField25() {
        return woTypeField25;
    }

    /**
     * Sets the value of the woTypeField25 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWOTypeField25(Integer value) {
        this.woTypeField25 = value;
    }

    /**
     * Gets the value of the woTypeField26 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWOTypeField26() {
        return woTypeField26;
    }

    /**
     * Sets the value of the woTypeField26 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWOTypeField26(Integer value) {
        this.woTypeField26 = value;
    }

    /**
     * Gets the value of the woTypeField27 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWOTypeField27() {
        return woTypeField27;
    }

    /**
     * Sets the value of the woTypeField27 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWOTypeField27(Integer value) {
        this.woTypeField27 = value;
    }

    /**
     * Gets the value of the woTypeField28 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField28() {
        return woTypeField28;
    }

    /**
     * Sets the value of the woTypeField28 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField28(String value) {
        this.woTypeField28 = value;
    }

    /**
     * Gets the value of the woTypeField29 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField29() {
        return woTypeField29;
    }

    /**
     * Sets the value of the woTypeField29 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField29(String value) {
        this.woTypeField29 = value;
    }

    /**
     * Gets the value of the woTypeField30 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField30() {
        return woTypeField30;
    }

    /**
     * Sets the value of the woTypeField30 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField30(String value) {
        this.woTypeField30 = value;
    }

    /**
     * Gets the value of the woTypeField10Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField10Label() {
        return woTypeField10Label;
    }

    /**
     * Sets the value of the woTypeField10Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField10Label(String value) {
        this.woTypeField10Label = value;
    }

    /**
     * Gets the value of the woTypeField11Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField11Label() {
        return woTypeField11Label;
    }

    /**
     * Sets the value of the woTypeField11Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField11Label(String value) {
        this.woTypeField11Label = value;
    }

    /**
     * Gets the value of the woTypeField12Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField12Label() {
        return woTypeField12Label;
    }

    /**
     * Sets the value of the woTypeField12Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField12Label(String value) {
        this.woTypeField12Label = value;
    }

    /**
     * Gets the value of the woTypeField13Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField13Label() {
        return woTypeField13Label;
    }

    /**
     * Sets the value of the woTypeField13Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField13Label(String value) {
        this.woTypeField13Label = value;
    }

    /**
     * Gets the value of the woTypeField14Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField14Label() {
        return woTypeField14Label;
    }

    /**
     * Sets the value of the woTypeField14Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField14Label(String value) {
        this.woTypeField14Label = value;
    }

    /**
     * Gets the value of the woTypeField15Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField15Label() {
        return woTypeField15Label;
    }

    /**
     * Sets the value of the woTypeField15Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField15Label(String value) {
        this.woTypeField15Label = value;
    }

    /**
     * Gets the value of the woTypeField16Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField16Label() {
        return woTypeField16Label;
    }

    /**
     * Sets the value of the woTypeField16Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField16Label(String value) {
        this.woTypeField16Label = value;
    }

    /**
     * Gets the value of the woTypeField17Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField17Label() {
        return woTypeField17Label;
    }

    /**
     * Sets the value of the woTypeField17Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField17Label(String value) {
        this.woTypeField17Label = value;
    }

    /**
     * Gets the value of the woTypeField18Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField18Label() {
        return woTypeField18Label;
    }

    /**
     * Sets the value of the woTypeField18Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField18Label(String value) {
        this.woTypeField18Label = value;
    }

    /**
     * Gets the value of the woTypeField19Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField19Label() {
        return woTypeField19Label;
    }

    /**
     * Sets the value of the woTypeField19Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField19Label(String value) {
        this.woTypeField19Label = value;
    }

    /**
     * Gets the value of the woTypeField20Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField20Label() {
        return woTypeField20Label;
    }

    /**
     * Sets the value of the woTypeField20Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField20Label(String value) {
        this.woTypeField20Label = value;
    }

    /**
     * Gets the value of the woTypeField21Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField21Label() {
        return woTypeField21Label;
    }

    /**
     * Sets the value of the woTypeField21Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField21Label(String value) {
        this.woTypeField21Label = value;
    }

    /**
     * Gets the value of the woTypeField22Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField22Label() {
        return woTypeField22Label;
    }

    /**
     * Sets the value of the woTypeField22Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField22Label(String value) {
        this.woTypeField22Label = value;
    }

    /**
     * Gets the value of the woTypeField23Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField23Label() {
        return woTypeField23Label;
    }

    /**
     * Sets the value of the woTypeField23Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField23Label(String value) {
        this.woTypeField23Label = value;
    }

    /**
     * Gets the value of the woTypeField24Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField24Label() {
        return woTypeField24Label;
    }

    /**
     * Sets the value of the woTypeField24Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField24Label(String value) {
        this.woTypeField24Label = value;
    }

    /**
     * Gets the value of the woTypeField25Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField25Label() {
        return woTypeField25Label;
    }

    /**
     * Sets the value of the woTypeField25Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField25Label(String value) {
        this.woTypeField25Label = value;
    }

    /**
     * Gets the value of the woTypeField26Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField26Label() {
        return woTypeField26Label;
    }

    /**
     * Sets the value of the woTypeField26Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField26Label(String value) {
        this.woTypeField26Label = value;
    }

    /**
     * Gets the value of the woTypeField27Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField27Label() {
        return woTypeField27Label;
    }

    /**
     * Sets the value of the woTypeField27Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField27Label(String value) {
        this.woTypeField27Label = value;
    }

    /**
     * Gets the value of the woTypeField28Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField28Label() {
        return woTypeField28Label;
    }

    /**
     * Sets the value of the woTypeField28Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField28Label(String value) {
        this.woTypeField28Label = value;
    }

    /**
     * Gets the value of the woTypeField29Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField29Label() {
        return woTypeField29Label;
    }

    /**
     * Sets the value of the woTypeField29Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField29Label(String value) {
        this.woTypeField29Label = value;
    }

    /**
     * Gets the value of the woTypeField30Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField30Label() {
        return woTypeField30Label;
    }

    /**
     * Sets the value of the woTypeField30Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField30Label(String value) {
        this.woTypeField30Label = value;
    }

    /**
     * Gets the value of the srWorkInfoType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SRWorkInfoTypeType }{@code >}
     *     
     */
    public JAXBElement<SRWorkInfoTypeType> getSRWorkInfoType() {
        return srWorkInfoType;
    }

    /**
     * Sets the value of the srWorkInfoType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SRWorkInfoTypeType }{@code >}
     *     
     */
    public void setSRWorkInfoType(JAXBElement<SRWorkInfoTypeType> value) {
        this.srWorkInfoType = value;
    }

    /**
     * Gets the value of the z1DConfirmGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DConfirmGroup() {
        return z1DConfirmGroup;
    }

    /**
     * Sets the value of the z1DConfirmGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DConfirmGroup(String value) {
        this.z1DConfirmGroup = value;
    }

    /**
     * Gets the value of the createdFromBackEndSynchWI property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreatedFromBackEndSynchWIType }{@code >}
     *     
     */
    public JAXBElement<CreatedFromBackEndSynchWIType> getCreatedFromBackEndSynchWI() {
        return createdFromBackEndSynchWI;
    }

    /**
     * Sets the value of the createdFromBackEndSynchWI property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreatedFromBackEndSynchWIType }{@code >}
     *     
     */
    public void setCreatedFromBackEndSynchWI(JAXBElement<CreatedFromBackEndSynchWIType> value) {
        this.createdFromBackEndSynchWI = value;
    }

    /**
     * Gets the value of the woTypeField48 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWOTypeField48() {
        return woTypeField48;
    }

    /**
     * Sets the value of the woTypeField48 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWOTypeField48(XMLGregorianCalendar value) {
        this.woTypeField48 = value;
    }

    /**
     * Gets the value of the woTypeField49 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWOTypeField49() {
        return woTypeField49;
    }

    /**
     * Sets the value of the woTypeField49 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWOTypeField49(XMLGregorianCalendar value) {
        this.woTypeField49 = value;
    }

    /**
     * Gets the value of the woTypeField50 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWOTypeField50() {
        return woTypeField50;
    }

    /**
     * Sets the value of the woTypeField50 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWOTypeField50(XMLGregorianCalendar value) {
        this.woTypeField50 = value;
    }

    /**
     * Gets the value of the woTypeField51 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWOTypeField51() {
        return woTypeField51;
    }

    /**
     * Sets the value of the woTypeField51 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWOTypeField51(XMLGregorianCalendar value) {
        this.woTypeField51 = value;
    }

    /**
     * Gets the value of the woTypeField48Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField48Label() {
        return woTypeField48Label;
    }

    /**
     * Sets the value of the woTypeField48Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField48Label(String value) {
        this.woTypeField48Label = value;
    }

    /**
     * Gets the value of the woTypeField49Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField49Label() {
        return woTypeField49Label;
    }

    /**
     * Sets the value of the woTypeField49Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField49Label(String value) {
        this.woTypeField49Label = value;
    }

    /**
     * Gets the value of the woTypeField50Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField50Label() {
        return woTypeField50Label;
    }

    /**
     * Sets the value of the woTypeField50Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField50Label(String value) {
        this.woTypeField50Label = value;
    }

    /**
     * Gets the value of the woTypeField51Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField51Label() {
        return woTypeField51Label;
    }

    /**
     * Sets the value of the woTypeField51Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField51Label(String value) {
        this.woTypeField51Label = value;
    }

    /**
     * Gets the value of the workOrderTemplateInstanceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkOrderTemplateInstanceID() {
        return workOrderTemplateInstanceID;
    }

    /**
     * Sets the value of the workOrderTemplateInstanceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkOrderTemplateInstanceID(String value) {
        this.workOrderTemplateInstanceID = value;
    }

    /**
     * Gets the value of the woTypeField01Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField01Label() {
        return woTypeField01Label;
    }

    /**
     * Sets the value of the woTypeField01Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField01Label(String value) {
        this.woTypeField01Label = value;
    }

    /**
     * Gets the value of the woTypeField02Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField02Label() {
        return woTypeField02Label;
    }

    /**
     * Sets the value of the woTypeField02Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField02Label(String value) {
        this.woTypeField02Label = value;
    }

    /**
     * Gets the value of the woTypeField03Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField03Label() {
        return woTypeField03Label;
    }

    /**
     * Sets the value of the woTypeField03Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField03Label(String value) {
        this.woTypeField03Label = value;
    }

    /**
     * Gets the value of the woTypeField04Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField04Label() {
        return woTypeField04Label;
    }

    /**
     * Sets the value of the woTypeField04Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField04Label(String value) {
        this.woTypeField04Label = value;
    }

    /**
     * Gets the value of the woTypeField05Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField05Label() {
        return woTypeField05Label;
    }

    /**
     * Sets the value of the woTypeField05Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField05Label(String value) {
        this.woTypeField05Label = value;
    }

    /**
     * Gets the value of the woTypeField06Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField06Label() {
        return woTypeField06Label;
    }

    /**
     * Sets the value of the woTypeField06Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField06Label(String value) {
        this.woTypeField06Label = value;
    }

    /**
     * Gets the value of the woTypeField07Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField07Label() {
        return woTypeField07Label;
    }

    /**
     * Sets the value of the woTypeField07Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField07Label(String value) {
        this.woTypeField07Label = value;
    }

    /**
     * Gets the value of the woTypeField08Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField08Label() {
        return woTypeField08Label;
    }

    /**
     * Sets the value of the woTypeField08Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField08Label(String value) {
        this.woTypeField08Label = value;
    }

    /**
     * Gets the value of the woTypeField09Label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWOTypeField09Label() {
        return woTypeField09Label;
    }

    /**
     * Sets the value of the woTypeField09Label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWOTypeField09Label(String value) {
        this.woTypeField09Label = value;
    }

    /**
     * Gets the value of the datasetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetId() {
        return datasetId;
    }

    /**
     * Sets the value of the datasetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetId(String value) {
        this.datasetId = value;
    }

    /**
     * Gets the value of the reconciliationIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReconciliationIdentity() {
        return reconciliationIdentity;
    }

    /**
     * Sets the value of the reconciliationIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReconciliationIdentity(String value) {
        this.reconciliationIdentity = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Gets the value of the locationCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationCompany() {
        return locationCompany;
    }

    /**
     * Sets the value of the locationCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationCompany(String value) {
        this.locationCompany = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Gets the value of the managerSupportOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerSupportOrganization() {
        return managerSupportOrganization;
    }

    /**
     * Sets the value of the managerSupportOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerSupportOrganization(String value) {
        this.managerSupportOrganization = value;
    }

    /**
     * Gets the value of the managerSupportGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerSupportGroupName() {
        return managerSupportGroupName;
    }

    /**
     * Sets the value of the managerSupportGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerSupportGroupName(String value) {
        this.managerSupportGroupName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleInitial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the value of the middleInitial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleInitial(String value) {
        this.middleInitial = value;
    }

    /**
     * Gets the value of the vip property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}
     *     
     */
    public JAXBElement<SecureWorkLogType> getVIP() {
        return vip;
    }

    /**
     * Sets the value of the vip property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}
     *     
     */
    public void setVIP(JAXBElement<SecureWorkLogType> value) {
        this.vip = value;
    }

    /**
     * Gets the value of the contactSensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ContactSensitivityType }{@code >}
     *     
     */
    public JAXBElement<ContactSensitivityType> getContactSensitivity() {
        return contactSensitivity;
    }

    /**
     * Sets the value of the contactSensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ContactSensitivityType }{@code >}
     *     
     */
    public void setContactSensitivity(JAXBElement<ContactSensitivityType> value) {
        this.contactSensitivity = value;
    }

    /**
     * Gets the value of the chgLocationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChgLocationAddress() {
        return chgLocationAddress;
    }

    /**
     * Sets the value of the chgLocationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChgLocationAddress(String value) {
        this.chgLocationAddress = value;
    }

    /**
     * Gets the value of the internetEMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternetEMail() {
        return internetEMail;
    }

    /**
     * Sets the value of the internetEMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternetEMail(String value) {
        this.internetEMail = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the z1DChar01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DChar01() {
        return z1DChar01;
    }

    /**
     * Sets the value of the z1DChar01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DChar01(String value) {
        this.z1DChar01 = value;
    }

    /**
     * Gets the value of the categorizationTier1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorizationTier1() {
        return categorizationTier1;
    }

    /**
     * Sets the value of the categorizationTier1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorizationTier1(String value) {
        this.categorizationTier1 = value;
    }

    /**
     * Gets the value of the categorizationTier2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorizationTier2() {
        return categorizationTier2;
    }

    /**
     * Sets the value of the categorizationTier2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorizationTier2(String value) {
        this.categorizationTier2 = value;
    }

    /**
     * Gets the value of the categorizationTier3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorizationTier3() {
        return categorizationTier3;
    }

    /**
     * Sets the value of the categorizationTier3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorizationTier3(String value) {
        this.categorizationTier3 = value;
    }

    /**
     * Gets the value of the z1DAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DAction() {
        return z1DAction;
    }

    /**
     * Sets the value of the z1DAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DAction(String value) {
        this.z1DAction = value;
    }

    /**
     * Gets the value of the z1DInteger01 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ1DInteger01() {
        return z1DInteger01;
    }

    /**
     * Sets the value of the z1DInteger01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ1DInteger01(Integer value) {
        this.z1DInteger01 = value;
    }

    /**
     * Gets the value of the personID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * Sets the value of the personID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonID(String value) {
        this.personID = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the addRequestFor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddRequestForType }{@code >}
     *     
     */
    public JAXBElement<AddRequestForType> getAddRequestFor() {
        return addRequestFor;
    }

    /**
     * Sets the value of the addRequestFor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddRequestForType }{@code >}
     *     
     */
    public void setAddRequestFor(JAXBElement<AddRequestForType> value) {
        this.addRequestFor = value;
    }

    /**
     * Gets the value of the z1DInteger02 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ1DInteger02() {
        return z1DInteger02;
    }

    /**
     * Sets the value of the z1DInteger02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ1DInteger02(Integer value) {
        this.z1DInteger02 = value;
    }

    /**
     * Gets the value of the z1DInteger03 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ1DInteger03() {
        return z1DInteger03;
    }

    /**
     * Sets the value of the z1DInteger03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ1DInteger03(Integer value) {
        this.z1DInteger03 = value;
    }

    /**
     * Gets the value of the z1DChar10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DChar10() {
        return z1DChar10;
    }

    /**
     * Sets the value of the z1DChar10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DChar10(String value) {
        this.z1DChar10 = value;
    }

    /**
     * Gets the value of the statusReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StatusReasonType }{@code >}
     *     
     */
    public JAXBElement<StatusReasonType> getStatusReason() {
        return statusReason;
    }

    /**
     * Sets the value of the statusReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StatusReasonType }{@code >}
     *     
     */
    public void setStatusReason(JAXBElement<StatusReasonType> value) {
        this.statusReason = value;
    }

    /**
     * Gets the value of the detailedDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailedDescription() {
        return detailedDescription;
    }

    /**
     * Sets the value of the detailedDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailedDescription(String value) {
        this.detailedDescription = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PriorityType }{@code >}
     *     
     */
    public JAXBElement<PriorityType> getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PriorityType }{@code >}
     *     
     */
    public void setPriority(JAXBElement<PriorityType> value) {
        this.priority = value;
    }

    /**
     * Gets the value of the workOrderType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WorkOrderTypeType }{@code >}
     *     
     */
    public JAXBElement<WorkOrderTypeType> getWorkOrderType() {
        return workOrderType;
    }

    /**
     * Sets the value of the workOrderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WorkOrderTypeType }{@code >}
     *     
     */
    public void setWorkOrderType(JAXBElement<WorkOrderTypeType> value) {
        this.workOrderType = value;
    }

    /**
     * Gets the value of the workOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkOrderID() {
        return workOrderID;
    }

    /**
     * Sets the value of the workOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkOrderID(String value) {
        this.workOrderID = value;
    }

    /**
     * Gets the value of the requestManagerCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestManagerCompany() {
        return requestManagerCompany;
    }

    /**
     * Sets the value of the requestManagerCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestManagerCompany(String value) {
        this.requestManagerCompany = value;
    }

    /**
     * Gets the value of the requesterSupportOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequesterSupportOrganization() {
        return requesterSupportOrganization;
    }

    /**
     * Sets the value of the requesterSupportOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequesterSupportOrganization(String value) {
        this.requesterSupportOrganization = value;
    }

    /**
     * Gets the value of the requestManager property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestManager() {
        return requestManager;
    }

    /**
     * Sets the value of the requestManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestManager(String value) {
        this.requestManager = value;
    }

    /**
     * Gets the value of the cabManagerLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCABManagerLogin() {
        return cabManagerLogin;
    }

    /**
     * Sets the value of the cabManagerLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCABManagerLogin(String value) {
        this.cabManagerLogin = value;
    }

    /**
     * Gets the value of the viewAccess property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Z1DViewAccessType }{@code >}
     *     
     */
    public JAXBElement<Z1DViewAccessType> getViewAccess() {
        return viewAccess;
    }

    /**
     * Sets the value of the viewAccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Z1DViewAccessType }{@code >}
     *     
     */
    public void setViewAccess(JAXBElement<Z1DViewAccessType> value) {
        this.viewAccess = value;
    }

    /**
     * Gets the value of the z1DStatusReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZ1DStatusReason() {
        return z1DStatusReason;
    }

    /**
     * Sets the value of the z1DStatusReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZ1DStatusReason(String value) {
        this.z1DStatusReason = value;
    }

    /**
     * Gets the value of the requestedByPersonID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedByPersonID() {
        return requestedByPersonID;
    }

    /**
     * Sets the value of the requestedByPersonID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedByPersonID(String value) {
        this.requestedByPersonID = value;
    }

    /**
     * Gets the value of the productCatTier12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCatTier12() {
        return productCatTier12;
    }

    /**
     * Sets the value of the productCatTier12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCatTier12(String value) {
        this.productCatTier12 = value;
    }

    /**
     * Gets the value of the productCatTier22 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCatTier22() {
        return productCatTier22;
    }

    /**
     * Sets the value of the productCatTier22 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCatTier22(String value) {
        this.productCatTier22 = value;
    }

    /**
     * Gets the value of the productCatTier32 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCatTier32() {
        return productCatTier32;
    }

    /**
     * Sets the value of the productCatTier32 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCatTier32(String value) {
        this.productCatTier32 = value;
    }

    /**
     * Gets the value of the secureWorkLog2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}
     *     
     */
    public JAXBElement<SecureWorkLogType> getSecureWorkLog2() {
        return secureWorkLog2;
    }

    /**
     * Sets the value of the secureWorkLog2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SecureWorkLogType }{@code >}
     *     
     */
    public void setSecureWorkLog2(JAXBElement<SecureWorkLogType> value) {
        this.secureWorkLog2 = value;
    }

    /**
     * Gets the value of the z1DPermissionGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZ1DPermissionGroupID() {
        return z1DPermissionGroupID;
    }

    /**
     * Sets the value of the z1DPermissionGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZ1DPermissionGroupID(Integer value) {
        this.z1DPermissionGroupID = value;
    }

    /**
     * Gets the value of the productName2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName2() {
        return productName2;
    }

    /**
     * Sets the value of the productName2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName2(String value) {
        this.productName2 = value;
    }

    /**
     * Gets the value of the productModelVersion2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductModelVersion2() {
        return productModelVersion2;
    }

    /**
     * Sets the value of the productModelVersion2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductModelVersion2(String value) {
        this.productModelVersion2 = value;
    }

    /**
     * Gets the value of the manufacturer2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer2() {
        return manufacturer2;
    }

    /**
     * Sets the value of the manufacturer2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer2(String value) {
        this.manufacturer2 = value;
    }

    /**
     * Gets the value of the workOrderEntryID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkOrderEntryID() {
        return workOrderEntryID;
    }

    /**
     * Sets the value of the workOrderEntryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkOrderEntryID(String value) {
        this.workOrderEntryID = value;
    }

    /**
     * Gets the value of the supportOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportOrganization() {
        return supportOrganization;
    }

    /**
     * Sets the value of the supportOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportOrganization(String value) {
        this.supportOrganization = value;
    }

    /**
     * Gets the value of the supportCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportCompany() {
        return supportCompany;
    }

    /**
     * Sets the value of the supportCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportCompany(String value) {
        this.supportCompany = value;
    }

    /**
     * Gets the value of the supportGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportGroupName() {
        return supportGroupName;
    }

    /**
     * Sets the value of the supportGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportGroupName(String value) {
        this.supportGroupName = value;
    }

    /**
     * Gets the value of the requestAssignee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestAssignee() {
        return requestAssignee;
    }

    /**
     * Sets the value of the requestAssignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestAssignee(String value) {
        this.requestAssignee = value;
    }

    /**
     * Gets the value of the customerPersonID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerPersonID() {
        return customerPersonID;
    }

    /**
     * Sets the value of the customerPersonID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPersonID(String value) {
        this.customerPersonID = value;
    }

    /**
     * Gets the value of the customerFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    /**
     * Sets the value of the customerFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerFirstName(String value) {
        this.customerFirstName = value;
    }

    /**
     * Gets the value of the customerLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * Sets the value of the customerLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerLastName(String value) {
        this.customerLastName = value;
    }

    /**
     * Gets the value of the customerCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerCompany() {
        return customerCompany;
    }

    /**
     * Sets the value of the customerCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerCompany(String value) {
        this.customerCompany = value;
    }

    /**
     * Gets the value of the customerOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerOrganization() {
        return customerOrganization;
    }

    /**
     * Sets the value of the customerOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerOrganization(String value) {
        this.customerOrganization = value;
    }

    /**
     * Gets the value of the customerDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerDepartment() {
        return customerDepartment;
    }

    /**
     * Sets the value of the customerDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerDepartment(String value) {
        this.customerDepartment = value;
    }

    /**
     * Gets the value of the customerInternetEMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerInternetEMail() {
        return customerInternetEMail;
    }

    /**
     * Sets the value of the customerInternetEMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerInternetEMail(String value) {
        this.customerInternetEMail = value;
    }

    /**
     * Gets the value of the customerPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    /**
     * Sets the value of the customerPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerPhoneNumber(String value) {
        this.customerPhoneNumber = value;
    }

}
