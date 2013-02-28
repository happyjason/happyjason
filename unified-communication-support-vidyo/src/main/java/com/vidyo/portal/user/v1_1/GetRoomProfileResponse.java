
package com.vidyo.portal.user.v1_1;

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
 *         &lt;element name="roomProfile" type="{http://portal.vidyo.com/user/v1_1}RoomProfile"/>
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
    "roomProfile"
})
@XmlRootElement(name = "GetRoomProfileResponse")
public class GetRoomProfileResponse {

    @XmlElement(required = true, nillable = true)
    protected RoomProfile roomProfile;

    /**
     * 获取roomProfile属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RoomProfile }
     *     
     */
    public RoomProfile getRoomProfile() {
        return roomProfile;
    }

    /**
     * 设置roomProfile属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RoomProfile }
     *     
     */
    public void setRoomProfile(RoomProfile value) {
        this.roomProfile = value;
    }

}
