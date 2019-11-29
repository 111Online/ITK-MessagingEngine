
package OctopusConsortium.RepeatCallerServiceV1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for handlingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="handlingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="spec" type="{urn:nhs-itk:ns:201005}handlingSpecType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "handlingType", propOrder = {
    "spec"
})
public class HandlingType {

    protected List<HandlingSpecType> spec;

    /**
     * Gets the value of the spec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HandlingSpecType }
     * 
     * 
     */
    public List<HandlingSpecType> getSpec() {
        if (spec == null) {
            spec = new ArrayList<HandlingSpecType>();
        }
        return this.spec;
    }

}