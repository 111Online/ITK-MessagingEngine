
package OctopusConsortium.DosService1_3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfServiceCareDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfServiceCareDestination"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceCareDestination" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceCareDestination" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceCareDestination", propOrder = {
    "serviceCareDestination"
})
public class ArrayOfServiceCareDestination {

    @XmlElement(name = "ServiceCareDestination", nillable = true)
    protected List<ServiceCareDestination> serviceCareDestination;

    /**
     * Gets the value of the serviceCareDestination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceCareDestination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceCareDestination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceCareDestination }
     * 
     * 
     */
    public List<ServiceCareDestination> getServiceCareDestination() {
        if (serviceCareDestination == null) {
            serviceCareDestination = new ArrayList<ServiceCareDestination>();
        }
        return this.serviceCareDestination;
    }

}
