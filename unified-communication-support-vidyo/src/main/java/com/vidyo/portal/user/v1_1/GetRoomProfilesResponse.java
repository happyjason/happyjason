
package com.vidyo.portal.user.v1_1;

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
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="roomProfile" type="{http://portal.vidyo.com/user/v1_1}RoomProfile" maxOccurs="unbounded" minOccurs="0"/>
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
    "total",
    "roomProfile"
})
@XmlRootElement(name = "GetRoomProfilesResponse")
public class GetRoomProfilesResponse {

    protected int total;
    @XmlElement(nillable = true)
    protected List<RoomProfile> roomProfile;

    /**
     * 获取total属性的值。
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置total属性的值。
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * Gets the value of the roomProfile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomProfile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomProfile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomProfile }
     * 
     * 
     */
    public List<RoomProfile> getRoomProfile() {
        if (roomProfile == null) {
            roomProfile = new ArrayList<RoomProfile>();
        }
        return this.roomProfile;
    }

}
