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
 * <p>Java class for CHLOutcomeLevelOfNeed_displayName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CHLOutcomeLevelOfNeed_displayName">
 *   &lt;restriction base="{urn:hl7-org:v3}st">
 *     &lt;enumeration value="No or Low Needs Identified"/>
 *     &lt;enumeration value="Some Level of Need Identified"/>
 *     &lt;enumeration value="Great Level of Need identified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CHLOutcomeLevelOfNeedDisplayName {

    @XmlEnumValue("No or Low Needs Identified")
    NO_OR_LOW_NEEDS_IDENTIFIED("No or Low Needs Identified"),
    @XmlEnumValue("Some Level of Need Identified")
    SOME_LEVEL_OF_NEED_IDENTIFIED("Some Level of Need Identified"),
    @XmlEnumValue("Great Level of Need identified")
    GREAT_LEVEL_OF_NEED_IDENTIFIED("Great Level of Need identified");
    private final String value;

    CHLOutcomeLevelOfNeedDisplayName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CHLOutcomeLevelOfNeedDisplayName fromValue(String v) {
        for (CHLOutcomeLevelOfNeedDisplayName c: CHLOutcomeLevelOfNeedDisplayName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
