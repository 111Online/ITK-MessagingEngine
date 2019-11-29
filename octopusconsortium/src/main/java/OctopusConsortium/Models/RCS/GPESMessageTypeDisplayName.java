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
 * <p>Java class for GPESMessageType_displayName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GPESMessageType_displayName">
 *   &lt;restriction base="{urn:hl7-org:v3}st">
 *     &lt;enumeration value="GPES-E-Q Notification message"/>
 *     &lt;enumeration value="GPES-E-Q Run Time Parameter Response message"/>
 *     &lt;enumeration value="GPES-Q-E Notification message"/>
 *     &lt;enumeration value="GPES-Q-E Run Time Parameter Request message"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum GPESMessageTypeDisplayName {

    @XmlEnumValue("GPES-E-Q Notification message")
    GPES_E_Q_NOTIFICATION_MESSAGE("GPES-E-Q Notification message"),
    @XmlEnumValue("GPES-E-Q Run Time Parameter Response message")
    GPES_E_Q_RUN_TIME_PARAMETER_RESPONSE_MESSAGE("GPES-E-Q Run Time Parameter Response message"),
    @XmlEnumValue("GPES-Q-E Notification message")
    GPES_Q_E_NOTIFICATION_MESSAGE("GPES-Q-E Notification message"),
    @XmlEnumValue("GPES-Q-E Run Time Parameter Request message")
    GPES_Q_E_RUN_TIME_PARAMETER_REQUEST_MESSAGE("GPES-Q-E Run Time Parameter Request message");
    private final String value;

    GPESMessageTypeDisplayName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GPESMessageTypeDisplayName fromValue(String v) {
        for (GPESMessageTypeDisplayName c: GPESMessageTypeDisplayName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
