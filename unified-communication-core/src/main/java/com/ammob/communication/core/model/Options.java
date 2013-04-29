package com.ammob.communication.core.model;


import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="t_options", uniqueConstraints = @UniqueConstraint(columnNames="option_name") )
@Indexed
@XmlRootElement
public class Options extends BaseObject implements Serializable {
	private static final long serialVersionUID = -2566688777359820727L;
	private Long optionId;
    private String optionName;
    private String optionValue;
    private String autoload;

    @Id @GeneratedValue(strategy=IDENTITY) @DocumentId    
    public Long getOptionId() {
        return this.optionId;
    }
    
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
    
    @Column(name="option_name", unique=true, nullable=false, length=64)
    @Field
    public String getOptionName() {
        return this.optionName;
    }
    
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    
    @Column(name="option_value", nullable=false)
    @Field
    public String getOptionValue() {
        return this.optionValue;
    }
    
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
    
    @Column(name="autoload", nullable=false, length=20)
    @Field
    public String getAutoload() {
        return this.autoload;
    }
    
    public void setAutoload(String autoload) {
        this.autoload = autoload;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Options pojo = (Options) o;

        if (optionName != null ? !optionName.equals(pojo.optionName) : pojo.optionName != null) return false;
        if (optionValue != null ? !optionValue.equals(pojo.optionValue) : pojo.optionValue != null) return false;
        if (autoload != null ? !autoload.equals(pojo.autoload) : pojo.autoload != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (optionName != null ? optionName.hashCode() : 0);
        result = 31 * result + (optionValue != null ? optionValue.hashCode() : 0);
        result = 31 * result + (autoload != null ? autoload.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("optionId").append("='").append(getOptionId()).append("', ");
        sb.append("optionName").append("='").append(getOptionName()).append("', ");
        sb.append("optionValue").append("='").append(getOptionValue()).append("', ");
        sb.append("autoload").append("='").append(getAutoload()).append("'");
        sb.append("]");
      
        return sb.toString();
    }
}
