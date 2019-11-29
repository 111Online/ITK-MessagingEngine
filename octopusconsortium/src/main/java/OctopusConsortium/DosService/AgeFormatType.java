
package OctopusConsortium.DosService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ageFormatType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ageFormatType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Years"/>
 *     &lt;enumeration value="AgeGroup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ageFormatType")
@XmlEnum
public enum AgeFormatType {

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
