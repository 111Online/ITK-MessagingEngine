//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.26 at 11:11:57 AM BST 
//


package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for IdentifyPatientResponse.GPEndpointStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentifyPatientResponse.GPEndpointStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GP_Endpoint_listed"/>
 *     &lt;enumeration value="No_GP_Endpoint_listed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum IdentifyPatientResponseGPEndpointStatus {

    @XmlEnumValue("GP_Endpoint_listed")
    GP_ENDPOINT_LISTED("GP_Endpoint_listed"),
    @XmlEnumValue("No_GP_endpoint_listed")
    NO_GP_ENDPOINT_LISTED("No_GP_endpoint_listed");
    private final String value;

    IdentifyPatientResponseGPEndpointStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IdentifyPatientResponseGPEndpointStatus fromValue(String v) {
        for (IdentifyPatientResponseGPEndpointStatus c: IdentifyPatientResponseGPEndpointStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}