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
 * <p>Java class for SubmitEncounterResponse.OverallStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubmitEncounterResponse.OverallStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unable_to_identify_patient"/>
 *     &lt;enumeration value="Invalid_encounter_data_passed"/>
 *     &lt;enumeration value="Successful_call_to_gp_webservice"/>
 *     &lt;enumeration value="Failed_call_to_gp_webservice"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SubmitEncounterResponseOverallStatus {

    @XmlEnumValue("Unable_to_identify_patient")
    UNABLE_TO_IDENTIFY_PATIENT("Unable_to_identify_patient"),
    @XmlEnumValue("Invalid_encounter_data_passed")
    INVALID_ENCOUNTER_DATA_PASSED("Invalid_encounter_data_passed"),
    @XmlEnumValue("Successful_call_to_gp_webservice")
    SUCCESSFUL_CALL_TO_GP_WEBSERVICE("Successful_call_to_gp_webservice"),
    @XmlEnumValue("Failed_call_to_gp_webservice")
    FAILED_CALL_TO_GP_WEBSERVICE("Failed_call_to_gp_webservice");
    private final String value;

    SubmitEncounterResponseOverallStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubmitEncounterResponseOverallStatus fromValue(String v) {
        for (SubmitEncounterResponseOverallStatus c: SubmitEncounterResponseOverallStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
