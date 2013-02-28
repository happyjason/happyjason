
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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recordScope" type="{http://replay.vidyo.com/apiservice}recordScopeUpdate" minOccurs="0"/>
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locked" type="{http://replay.vidyo.com/apiservice}recordLocked" minOccurs="0"/>
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
    "id",
    "title",
    "comments",
    "tags",
    "recordScope",
    "pin",
    "locked"
})
@XmlRootElement(name = "UpdateRecordRequest")
public class UpdateRecordRequest {

    protected int id;
    protected String title;
    @XmlElementRef(name = "comments", namespace = "http://replay.vidyo.com/apiservice", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "tags", namespace = "http://replay.vidyo.com/apiservice", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tags;
    @XmlElementRef(name = "recordScope", namespace = "http://replay.vidyo.com/apiservice", type = JAXBElement.class, required = false)
    protected JAXBElement<RecordScopeUpdate> recordScope;
    @XmlElementRef(name = "pin", namespace = "http://replay.vidyo.com/apiservice", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pin;
    @XmlElementRef(name = "locked", namespace = "http://replay.vidyo.com/apiservice", type = JAXBElement.class, required = false)
    protected JAXBElement<RecordLocked> locked;

    /**
     * 获取id属性的值。
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * 获取title属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置title属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * 获取comments属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getComments() {
        return comments;
    }

    /**
     * 设置comments属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComments(JAXBElement<String> value) {
        this.comments = value;
    }

    /**
     * 获取tags属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTags() {
        return tags;
    }

    /**
     * 设置tags属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTags(JAXBElement<String> value) {
        this.tags = value;
    }

    /**
     * 获取recordScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RecordScopeUpdate }{@code >}
     *     
     */
    public JAXBElement<RecordScopeUpdate> getRecordScope() {
        return recordScope;
    }

    /**
     * 设置recordScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RecordScopeUpdate }{@code >}
     *     
     */
    public void setRecordScope(JAXBElement<RecordScopeUpdate> value) {
        this.recordScope = value;
    }

    /**
     * 获取pin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPin() {
        return pin;
    }

    /**
     * 设置pin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPin(JAXBElement<String> value) {
        this.pin = value;
    }

    /**
     * 获取locked属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RecordLocked }{@code >}
     *     
     */
    public JAXBElement<RecordLocked> getLocked() {
        return locked;
    }

    /**
     * 设置locked属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RecordLocked }{@code >}
     *     
     */
    public void setLocked(JAXBElement<RecordLocked> value) {
        this.locked = value;
    }

}
