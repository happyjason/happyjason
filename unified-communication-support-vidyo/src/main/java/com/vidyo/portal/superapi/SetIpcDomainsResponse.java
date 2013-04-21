
package com.vidyo.portal.superapi;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="notAddedIpcDomainList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="notRemovedIpcDomainList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    "ok",
    "notAddedIpcDomainList",
    "notRemovedIpcDomainList"
})
@XmlRootElement(name = "setIpcDomainsResponse")
public class SetIpcDomainsResponse {

    @XmlElement(name = "OK", required = true)
    protected String ok;
    @XmlElement(nillable = true)
    protected List<String> notAddedIpcDomainList;
    @XmlElement(nillable = true)
    protected List<String> notRemovedIpcDomainList;

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

    /**
     * Gets the value of the notAddedIpcDomainList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notAddedIpcDomainList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotAddedIpcDomainList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNotAddedIpcDomainList() {
        if (notAddedIpcDomainList == null) {
            notAddedIpcDomainList = new ArrayList<String>();
        }
        return this.notAddedIpcDomainList;
    }

    /**
     * Gets the value of the notRemovedIpcDomainList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notRemovedIpcDomainList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotRemovedIpcDomainList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNotRemovedIpcDomainList() {
        if (notRemovedIpcDomainList == null) {
            notRemovedIpcDomainList = new ArrayList<String>();
        }
        return this.notRemovedIpcDomainList;
    }

}
