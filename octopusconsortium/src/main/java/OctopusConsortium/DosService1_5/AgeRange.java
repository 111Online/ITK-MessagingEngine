
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgeRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgeRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="daysFrom" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="daysTo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgeRange", propOrder = {
    "daysFrom",
    "daysTo"
})
public class AgeRange {

    protected float daysFrom;
    protected float daysTo;

    /**
     * Gets the value of the daysFrom property.
     * 
     */
    public float getDaysFrom() {
        return daysFrom;
    }

    /**
     * Sets the value of the daysFrom property.
     * 
     */
    public void setDaysFrom(float value) {
        this.daysFrom = value;
    }

    /**
     * Gets the value of the daysTo property.
     * 
     */
    public float getDaysTo() {
        return daysTo;
    }

    /**
     * Sets the value of the daysTo property.
     * 
     */
    public void setDaysTo(float value) {
        this.daysTo = value;
    }

}
