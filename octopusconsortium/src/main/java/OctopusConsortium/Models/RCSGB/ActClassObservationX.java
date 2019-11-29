//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ActClassObservation_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassObservation_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OBS"/>
 *     &lt;enumeration value="CLNTRL"/>
 *     &lt;enumeration value="VERIF"/>
 *     &lt;enumeration value="CNOD"/>
 *     &lt;enumeration value="COND"/>
 *     &lt;enumeration value="MPROT"/>
 *     &lt;enumeration value="ALRT"/>
 *     &lt;enumeration value="SPCOBS"/>
 *     &lt;enumeration value="INVSTG"/>
 *     &lt;enumeration value="DGIMG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ActClassObservationX {

    OBS,
    CLNTRL,
    VERIF,
    CNOD,
    COND,
    MPROT,
    ALRT,
    SPCOBS,
    INVSTG,
    DGIMG;

    public String value() {
        return name();
    }

    public static ActClassObservationX fromValue(String v) {
        return valueOf(v);
    }

}