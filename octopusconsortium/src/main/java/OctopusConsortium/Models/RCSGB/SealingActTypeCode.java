//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for SealingActType_code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SealingActType_code">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RQTS"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="USE"/>
 *     &lt;enumeration value="RTS"/>
 *     &lt;enumeration value="RR"/>
 *     &lt;enumeration value="RQTUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SealingActTypeCode {

    RQTS,
    SE,
    USE,
    RTS,
    RR,
    RQTUS;

    public String value() {
        return name();
    }

    public static SealingActTypeCode fromValue(String v) {
        return valueOf(v);
    }

}
