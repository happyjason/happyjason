
package com.vidyo.portal.superapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>IpcAccessControl complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="IpcAccessControl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="level" type="{http://portal.vidyo.com/superapi/}IpcAccessControlLevel"/>
 *         &lt;element name="accessMode" type="{http://portal.vidyo.com/superapi/}IpcAccessControlAccessMode" minOccurs="0"/>
 *         &lt;element name="routerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpcAccessControl", propOrder = {
    "level",
    "accessMode",
    "routerID"
})
public class IpcAccessControl {

    @XmlElement(required = true)
    protected IpcAccessControlLevel level;
    @XmlElementRef(name = "accessMode", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<IpcAccessControlAccessMode> accessMode;
    @XmlElementRef(name = "routerID", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> routerID;

    /**
     * 获取level属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IpcAccessControlLevel }
     *     
     */
    public IpcAccessControlLevel getLevel() {
        return level;
    }

    /**
     * 设置level属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IpcAccessControlLevel }
     *     
     */
    public void setLevel(IpcAccessControlLevel value) {
        this.level = value;
    }

    /**
     * 获取accessMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IpcAccessControlAccessMode }{@code >}
     *     
     */
    public JAXBElement<IpcAccessControlAccessMode> getAccessMode() {
        return accessMode;
    }

    /**
     * 设置accessMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IpcAccessControlAccessMode }{@code >}
     *     
     */
    public void setAccessMode(JAXBElement<IpcAccessControlAccessMode> value) {
        this.accessMode = value;
    }

    /**
     * 获取routerID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRouterID() {
        return routerID;
    }

    /**
     * 设置routerID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRouterID(JAXBElement<String> value) {
        this.routerID = value;
    }

}
