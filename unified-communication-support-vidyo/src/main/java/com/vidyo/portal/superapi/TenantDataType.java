
package com.vidyo.portal.superapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TenantDataType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TenantDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenantName" type="{http://portal.vidyo.com/superapi/}TenantNamePattern"/>
 *         &lt;element name="tenantUrl" type="{http://portal.vidyo.com/superapi/}TenantUrlPattern"/>
 *         &lt;element name="extensionPrefix" type="{http://portal.vidyo.com/superapi/}TenantExtensionPrefixPattern"/>
 *         &lt;element name="dialinNumber" type="{http://portal.vidyo.com/superapi/}String20" minOccurs="0"/>
 *         &lt;element name="vidyoReplayUrl" type="{http://portal.vidyo.com/superapi/}TenantUrlPattern" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numOfInstalls" type="{http://portal.vidyo.com/superapi/}NonNegativeInt"/>
 *         &lt;element name="numOfSeats" type="{http://portal.vidyo.com/superapi/}NonNegativeInt"/>
 *         &lt;element name="numOfLines" type="{http://portal.vidyo.com/superapi/}NonNegativeInt"/>
 *         &lt;element name="numOfExecutives" type="{http://portal.vidyo.com/superapi/}NonNegativeInt"/>
 *         &lt;element name="numOfPanoramas" type="{http://portal.vidyo.com/superapi/}NonNegativeInt"/>
 *         &lt;element name="enableGuestLogin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="allowedTenantList" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vidyoManager" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vidyoProxyList" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowedVidyoGatewayList" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowedVidyoReplayRecorderList" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowedVidyoRepalyList" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowedLocationTagList" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *         &lt;element name="vidyoMobileAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ipcAllowOutbound" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ipcAllowInbound" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenantDataType", propOrder = {
    "tenantName",
    "tenantUrl",
    "extensionPrefix",
    "dialinNumber",
    "vidyoReplayUrl",
    "description",
    "numOfInstalls",
    "numOfSeats",
    "numOfLines",
    "numOfExecutives",
    "numOfPanoramas",
    "enableGuestLogin",
    "allowedTenantList",
    "vidyoManager",
    "vidyoProxyList",
    "allowedVidyoGatewayList",
    "allowedVidyoReplayRecorderList",
    "allowedVidyoRepalyList",
    "allowedLocationTagList",
    "vidyoMobileAllowed",
    "ipcAllowOutbound",
    "ipcAllowInbound"
})
@XmlSeeAlso({
    TenantDataExtType.class
})
public class TenantDataType {

