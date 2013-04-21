
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>IpcAccessControlAccessMode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="IpcAccessControlAccessMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Allow"/>
 *     &lt;enumeration value="Block"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IpcAccessControlAccessMode")
@XmlEnum
public enum IpcAccessControlAccessMode {

    @XmlEnumValue("Allow")
    ALLOW("Allow"),
    @XmlEnumValue("Block")
    BLOCK("Block");
    private final String value;

    IpcAccessControlAccessMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IpcAccessControlAccessMode fromValue(String v) {
        for (IpcAccessControlAccessMode c: IpcAccessControlAccessMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
