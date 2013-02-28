
package com.vidyo.replay.apiservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>recordScopeUpdate的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="recordScopeUpdate">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="private"/>
 *     &lt;enumeration value="organization"/>
 *     &lt;enumeration value="public"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "recordScopeUpdate")
@XmlEnum
public enum RecordScopeUpdate {

    @XmlEnumValue("private")
    PRIVATE("private"),
    @XmlEnumValue("organization")
    ORGANIZATION("organization"),
    @XmlEnumValue("public")
    PUBLIC("public");
    private final String value;

    RecordScopeUpdate(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecordScopeUpdate fromValue(String v) {
        for (RecordScopeUpdate c: RecordScopeUpdate.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
