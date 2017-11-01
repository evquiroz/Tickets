package woi_workorderinterface_create_ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for z1D_View_AccessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="z1D_View_AccessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Internal"/>
 *     &lt;enumeration value="Public"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "z1D_View_AccessType")
@XmlEnum
public enum Z1DViewAccessType {

    @XmlEnumValue("Internal")
    INTERNAL("Internal"),
    @XmlEnumValue("Public")
    PUBLIC("Public");
    private final String value;

    Z1DViewAccessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Z1DViewAccessType fromValue(String v) {
        for (Z1DViewAccessType c: Z1DViewAccessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
