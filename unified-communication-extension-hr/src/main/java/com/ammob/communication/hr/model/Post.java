package com.ammob.communication.hr.model;

import com.ammob.communication.core.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="t_ext_hr_post")
@Indexed
@XmlRootElement
public class Post extends BaseObject implements Serializable {
	private static final long serialVersionUID = -652052677825967712L;
	private Long id;
    private String name;
    private String responsibility;
    private String require;

    @Id
    @DocumentId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="name", nullable=false, length=60)
    @Field
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="responsibility", length=65535)
    @Field
    public String getResponsibility() {
        return this.responsibility;
    }
    
    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
    
    @Column(name="require", length=65535)
    @Field
    public String getRequire() {
        return this.require;
    }
    
    public void setRequire(String require) {
        this.require = require;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post pojo = (Post) o;

        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (responsibility != null ? !responsibility.equals(pojo.responsibility) : pojo.responsibility != null) return false;
        if (require != null ? !require.equals(pojo.require) : pojo.require != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (responsibility != null ? responsibility.hashCode() : 0);
        result = 31 * result + (require != null ? require.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("responsibility").append("='").append(getResponsibility()).append("', ");
        sb.append("require").append("='").append(getRequire()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
