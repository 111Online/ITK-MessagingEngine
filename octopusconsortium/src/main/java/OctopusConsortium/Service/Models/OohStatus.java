package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlEnumValue;



public enum OohStatus {	

    @XmlEnumValue("InHours")
    InHours("InHours"),
    @XmlEnumValue("OutOfHours")
    OutOfHours("OutOfHours");
    
    private final String value;

    OohStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OohStatus fromValue(String v) {
        for (OohStatus c: OohStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}

