
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
 *         &lt;element name="addIpcDomainList" type="{http://portal.vidyo.com/superapi/}NotEmptyString" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="removeIpcDomainList" type="{http://portal.vidyo.com/superapi/}NotEmptyString" maxOccurs="unbounded" minOccurs="0"/>
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
    "addIpcDomainList",
    "removeIpcDomainList"
})
@XmlRootElement(name = "setIpcDomainsRequest")
public class SetIpcDomainsRequest {

    @XmlElement(nillable = true)
    protected List<String> addIpcDomainList;
    @XmlElement(nillable = true)
    protected List<String> removeIpcDomainList;

    /**
     * Gets the value of the addIpcDomainList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addIpcDomainList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddIpcDomainList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddIpcDomainList() {
        if (addIpcDomainList == null) {
            addIpcDomainList = new ArrayList<String>();
        }
        return this.addIpcDomainList;
    }

    /**
     * Gets the value of the removeIpcDomainList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the removeIpcDomainList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemoveIpcDomainList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRemoveIpcDomainList() {
        if (removeIpcDomainList == null) {
            removeIpcDomainList = new ArrayList<String>();
        }
        return this.removeIpcDomainList;
    }

}
