
package OctopusConsortium.DosService1_5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfServiceAgeRanges complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfServiceAgeRanges">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ageRange" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}AgeRange" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceAgeRanges", propOrder = {
    "ageRange"
})
public class ArrayOfServiceAgeRanges {

    @XmlElement(nillable = true)
    protected List<AgeRange> ageRange;

    /**
     * Gets the value of the ageRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ageRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgeRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AgeRange }
     * 
     * 
     */
    public List<AgeRange> getAgeRange() {
        if (ageRange == null) {
            ageRange = new ArrayList<AgeRange>();
        }
        return this.ageRange;
    }

}
