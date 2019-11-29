
package OctopusConsortium.DosService1_3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfServiceCareSummaryDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfServiceCareSummaryDestination"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceCareSummaryDestination" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceCareSummaryDestination" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceCareSummaryDestination", propOrder = {
    "serviceCareSummaryDestination"
})
public class ArrayOfServiceCareSummaryDestination {

    @XmlElement(name = "ServiceCareSummaryDestination", nillable = true)
    protected List<ServiceCareSummaryDestination> serviceCareSummaryDestination;

    /**
     * Gets the value of the serviceCareSummaryDestination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceCareSummaryDestination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceCareSummaryDestination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceCareSummaryDestination }
     * 
     * 
     */
    public List<ServiceCareSummaryDestination> getServiceCareSummaryDestination() {
        if (serviceCareSummaryDestination == null) {
            serviceCareSummaryDestination = new ArrayList<ServiceCareSummaryDestination>();
        }
        return this.serviceCareSummaryDestination;
    }

}
