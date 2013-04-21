
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SortingDirection的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="SortingDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ASC"/>
 *     &lt;enumeration value="DESC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SortingDirection")
@XmlEnum
public enum SortingDirection {

    ASC,
    DESC;

    public String value() {
        return name();
    }

    public static SortingDirection fromValue(String v) {
        return valueOf(v);
    }

}
