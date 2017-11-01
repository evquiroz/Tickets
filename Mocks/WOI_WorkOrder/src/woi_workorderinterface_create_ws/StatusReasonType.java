package woi_workorderinterface_create_ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Status_ReasonType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Status_ReasonType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No Longer Required"/>
 *     &lt;enumeration value="Funding Not Available"/>
 *     &lt;enumeration value="To Be Re-Scheduled"/>
 *     &lt;enumeration value="Resources Not Available"/>
 *     &lt;enumeration value="Successful"/>
 *     &lt;enumeration value="Successful with Issues"/>
 *     &lt;enumeration value="Unsuccessful"/>
 *     &lt;enumeration value="Backed Out"/>
 *     &lt;enumeration value="Final Review Complete"/>
 *     &lt;enumeration value="Final Review Required"/>
 *     &lt;enumeration value="Additional Coding Required"/>
 *     &lt;enumeration value="Insufficient Task Data"/>
 *     &lt;enumeration value="In Verification"/>
 *     &lt;enumeration value="In Rollout"/>
 *     &lt;enumeration value="Insufficient Change Data"/>
 *     &lt;enumeration value="Schedule Conflicts"/>
 *     &lt;enumeration value="In Development"/>
 *     &lt;enumeration value="In Test"/>
 *     &lt;enumeration value="In Build"/>
 *     &lt;enumeration value="In Rollback"/>
 *     &lt;enumeration value="In Documentation"/>
 *     &lt;enumeration value="Vendor Purchase"/>
 *     &lt;enumeration value="Support Group Communication"/>
 *     &lt;enumeration value="Task Review"/>
 *     &lt;enumeration value="Miscellaneous"/>
 *     &lt;enumeration value="Future Enhancement"/>
 *     &lt;enumeration value="Manager Intervention"/>
 *     &lt;enumeration value="Accepted"/>
 *     &lt;enumeration value="Assigned"/>
 *     &lt;enumeration value="Built"/>
 *     &lt;enumeration value="On Hold"/>
 *     &lt;enumeration value="Automatically Closed"/>
 *     &lt;enumeration value="Client Hold"/>
 *     &lt;enumeration value="Client Additional Information Requested"/>
 *     &lt;enumeration value="Client Action Required"/>
 *     &lt;enumeration value="Support Contact Hold"/>
 *     &lt;enumeration value="Local Site Action Required"/>
 *     &lt;enumeration value="Purchase Order Approval"/>
 *     &lt;enumeration value="Supplier Delivery"/>
 *     &lt;enumeration value="Third Party Vendor Action Required"/>
 *     &lt;enumeration value="Infrastructure Change"/>
 *     &lt;enumeration value="Initial Status"/>
 *     &lt;enumeration value="Awaiting Request Assignee"/>
 *     &lt;enumeration value="Work not started"/>
 *     &lt;enumeration value="Cancelled by Requester"/>
 *     &lt;enumeration value="Cancelled by Support"/>
 *     &lt;enumeration value="Customer Close"/>
 *     &lt;enumeration value="System Close"/>
 *     &lt;enumeration value="System Close with Issues"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Status_ReasonType")
@XmlEnum
public enum StatusReasonType {

