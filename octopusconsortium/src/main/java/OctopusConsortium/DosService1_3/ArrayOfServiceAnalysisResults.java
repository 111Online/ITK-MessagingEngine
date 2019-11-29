
package OctopusConsortium.DosService1_3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfServiceAnalysisResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfServiceAnalysisResults"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceAnalysisResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceAnalysisResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceAnalysisResults", propOrder = {
    "serviceAnalysisResult"
})
public class ArrayOfServiceAnalysisResults {

    @XmlElement(name = "ServiceAnalysisResult", nillable = true)
    protected List<ServiceAnalysisResult> serviceAnalysisResult;

    /**
     * Gets the value of the serviceAnalysisResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceAnalysisResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceAnalysisResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceAnalysisResult }
     * 
     * 
     */
    public List<ServiceAnalysisResult> getServiceAnalysisResult() {
        if (serviceAnalysisResult == null) {
            serviceAnalysisResult = new ArrayList<ServiceAnalysisResult>();
        }
        return this.serviceAnalysisResult;
    }

}
