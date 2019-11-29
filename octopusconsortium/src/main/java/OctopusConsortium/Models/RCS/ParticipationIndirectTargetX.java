//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:44:55 PM BST 
//


package OctopusConsortium.Models.RCS;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ParticipationIndirectTarget_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationIndirectTarget_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="IND"/>
 *     &lt;enumeration value="HLD"/>
 *     &lt;enumeration value="COV"/>
 *     &lt;enumeration value="RCV"/>
 *     &lt;enumeration value="RCT"/>
 *     &lt;enumeration value="BEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ParticipationIndirectTargetX {

    IND,
    HLD,
    COV,
    RCV,
    RCT,
    BEN;

    public String value() {
        return name();
    }

    public static ParticipationIndirectTargetX fromValue(String v) {
        return valueOf(v);
    }

}
