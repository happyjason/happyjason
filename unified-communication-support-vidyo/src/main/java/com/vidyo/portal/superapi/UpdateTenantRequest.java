
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="tenantData" type="{http://portal.vidyo.com/superapi/}TenantDataExtType"/>
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
    "tenantData"
})
@XmlRootElement(name = "UpdateTenantRequest")
public class UpdateTenantRequest {

    @XmlElement(required = true)
    protected TenantDataExtType tenantData;

    /**
     * 获取tenantData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TenantDataExtType }
     *     
     */
    public TenantDataExtType getTenantData() {
        return tenantData;
    }

    /**
     * 设置tenantData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TenantDataExtType }
     *     
     */
    public void setTenantData(TenantDataExtType value) {
        this.tenantData = value;
    }

}
