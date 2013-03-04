package com.ammob.communication.vidyo.model;

import com.ammob.communication.core.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used to represent available tenants in the database.
 */
@Entity
@Table(name = "t_ext_vidyo_tenant")
@Indexed
@XmlRootElement
public class Tenant extends BaseObject implements Serializable {
	private static final long serialVersionUID = -6907585098285228850L;
	
	private Long id;
	private String name;
    private String description;
    private String url;
    private String vidyoReplayUrl;
    private String adminName;
    private String adminPassword;
    private String cdrUsername;
    private String cdrPassword;
    private Integer installNumber;					// max-500
    private Integer seatNumber;						// max-10000
    private Integer lineNumber;						// max-10
    private Integer executiveNumber;				// max-0
    private Integer vidyoRoomNumber;
    private Integer vidyoPanoramaNumber;
    private Integer dialIn;
    private Integer extensionPrefix;
    private Integer version;
    private Date cdrSynchroTime;
    private Date cdrSchedulerTime;
    private boolean cdr;
    private boolean license;
    private boolean enabled;
    
	/**
     * Default constructor - creates a new instance with no values set.
     */
    public Tenant() {
    }
    
    /**
     * Create a new instance and set the name.
     *
     * @param name name of the role.
     */
    public Tenant(final String name) {
        this.name = name;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(length = 20, nullable=false, unique = true)
    @Field
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="url", nullable=false, unique = true)
    @Field
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name="vidyo_replay_url")
    public String getVidyoReplayUrl() {
		return vidyoReplayUrl;
	}

	public void setVidyoReplayUrl(String vidyoReplayUrl) {
		this.vidyoReplayUrl = vidyoReplayUrl;
	}

	@Column(name="description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="admin_name", nullable=false, length=168)
    public String getAdminName() {
        return this.adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    @Column(name="admin_password", nullable=false, length=168)
    public String getAdminPassword() {
        return this.adminPassword;
    }
    
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Transient
	public String getCdrUsername() {
		return cdrUsername;
	}

	public void setCdrUsername(String cdrUsername) {
		this.cdrUsername = cdrUsername;
	}
	
    @Column(name="cdr_password", length=168)
	public String getCdrPassword() {
		return cdrPassword;
	}

	public void setCdrPassword(String cdrPassword) {
		this.cdrPassword = cdrPassword;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="cdr_synchro_time", length=19)
    public Date getCdrSynchroTime() {
		return cdrSynchroTime;
	}

	public void setCdrSynchroTime(Date cdrSynchroTime) {
		this.cdrSynchroTime = cdrSynchroTime;
	}
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="cdr_scheduler_time", length=19)
	public Date getCdrSchedulerTime() {
		return cdrSchedulerTime;
	}

	public void setCdrSchedulerTime(Date cdrSchedulerTime) {
		this.cdrSchedulerTime = cdrSchedulerTime;
	}
	
    @Column(name="extension_prefix", length=3)
	public Integer getExtensionPrefix() {
		return extensionPrefix;
	}
    
	public void setExtensionPrefix(Integer extensionPrefix) {
		this.extensionPrefix = extensionPrefix;
	}
	
    @Version
    public Integer getVersion() {
        return version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    
	@Column(name="dial_in")
	public Integer getDialIn() {
		return dialIn;
	}

	public void setDialIn(Integer dialIn) {
		this.dialIn = dialIn;
	}

	@Column(name="install_number")
	public Integer getInstallNumber() {
		return installNumber;
	}

	public void setInstallNumber(Integer installNumber) {
		this.installNumber = installNumber;
	}
	
	@Column(name="seat_number")
	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	@Column(name="line_number")
	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	@Column(name="executive_number")
	public Integer getExecutiveNumber() {
		return executiveNumber;
	}

	public void setExecutiveNumber(Integer executiveNumber) {
		this.executiveNumber = executiveNumber;
	}
	
	@Column(name="vidyo_panorama_number")
	public Integer getVidyoPanoramaNumber() {
		return vidyoPanoramaNumber;
	}

	public void setVidyoPanoramaNumber(Integer vidyoPanoramaNumber) {
		this.vidyoPanoramaNumber = vidyoPanoramaNumber;
	}
	
	@Column(name="vidyo_room_number")
	public Integer getVidyoRoomNumber() {
		return vidyoRoomNumber;
	}

	public void setVidyoRoomNumber(Integer vidyoRoomNumber) {
		this.vidyoRoomNumber = vidyoRoomNumber;
	}
	
	@Column(name = "cdr", nullable=false, columnDefinition="bit(1) default 0")
	public boolean isCdr() {
		return cdr;
	}

	public void setCdr(boolean cdr) {
		this.cdr = cdr;
	}
	
    @Column(name = "enabled", nullable=false, columnDefinition="bit(1) default 1")
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Column(name = "license", nullable=false, columnDefinition="bit(1) default 0")
    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }
	
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tenant pojo = (Tenant) o;

        if (url != null ? !url.equals(pojo.url) : pojo.url != null) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (adminName != null ? !adminName.equals(pojo.adminName) : pojo.adminName != null) return false;
        if (adminPassword != null ? !adminPassword.equals(pojo.adminPassword) : pojo.adminPassword != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (url != null ? url.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (adminPassword != null ? adminPassword.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("url").append("='").append(getUrl()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("adminName").append("='").append(getAdminName()).append("', ");
        sb.append("adminPassword").append("='").append(getAdminPassword()).append("'");
        sb.append("]");
      
        return sb.toString();
    }
}
