//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ParticipationTargetDirect_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationTargetDirect_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="BBY"/>
 *     &lt;enumeration value="DON"/>
 *     &lt;enumeration value="PRD"/>
 *     &lt;enumeration value="SBJ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ParticipationTargetDirectX {

    DIR,
    BBY,
    DON,
    PRD,
    SBJ;

    public String value() {
        return name();
    }

    public static ParticipationTargetDirectX fromValue(String v) {
        return valueOf(v);
    }

}
