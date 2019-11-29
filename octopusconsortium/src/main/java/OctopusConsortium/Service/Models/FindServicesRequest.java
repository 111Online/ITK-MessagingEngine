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
@XmlType(name = "FindServicesRequest", propOrder = {    
	"age",
    "gender",
    "postcode",
    "surgery",
    "searchDistance",
    //"dispositionDetails"
    "dispositionCode",   
    "symptomGroup",
    "symptomDiscriminatorList"
})
public class FindServicesRequest {
	@XmlElement(name = "Age", required = false, type = Integer.class)
	protected Integer age;
	@XmlElement(name = "Gender",required = false)
    protected Gender gender;
	@XmlElement(name = "Postcode",required = true)
	protected String postcode;	
	@XmlElement(name = "Surgery",required = false)
	protected String surgery;
	@XmlElement(name="SearchDistance",required = false, type = Integer.class)
	protected Integer searchDistance;
	//@XmlElement(name = "DispositionDetails", required = true)
	//protected DispositionDetails dispositionDetails;
	
	@XmlElement(name = "DispositionCode", required = true)
	protected int dispositionCode;
	
	@XmlElement(name = "SymptomGroup", required = true)
	protected int symptomGroup;	
	
	@XmlElement(name = "SymptomDiscriminatorList", required = true)
    protected List<Integer> symptomDiscriminatorList;	
	
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * 
	 * @return
	 */
	public String getSurgery() {
		return surgery;
	}
	/**
	 * 
	 * @param surgery
	 */
	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}
	
	/**
	 * @return the searchDistance
	 */
	public Integer getSearchDistance() {
		return searchDistance;
	}
	/**
	 * @param searchDistance the searchDistance to set
	 */
	public void setSearchDistance(int searchDistance) {
		this.searchDistance = searchDistance;
	}
	/**
	 * @return the dispositionDetails
	 */
	//public DispositionDetails getDispositionDetails() {
	//	return dispositionDetails;
	//}
	/**
	 * @param dispositionDetails the dispositionDetails to set
	 */
	//public void setDispositionDetails(DispositionDetails dispositionDetails) {
	//	this.dispositionDetails = dispositionDetails;
	//}
	
	/**
	 * @return the dispositionCode
	 */
	public int getDispositionCode() {
		return dispositionCode;
	}
	/**
	 * @param dispositionCode the dispositionCode to set
	 */
	public void setDispositionCode(int dispositionCode) {
		this.dispositionCode = dispositionCode;
	}
	
	public int getSymptomGroup() {
		return symptomGroup;
	}
	
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


