
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistanceSource.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistanceSource">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Postcode"/>
 *     &lt;enumeration value="District"/>
 *     &lt;enumeration value="Sector"/>
 *     &lt;enumeration value="Web Service"/>
 *     &lt;enumeration value="National"/>
 *     &lt;enumeration value="Override"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DistanceSource")
@XmlEnum
public enum DistanceSource {


    /**
     * Preset value used for the specific postcode (e.g. "ME1 4AB").
     * 
     */
    @XmlEnumValue("Postcode")
    POSTCODE("Postcode"),

    /**
     * Preset value used for the postcode district (e.g. "ME1").
     * 
     */
    @XmlEnumValue("District")
    DISTRICT("District"),

    /**
     * Preset value used for the postcode sector (e.g. "ME1 4").
     * 
     */
    @XmlEnumValue("Sector")
    SECTOR("Sector"),

    /**
     * Value used from search request.
     * 
     */
    @XmlEnumValue("Web Service")
    WEB_SERVICE("Web Service"),

    /**
     * National default value used.
     * 
     */
    @XmlEnumValue("National")
    NATIONAL("National"),

    /**
     * When search distance is forced.
     * 
     */
    @XmlEnumValue("Override")
    OVERRIDE("Override");
    private final String value;

    DistanceSource(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistanceSource fromValue(String v) {
        for (DistanceSource c: DistanceSource.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
