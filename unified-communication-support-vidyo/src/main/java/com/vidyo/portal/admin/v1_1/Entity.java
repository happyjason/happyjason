
package com.vidyo.portal.admin.v1_1;

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
 *         &lt;element name="entityID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
 *         &lt;element name="participantID" type="{http://portal.vidyo.com/admin/v1_1}EntityID" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/admin/v1_1}EntityType"/>
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/admin/v1_1}Language" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/admin/v1_1}MemberStatus" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/admin/v1_1}MemberMode" minOccurs="0"/>
 *         &lt;element name="canCallDirect" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canJoinMeeting" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/admin/v1_1}RoomStatus" minOccurs="0"/>
 *         &lt;element ref="{http://portal.vidyo.com/admin/v1_1}RoomMode" minOccurs="0"/>
 *         &lt;element name="canControl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="audio" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="video" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="appshare" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "entityID",
    "participantID",
    "entityType",
    "displayName",
    "extension",
    "description",
    "language",
    "memberStatus",
    "memberMode",
    "canCallDirect",
    "canJoinMeeting",
    "roomStatus",
    "roomMode",
    "canControl",
    "audio",
    "video",
    "appshare"
})
@XmlRootElement(name = "Entity")
public class Entity {

    protected int entityID;
    @XmlElementRef(name = "participantID", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> participantID;
    @XmlElement(name = "EntityType", required = true)
    protected String entityType;
    @XmlElement(required = true)
    protected String displayName;
    @XmlElement(required = true)
    protected String extension;
    protected String description;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "MemberStatus")
    protected String memberStatus;
    @XmlElement(name = "MemberMode")
    protected String memberMode;
    protected Boolean canCallDirect;
    protected Boolean canJoinMeeting;
    @XmlElement(name = "RoomStatus")
    protected String roomStatus;
    @XmlElement(name = "RoomMode")
    protected RoomMode roomMode;
    protected Boolean canControl;
    @XmlElementRef(name = "audio", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> audio;
    @XmlElementRef(name = "video", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> video;
    @XmlElementRef(name = "appshare", namespace = "http://portal.vidyo.com/admin/v1_1", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> appshare;

    /**
     * 获取entityID属性的值。
     * 
     */
    public int getEntityID() {
        return entityID;
    }

    /**
     * 设置entityID属性的值。
     * 
     */
    public void setEntityID(int value) {
        this.entityID = value;
    }

    /**
     * 获取participantID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getParticipantID() {
        return participantID;
    }

    /**
     * 设置participantID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setParticipantID(JAXBElement<Integer> value) {
        this.participantID = value;
    }

    /**
     * 获取entityType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * 设置entityType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityType(String value) {
        this.entityType = value;
    }

    /**
     * 获取displayName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置displayName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * 获取extension属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 设置extension属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtension(String value) {
        this.extension = value;
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
     * 获取language属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置language属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * 获取memberStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberStatus() {
        return memberStatus;
    }

    /**
     * 设置memberStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberStatus(String value) {
        this.memberStatus = value;
    }

    /**
     * 获取memberMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberMode() {
        return memberMode;
    }

    /**
     * 设置memberMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberMode(String value) {
        this.memberMode = value;
    }

    /**
     * 获取canCallDirect属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanCallDirect() {
        return canCallDirect;
    }

    /**
     * 设置canCallDirect属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanCallDirect(Boolean value) {
        this.canCallDirect = value;
    }

    /**
     * 获取canJoinMeeting属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanJoinMeeting() {
        return canJoinMeeting;
    }

    /**
     * 设置canJoinMeeting属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanJoinMeeting(Boolean value) {
        this.canJoinMeeting = value;
    }

    /**
     * 获取roomStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomStatus() {
        return roomStatus;
    }

    /**
     * 设置roomStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomStatus(String value) {
        this.roomStatus = value;
    }

    /**
     * 获取roomMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RoomMode }
     *     
     */
    public RoomMode getRoomMode() {
        return roomMode;
    }

    /**
     * 设置roomMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RoomMode }
     *     
     */
    public void setRoomMode(RoomMode value) {
        this.roomMode = value;
    }

    /**
     * 获取canControl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanControl() {
        return canControl;
    }

    /**
     * 设置canControl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanControl(Boolean value) {
        this.canControl = value;
    }

    /**
     * 获取audio属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAudio() {
        return audio;
    }

    /**
     * 设置audio属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAudio(JAXBElement<Boolean> value) {
        this.audio = value;
    }

    /**
     * 获取video属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getVideo() {
        return video;
    }

    /**
     * 设置video属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setVideo(JAXBElement<Boolean> value) {
        this.video = value;
    }

    /**
     * 获取appshare属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAppshare() {
        return appshare;
    }

    /**
     * 设置appshare属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAppshare(JAXBElement<Boolean> value) {
        this.appshare = value;
    }

}
