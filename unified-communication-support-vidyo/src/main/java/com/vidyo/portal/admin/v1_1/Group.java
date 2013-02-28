
package com.vidyo.portal.admin.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 						Group Description on VidyoPortal.
 *                         All the members and rooms belong to the same group share the same properties.
 * 					
 * 
 * <p>Group complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Group">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groupID" type="{http://portal.vidyo.com/admin/v1_1}EntityID" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="roomMaxUsers" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userMaxBandWidthIn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userMaxBandWidthOut" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowRecording" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Group", propOrder = {
    "groupID",
    "name",
    "roomMaxUsers",
    "userMaxBandWidthIn",
    "userMaxBandWidthOut",
    "description",
    "allowRecording"
})
public class Group {

    protected Integer groupID;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String roomMaxUsers;
    @XmlElement(required = true)
    protected String userMaxBandWidthIn;
    @XmlElement(required = true)
    protected String userMaxBandWidthOut;
    protected String description;
    protected Boolean allowRecording;

    /**
     * 获取groupID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGroupID() {
        return groupID;
    }

    /**
     * 设置groupID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGroupID(Integer value) {
        this.groupID = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取roomMaxUsers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomMaxUsers() {
        return roomMaxUsers;
    }

    /**
     * 设置roomMaxUsers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomMaxUsers(String value) {
        this.roomMaxUsers = value;
    }

    /**
     * 获取userMaxBandWidthIn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMaxBandWidthIn() {
        return userMaxBandWidthIn;
    }

    /**
     * 设置userMaxBandWidthIn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMaxBandWidthIn(String value) {
        this.userMaxBandWidthIn = value;
    }

    /**
     * 获取userMaxBandWidthOut属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMaxBandWidthOut() {
        return userMaxBandWidthOut;
    }

    /**
     * 设置userMaxBandWidthOut属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMaxBandWidthOut(String value) {
        this.userMaxBandWidthOut = value;
    }

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取allowRecording属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowRecording() {
        return allowRecording;
    }

    /**
     * 设置allowRecording属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowRecording(Boolean value) {
        this.allowRecording = value;
    }

}
