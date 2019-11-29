
package OctopusConsortium.DosService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="userInfo" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}UserInfo" minOccurs="0"/>
 *         &lt;element name="serviceCareExp" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceCareException" minOccurs="0"/>
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
    "userInfo",
    "serviceCareExp"
})
@XmlRootElement(name = "ServiceCareException")
public class ServiceCareException {

    protected UserInfo userInfo;
    protected ServiceCareException2 serviceCareExp;

    /**
     * Gets the value of the userInfo property.
     * 
     * @return
     *     possible object is
     *     {@link UserInfo }
     *     
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * Sets the value of the userInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfo }
     *     
     */
    public void setUserInfo(UserInfo value) {
        this.userInfo = value;
    }

    /**
     * Gets the value of the serviceCareExp property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCareException2 }
     *     
     */
    public ServiceCareException2 getServiceCareExp() {
        return serviceCareExp;
    }

    /**
     * Sets the value of the serviceCareExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCareException2 }
     *     
     */
    public void setServiceCareExp(ServiceCareException2 value) {
        this.serviceCareExp = value;
    }

}
