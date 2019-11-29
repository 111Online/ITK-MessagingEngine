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
 * <p>Java class for cs_EntityNameUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cs_EntityNameUse">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="L"/>
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="ABC"/>
 *     &lt;enumeration value="SYL"/>
 *     &lt;enumeration value="IDE"/>
 *     &lt;enumeration value="PREVIOUS-BIRTH"/>
 *     &lt;enumeration value="PREVIOUS-MAIDEN"/>
 *     &lt;enumeration value="PREVIOUS-BACHELOR"/>
 *     &lt;enumeration value="PREVIOUS"/>
 *     &lt;enumeration value="PREFERRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CsEntityNameUse {

    L("L"),
    A("A"),
    I("I"),
    R("R"),
    ABC("ABC"),
    SYL("SYL"),
    IDE("IDE"),
    @XmlEnumValue("PREVIOUS-BIRTH")
    PREVIOUS_BIRTH("PREVIOUS-BIRTH"),
    @XmlEnumValue("PREVIOUS-MAIDEN")
    PREVIOUS_MAIDEN("PREVIOUS-MAIDEN"),
    @XmlEnumValue("PREVIOUS-BACHELOR")
    PREVIOUS_BACHELOR("PREVIOUS-BACHELOR"),
    PREVIOUS("PREVIOUS"),
    PREFERRED("PREFERRED");
    private final String value;

    CsEntityNameUse(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CsEntityNameUse fromValue(String v) {
        for (CsEntityNameUse c: CsEntityNameUse.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
