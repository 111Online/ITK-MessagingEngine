//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:44:55 PM BST 
//


package OctopusConsortium.Models.RCS;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for TableRowGroupType_X.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TableRowGroupType_X">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="tbody"/>
 *     &lt;enumeration value="tfoot"/>
 *     &lt;enumeration value="thead"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TableRowGroupTypeX {

    @XmlEnumValue("tbody")
    TBODY("tbody"),
    @XmlEnumValue("tfoot")
    TFOOT("tfoot"),
    @XmlEnumValue("thead")
    THEAD("thead");
    private final String value;

    TableRowGroupTypeX(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TableRowGroupTypeX fromValue(String v) {
        for (TableRowGroupTypeX c: TableRowGroupTypeX.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}