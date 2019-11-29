
package OctopusConsortium.DosService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DispositionsResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfDisposition" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dispositionsResult"
})
@XmlRootElement(name = "DispositionsResponse")
public class DispositionsResponse {

    @XmlElement(name = "DispositionsResult")
    protected ArrayOfDisposition dispositionsResult;

    /**
     * Gets the value of the dispositionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDisposition }
     *     
     */
    public ArrayOfDisposition getDispositionsResult() {
        return dispositionsResult;
    }

    /**
     * Sets the value of the dispositionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDisposition }
     *     
     */
    public void setDispositionsResult(ArrayOfDisposition value) {
        this.dispositionsResult = value;
    }

}
