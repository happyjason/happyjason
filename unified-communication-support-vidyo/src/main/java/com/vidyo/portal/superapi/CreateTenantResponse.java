
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://portal.vidyo.com/superapi/}OK"/>
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
    "ok"
})
@XmlRootElement(name = "CreateTenantResponse")
public class CreateTenantResponse {

    @XmlElement(name = "OK", required = true)
    protected String ok;

    /**
     * 获取ok属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOK() {
        return ok;
    }

    /**
     * 设置ok属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOK(String value) {
        this.ok = value;
    }

}
