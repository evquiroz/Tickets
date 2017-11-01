package woi_workorderinterface_create_ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Assignment_Accelerator_AssigneeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Assignment_Accelerator_AssigneeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="My Default Group"/>
 *     &lt;enumeration value="My Group List"/>
 *     &lt;enumeration value="Favorite Group(s)"/>
 *     &lt;enumeration value="Auto Assign"/>
 *     &lt;enumeration value="Change Manager"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Assignment_Accelerator_AssigneeType")
@XmlEnum
public enum AssignmentAcceleratorAssigneeType {

    @XmlEnumValue("My Default Group")
    MY_DEFAULT_GROUP("My Default Group"),
    @XmlEnumValue("My Group List")
    MY_GROUP_LIST("My Group List"),
    @XmlEnumValue("Favorite Group(s)")
    FAVORITE_GROUP_S("Favorite Group(s)"),
    @XmlEnumValue("Auto Assign")
    AUTO_ASSIGN("Auto Assign"),
    @XmlEnumValue("Change Manager")
    CHANGE_MANAGER("Change Manager");
    private final String value;

    AssignmentAcceleratorAssigneeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssignmentAcceleratorAssigneeType fromValue(String v) {
        for (AssignmentAcceleratorAssigneeType c: AssignmentAcceleratorAssigneeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
