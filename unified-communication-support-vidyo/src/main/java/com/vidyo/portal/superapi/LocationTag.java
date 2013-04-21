
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LocationTag complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LocationTag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locationTagID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="locationTagName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationTag", propOrder = {
    "locationTagID",
    "locationTagName"
})
public class LocationTag {

    protected int locationTagID;
    @XmlElement(required = true)
    protected String locationTagName;

    /**
     * 获取locationTagID属性的值。
     * 
     */
    public int getLocationTagID() {
        return locationTagID;
    }

    /**
     * 设置locationTagID属性的值。
     * 
     */
    public void setLocationTagID(int value) {
        this.locationTagID = value;
    }

    /**
     * 获取locationTagName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationTagName() {
        return locationTagName;
    }

    /**
     * 设置locationTagName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationTagName(String value) {
        this.locationTagName = value;
    }

}
