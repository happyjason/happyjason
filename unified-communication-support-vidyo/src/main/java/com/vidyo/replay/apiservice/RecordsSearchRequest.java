
package com.vidyo.replay.apiservice;

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
 *         &lt;element name="tenantName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roomFilter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="usernameFilter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordScope" type="{http://replay.vidyo.com/apiservice}recordScopeFilter"/>
 *         &lt;element name="sortBy" type="{http://replay.vidyo.com/apiservice}sortBy"/>
 *         &lt;element name="dir" type="{http://replay.vidyo.com/apiservice}sortDirection"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="webcast" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "roomFilter",
    "usernameFilter",
    "query",
    "recordScope",
    "sortBy",
    "dir",
    "limit",
    "start",
    "webcast"
})
@XmlRootElement(name = "RecordsSearchRequest")
public class RecordsSearchRequest {

    @XmlElement(required = true, nillable = true)
    protected String tenantName;
    @XmlElement(required = true, nillable = true)
    protected String roomFilter;
    @XmlElement(required = true, nillable = true)
    protected String usernameFilter;
    @XmlElement(required = true, nillable = true)
    protected String query;
    @XmlElement(required = true, nillable = true)
    protected RecordScopeFilter recordScope;
    @XmlElement(required = true, nillable = true)
    protected SortBy sortBy;
    @XmlElement(required = true, nillable = true)
    protected SortDirection dir;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer limit;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer start;
    @XmlElement(required = true, type = Boolean.class, nillable = true)
    protected Boolean webcast;

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
     * 获取roomFilter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomFilter() {
        return roomFilter;
    }

    /**
     * 设置roomFilter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomFilter(String value) {
        this.roomFilter = value;
    }

    /**
     * 获取usernameFilter属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsernameFilter() {
        return usernameFilter;
    }

    /**
     * 设置usernameFilter属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsernameFilter(String value) {
        this.usernameFilter = value;
    }

    /**
     * 获取query属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuery() {
        return query;
    }

    /**
     * 设置query属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuery(String value) {
        this.query = value;
    }

    /**
     * 获取recordScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RecordScopeFilter }
     *     
     */
    public RecordScopeFilter getRecordScope() {
        return recordScope;
    }

    /**
     * 设置recordScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RecordScopeFilter }
     *     
     */
    public void setRecordScope(RecordScopeFilter value) {
        this.recordScope = value;
    }

    /**
     * 获取sortBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SortBy }
     *     
     */
    public SortBy getSortBy() {
        return sortBy;
    }

    /**
     * 设置sortBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SortBy }
     *     
     */
    public void setSortBy(SortBy value) {
        this.sortBy = value;
    }

    /**
     * 获取dir属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SortDirection }
     *     
     */
    public SortDirection getDir() {
        return dir;
    }

    /**
     * 设置dir属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SortDirection }
     *     
     */
    public void setDir(SortDirection value) {
        this.dir = value;
    }

    /**
     * 获取limit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 设置limit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLimit(Integer value) {
        this.limit = value;
    }

    /**
     * 获取start属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 设置start属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStart(Integer value) {
        this.start = value;
    }

    /**
     * 获取webcast属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWebcast() {
        return webcast;
    }

    /**
     * 设置webcast属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWebcast(Boolean value) {
        this.webcast = value;
    }

}
