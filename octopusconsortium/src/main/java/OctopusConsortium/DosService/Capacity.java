
package OctopusConsortium.DosService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Capacity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Capacity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="None"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Capacity")
@XmlEnum
public enum Capacity {

    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("None")
    NONE("None");
    private final String value;

    Capacity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Capacity fromValue(String v) {
        for (Capacity c: Capacity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
