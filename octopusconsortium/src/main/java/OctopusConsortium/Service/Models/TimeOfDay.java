
package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeOfDay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeOfDay">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hours" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="minutes" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeOfDay", propOrder = {
    "hours",
    "minutes"
})
public class TimeOfDay {

    protected short hours;
    protected short minutes;

    /**
     * Gets the value of the hours property.
     * 
     */
    public short getHours() {
        return hours;
    }

    /**
     * Sets the value of the hours property.
     * 
     */
    public void setHours(short value) {
        this.hours = value;
    }

    /**
     * Gets the value of the minutes property.
     * 
     */
    public short getMinutes() {
        return minutes;
    }

    /**
     * Sets the value of the minutes property.
     * 
     */
    public void setMinutes(short value) {
        this.minutes = value;
    }

}
