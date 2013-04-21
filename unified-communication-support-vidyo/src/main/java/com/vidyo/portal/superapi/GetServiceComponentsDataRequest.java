
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
 *         &lt;element name="serviceComponentType" type="{http://portal.vidyo.com/superapi/}ServiceComponentType" minOccurs="0"/>
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
    "serviceComponentType"
})
@XmlRootElement(name = "GetServiceComponentsDataRequest")
public class GetServiceComponentsDataRequest {

    @XmlElementRef(name = "serviceComponentType", namespace = "http://portal.vidyo.com/superapi/", type = JAXBElement.class, required = false)
    protected JAXBElement<ServiceComponentType> serviceComponentType;

    /**
     * 获取serviceComponentType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceComponentType }{@code >}
     *     
     */
    public JAXBElement<ServiceComponentType> getServiceComponentType() {
        return serviceComponentType;
    }

    /**
     * 设置serviceComponentType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceComponentType }{@code >}
     *     
     */
    public void setServiceComponentType(JAXBElement<ServiceComponentType> value) {
        this.serviceComponentType = value;
    }

}
