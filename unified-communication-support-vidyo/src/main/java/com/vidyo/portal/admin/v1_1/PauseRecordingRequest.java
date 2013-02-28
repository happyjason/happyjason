
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
 *         &lt;element name="recorderID" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "recorderID"
})
@XmlRootElement(name = "PauseRecordingRequest")
public class PauseRecordingRequest {

    protected int conferenceID;
    protected int recorderID;

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
     * 获取recorderID属性的值。
     * 
     */
    public int getRecorderID() {
        return recorderID;
    }

    /**
     * 设置recorderID属性的值。
     * 
     */
    public void setRecorderID(int value) {
        this.recorderID = value;
    }

}
