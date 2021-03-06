//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for TriageDispositionType_displayName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TriageDispositionType_displayName">
 *   &lt;restriction base="{urn:hl7-org:v3}st">
 *     &lt;enumeration value="Triage Disposition"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TriageDispositionTypeDisplayName {

    @XmlEnumValue("Triage Disposition")
    TRIAGE_DISPOSITION("Triage Disposition");
    private final String value;

    TriageDispositionTypeDisplayName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TriageDispositionTypeDisplayName fromValue(String v) {
        for (TriageDispositionTypeDisplayName c: TriageDispositionTypeDisplayName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
