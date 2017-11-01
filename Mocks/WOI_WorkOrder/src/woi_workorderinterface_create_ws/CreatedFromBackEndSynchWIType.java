package woi_workorderinterface_create_ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreatedFromBackEndSynchWIType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CreatedFromBackEndSynchWIType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Yes"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CreatedFromBackEndSynchWIType")
@XmlEnum
public enum CreatedFromBackEndSynchWIType {

    @XmlEnumValue("Yes")
    YES("Yes");
    private final String value;

    CreatedFromBackEndSynchWIType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CreatedFromBackEndSynchWIType fromValue(String v) {
        for (CreatedFromBackEndSynchWIType c: CreatedFromBackEndSynchWIType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
