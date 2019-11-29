
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgeFormatType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AgeFormatType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Days"/>
 *     &lt;enumeration value="Months"/>
 *     &lt;enumeration value="Years"/>
 *     &lt;enumeration value="AgeGroup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AgeFormatType")
@XmlEnum
public enum AgeFormatType {

    @XmlEnumValue("Days")
    DAYS("Days"),
    @XmlEnumValue("Months")
    MONTHS("Months"),
    @XmlEnumValue("Years")
    YEARS("Years"),
    @XmlEnumValue("AgeGroup")
    AGE_GROUP("AgeGroup");
    private final String value;

    AgeFormatType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AgeFormatType fromValue(String v) {
        for (AgeFormatType c: AgeFormatType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
