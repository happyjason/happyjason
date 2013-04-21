
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenantId" type="{http://portal.vidyo.com/superapi/}EntityID"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tenantId"
})
@XmlRootElement(name = "DeleteTenantRequest")
public class DeleteTenantRequest {

    protected int tenantId;

    /**
     * 获取tenantId属性的值。
     * 
     */
    public int getTenantId() {
        return tenantId;
    }

    /**
     * 设置tenantId属性的值。
     * 
     */
    public void setTenantId(int value) {
        this.tenantId = value;
    }

}
