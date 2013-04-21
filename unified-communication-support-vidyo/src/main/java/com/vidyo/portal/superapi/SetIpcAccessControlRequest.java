
package com.vidyo.portal.superapi;

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
 *         &lt;element name="ipcAccessControl" type="{http://portal.vidyo.com/superapi/}IpcAccessControl"/>
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
    "ipcAccessControl"
})
@XmlRootElement(name = "setIpcAccessControlRequest")
public class SetIpcAccessControlRequest {

    @XmlElement(required = true)
    protected IpcAccessControl ipcAccessControl;

    /**
     * 获取ipcAccessControl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IpcAccessControl }
     *     
     */
    public IpcAccessControl getIpcAccessControl() {
        return ipcAccessControl;
    }

    /**
     * 设置ipcAccessControl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IpcAccessControl }
     *     
     */
    public void setIpcAccessControl(IpcAccessControl value) {
        this.ipcAccessControl = value;
    }

}
