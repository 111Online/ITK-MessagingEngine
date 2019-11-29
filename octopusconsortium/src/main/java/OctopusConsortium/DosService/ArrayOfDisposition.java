
package OctopusConsortium.DosService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDisposition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDisposition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Disposition" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}Disposition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDisposition", propOrder = {
    "disposition"
})
public class ArrayOfDisposition {

    @XmlElement(name = "Disposition", nillable = true)
    protected List<Disposition> disposition;

    /**
     * Gets the value of the disposition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disposition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisposition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Disposition }
     * 
     * 
     */
    public List<Disposition> getDisposition() {
        if (disposition == null) {
            disposition = new ArrayList<Disposition>();
        }
        return this.disposition;
    }

}
