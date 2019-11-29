
package OctopusConsortium.DosService1_5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHospitalScores complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHospitalScores">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hospital" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}Hospital" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHospitalScores", propOrder = {
    "hospital"
})
public class ArrayOfHospitalScores {

    @XmlElement(name = "Hospital", nillable = true)
    protected List<Hospital> hospital;

    /**
     * Gets the value of the hospital property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hospital property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHospital().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hospital }
     * 
     * 
     */
    public List<Hospital> getHospital() {
        if (hospital == null) {
            hospital = new ArrayList<Hospital>();
        }
        return this.hospital;
    }

}
