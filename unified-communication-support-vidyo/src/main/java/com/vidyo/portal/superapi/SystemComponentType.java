
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SystemComponentType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="SystemComponentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VidyoRouter"/>
 *     &lt;enumeration value="VidyoProxy"/>
 *     &lt;enumeration value="VidyoManager"/>
 *     &lt;enumeration value="VidyoReplay"/>
 *     &lt;enumeration value="VidyoGateway"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SystemComponentType")
@XmlEnum
public enum SystemComponentType {

    @XmlEnumValue("VidyoRouter")
    VIDYO_ROUTER("VidyoRouter"),
    @XmlEnumValue("VidyoProxy")
    VIDYO_PROXY("VidyoProxy"),
    @XmlEnumValue("VidyoManager")
    VIDYO_MANAGER("VidyoManager"),
    @XmlEnumValue("VidyoReplay")
    VIDYO_REPLAY("VidyoReplay"),
    @XmlEnumValue("VidyoGateway")
    VIDYO_GATEWAY("VidyoGateway");
    private final String value;

    SystemComponentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemComponentType fromValue(String v) {
        for (SystemComponentType c: SystemComponentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
