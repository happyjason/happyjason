
package com.vidyo.portal.superapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="tenantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenantURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="start" type="{http://portal.vidyo.com/superapi/}IntHolder" minOccurs="0"/>
 *         &lt;element name="limit" type="{http://portal.vidyo.com/superapi/}IntHolder" minOccurs="0"/>
 *         &lt;element name="sortBy" type="{http://portal.vidyo.com/superapi/}TenantSortingField" minOccurs="0"/>
 *         &lt;element name="dir" type="{http://portal.vidyo.com/superapi/}SortingDirection" minOccurs="0"/>
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
    "tenantName",
    "tenantURL",
    "start",
    "limit",
    "sortBy",
    "dir"
})
@XmlRootElement(name = "ListTenantsRequest")
public class ListTenantsRequest {

    protected String tenantName;
    protected String tenantURL;
    @XmlElementRef(name = "start", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> start;
    @XmlElementRef(name = "limit", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> limit;
    protected TenantSortingField sortBy;
    protected SortingDirection dir;

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
     * 获取start属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getStart() {
        return start;
    }

    /**
     * 设置start属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setStart(JAXBElement<Integer> value) {
        this.start = value;
    }

    /**
     * 获取limit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getLimit() {
        return limit;
    }

    /**
     * 设置limit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setLimit(JAXBElement<Integer> value) {
        this.limit = value;
    }

    /**
     * 获取sortBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TenantSortingField }
     *     
     */
    public TenantSortingField getSortBy() {
        return sortBy;
    }

    /**
     * 设置sortBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TenantSortingField }
     *     
     */
    public void setSortBy(TenantSortingField value) {
        this.sortBy = value;
    }

    /**
     * 获取dir属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SortingDirection }
     *     
     */
    public SortingDirection getDir() {
        return dir;
    }

    /**
     * 设置dir属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SortingDirection }
     *     
     */
    public void setDir(SortingDirection value) {
        this.dir = value;
    }

}
