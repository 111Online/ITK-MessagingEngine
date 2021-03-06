//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 01:11:57 PM BST 
//


package OctopusConsortium.Models.ITK;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for EntityStatusNormal_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityStatusNormal_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="terminated"/>
 *     &lt;enumeration value="active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum EntityStatusNormalX {

    @XmlEnumValue("terminated")
    TERMINATED("terminated"),
    @XmlEnumValue("active")
    ACTIVE("active");
    private final String value;

    EntityStatusNormalX(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntityStatusNormalX fromValue(String v) {
        for (EntityStatusNormalX c: EntityStatusNormalX.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
