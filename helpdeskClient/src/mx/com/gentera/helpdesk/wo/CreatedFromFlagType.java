package mx.com.gentera.helpdesk.wo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Created_From_flagType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Created_From_flagType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Change"/>
 *     &lt;enumeration value="Request"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Created_From_flagType")
@XmlEnum
public enum CreatedFromFlagType {

    @XmlEnumValue("Change")
    CHANGE("Change"),
    @XmlEnumValue("Request")
    REQUEST("Request");
    private final String value;

    CreatedFromFlagType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CreatedFromFlagType fromValue(String v) {
        for (CreatedFromFlagType c: CreatedFromFlagType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
