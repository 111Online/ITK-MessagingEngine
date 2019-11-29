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
 * <p>Java class for cs_ProbabilityDistributionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cs_ProbabilityDistributionType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="U"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="LN"/>
 *     &lt;enumeration value="G"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="X2"/>
 *     &lt;enumeration value="T"/>
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CsProbabilityDistributionType {

    U("U"),
    N("N"),
    LN("LN"),
    G("G"),
    E("E"),
    @XmlEnumValue("X2")
    X_2("X2"),
    T("T"),
    F("F"),
    B("B");
    private final String value;

    CsProbabilityDistributionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CsProbabilityDistributionType fromValue(String v) {
        for (CsProbabilityDistributionType c: CsProbabilityDistributionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
