package woi_workorderinterface_create_ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for z1D_CommunicationSourceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="z1D_CommunicationSourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Email"/>
 *     &lt;enumeration value="Fax"/>
 *     &lt;enumeration value="Phone"/>
 *     &lt;enumeration value="Voice Mail"/>
 *     &lt;enumeration value="Walk In"/>
 *     &lt;enumeration value="Pager"/>
 *     &lt;enumeration value="System Assignment"/>
 *     &lt;enumeration value="Web"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "z1D_CommunicationSourceType")
@XmlEnum
public enum Z1DCommunicationSourceType {

    @XmlEnumValue("Email")
    EMAIL("Email"),
    @XmlEnumValue("Fax")
    FAX("Fax"),
    @XmlEnumValue("Phone")
    PHONE("Phone"),
    @XmlEnumValue("Voice Mail")
    VOICE_MAIL("Voice Mail"),
    @XmlEnumValue("Walk In")
    WALK_IN("Walk In"),
    @XmlEnumValue("Pager")
    PAGER("Pager"),
    @XmlEnumValue("System Assignment")
    SYSTEM_ASSIGNMENT("System Assignment"),
    @XmlEnumValue("Web")
    WEB("Web"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    Z1DCommunicationSourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Z1DCommunicationSourceType fromValue(String v) {
        for (Z1DCommunicationSourceType c: Z1DCommunicationSourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