    @XmlEnumValue("No Longer Required")
    NO_LONGER_REQUIRED("No Longer Required"),
    @XmlEnumValue("Funding Not Available")
    FUNDING_NOT_AVAILABLE("Funding Not Available"),
    @XmlEnumValue("To Be Re-Scheduled")
    TO_BE_RE_SCHEDULED("To Be Re-Scheduled"),
    @XmlEnumValue("Resources Not Available")
    RESOURCES_NOT_AVAILABLE("Resources Not Available"),
    @XmlEnumValue("Successful")
    SUCCESSFUL("Successful"),
    @XmlEnumValue("Successful with Issues")
    SUCCESSFUL_WITH_ISSUES("Successful with Issues"),
    @XmlEnumValue("Unsuccessful")
    UNSUCCESSFUL("Unsuccessful"),
    @XmlEnumValue("Backed Out")
    BACKED_OUT("Backed Out"),
    @XmlEnumValue("Final Review Complete")
    FINAL_REVIEW_COMPLETE("Final Review Complete"),
    @XmlEnumValue("Final Review Required")
    FINAL_REVIEW_REQUIRED("Final Review Required"),
    @XmlEnumValue("Additional Coding Required")
    ADDITIONAL_CODING_REQUIRED("Additional Coding Required"),
    @XmlEnumValue("Insufficient Task Data")
    INSUFFICIENT_TASK_DATA("Insufficient Task Data"),
    @XmlEnumValue("In Verification")
    IN_VERIFICATION("In Verification"),
    @XmlEnumValue("In Rollout")
    IN_ROLLOUT("In Rollout"),
    @XmlEnumValue("Insufficient Change Data")
    INSUFFICIENT_CHANGE_DATA("Insufficient Change Data"),
    @XmlEnumValue("Schedule Conflicts")
    SCHEDULE_CONFLICTS("Schedule Conflicts"),
    @XmlEnumValue("In Development")
    IN_DEVELOPMENT("In Development"),
    @XmlEnumValue("In Test")
    IN_TEST("In Test"),
    @XmlEnumValue("In Build")
    IN_BUILD("In Build"),
    @XmlEnumValue("In Rollback")
    IN_ROLLBACK("In Rollback"),
    @XmlEnumValue("In Documentation")
    IN_DOCUMENTATION("In Documentation"),
    @XmlEnumValue("Vendor Purchase")
    VENDOR_PURCHASE("Vendor Purchase"),
    @XmlEnumValue("Support Group Communication")
    SUPPORT_GROUP_COMMUNICATION("Support Group Communication"),
    @XmlEnumValue("Task Review")
    TASK_REVIEW("Task Review"),
    @XmlEnumValue("Miscellaneous")
    MISCELLANEOUS("Miscellaneous"),
    @XmlEnumValue("Future Enhancement")
    FUTURE_ENHANCEMENT("Future Enhancement"),
    @XmlEnumValue("Manager Intervention")
    MANAGER_INTERVENTION("Manager Intervention"),
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("Assigned")
    ASSIGNED("Assigned"),
    @XmlEnumValue("Built")
    BUILT("Built"),
    @XmlEnumValue("On Hold")
    ON_HOLD("On Hold"),
    @XmlEnumValue("Automatically Closed")
    AUTOMATICALLY_CLOSED("Automatically Closed"),
    @XmlEnumValue("Client Hold")
    CLIENT_HOLD("Client Hold"),
    @XmlEnumValue("Client Additional Information Requested")
    CLIENT_ADDITIONAL_INFORMATION_REQUESTED("Client Additional Information Requested"),
    @XmlEnumValue("Client Action Required")
    CLIENT_ACTION_REQUIRED("Client Action Required"),
    @XmlEnumValue("Support Contact Hold")
    SUPPORT_CONTACT_HOLD("Support Contact Hold"),
    @XmlEnumValue("Local Site Action Required")
    LOCAL_SITE_ACTION_REQUIRED("Local Site Action Required"),
    @XmlEnumValue("Purchase Order Approval")
    PURCHASE_ORDER_APPROVAL("Purchase Order Approval"),
    @XmlEnumValue("Supplier Delivery")
    SUPPLIER_DELIVERY("Supplier Delivery"),
    @XmlEnumValue("Third Party Vendor Action Required")
    THIRD_PARTY_VENDOR_ACTION_REQUIRED("Third Party Vendor Action Required"),
    @XmlEnumValue("Infrastructure Change")
    INFRASTRUCTURE_CHANGE("Infrastructure Change"),
    @XmlEnumValue("Initial Status")
    INITIAL_STATUS("Initial Status"),
    @XmlEnumValue("Awaiting Request Assignee")
    AWAITING_REQUEST_ASSIGNEE("Awaiting Request Assignee"),
    @XmlEnumValue("Work not started")
    WORK_NOT_STARTED("Work not started"),
    @XmlEnumValue("Cancelled by Requester")
    CANCELLED_BY_REQUESTER("Cancelled by Requester"),
    @XmlEnumValue("Cancelled by Support")
    CANCELLED_BY_SUPPORT("Cancelled by Support"),
    @XmlEnumValue("Customer Close")
    CUSTOMER_CLOSE("Customer Close"),
    @XmlEnumValue("System Close")
    SYSTEM_CLOSE("System Close"),
    @XmlEnumValue("System Close with Issues")
    SYSTEM_CLOSE_WITH_ISSUES("System Close with Issues");
    private final String value;

    StatusReasonType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusReasonType fromValue(String v) {
        for (StatusReasonType c: StatusReasonType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
