
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SingleTenantDataType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SingleTenantDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenantId" type="{http://portal.vidyo.com/superapi/}EntityID"/>
 *         &lt;element name="tenantName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tenantURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extensionPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dialinNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vidyoReplayUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vidyoMobileAllowed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleTenantDataType", propOrder = {
    "tenantId",
    "tenantName",
    "tenantURL",
    "extensionPrefix",
    "dialinNumber",
    "vidyoReplayUrl",
    "description",
    "vidyoMobileAllowed"
})
public class SingleTenantDataType {

    protected int tenantId;
    @XmlElement(required = true)
    protected String tenantName;
    protected String tenantURL;
    @XmlElement(required = true)
    protected String extensionPrefix;
    protected String dialinNumber;
    protected String vidyoReplayUrl;
    protected String description;
    protected int vidyoMobileAllowed;

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

    /**
     * 获取tenantName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * 设置tenantName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantName(String value) {
        this.tenantName = value;
    }

    /**
     * 获取tenantURL属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantURL() {
        return tenantURL;
    }

    /**
     * 设置tenantURL属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantURL(String value) {
        this.tenantURL = value;
    }

    /**
     * 获取extensionPrefix属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionPrefix() {
        return extensionPrefix;
    }

    /**
     * 设置extensionPrefix属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionPrefix(String value) {
        this.extensionPrefix = value;
    }

    /**
     * 获取dialinNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialinNumber() {
        return dialinNumber;
    }

    /**
     * 设置dialinNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialinNumber(String value) {
        this.dialinNumber = value;
    }

    /**
     * 获取vidyoReplayUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVidyoReplayUrl() {
        return vidyoReplayUrl;
    }

    /**
     * 设置vidyoReplayUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVidyoReplayUrl(String value) {
        this.vidyoReplayUrl = value;
    }

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取vidyoMobileAllowed属性的值。
     * 
     */
    public int getVidyoMobileAllowed() {
        return vidyoMobileAllowed;
    }

    /**
     * 设置vidyoMobileAllowed属性的值。
     * 
     */
    public void setVidyoMobileAllowed(int value) {
        this.vidyoMobileAllowed = value;
    }

}
