//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 01:11:57 PM BST 
//


package OctopusConsortium.Models.ITK;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PN.NHS.PersonNameType2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PN.NHS.PersonNameType2">
 *   &lt;complexContent>
 *     &lt;restriction base="{urn:hl7-org:v3}PN.NHS.Internal">
 *       &lt;sequence>
 *         &lt;element name="prefix" type="{urn:hl7-org:v3}en.prefix" minOccurs="0"/>
 *         &lt;element name="given" type="{urn:hl7-org:v3}en.given" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="family" type="{urn:hl7-org:v3}en.family" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_cs_EntityNameUse" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PN.NHS.PersonNameType2")
public class PNNHSPersonNameType2
    extends PNNHSInternal
{


}
