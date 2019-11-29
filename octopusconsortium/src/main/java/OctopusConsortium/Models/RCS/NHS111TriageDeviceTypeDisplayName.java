//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:44:55 PM BST 
//


package OctopusConsortium.Models.RCS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for NHS111TriageDeviceType_displayName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NHS111TriageDeviceType_displayName">
 *   &lt;restriction base="{urn:hl7-org:v3}st">
 *     &lt;enumeration value="TriageSystem Software"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum NHS111TriageDeviceTypeDisplayName {

    @XmlEnumValue("TriageSystem Software")
    TRIAGE_SYSTEM_SOFTWARE("TriageSystem Software");
    private final String value;

    NHS111TriageDeviceTypeDisplayName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NHS111TriageDeviceTypeDisplayName fromValue(String v) {
        for (NHS111TriageDeviceTypeDisplayName c: NHS111TriageDeviceTypeDisplayName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}