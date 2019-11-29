
package OctopusConsortium.DosService1_5;

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
 *         &lt;element name="GetHospitalScoresResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfHospitalScores" minOccurs="0"/>
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
    "getHospitalScoresResult"
})
@XmlRootElement(name = "GetHospitalScoresResponse")
public class GetHospitalScoresResponse {

    @XmlElement(name = "GetHospitalScoresResult")
    protected ArrayOfHospitalScores getHospitalScoresResult;

    /**
     * Gets the value of the getHospitalScoresResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHospitalScores }
     *     
     */
    public ArrayOfHospitalScores getGetHospitalScoresResult() {
        return getHospitalScoresResult;
    }

    /**
     * Sets the value of the getHospitalScoresResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHospitalScores }
     *     
     */
    public void setGetHospitalScoresResult(ArrayOfHospitalScores value) {
        this.getHospitalScoresResult = value;
    }

}
