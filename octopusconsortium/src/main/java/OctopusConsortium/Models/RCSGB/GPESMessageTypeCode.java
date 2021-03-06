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
 * <p>Java class for GPESMessageType_code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GPESMessageType_code">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="GPES-E-Q-NT"/>
 *     &lt;enumeration value="GPES-E-Q-RTPR"/>
 *     &lt;enumeration value="GPES-Q-E-NT"/>
 *     &lt;enumeration value="GPES-Q-E-RTP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum GPESMessageTypeCode {

    @XmlEnumValue("GPES-E-Q-NT")
    GPES_E_Q_NT("GPES-E-Q-NT"),
    @XmlEnumValue("GPES-E-Q-RTPR")
    GPES_E_Q_RTPR("GPES-E-Q-RTPR"),
    @XmlEnumValue("GPES-Q-E-NT")
    GPES_Q_E_NT("GPES-Q-E-NT"),
    @XmlEnumValue("GPES-Q-E-RTP")
    GPES_Q_E_RTP("GPES-Q-E-RTP");
    private final String value;

    GPESMessageTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GPESMessageTypeCode fromValue(String v) {
        for (GPESMessageTypeCode c: GPESMessageTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
