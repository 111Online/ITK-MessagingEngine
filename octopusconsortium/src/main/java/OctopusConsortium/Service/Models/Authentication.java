package OctopusConsortium.Service.Models;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Authentication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Authentication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="1"/>
  *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authentication", propOrder = {
    "username",
    "password",
    "source"
})
public class Authentication {

	@XmlElement(name = "Username", required = true)
	protected String username;
	@XmlElement(name = "Password", required = true)
	protected String password;
	@XmlElement(name = "Source", required = false, type = Integer.class)
	protected Integer source;
	@XmlTransient
	private Collection roles;
	
    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getUsername() {
		return this.username;
	}
	
	/**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getPassword() {
		return this.password;
	}
	
	/**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public Integer getSource() {
		return this.source;
	}
	
	/**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setSource(Integer source) {
		this.source = source;
	}
	
	public void setRoles(Collection roles) {
		this.roles = roles;
	}
	
	public Collection getRoles() {
		return this.roles;
	}
}
