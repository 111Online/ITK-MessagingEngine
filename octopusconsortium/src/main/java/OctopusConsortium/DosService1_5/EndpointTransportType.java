
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contactType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="contactType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="dts"/&gt;
 *     &lt;enumeration value="itk"/&gt;
 *     &lt;enumeration value="telno"/&gt;
 *     &lt;enumeration value="email"/&gt;
 *     &lt;enumeration value="faxno"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "contactType")
@XmlEnum
public enum EndpointTransportType {

    @XmlEnumValue("dts")
    DTS("dts"),
    @XmlEnumValue("itk")
    ITK("itk"),
    @XmlEnumValue("telno")
    TELNO("telno"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("faxno")
    FAXNO("faxno");
    private final String value;

    EndpointTransportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public boolean equalsValue(String v){
    	if (v == null)
    		throw new IllegalArgumentException(v);

    	return (this.value().equalsIgnoreCase(v));
    }
    
    public static EndpointTransportType fromValue(String v) {
    	if (v == null)
    		throw new IllegalArgumentException(v);
    	
    	v = v.toLowerCase();
    	
        for (EndpointTransportType c: EndpointTransportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
