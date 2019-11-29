//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 01:11:57 PM BST 
//


package OctopusConsortium.Models.ITK;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ActDocumentStructureClass_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActDocumentStructureClass_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DOCBODY"/>
 *     &lt;enumeration value="DOCCNTNT"/>
 *     &lt;enumeration value="DOCLSTITM"/>
 *     &lt;enumeration value="DOCPARA"/>
 *     &lt;enumeration value="DOCSECT"/>
 *     &lt;enumeration value="DOCTBL"/>
 *     &lt;enumeration value="LINKHTML"/>
 *     &lt;enumeration value="LOCALATTR"/>
 *     &lt;enumeration value="LOCALMRKP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ActDocumentStructureClassX {

    DOCBODY,
    DOCCNTNT,
    DOCLSTITM,
    DOCPARA,
    DOCSECT,
    DOCTBL,
    LINKHTML,
    LOCALATTR,
    LOCALMRKP;

    public String value() {
        return name();
    }

    public static ActDocumentStructureClassX fromValue(String v) {
        return valueOf(v);
    }

}
