
package com.vidyo.portal.superapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TenantDataExtType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TenantDataExtType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://portal.vidyo.com/superapi/}TenantDataType">
 *       &lt;sequence>
 *         &lt;element name="tenantID" type="{http://portal.vidyo.com/superapi/}EntityID"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenantDataExtType", propOrder = {
    "tenantID"
})
public class TenantDataExtType
    extends TenantDataType
{

    protected int tenantID;

    /**
     * 获取tenantID属性的值。
     * 
     */
    public int getTenantID() {
        return tenantID;
    }

    /**
     * 设置tenantID属性的值。
     * 
     */
    public void setTenantID(int value) {
        this.tenantID = value;
    }

}
