package OctopusConsortium.Models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OOHServiceStatus {

    @XmlEnumValue("InHours")
    InHours("InHours"),
    @XmlEnumValue("OOHAvailable")
    OOHAvailable("OOHAvailable"),
    @XmlEnumValue("OOHNotAvailable")
    OOHNotAvailable("OOHNotAvailable");

    private final String value;

    OOHServiceStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OOHServiceStatus fromValue(String v) {
        for (OOHServiceStatus c: OOHServiceStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}