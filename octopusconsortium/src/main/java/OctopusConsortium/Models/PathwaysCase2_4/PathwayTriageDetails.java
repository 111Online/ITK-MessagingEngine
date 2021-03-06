//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.12 at 02:51:14 PM BST 
//


package OctopusConsortium.Models.PathwaysCase2_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="pathwayTriage">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="finish" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="triageDisposition" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="initialDispCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="initialDispText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="timeReached" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="finalDisposition" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="finalDispCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="finalDisptext" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="override" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Higher"/>
 *                                   &lt;enumeration value="Lower"/>
 *                                   &lt;enumeration value="CallerUnlikelyToFollow"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="transferCodeDetails" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="transferCode">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="type" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="T1"/>
 *                                           &lt;enumeration value="T2"/>
 *                                           &lt;enumeration value="T3"/>
 *                                           &lt;enumeration value="T4"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="systemFlags" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="systemFlag">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Trauma"/>
 *                                   &lt;enumeration value="NonTrauma"/>
 *                                   &lt;enumeration value="SceneSafe"/>
 *                                   &lt;enumeration value="SceneUnsafe"/>
 *                                   &lt;enumeration value="Police"/>
 *                                   &lt;enumeration value="Fire"/>
 *                                   &lt;enumeration value="CATALevel1"/>
 *                                   &lt;enumeration value="CATALevel2"/>
 *                                   &lt;enumeration value="CATALevel3"/>
 *                                   &lt;enumeration value="CATALevel4"/>
 *                                   &lt;enumeration value="CATBLevel1"/>
 *                                   &lt;enumeration value="CATBLevel2"/>
 *                                   &lt;enumeration value="CATBLevel3"/>
 *                                   &lt;enumeration value="CATBLevel4"/>
 *                                   &lt;enumeration value="Trapped"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="user">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="skillSet">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="T1"/>
 *                                   &lt;enumeration value="T2"/>
 *                                   &lt;enumeration value="T3"/>
 *                                   &lt;enumeration value="T4"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="triageLineDetails" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="triageLine">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                                       &lt;element name="finish" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                                       &lt;element name="questionType">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="PathwaysSelection"/>
 *                                             &lt;enumeration value="MultipleChoice"/>
 *                                             &lt;enumeration value="SingleAnswer"/>
 *                                             &lt;enumeration value="Disposition"/>
 *                                             &lt;enumeration value="HomeCareAdvice"/>
 *                                             &lt;enumeration value="InterimCareAdvice"/>
 *                                             &lt;enumeration value="SetVariable"/>
 *                                             &lt;enumeration value="QueryVariable"/>
 *                                             &lt;enumeration value="CMS Lookup"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="question" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="triageLogicId">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="pathwayVersion">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                     &lt;element name="minor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                     &lt;element name="subRevision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="pathwayId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="pathwayOrderNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="questionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="questionText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="questionRationale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="answers">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence maxOccurs="unbounded">
 *                                                           &lt;element name="answer">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="rationale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                   &lt;attribute name="selected" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="dispositionRationale" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="careAdviceKeywordDetails" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence maxOccurs="unbounded">
 *                                                 &lt;element name="careAdviceKeyword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="dispositionInstruction" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="itemDetails">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence maxOccurs="unbounded">
 *                                                           &lt;element name="item">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence>
 *                                                                     &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                     &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="careAdviceDetails" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence maxOccurs="unbounded">
 *                                                 &lt;element name="careAdvice">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="topic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="itemDetails">
 *                                                             &lt;complexType>
 *                                                               &lt;complexContent>
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                   &lt;sequence maxOccurs="unbounded">
 *                                                                     &lt;element name="item">
 *                                                                       &lt;complexType>
 *                                                                         &lt;complexContent>
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                             &lt;sequence>
 *                                                                               &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                               &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                                             &lt;/sequence>
 *                                                                           &lt;/restriction>
 *                                                                         &lt;/complexContent>
 *                                                                       &lt;/complexType>
 *                                                                     &lt;/element>
 *                                                                   &lt;/sequence>
 *                                                                 &lt;/restriction>
 *                                                               &lt;/complexContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                         &lt;/sequence>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="clinicalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="reportText">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="positive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="userComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="action">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="End"/>
 *                                             &lt;enumeration value="Next"/>
 *                                             &lt;enumeration value="Change"/>
 *                                             &lt;enumeration value="Restart"/>
 *                                             &lt;enumeration value="EarlyExit"/>
 *                                             &lt;enumeration value="Back"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="includeInReport" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                       &lt;element name="systemFlags" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence maxOccurs="unbounded">
 *                                                 &lt;element name="systemFlag">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                       &lt;enumeration value="Trauma"/>
 *                                                       &lt;enumeration value="NonTrauma"/>
 *                                                       &lt;enumeration value="SceneSafe"/>
 *                                                       &lt;enumeration value="SceneUnsafe"/>
 *                                                       &lt;enumeration value="Police"/>
 *                                                       &lt;enumeration value="Fire"/>
 *                                                       &lt;enumeration value="CATALevel1"/>
 *                                                       &lt;enumeration value="CATALevel2"/>
 *                                                       &lt;enumeration value="CATALevel3"/>
 *                                                       &lt;enumeration value="CATALevel4"/>
 *                                                       &lt;enumeration value="CATBLevel1"/>
 *                                                       &lt;enumeration value="CATBLevel2"/>
 *                                                       &lt;enumeration value="CATBLevel3"/>
 *                                                       &lt;enumeration value="CATBLevel4"/>
 *                                                       &lt;enumeration value="Trapped"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="origSite">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="siteName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="pathwaysContentVersion" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="software">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="callerIsPatient" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "pathwayTriage"
})
public class PathwayTriageDetails {

    @XmlElement(required = true)
    protected List<PathwayTriage> pathwayTriage;

    /**
     * Gets the value of the pathwayTriage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pathwayTriage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPathwayTriage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PathwayTriage }
     * 
     * 
     */
    public List<PathwayTriage> getPathwayTriage() {
        if (pathwayTriage == null) {
            pathwayTriage = new ArrayList<PathwayTriage>();
        }
        return this.pathwayTriage;
    }

}
