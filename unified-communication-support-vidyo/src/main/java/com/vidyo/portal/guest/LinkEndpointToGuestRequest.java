
package com.vidyo.portal.guest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="guestID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vrIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "eid",
    "vrIP",
    "clientType",
    "any"
})
@XmlRootElement(name = "LinkEndpointToGuestRequest")
public class LinkEndpointToGuestRequest {

    protected int guestID;
    @XmlElement(name = "EID", required = true)
    protected String eid;
    protected String vrIP;
    protected String clientType;
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
     * 获取eid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEID() {
        return eid;
    }

    /**
     * 设置eid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEID(String value) {
        this.eid = value;
    }

    /**
     * 获取vrIP属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrIP() {
        return vrIP;
    }

    /**
     * 设置vrIP属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrIP(String value) {
        this.vrIP = value;
    }

    /**
     * 获取clientType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * 设置clientType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientType(String value) {
        this.clientType = value;
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
