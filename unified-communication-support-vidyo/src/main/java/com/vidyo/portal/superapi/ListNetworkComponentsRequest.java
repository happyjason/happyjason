
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="componentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="componentType" type="{http://portal.vidyo.com/superapi/}SystemComponentType" minOccurs="0"/>
 *         &lt;element name="status" type="{http://portal.vidyo.com/superapi/}ComponentStatus" minOccurs="0"/>
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
    "componentName",
    "componentType",
    "status"
})
@XmlRootElement(name = "ListNetworkComponentsRequest")
public class ListNetworkComponentsRequest {

    protected String componentName;
    protected SystemComponentType componentType;
    protected ComponentStatus status;

    /**
     * 获取componentName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * 设置componentName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentName(String value) {
        this.componentName = value;
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
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ComponentStatus }
     *     
     */
    public ComponentStatus getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentStatus }
     *     
     */
    public void setStatus(ComponentStatus value) {
        this.status = value;
    }

}
