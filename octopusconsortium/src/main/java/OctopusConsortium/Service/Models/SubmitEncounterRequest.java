/**
 * 
 */
package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author stuart.yeates
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitEncounterRequest", propOrder = {
			"_haSC",
		    "_patientDetails",
		    "_sendToRepeatCaller"
		})
public class SubmitEncounterRequest {
	@XmlElement(name = "PatientDetails", required = true)
	protected IdentifyPatientRequest _patientDetails;
	@XmlElement(name = "HaSC", required = true)
	protected HaSC _haSC;
	@XmlElement(name = "SendToRepeatCaller")
	protected boolean _sendToRepeatCaller;
	
	public HaSC getHaSC()
	{
		return _haSC;
	}
	public void setHaSC(HaSC value)
	{
		_haSC = value;
	}
	public IdentifyPatientRequest getIdentifyPatient()
	{
		return _patientDetails;
	}
	public void setIdentifyPatient(IdentifyPatientRequest value)
	{
		_patientDetails = value;
	}
		
	public boolean getSendToRepeatCaller() {
		return _sendToRepeatCaller;
	}
	public void setSendToRepeatCaller(boolean value) {
		_sendToRepeatCaller = value;
	}
}