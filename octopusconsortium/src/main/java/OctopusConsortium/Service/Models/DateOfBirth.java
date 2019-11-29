package OctopusConsortium.Service.Models;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateOfBirth",propOrder = {
	    "dob"
	})
public class DateOfBirth {
	private static DatatypeFactory df = null;
	static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException(
                "Exception while obtaining DatatypeFactory instance", dce);
        }
    }  
	
	
	
	
	public class AgeInDays {public int ageInDays;}
	
	/*
	 * @XmlElement(name = "DateOfBirth")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfBirth;	
	@XmlElement(name = "YearOfBirth")
    protected Integer yearOfBirth;
    */
	
	@XmlElements(value = {
            @XmlElement(name="dateOfBirth",
            			required=true,
            			type=XMLGregorianCalendar.class),
            @XmlElement(name="yearOfBirth",
            			required=true,
                        type=Integer.class),
            @XmlElement(name="age",
            			required=true,
                        type=Age.class)
    })
	protected Object dob;

	
    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDob() {
    	if(dob!=null && dob instanceof Date){
    		Date ddob = (Date)dob;
    		GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(ddob.getTime());
            return df.newXMLGregorianCalendar(gc);    		
    	}else if(dob!=null && dob instanceof XMLGregorianCalendar){
    		OctopusConsortium.Core.XMLGregorianCalendarConversionUtil.asDate((XMLGregorianCalendar)dob);
    		return (XMLGregorianCalendar)dob;
    	}
    	return null;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDob(XMLGregorianCalendar value) {    
    	if (value == null) {
    		this.dob = value;
        } else {
        	this.dob = value.toGregorianCalendar().getTime();
        }        
    }

    /**
     * Gets the value of the yearOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYearOfBirth() {
    	if(dob!=null && dob instanceof Integer){
    		return (Integer)dob;
    	}
        return null;
    }

    /**
     * Sets the value of the yearOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYearOfBirth(Integer value) {
        this.dob = value;
    }
    
    
    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Age }
     *     
     */
    public Age getAge() {
    	if(dob!=null && dob instanceof Age){
    		return ((Age)dob);
    	}
        return null;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Age }
     *     
     */
    public void setAgeInMonths(Age value) {        
        this.dob = value;
    }
    
}
