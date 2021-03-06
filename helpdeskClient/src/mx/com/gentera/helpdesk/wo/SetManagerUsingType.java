package mx.com.gentera.helpdesk.wo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Set_Manager_usingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Set_Manager_usingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Auto Assign"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Set_Manager_usingType")
@XmlEnum
public enum SetManagerUsingType {

    @XmlEnumValue("Auto Assign")
    AUTO_ASSIGN("Auto Assign");
    private final String value;

    SetManagerUsingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SetManagerUsingType fromValue(String v) {
        for (SetManagerUsingType c: SetManagerUsingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
