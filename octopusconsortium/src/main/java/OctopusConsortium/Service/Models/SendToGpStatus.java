/**
 * 
 */
package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author stuart.yeates
 *
 */
public enum SendToGpStatus {
	@XmlEnumValue("Unable_to_identify_recipient")
    UNABLE_TO_IDENTIFY_RECIPIENT("Unable_to_identify_recipient"),
    @XmlEnumValue("Invalid_encounter_data")
    INVALID_ENCOUNTER_DATA_PASSED("Invalid_encounter_data"),
    @XmlEnumValue("No_endpoint")
    NO_ENDPOINT("No_endpoint"),
    @XmlEnumValue("Successful_send")
    SUCCESSFUL_SEND("Successful_send"),
    @XmlEnumValue("Failed_to_send")
    FAILED_TO_SEND("Failed_to_send");
    private final String value;

    SendToGpStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SendToGpStatus fromValue(String v) {
        for (SendToGpStatus c: SendToGpStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
