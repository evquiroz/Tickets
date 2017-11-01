package mx.com.gentera.helpdesk.wo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SRWorkInfoTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SRWorkInfoTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Request Primary Attachment"/>
 *     &lt;enumeration value="WorkInfo created Before SR Submit"/>
 *     &lt;enumeration value="WorkInfo created After SR Submit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SRWorkInfoTypeType")
@XmlEnum
public enum SRWorkInfoTypeType {

    @XmlEnumValue("Request Primary Attachment")
    REQUEST_PRIMARY_ATTACHMENT("Request Primary Attachment"),
    @XmlEnumValue("WorkInfo created Before SR Submit")
    WORK_INFO_CREATED_BEFORE_SR_SUBMIT("WorkInfo created Before SR Submit"),
    @XmlEnumValue("WorkInfo created After SR Submit")
    WORK_INFO_CREATED_AFTER_SR_SUBMIT("WorkInfo created After SR Submit");
    private final String value;

    SRWorkInfoTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SRWorkInfoTypeType fromValue(String v) {
        for (SRWorkInfoTypeType c: SRWorkInfoTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
