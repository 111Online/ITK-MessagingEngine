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
 * <p>Java class for NHS111MessageType_displayName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NHS111MessageType_displayName">
 *   &lt;restriction base="{urn:hl7-org:v3}st">
 *     &lt;enumeration value="NHS111 Repeat Caller Database Request"/>
 *     &lt;enumeration value="NHS111 Repeat Caller Database Response"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum NHS111MessageTypeDisplayName {

    @XmlEnumValue("NHS111 Repeat Caller Database Request")
    NHS_111_REPEAT_CALLER_DATABASE_REQUEST("NHS111 Repeat Caller Database Request"),
    @XmlEnumValue("NHS111 Repeat Caller Database Response")
    NHS_111_REPEAT_CALLER_DATABASE_RESPONSE("NHS111 Repeat Caller Database Response");
    private final String value;

    NHS111MessageTypeDisplayName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NHS111MessageTypeDisplayName fromValue(String v) {
        for (NHS111MessageTypeDisplayName c: NHS111MessageTypeDisplayName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
