
package com.vidyo.portal.guest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="guestID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isLocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasPin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxyaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loctag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="un" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pak" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portalVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;any minOccurs="0"/>
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
    "guestID",
    "isLocked",
    "hasPin",
    "vmaddress",
    "proxyaddress",
    "loctag",
    "un",
    "pak",
    "portal",
    "portalVersion",
    "any"
})
@XmlRootElement(name = "LogInAsGuestResponse")
public class LogInAsGuestResponse {

    protected int guestID;
    protected boolean isLocked;
    protected boolean hasPin;
    @XmlElementRef(name = "vmaddress", namespace = "http://portal.vidyo.com/guest", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vmaddress;
    @XmlElementRef(name = "proxyaddress", namespace = "http://portal.vidyo.com/guest", type = JAXBElement.class, required = false)
    protected JAXBElement<String> proxyaddress;
    @XmlElementRef(name = "loctag", namespace = "http://portal.vidyo.com/guest", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loctag;
    @XmlElement(required = true)
    protected String un;
    @XmlElement(required = true)
    protected String pak;
    @XmlElement(required = true)
    protected String portal;
    @XmlElement(required = true)
    protected String portalVersion;
    @XmlAnyElement(lax = true)
    protected Object any;

    /**
     * 获取guestID属性的值。
     * 
     */
    public int getGuestID() {
        return guestID;
    }

    /**
     * 设置guestID属性的值。
     * 
     */
    public void setGuestID(int value) {
        this.guestID = value;
    }

    /**
     * 获取isLocked属性的值。
     * 
     */
    public boolean isIsLocked() {
        return isLocked;
    }

    /**
     * 设置isLocked属性的值。
     * 
     */
    public void setIsLocked(boolean value) {
        this.isLocked = value;
    }

    /**
     * 获取hasPin属性的值。
     * 
     */
    public boolean isHasPin() {
        return hasPin;
    }

    /**
     * 设置hasPin属性的值。
     * 
     */
    public void setHasPin(boolean value) {
        this.hasPin = value;
    }

    /**
     * 获取vmaddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVmaddress() {
        return vmaddress;
    }

    /**
     * 设置vmaddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVmaddress(JAXBElement<String> value) {
        this.vmaddress = value;
    }

    /**
     * 获取proxyaddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProxyaddress() {
        return proxyaddress;
    }

    /**
     * 设置proxyaddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProxyaddress(JAXBElement<String> value) {
        this.proxyaddress = value;
    }

    /**
     * 获取loctag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoctag() {
        return loctag;
    }

    /**
     * 设置loctag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoctag(JAXBElement<String> value) {
        this.loctag = value;
    }

    /**
     * 获取un属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUn() {
        return un;
    }

    /**
     * 设置un属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUn(String value) {
        this.un = value;
    }

    /**
     * 获取pak属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPak() {
        return pak;
    }

    /**
     * 设置pak属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPak(String value) {
        this.pak = value;
    }

    /**
     * 获取portal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortal() {
        return portal;
    }

    /**
     * 设置portal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortal(String value) {
        this.portal = value;
    }

    /**
     * 获取portalVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortalVersion() {
        return portalVersion;
    }

    /**
     * 设置portalVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortalVersion(String value) {
        this.portalVersion = value;
    }

    /**
     * 获取any属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * 设置any属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

}
