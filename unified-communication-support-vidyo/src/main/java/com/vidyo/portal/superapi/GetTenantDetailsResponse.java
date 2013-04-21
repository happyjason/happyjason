
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
 *         &lt;element name="tenantDetail" type="{http://portal.vidyo.com/superapi/}TenantDataExtType"/>
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
    "tenantDetail"
})
@XmlRootElement(name = "GetTenantDetailsResponse")
public class GetTenantDetailsResponse {

    @XmlElement(required = true)
    protected TenantDataExtType tenantDetail;

    /**
     * 获取tenantDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TenantDataExtType }
     *     
     */
    public TenantDataExtType getTenantDetail() {
        return tenantDetail;
    }

    /**
     * 设置tenantDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TenantDataExtType }
     *     
     */
    public void setTenantDetail(TenantDataExtType value) {
        this.tenantDetail = value;
    }

}
