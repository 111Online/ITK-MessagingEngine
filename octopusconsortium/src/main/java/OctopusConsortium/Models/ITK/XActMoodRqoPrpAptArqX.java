//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 01:11:57 PM BST 
//


package OctopusConsortium.Models.ITK;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for x_ActMoodRqoPrpAptArq_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActMoodRqoPrpAptArq_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RQO"/>
 *     &lt;enumeration value="PRP"/>
 *     &lt;enumeration value="APT"/>
 *     &lt;enumeration value="ARQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum XActMoodRqoPrpAptArqX {

    RQO,
    PRP,
    APT,
    ARQ;

    public String value() {
        return name();
    }

    public static XActMoodRqoPrpAptArqX fromValue(String v) {
        return valueOf(v);
    }

}
