
package OctopusConsortium.DosService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contactType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="contactType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="dts"/>
 *     &lt;enumeration value="itk"/>
 *     &lt;enumeration value="telno"/>
 *     &lt;enumeration value="email"/>
 *     &lt;enumeration value="faxno"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "contactType")
@XmlEnum
public enum ContactType {

    @XmlEnumValue("dts")
    DTS("dts"),
    @XmlEnumValue("itk")
    ITK("itk"),
    @XmlEnumValue("telno")
    TELNO("telno"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("faxno")
    FAXNO("faxno");
    private final String value;

    ContactType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContactType fromValue(String v) {
        for (ContactType c: ContactType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
