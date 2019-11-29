
package OctopusConsortium.DosService1_3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Capacity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Capacity"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="High"/&gt;
 *     &lt;enumeration value="Low"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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
