//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for RoleClassMutualRelationship_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassMutualRelationship_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CAREGIVER"/>
 *     &lt;enumeration value="PRS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum RoleClassMutualRelationshipX {

    CAREGIVER,
    PRS;

    public String value() {
        return name();
    }

    public static RoleClassMutualRelationshipX fromValue(String v) {
        return valueOf(v);
    }

}
