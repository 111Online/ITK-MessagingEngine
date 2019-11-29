//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.07 at 10:56:02 AM BST 
//


package OctopusConsortium.Models.PDS;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for cs_PostalAddressUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cs_PostalAddressUse">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PHYS"/>
 *     &lt;enumeration value="PST"/>
 *     &lt;enumeration value="TMP"/>
 *     &lt;enumeration value="BAD"/>
 *     &lt;enumeration value="H"/>
 *     &lt;enumeration value="HP"/>
 *     &lt;enumeration value="HV"/>
 *     &lt;enumeration value="WP"/>
 *     &lt;enumeration value="ABC"/>
 *     &lt;enumeration value="SYL"/>
 *     &lt;enumeration value="IDE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CsPostalAddressUse {

    PHYS,
    PST,
    TMP,
    BAD,
    H,
    HP,
    HV,
    WP,
    ABC,
    SYL,
    IDE;

    public String value() {
        return name();
    }

    public static CsPostalAddressUse fromValue(String v) {
        return valueOf(v);
    }

}
