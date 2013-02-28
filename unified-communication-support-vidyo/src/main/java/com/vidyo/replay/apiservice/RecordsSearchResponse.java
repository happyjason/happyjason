
package com.vidyo.replay.apiservice;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="allVideosCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="searchCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="myVideosCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="webcastCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="privateCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="organizationalCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="publicCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="records" type="{http://replay.vidyo.com/apiservice}Record" maxOccurs="unbounded" minOccurs="0"/>
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
    "allVideosCount",
    "searchCount",
    "myVideosCount",
    "webcastCount",
    "newCount",
    "privateCount",
    "organizationalCount",
    "publicCount",
    "records"
})
@XmlRootElement(name = "RecordsSearchResponse")
public class RecordsSearchResponse {

    protected int allVideosCount;
    protected int searchCount;
    protected int myVideosCount;
    protected int webcastCount;
    protected int newCount;
    protected int privateCount;
    protected int organizationalCount;
    protected int publicCount;
    protected List<Record> records;

    /**
     * 获取allVideosCount属性的值。
     * 
     */
    public int getAllVideosCount() {
        return allVideosCount;
    }

    /**
     * 设置allVideosCount属性的值。
     * 
     */
    public void setAllVideosCount(int value) {
        this.allVideosCount = value;
    }

    /**
     * 获取searchCount属性的值。
     * 
     */
    public int getSearchCount() {
        return searchCount;
    }

    /**
     * 设置searchCount属性的值。
     * 
     */
    public void setSearchCount(int value) {
        this.searchCount = value;
    }

    /**
     * 获取myVideosCount属性的值。
     * 
     */
    public int getMyVideosCount() {
        return myVideosCount;
    }

    /**
     * 设置myVideosCount属性的值。
     * 
     */
    public void setMyVideosCount(int value) {
        this.myVideosCount = value;
    }

    /**
     * 获取webcastCount属性的值。
     * 
     */
    public int getWebcastCount() {
        return webcastCount;
    }

    /**
     * 设置webcastCount属性的值。
     * 
     */
    public void setWebcastCount(int value) {
        this.webcastCount = value;
    }

    /**
     * 获取newCount属性的值。
     * 
     */
    public int getNewCount() {
        return newCount;
    }

    /**
     * 设置newCount属性的值。
     * 
     */
    public void setNewCount(int value) {
        this.newCount = value;
    }

    /**
     * 获取privateCount属性的值。
     * 
     */
    public int getPrivateCount() {
        return privateCount;
    }

    /**
     * 设置privateCount属性的值。
     * 
     */
    public void setPrivateCount(int value) {
        this.privateCount = value;
    }

    /**
     * 获取organizationalCount属性的值。
     * 
     */
    public int getOrganizationalCount() {
        return organizationalCount;
    }

    /**
     * 设置organizationalCount属性的值。
     * 
     */
    public void setOrganizationalCount(int value) {
        this.organizationalCount = value;
    }

    /**
     * 获取publicCount属性的值。
     * 
     */
    public int getPublicCount() {
        return publicCount;
    }

    /**
     * 设置publicCount属性的值。
     * 
     */
    public void setPublicCount(int value) {
        this.publicCount = value;
    }

    /**
     * Gets the value of the records property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the records property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Record }
     * 
     * 
     */
    public List<Record> getRecords() {
        if (records == null) {
            records = new ArrayList<Record>();
        }
        return this.records;
    }

}