    @XmlElement(required = true)
    protected String tenantName;
    @XmlElement(required = true)
    protected String tenantUrl;
    @XmlElement(required = true)
    protected String extensionPrefix;
    @XmlElementRef(name = "dialinNumber", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dialinNumber;
    @XmlElementRef(name = "vidyoReplayUrl", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vidyoReplayUrl;
    @XmlElementRef(name = "description", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> description;
    protected int numOfInstalls;
    protected int numOfSeats;
    protected int numOfLines;
    protected int numOfExecutives;
    protected int numOfPanoramas;
    @XmlElementRef(name = "enableGuestLogin", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> enableGuestLogin;
    @XmlElement(nillable = true)
    protected List<Integer> allowedTenantList;
    protected int vidyoManager;
    @XmlElement(nillable = true)
    protected List<Integer> vidyoProxyList;
    @XmlElement(nillable = true)
    protected List<Integer> allowedVidyoGatewayList;
    @XmlElement(nillable = true)
    protected List<Integer> allowedVidyoReplayRecorderList;
    @XmlElement(nillable = true)
    protected List<Integer> allowedVidyoRepalyList;
    @XmlElement(type = Integer.class)
    protected List<Integer> allowedLocationTagList;
    @XmlElementRef(name = "vidyoMobileAllowed", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> vidyoMobileAllowed;
    @XmlElementRef(name = "ipcAllowOutbound", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> ipcAllowOutbound;
    @XmlElementRef(name = "ipcAllowInbound", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> ipcAllowInbound;

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
     * 获取tenantUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantUrl() {
        return tenantUrl;
    }

    /**
     * 设置tenantUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantUrl(String value) {
        this.tenantUrl = value;
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDialinNumber() {
        return dialinNumber;
    }

    /**
     * 设置dialinNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDialinNumber(JAXBElement<String> value) {
        this.dialinNumber = value;
    }

    /**
     * 获取vidyoReplayUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVidyoReplayUrl() {
        return vidyoReplayUrl;
    }

    /**
     * 设置vidyoReplayUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVidyoReplayUrl(JAXBElement<String> value) {
        this.vidyoReplayUrl = value;
    }

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescription(JAXBElement<String> value) {
        this.description = value;
    }

    /**
     * 获取numOfInstalls属性的值。
     * 
     */
    public int getNumOfInstalls() {
        return numOfInstalls;
    }

    /**
     * 设置numOfInstalls属性的值。
     * 
     */
    public void setNumOfInstalls(int value) {
        this.numOfInstalls = value;
    }

    /**
     * 获取numOfSeats属性的值。
     * 
     */
    public int getNumOfSeats() {
        return numOfSeats;
    }

    /**
     * 设置numOfSeats属性的值。
     * 
     */
    public void setNumOfSeats(int value) {
        this.numOfSeats = value;
    }

    /**
     * 获取numOfLines属性的值。
     * 
     */
    public int getNumOfLines() {
        return numOfLines;
    }

    /**
     * 设置numOfLines属性的值。
     * 
     */
    public void setNumOfLines(int value) {
        this.numOfLines = value;
    }

    /**
     * 获取numOfExecutives属性的值。
     * 
     */
    public int getNumOfExecutives() {
        return numOfExecutives;
    }

    /**
     * 设置numOfExecutives属性的值。
     * 
     */
    public void setNumOfExecutives(int value) {
        this.numOfExecutives = value;
    }

    /**
     * 获取numOfPanoramas属性的值。
     * 
     */
    public int getNumOfPanoramas() {
        return numOfPanoramas;
    }

    /**
     * 设置numOfPanoramas属性的值。
     * 
     */
    public void setNumOfPanoramas(int value) {
        this.numOfPanoramas = value;
    }

    /**
     * 获取enableGuestLogin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEnableGuestLogin() {
        return enableGuestLogin;
    }

    /**
     * 设置enableGuestLogin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEnableGuestLogin(JAXBElement<Boolean> value) {
        this.enableGuestLogin = value;
    }

    /**
     * Gets the value of the allowedTenantList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedTenantList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedTenantList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAllowedTenantList() {
        if (allowedTenantList == null) {
            allowedTenantList = new ArrayList<Integer>();
        }
        return this.allowedTenantList;
    }

    /**
     * 获取vidyoManager属性的值。
     * 
     */
    public int getVidyoManager() {
        return vidyoManager;
    }

    /**
     * 设置vidyoManager属性的值。
     * 
     */
    public void setVidyoManager(int value) {
        this.vidyoManager = value;
    }

    /**
     * Gets the value of the vidyoProxyList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vidyoProxyList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVidyoProxyList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getVidyoProxyList() {
        if (vidyoProxyList == null) {
            vidyoProxyList = new ArrayList<Integer>();
        }
        return this.vidyoProxyList;
    }

    /**
     * Gets the value of the allowedVidyoGatewayList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedVidyoGatewayList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedVidyoGatewayList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAllowedVidyoGatewayList() {
        if (allowedVidyoGatewayList == null) {
            allowedVidyoGatewayList = new ArrayList<Integer>();
        }
        return this.allowedVidyoGatewayList;
    }

    /**
     * Gets the value of the allowedVidyoReplayRecorderList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedVidyoReplayRecorderList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedVidyoReplayRecorderList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAllowedVidyoReplayRecorderList() {
        if (allowedVidyoReplayRecorderList == null) {
            allowedVidyoReplayRecorderList = new ArrayList<Integer>();
        }
        return this.allowedVidyoReplayRecorderList;
    }

    /**
     * Gets the value of the allowedVidyoRepalyList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedVidyoRepalyList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedVidyoRepalyList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAllowedVidyoRepalyList() {
        if (allowedVidyoRepalyList == null) {
            allowedVidyoRepalyList = new ArrayList<Integer>();
        }
        return this.allowedVidyoRepalyList;
    }

    /**
     * Gets the value of the allowedLocationTagList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowedLocationTagList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowedLocationTagList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAllowedLocationTagList() {
        if (allowedLocationTagList == null) {
            allowedLocationTagList = new ArrayList<Integer>();
        }
        return this.allowedLocationTagList;
    }

    /**
     * 获取vidyoMobileAllowed属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getVidyoMobileAllowed() {
        return vidyoMobileAllowed;
    }

    /**
     * 设置vidyoMobileAllowed属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setVidyoMobileAllowed(JAXBElement<Boolean> value) {
        this.vidyoMobileAllowed = value;
    }

    /**
     * 获取ipcAllowOutbound属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIpcAllowOutbound() {
        return ipcAllowOutbound;
    }

    /**
     * 设置ipcAllowOutbound属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIpcAllowOutbound(JAXBElement<Boolean> value) {
        this.ipcAllowOutbound = value;
    }

    /**
     * 获取ipcAllowInbound属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getIpcAllowInbound() {
        return ipcAllowInbound;
    }

    /**
     * 设置ipcAllowInbound属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setIpcAllowInbound(JAXBElement<Boolean> value) {
        this.ipcAllowInbound = value;
    }

}
