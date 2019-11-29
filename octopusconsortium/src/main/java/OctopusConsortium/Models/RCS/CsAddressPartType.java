//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:44:55 PM BST 
//


package OctopusConsortium.Models.RCS;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for cs_AddressPartType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cs_AddressPartType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DEL"/>
 *     &lt;enumeration value="CNT"/>
 *     &lt;enumeration value="STA"/>
 *     &lt;enumeration value="CPA"/>
 *     &lt;enumeration value="CTY"/>
 *     &lt;enumeration value="ZIP"/>
 *     &lt;enumeration value="SAL"/>
 *     &lt;enumeration value="BNR"/>
 *     &lt;enumeration value="BNN"/>
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="STR"/>
 *     &lt;enumeration value="STB"/>
 *     &lt;enumeration value="STTYP"/>
 *     &lt;enumeration value="ADL"/>
 *     &lt;enumeration value="UNID"/>
 *     &lt;enumeration value="UNIT"/>
 *     &lt;enumeration value="CAR"/>
 *     &lt;enumeration value="CEN"/>
 *     &lt;enumeration value="DESC"/>
 *     &lt;enumeration value="ADDRK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CsAddressPartType {

    DEL,
    CNT,
    STA,
    CPA,
    CTY,
    ZIP,
    SAL,
    BNR,
    BNN,
    DIR,
    STR,
    STB,
    STTYP,
    ADL,
    UNID,
    UNIT,
    CAR,
    CEN,
    DESC,
    ADDRK;

    public String value() {
        return name();
    }

    public static CsAddressPartType fromValue(String v) {
        return valueOf(v);
    }

}
