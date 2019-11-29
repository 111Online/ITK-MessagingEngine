
package OctopusConsortium.DosService1_3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfServiceCareItemRotaSession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfServiceCareItemRotaSession"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceCareItemRotaSession" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceCareItemRotaSession" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceCareItemRotaSession", propOrder = {
    "serviceCareItemRotaSession"
})
public class ArrayOfServiceCareItemRotaSession {

    @XmlElement(name = "ServiceCareItemRotaSession", nillable = true)
    protected List<ServiceCareItemRotaSession> serviceCareItemRotaSession;

    /**
     * Gets the value of the serviceCareItemRotaSession property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceCareItemRotaSession property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceCareItemRotaSession().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceCareItemRotaSession }
     * 
     * 
     */
    public List<ServiceCareItemRotaSession> getServiceCareItemRotaSession() {
        if (serviceCareItemRotaSession == null) {
            serviceCareItemRotaSession = new ArrayList<ServiceCareItemRotaSession>();
        }
        return this.serviceCareItemRotaSession;
    }

}
