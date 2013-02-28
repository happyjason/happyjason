
package com.vidyo.portal.admin.v1_1;

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
 *         &lt;element name="conferenceID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
 *         &lt;element name="recorderPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="webcast" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "conferenceID",
    "recorderPrefix",
    "webcast"
})
@XmlRootElement(name = "StartRecordingRequest")
public class StartRecordingRequest {

    protected int conferenceID;
    @XmlElement(required = true)
    protected String recorderPrefix;
    protected boolean webcast;

    /**
     * 获取conferenceID属性的值。
     * 
     */
    public int getConferenceID() {
        return conferenceID;
    }

    /**
     * 设置conferenceID属性的值。
     * 
     */
    public void setConferenceID(int value) {
        this.conferenceID = value;
    }

    /**
     * 获取recorderPrefix属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecorderPrefix() {
        return recorderPrefix;
    }

    /**
     * 设置recorderPrefix属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecorderPrefix(String value) {
        this.recorderPrefix = value;
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

}
