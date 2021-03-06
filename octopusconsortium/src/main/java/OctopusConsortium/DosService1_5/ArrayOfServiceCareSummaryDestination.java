
package OctopusConsortium.DosService1_5;

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
 * &lt;complexType name="ArrayOfServiceCareSummaryDestination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceCareSummaryDestination" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceCareSummaryDestination" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceCareSummaryDestination", propOrder = {
    "serviceCareSummaryDestination"
})
public class ArrayOfServiceCareSummaryDestination {

    @XmlElement(nillable = true)
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
