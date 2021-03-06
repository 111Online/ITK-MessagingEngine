//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for NHS111RepeatCallerServiceResponseType_code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NHS111RepeatCallerServiceResponseType_code">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RC"/>
 *     &lt;enumeration value="NRC"/>
 *     &lt;enumeration value="PRC"/>
 *     &lt;enumeration value="IIQ"/>
 *     &lt;enumeration value="ER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum NHS111RepeatCallerServiceResponseTypeCode {

    RC,
    NRC,
    PRC,
    IIQ,
    ER;

    public String value() {
        return name();
    }

    public static NHS111RepeatCallerServiceResponseTypeCode fromValue(String v) {
        return valueOf(v);
    }

}
