/**
 * 
 */
package OctopusConsortium.Service.Models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author stuart.yeates
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispositionDetails", propOrder = {    
    "dispositionCode",
    "dispositionName",
    "symptomGroup",
    "symptomDiscriminatorList"
})
public class DispositionDetails {
	
	@XmlElement(name = "DispositionCode", required = true)
	protected int dispositionCode;
	@XmlElement(name = "DispositionName", required = true)
	protected String dispositionName;
	@XmlElement(name = "SymptomGroup", required = true)
	protected int symptomGroup;		
	@XmlElement(name = "SymptomDiscriminatorList", required = true)
    protected List<Integer> symptomDiscriminatorList;	
	
	public String getDispositionName() {
		return dispositionName;
	}
	public void setDispositionName(String dispositionName) {
		this.dispositionName = dispositionName;
	}
	public int getDispositionCode() {
		return dispositionCode;
	}
	public void setDispositionCode(int _disposition) {
		this.dispositionCode = _disposition;
	}
	/**
	 * @return the symptomGroup
	 */
	public int getSymptomGroup() {
		return symptomGroup;
	}
	/**
	 * @param symptomGroup the symptomGroup to set
	 */
	public void setSymptomGroup(int symptomGroup) {
		this.symptomGroup = symptomGroup;
	}
	/**
	 * @return the symptomDiscriminatorList
	 */
	public List<Integer> getSymptomDiscriminatorList() {
		return symptomDiscriminatorList;
	}
	/**
	 * @param symptomDiscriminatorList the symptomDiscriminatorList to set
	 */
	public void setSymptomDiscriminatorList(List<Integer> symptomDiscriminatorList) {
		this.symptomDiscriminatorList = symptomDiscriminatorList;
	}
	
}
