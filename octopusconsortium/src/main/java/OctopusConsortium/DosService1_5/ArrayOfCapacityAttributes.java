
package OctopusConsortium.DosService1_5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCapacityAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCapacityAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capacityAttribute" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}CapacityAttribute" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCapacityAttributes", propOrder = {
    "capacityAttribute"
})
public class ArrayOfCapacityAttributes {

    @XmlElement(required = true, nillable = true)
    protected List<CapacityAttribute> capacityAttribute;

    /**
     * Gets the value of the capacityAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capacityAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapacityAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapacityAttribute }
     * 
     * 
     */
    public List<CapacityAttribute> getCapacityAttribute() {
        if (capacityAttribute == null) {
            capacityAttribute = new ArrayList<CapacityAttribute>();
        }
        return this.capacityAttribute;
    }

}
