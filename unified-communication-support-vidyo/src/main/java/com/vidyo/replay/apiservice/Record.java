
package com.vidyo.replay.apiservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 *                         This elements array will be returned after user search request
 *                         
 * 
 * <p>Record complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Record">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="guid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tenantName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userFullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dateCreatedString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="framerate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recordScope" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roomName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="recorderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webcast" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locked" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="externalPlaybackLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Record", propOrder = {
    "id",
    "guid",
    "tenantName",
    "userName",
    "userFullName",
    "dateCreated",
    "dateCreatedString",
    "endTime",
    "duration",
    "resolution",
    "framerate",
    "pin",
    "recordScope",
    "title",
    "roomName",
    "fileLink",
    "recorderId",
    "webcast",
    "tags",
    "comments",
    "locked",
    "externalPlaybackLink"
})
public class Record {

    protected int id;
    @XmlElement(required = true)
    protected String guid;
    @XmlElement(required = true)
    protected String tenantName;
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String userFullName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    @XmlElement(required = true)
    protected String dateCreatedString;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endTime;
    @XmlElement(required = true)
    protected String duration;
    @XmlElement(required = true)
    protected String resolution;
    protected int framerate;
    @XmlElement(required = true, nillable = true)
    protected String pin;
    @XmlElement(required = true)
    protected String recordScope;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String roomName;
    @XmlElement(required = true)
    protected String fileLink;
    @XmlElement(required = true)
    protected String recorderId;
    protected boolean webcast;
    @XmlElement(required = true, nillable = true)
    protected String tags;
    @XmlElement(required = true, nillable = true)
    protected String comments;
    protected boolean locked;
    @XmlElement(required = true, nillable = true)
    protected String externalPlaybackLink;

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
     * 获取guid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 设置guid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuid(String value) {
        this.guid = value;
    }

    /**
     * 获取tenantName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * 设置tenantName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantName(String value) {
        this.tenantName = value;
    }

    /**
     * 获取userName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置userName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * 获取userFullName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserFullName() {
        return userFullName;
    }

    /**
     * 设置userFullName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserFullName(String value) {
        this.userFullName = value;
    }

    /**
     * 获取dateCreated属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * 设置dateCreated属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }

    /**
     * 获取dateCreatedString属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateCreatedString() {
        return dateCreatedString;
    }

    /**
     * 设置dateCreatedString属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateCreatedString(String value) {
        this.dateCreatedString = value;
    }

    /**
     * 获取endTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * 设置endTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
    }

    /**
     * 获取duration属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置duration属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * 获取resolution属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * 设置resolution属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * 获取framerate属性的值。
     * 
     */
    public int getFramerate() {
        return framerate;
    }

    /**
     * 设置framerate属性的值。
     * 
     */
    public void setFramerate(int value) {
        this.framerate = value;
    }

    /**
     * 获取pin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
        return pin;
    }

    /**
     * 设置pin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin(String value) {
        this.pin = value;
    }

    /**
     * 获取recordScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordScope() {
        return recordScope;
    }

    /**
     * 设置recordScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordScope(String value) {
        this.recordScope = value;
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
     * 获取roomName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * 设置roomName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomName(String value) {
        this.roomName = value;
    }

    /**
     * 获取fileLink属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileLink() {
        return fileLink;
    }

    /**
     * 设置fileLink属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileLink(String value) {
        this.fileLink = value;
    }

    /**
     * 获取recorderId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecorderId() {
        return recorderId;
    }

    /**
     * 设置recorderId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecorderId(String value) {
        this.recorderId = value;
    }

    /**
     * 获取webcast属性的值。
     * 
     */
    public boolean isWebcast() {
        return webcast;
    }

    /**
     * 设置webcast属性的值。
     * 
     */
    public void setWebcast(boolean value) {
        this.webcast = value;
    }

    /**
     * 获取tags属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置tags属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTags(String value) {
        this.tags = value;
    }

    /**
     * 获取comments属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置comments属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * 获取locked属性的值。
     * 
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * 设置locked属性的值。
     * 
     */
    public void setLocked(boolean value) {
        this.locked = value;
    }

    /**
     * 获取externalPlaybackLink属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalPlaybackLink() {
        return externalPlaybackLink;
    }

    /**
     * 设置externalPlaybackLink属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalPlaybackLink(String value) {
        this.externalPlaybackLink = value;
    }

}
