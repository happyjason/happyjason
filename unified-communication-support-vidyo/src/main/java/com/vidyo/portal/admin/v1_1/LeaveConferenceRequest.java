
package com.vidyo.portal.admin.v1_1;

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
 *         &lt;element name="conferenceID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
 *         &lt;element name="participantID" type="{http://portal.vidyo.com/admin/v1_1}EntityID"/>
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
    "participantID"
})
@XmlRootElement(name = "LeaveConferenceRequest")
public class LeaveConferenceRequest {

    protected int conferenceID;
    protected int participantID;

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
     * 获取participantID属性的值。
     * 
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * 设置participantID属性的值。
     * 
     */
    public void setParticipantID(int value) {
        this.participantID = value;
    }

}
