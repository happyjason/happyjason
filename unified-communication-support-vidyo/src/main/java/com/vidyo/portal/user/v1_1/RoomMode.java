
package com.vidyo.portal.user.v1_1;

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
 *         &lt;element name="roomURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isLocked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hasPIN" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="roomPIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webCastURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasWebCastPIN" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="webCastPIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasModeratorPIN" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="moderatorPIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "roomURL",
    "isLocked",
    "hasPIN",
    "roomPIN",
    "webCastURL",
    "hasWebCastPIN",
    "webCastPIN",
    "hasModeratorPIN",
    "moderatorPIN"
})
@XmlRootElement(name = "RoomMode")
public class RoomMode {

    @XmlElementRef(name = "roomURL", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> roomURL;
    protected boolean isLocked;
    protected boolean hasPIN;
    @XmlElementRef(name = "roomPIN", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> roomPIN;
    @XmlElementRef(name = "webCastURL", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> webCastURL;
    protected Boolean hasWebCastPIN;
    @XmlElementRef(name = "webCastPIN", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> webCastPIN;
    @XmlElementRef(name = "hasModeratorPIN", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> hasModeratorPIN;
    @XmlElementRef(name = "moderatorPIN", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> moderatorPIN;

    /**
     * 获取roomURL属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRoomURL() {
        return roomURL;
    }

    /**
     * 设置roomURL属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRoomURL(JAXBElement<String> value) {
        this.roomURL = value;
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
     * 获取hasPIN属性的值。
     * 
     */
    public boolean isHasPIN() {
        return hasPIN;
    }

    /**
     * 设置hasPIN属性的值。
     * 
     */
    public void setHasPIN(boolean value) {
        this.hasPIN = value;
    }

    /**
     * 获取roomPIN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRoomPIN() {
        return roomPIN;
    }

    /**
     * 设置roomPIN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRoomPIN(JAXBElement<String> value) {
        this.roomPIN = value;
    }

    /**
     * 获取webCastURL属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWebCastURL() {
        return webCastURL;
    }

    /**
     * 设置webCastURL属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWebCastURL(JAXBElement<String> value) {
        this.webCastURL = value;
    }

    /**
     * 获取hasWebCastPIN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasWebCastPIN() {
        return hasWebCastPIN;
    }

    /**
     * 设置hasWebCastPIN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasWebCastPIN(Boolean value) {
        this.hasWebCastPIN = value;
    }

    /**
     * 获取webCastPIN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWebCastPIN() {
        return webCastPIN;
    }

    /**
     * 设置webCastPIN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWebCastPIN(JAXBElement<String> value) {
        this.webCastPIN = value;
    }

    /**
     * 获取hasModeratorPIN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getHasModeratorPIN() {
        return hasModeratorPIN;
    }

    /**
     * 设置hasModeratorPIN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setHasModeratorPIN(JAXBElement<Boolean> value) {
        this.hasModeratorPIN = value;
    }

    /**
     * 获取moderatorPIN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getModeratorPIN() {
        return moderatorPIN;
    }

    /**
     * 设置moderatorPIN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setModeratorPIN(JAXBElement<String> value) {
        this.moderatorPIN = value;
    }

}
