
package com.vidyo.replay.apiservice;

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
 *         &lt;element name="GeneralFault" type="{http://replay.vidyo.com/apiservice}Exception" minOccurs="0"/>
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
    "generalFault"
})
@XmlRootElement(name = "GeneralFault")
public class GeneralFault {

    @XmlElementRef(name = "GeneralFault", namespace = "http://replay.vidyo.com/apiservice", type = JAXBElement.class, required = false)
    protected JAXBElement<Exception> generalFault;

    /**
     * 获取generalFault属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Exception }{@code >}
     *     
     */
    public JAXBElement<Exception> getGeneralFault() {
        return generalFault;
    }

    /**
     * 设置generalFault属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Exception }{@code >}
     *     
     */
    public void setGeneralFault(JAXBElement<Exception> value) {
        this.generalFault = value;
    }

}
