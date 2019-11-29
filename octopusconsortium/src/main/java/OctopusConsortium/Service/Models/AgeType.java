package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AgeType {

    @XmlEnumValue("Years")
    Years("Years"),
    @XmlEnumValue("Months")
    Months("Months"),
    @XmlEnumValue("Days")
    Days("Days");

    private final String value;

    AgeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AgeType fromValue(String v) {
        for (AgeType c: AgeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}