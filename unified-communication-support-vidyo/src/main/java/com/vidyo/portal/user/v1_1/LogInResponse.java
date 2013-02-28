
package com.vidyo.portal.user.v1_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="pak" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vmaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxyaddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loctag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pak",
    "vmaddress",
    "proxyaddress",
    "loctag"
})
@XmlRootElement(name = "LogInResponse")
public class LogInResponse {

    @XmlElement(required = true)
    protected String pak;
    @XmlElementRef(name = "vmaddress", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vmaddress;
    @XmlElementRef(name = "proxyaddress", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> proxyaddress;
    @XmlElementRef(name = "loctag", namespace = "http://portal.vidyo.com/user/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loctag;

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

}
