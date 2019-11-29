package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * <p>Java class for SubmitToCallQueueResponseOverallStatus
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubmitToCallQueueResponse.OverallStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Successful_call_queue_submission"/>
 *     &lt;enumeration value="Invalid_data_passed"/>
 *     &lt;enumeration value="Failed_call_queue_submission"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SubmitToCallQueueResponseOverallStatus {
	@XmlEnumValue("Successful_call_queue_submission")
    SUCCESSFUL_CALL_QUEUE_SUBMISSION("Successful_call_queue_submission"),
    @XmlEnumValue("Invalid_data_passed")
    INVALID_DATA_PASSED("Invalid_data_passed"),
    @XmlEnumValue("Failed_call_queue_submission")
	FAILED_CALL_QUEUE_SUBMISSION("Failed_call_queue_submission");
    
    private final String value;

	SubmitToCallQueueResponseOverallStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubmitToCallQueueResponseOverallStatus fromValue(String v) {
        for (SubmitToCallQueueResponseOverallStatus c: SubmitToCallQueueResponseOverallStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
