
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ServiceComponentType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceComponentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VidyoManager"/>
 *     &lt;enumeration value="VidyoGateway"/>
 *     &lt;enumeration value="VidyoProxy"/>
 *     &lt;enumeration value="VidyoRecorder"/>
 *     &lt;enumeration value="VidyoReplay"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceComponentType")
@XmlEnum
public enum ServiceComponentType {

    @XmlEnumValue("VidyoManager")
    VIDYO_MANAGER("VidyoManager"),
    @XmlEnumValue("VidyoGateway")
    VIDYO_GATEWAY("VidyoGateway"),
    @XmlEnumValue("VidyoProxy")
    VIDYO_PROXY("VidyoProxy"),
    @XmlEnumValue("VidyoRecorder")
    VIDYO_RECORDER("VidyoRecorder"),
    @XmlEnumValue("VidyoReplay")
    VIDYO_REPLAY("VidyoReplay");
    private final String value;

    ServiceComponentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceComponentType fromValue(String v) {
        for (ServiceComponentType c: ServiceComponentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
