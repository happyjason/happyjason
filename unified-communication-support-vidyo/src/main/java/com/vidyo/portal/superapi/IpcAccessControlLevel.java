
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>IpcAccessControlLevel的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="IpcAccessControlLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tenant"/>
 *     &lt;enumeration value="System"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IpcAccessControlLevel")
@XmlEnum
public enum IpcAccessControlLevel {

    @XmlEnumValue("Tenant")
    TENANT("Tenant"),
    @XmlEnumValue("System")
    SYSTEM("System");
    private final String value;

    IpcAccessControlLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IpcAccessControlLevel fromValue(String v) {
        for (IpcAccessControlLevel c: IpcAccessControlLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
