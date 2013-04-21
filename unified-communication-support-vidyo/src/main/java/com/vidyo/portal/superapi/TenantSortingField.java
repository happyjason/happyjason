
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TenantSortingField的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="TenantSortingField">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="tenantName"/>
 *     &lt;enumeration value="tenantURL"/>
 *     &lt;enumeration value="extensionPrefix"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TenantSortingField")
@XmlEnum
public enum TenantSortingField {

    @XmlEnumValue("tenantName")
    TENANT_NAME("tenantName"),
    @XmlEnumValue("tenantURL")
    TENANT_URL("tenantURL"),
    @XmlEnumValue("extensionPrefix")
    EXTENSION_PREFIX("extensionPrefix");
    private final String value;

    TenantSortingField(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TenantSortingField fromValue(String v) {
        for (TenantSortingField c: TenantSortingField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
