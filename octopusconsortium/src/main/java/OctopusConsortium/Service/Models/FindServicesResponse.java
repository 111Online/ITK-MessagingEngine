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
@XmlType(name = "FindServicesResponse", propOrder = {
    "results"    
})
public class FindServicesResponse {
	    
    @XmlElement(name="Results")
    protected List<OctopusConsortium.Service.Models.ServiceCareSummaryDestination> results;

	/**
	 * @return the results
	 */
	public List<OctopusConsortium.Service.Models.ServiceCareSummaryDestination> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(
			List<OctopusConsortium.Service.Models.ServiceCareSummaryDestination> results) {
		this.results = results;
	}
}
