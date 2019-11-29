
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
 *         &lt;element name="ExceptionCaptureResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfExceptionCapture" minOccurs="0"/>
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
    "exceptionCaptureResult"
})
@XmlRootElement(name = "ExceptionCaptureResponse")
public class ExceptionCaptureResponse {

    @XmlElement(name = "ExceptionCaptureResult")
    protected ArrayOfExceptionCapture exceptionCaptureResult;

    /**
     * Gets the value of the exceptionCaptureResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfExceptionCapture }
     *     
     */
    public ArrayOfExceptionCapture getExceptionCaptureResult() {
        return exceptionCaptureResult;
    }

    /**
     * Sets the value of the exceptionCaptureResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfExceptionCapture }
     *     
     */
    public void setExceptionCaptureResult(ArrayOfExceptionCapture value) {
        this.exceptionCaptureResult = value;
    }

}
