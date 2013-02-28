package com.ammob.communication.vidyo.model;

import com.ammob.communication.core.model.BaseObject;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="ConferenceCall2"/*, catalog="portal2"*/)
@Indexed
@XmlRootElement
public class ConferenceCall extends BaseObject implements Serializable {
	private static final long serialVersionUID = 8262476146117395316L;
	
	private Long callId;
    private String tenantName;
    private String conferenceName;
    private String conferenceType;
    private String uniqueCallId;
    private String callerId;
    private String callerName;
    private String callState;
    private String routerId;
    private String gwid;
    private String gwprefix;
    private Date joinTime;
    private Date leaveTime;
    private char direction;
    private char endpointType;

    @Id 
    @GeneratedValue(strategy=IDENTITY) 
    @DocumentId    
    public Long getCallId() {
        return this.callId;
    }
    
    public void setCallId(Long callId) {
        this.callId = callId;
    }
    
    @Column(name="UniqueCallID", nullable=false, length=20)
    @Field
    public String getUniqueCallId() {
        return this.uniqueCallId;
    }
    
    public void setUniqueCallId(String uniqueCallId) {
        this.uniqueCallId = uniqueCallId;
    }
    
    @Column(name="ConferenceName", nullable=false, length=200)
    @Field
    public String getConferenceName() {
        return this.conferenceName;
    }
    
    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }
    
    @Column(name="TenantName", nullable=false, length=128)
    @Field
    public String getTenantName() {
        return this.tenantName;
    }
    
    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
    
    @Column(name="ConferenceType", nullable=false, length=2)
    @Field
    public String getConferenceType() {
        return this.conferenceType;
    }
    
    public void setConferenceType(String conferenceType) {
        this.conferenceType = conferenceType;
    }
    
    @Column(name="EndpointType", nullable=false, length=1)
    @Field
    public char getEndpointType() {
        return this.endpointType;
    }
    
    public void setEndpointType(char endpointType) {
        this.endpointType = endpointType;
    }
    
    @Column(name="CallerID", nullable=false, length=200)
    @Field
    public String getCallerId() {
        return this.callerId;
    }
    
    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }
    
    @Column(name="CallerName", length=200)
    @Field
    public String getCallerName() {
        return this.callerName;
    }
    
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="JoinTime", nullable=false, length=19)
    @Field
    public Date getJoinTime() {
        return this.joinTime;
    }
    
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LeaveTime", length=19)
    @Field
    public Date getLeaveTime() {
        return this.leaveTime;
    }
    
    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
    
    @Column(name="CallState", nullable=false, length=80)
    @Field
    public String getCallState() {
        return this.callState;
    }
    
    public void setCallState(String callState) {
        this.callState = callState;
    }
    
    @Column(name="Direction", nullable=false, length=1)
    @Field
    public char getDirection() {
        return this.direction;
    }
    
    public void setDirection(char direction) {
        this.direction = direction;
    }
    
    @Column(name="RouterID", length=128)
    @Field
    public String getRouterId() {
        return this.routerId;
    }
    
    public void setRouterId(String routerId) {
        this.routerId = routerId;
    }
    
    @Column(name="GWID", length=40)
    @Field
    public String getGwid() {
        return this.gwid;
    }
    
    public void setGwid(String gwid) {
        this.gwid = gwid;
    }
    
    @Column(name="GWPrefix", length=20)
    @Field
    public String getGwprefix() {
        return this.gwprefix;
    }
    
    public void setGwprefix(String gwprefix) {
        this.gwprefix = gwprefix;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConferenceCall pojo = (ConferenceCall) o;

        if (uniqueCallId != null ? !uniqueCallId.equals(pojo.uniqueCallId) : pojo.uniqueCallId != null) return false;
        if (conferenceName != null ? !conferenceName.equals(pojo.conferenceName) : pojo.conferenceName != null) return false;
        if (tenantName != null ? !tenantName.equals(pojo.tenantName) : pojo.tenantName != null) return false;
        if (conferenceType != null ? !conferenceType.equals(pojo.conferenceType) : pojo.conferenceType != null) return false;
        if (endpointType != '\u0000' ? endpointType != pojo.endpointType : pojo.endpointType != '\u0000') return false;
        if (callerId != null ? !callerId.equals(pojo.callerId) : pojo.callerId != null) return false;
        if (callerName != null ? !callerName.equals(pojo.callerName) : pojo.callerName != null) return false;
        if (joinTime != null ? !joinTime.equals(pojo.joinTime) : pojo.joinTime != null) return false;
        if (leaveTime != null ? !leaveTime.equals(pojo.leaveTime) : pojo.leaveTime != null) return false;
        if (callState != null ? !callState.equals(pojo.callState) : pojo.callState != null) return false;
        if (direction != '\u0000' ? direction != pojo.direction : pojo.direction != '\u0000') return false;
        if (routerId != null ? !routerId.equals(pojo.routerId) : pojo.routerId != null) return false;
        if (gwid != null ? !gwid.equals(pojo.gwid) : pojo.gwid != null) return false;
        if (gwprefix != null ? !gwprefix.equals(pojo.gwprefix) : pojo.gwprefix != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (uniqueCallId != null ? uniqueCallId.hashCode() : 0);
        result = 31 * result + (conferenceName != null ? conferenceName.hashCode() : 0);
        result = 31 * result + (tenantName != null ? tenantName.hashCode() : 0);
        result = 31 * result + (conferenceType != null ? conferenceType.hashCode() : 0);
        result = 31 * result + (endpointType);
        result = 31 * result + (callerId != null ? callerId.hashCode() : 0);
        result = 31 * result + (callerName != null ? callerName.hashCode() : 0);
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
        result = 31 * result + (leaveTime != null ? leaveTime.hashCode() : 0);
        result = 31 * result + (callState != null ? callState.hashCode() : 0);
        result = 31 * result + (direction);
        result = 31 * result + (routerId != null ? routerId.hashCode() : 0);
        result = 31 * result + (gwid != null ? gwid.hashCode() : 0);
        result = 31 * result + (gwprefix != null ? gwprefix.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("callId").append("='").append(getCallId()).append("', ");
        sb.append("uniqueCallId").append("='").append(getUniqueCallId()).append("', ");
        sb.append("conferenceName").append("='").append(getConferenceName()).append("', ");
        sb.append("tenantName").append("='").append(getTenantName()).append("', ");
        sb.append("conferenceType").append("='").append(getConferenceType()).append("', ");
        sb.append("endpointType").append("='").append(getEndpointType()).append("', ");
        sb.append("callerId").append("='").append(getCallerId()).append("', ");
        sb.append("callerName").append("='").append(getCallerName()).append("', ");
        sb.append("joinTime").append("='").append(getJoinTime()).append("', ");
        sb.append("leaveTime").append("='").append(getLeaveTime()).append("', ");
        sb.append("callState").append("='").append(getCallState()).append("', ");
        sb.append("direction").append("='").append(getDirection()).append("', ");
        sb.append("routerId").append("='").append(getRouterId()).append("', ");
        sb.append("gwid").append("='").append(getGwid()).append("', ");
        sb.append("gwprefix").append("='").append(getGwprefix()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
