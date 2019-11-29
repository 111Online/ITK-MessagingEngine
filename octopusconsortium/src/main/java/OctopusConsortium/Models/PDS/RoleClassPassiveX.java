//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.07 at 10:56:02 AM BST 
//


package OctopusConsortium.Models.PDS;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for RoleClassPassive_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassPassive_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="BIRTHPL"/>
 *     &lt;enumeration value="ACCESS"/>
 *     &lt;enumeration value="EXPR"/>
 *     &lt;enumeration value="HLTHCHRT"/>
 *     &lt;enumeration value="HLD"/>
 *     &lt;enumeration value="IDENT"/>
 *     &lt;enumeration value="MNT"/>
 *     &lt;enumeration value="OWN"/>
 *     &lt;enumeration value="RGPR"/>
 *     &lt;enumeration value="TERR"/>
 *     &lt;enumeration value="WRTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum RoleClassPassiveX {

    BIRTHPL,
    ACCESS,
    EXPR,
    HLTHCHRT,
    HLD,
    IDENT,
    MNT,
    OWN,
    RGPR,
    TERR,
    WRTE;

    public String value() {
        return name();
    }

    public static RoleClassPassiveX fromValue(String v) {
        return valueOf(v);
    }

}
