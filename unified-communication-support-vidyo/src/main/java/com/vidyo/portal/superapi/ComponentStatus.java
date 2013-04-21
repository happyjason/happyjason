
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ComponentStatus的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ComponentStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="UP"/>
 *     &lt;enumeration value="DOWN"/>
 *     &lt;enumeration value="DISABLED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ComponentStatus")
@XmlEnum
public enum ComponentStatus {

    NEW,
    UP,
    DOWN,
    DISABLED;

    public String value() {
        return name();
    }

    public static ComponentStatus fromValue(String v) {
        return valueOf(v);
    }

}
