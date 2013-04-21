
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SingleComponentDataType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SingleComponentDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="componentType" type="{http://portal.vidyo.com/superapi/}SystemComponentType"/>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="runningVersion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="alarm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="swVer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="componentStatus" type="{http://portal.vidyo.com/superapi/}ComponentStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleComponentDataType", propOrder = {
    "identifier",
    "displayName",
    "componentType",
    "ipAddress",
    "runningVersion",
    "version",
    "alarm",
    "swVer",
    "componentStatus"
})
public class SingleComponentDataType {

    @XmlElement(required = true)
    protected String identifier;
    @XmlElement(required = true)
    protected String displayName;
    @XmlElement(required = true)
    protected SystemComponentType componentType;
    @XmlElement(required = true)
    protected String ipAddress;
    protected Integer runningVersion;
    protected Integer version;
    @XmlElement(required = true)
    protected String alarm;
    @XmlElement(required = true)
    protected String swVer;
    @XmlElement(required = true)
    protected ComponentStatus componentStatus;

    /**
     * 获取identifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 设置identifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * 获取displayName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置displayName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * 获取componentType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemComponentType }
     *     
     */
    public SystemComponentType getComponentType() {
        return componentType;
    }

    /**
     * 设置componentType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemComponentType }
     *     
     */
    public void setComponentType(SystemComponentType value) {
        this.componentType = value;
    }

    /**
     * 获取ipAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置ipAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    /**
     * 获取runningVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRunningVersion() {
        return runningVersion;
    }

    /**
     * 设置runningVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRunningVersion(Integer value) {
        this.runningVersion = value;
    }

    /**
     * 获取version属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置version属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVersion(Integer value) {
        this.version = value;
    }

    /**
     * 获取alarm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlarm() {
        return alarm;
    }

    /**
     * 设置alarm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlarm(String value) {
        this.alarm = value;
    }

    /**
     * 获取swVer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwVer() {
        return swVer;
    }

    /**
     * 设置swVer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwVer(String value) {
        this.swVer = value;
    }

    /**
     * 获取componentStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ComponentStatus }
     *     
     */
    public ComponentStatus getComponentStatus() {
        return componentStatus;
    }

    /**
     * 设置componentStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentStatus }
     *     
     */
    public void setComponentStatus(ComponentStatus value) {
        this.componentStatus = value;
    }

}
