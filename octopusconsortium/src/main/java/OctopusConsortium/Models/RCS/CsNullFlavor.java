//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:44:55 PM BST 
//


package OctopusConsortium.Models.RCS;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for cs_NullFlavor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cs_NullFlavor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="UNK"/>
 *     &lt;enumeration value="NASK"/>
 *     &lt;enumeration value="ASKU"/>
 *     &lt;enumeration value="NAV"/>
 *     &lt;enumeration value="OTH"/>
 *     &lt;enumeration value="PINF"/>
 *     &lt;enumeration value="NINF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CsNullFlavor {

    NI,
    NA,
    UNK,
    NASK,
    ASKU,
    NAV,
    OTH,
    PINF,
    NINF;

    public String value() {
        return name();
    }

    public static CsNullFlavor fromValue(String v) {
        return valueOf(v);
    }

}
