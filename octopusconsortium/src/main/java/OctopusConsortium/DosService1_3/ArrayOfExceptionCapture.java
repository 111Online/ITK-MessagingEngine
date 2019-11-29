
package OctopusConsortium.DosService1_3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExceptionCapture complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExceptionCapture"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExceptionCapture" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ExceptionCapture" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExceptionCapture", propOrder = {
    "exceptionCapture"
})
public class ArrayOfExceptionCapture {

    @XmlElement(name = "ExceptionCapture", nillable = true)
    protected List<ExceptionCapture2> exceptionCapture;

    /**
     * Gets the value of the exceptionCapture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exceptionCapture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExceptionCapture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExceptionCapture2 }
     * 
     * 
     */
    public List<ExceptionCapture2> getExceptionCapture() {
        if (exceptionCapture == null) {
            exceptionCapture = new ArrayList<ExceptionCapture2>();
        }
        return this.exceptionCapture;
    }

}
