//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.07 at 10:56:02 AM BST 
//


package OctopusConsortium.Models.PDS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * A character string that may have a type-tag signifying its role in the
 * address. Typical parts that exist in about every address are street,
 * house number, or post box, postal code, city, country but other roles
 * may be defined regionally, nationally, or on an enterprise level
 * (e.g. in military addresses). Addresses are usually broken up into
 * lines, which are indicated by special line-breaking delimiter elements 
 * (e.g., DEL).
 * 
 * 
 * <p>Java class for ADXP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ADXP">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ST">
 *       &lt;attribute name="partType" type="{urn:hl7-org:v3}cs_AddressPartType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADXP")
@XmlSeeAlso({
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.Delimiter.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.State.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.County.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.City.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.PostalCode.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.StreetAddressLine.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.HouseNumber.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.HouseNumberNumeric.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.Direction.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.StreetName.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.StreetNameBase.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.StreetNameType.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.AdditionalLocator.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.UnitID.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.UnitType.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.Carrier.class,
    OctopusConsortium.Models.PDS.ADNPfITCodedCountry.CensusTract.class,
    OctopusConsortium.Models.PDS.AD.Delimiter.class,
    OctopusConsortium.Models.PDS.AD.Country.class,
    OctopusConsortium.Models.PDS.AD.State.class,
    OctopusConsortium.Models.PDS.AD.County.class,
    OctopusConsortium.Models.PDS.AD.City.class,
    OctopusConsortium.Models.PDS.AD.PostalCode.class,
    OctopusConsortium.Models.PDS.AD.StreetAddressLine.class,
    OctopusConsortium.Models.PDS.AD.HouseNumber.class,
    OctopusConsortium.Models.PDS.AD.HouseNumberNumeric.class,
    OctopusConsortium.Models.PDS.AD.Direction.class,
    OctopusConsortium.Models.PDS.AD.StreetName.class,
    OctopusConsortium.Models.PDS.AD.StreetNameBase.class,
    OctopusConsortium.Models.PDS.AD.StreetNameType.class,
    OctopusConsortium.Models.PDS.AD.AdditionalLocator.class,
    OctopusConsortium.Models.PDS.AD.UnitID.class,
    OctopusConsortium.Models.PDS.AD.UnitType.class,
    OctopusConsortium.Models.PDS.AD.Carrier.class,
    OctopusConsortium.Models.PDS.AD.CensusTract.class
})
public class ADXP
    extends ST
{

    @XmlAttribute
    protected CsAddressPartType partType;

    /**
     * Gets the value of the partType property.
     * 
     * @return
     *     possible object is
     *     {@link CsAddressPartType }
     *     
     */
    public CsAddressPartType getPartType() {
        return partType;
    }

    /**
     * Sets the value of the partType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CsAddressPartType }
     *     
     */
    public void setPartType(CsAddressPartType value) {
        this.partType = value;
    }

}
