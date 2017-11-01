package woi_workorderinterface_create_ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contact_SensitivityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Contact_SensitivityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sensitive"/>
 *     &lt;enumeration value="Standard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Contact_SensitivityType")
@XmlEnum
public enum ContactSensitivityType {

    @XmlEnumValue("Sensitive")
    SENSITIVE("Sensitive"),
    @XmlEnumValue("Standard")
    STANDARD("Standard");
    private final String value;

    ContactSensitivityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContactSensitivityType fromValue(String v) {
        for (ContactSensitivityType c: ContactSensitivityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
