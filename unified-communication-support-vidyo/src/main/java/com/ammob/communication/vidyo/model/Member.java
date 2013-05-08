package com.ammob.communication.vidyo.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.vidyo.portal.user.v1_1.RoomMode;

@JsonIgnoreProperties(value={ "password" }, ignoreUnknown=true)
@JsonPropertyOrder(value={ "memberStatus" }, alphabetic=false)
@JsonSerialize(include=Inclusion.NON_NULL)
public class Member implements Comparable<Member> {
	
    private int entityID;
    private String ownerID;
    private String participantID;
    private String entityType;
    private String displayName;
    private String extension;
    private String emailAddress;
    private String tenant;
    private String description;
    private String language;
    private String memberStatus;
    private String memberMode;
    private Boolean canCallDirect;
    private Boolean canJoinMeeting;
    private Boolean canRecordMeeting;
    private Boolean isInMyContacts;
    private String roomStatus;
    private RoomMode roomMode;
    private Boolean canControl;
    private Boolean audio;
    private Boolean video;
    private Boolean appshare;
    
	public int getEntityID() {
		return entityID;
	}
	public void setEntityID(String entityID) {
		try {
			this.entityID = Integer.parseInt(entityID);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public String getParticipantID() {
		return participantID;
	}
	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getMemberStatus() {
		return memberStatus;
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getMemberMode() {
		return memberMode;
	}
	public void setMemberMode(String memberMode) {
		this.memberMode = memberMode;
	}
	public Boolean getCanCallDirect() {
		return canCallDirect;
	}
	public void setCanCallDirect(Boolean canCallDirect) {
		this.canCallDirect = canCallDirect;
	}
	public Boolean getCanJoinMeeting() {
		return canJoinMeeting;
	}
	public void setCanJoinMeeting(Boolean canJoinMeeting) {
		this.canJoinMeeting = canJoinMeeting;
	}
	public Boolean getCanRecordMeeting() {
		return canRecordMeeting;
	}
	public void setCanRecordMeeting(Boolean canRecordMeeting) {
		this.canRecordMeeting = canRecordMeeting;
	}
	public Boolean getIsInMyContacts() {
		return isInMyContacts;
	}
	public void setIsInMyContacts(Boolean isInMyContacts) {
		this.isInMyContacts = isInMyContacts;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public RoomMode getRoomMode() {
		return roomMode;
	}
	public void setRoomMode(RoomMode roomMode) {
		this.roomMode = roomMode;
	}
	public Boolean getCanControl() {
		return canControl;
	}
	public void setCanControl(Boolean canControl) {
		this.canControl = canControl;
	}
	public Boolean getAudio() {
		return audio;
	}
	public void setAudio(Boolean audio) {
		this.audio = audio;
	}
	public Boolean getVideo() {
		return video;
	}
	public void setVideo(Boolean video) {
		this.video = video;
	}
	public Boolean getAppshare() {
		return appshare;
	}
	public void setAppshare(Boolean appshare) {
		this.appshare = appshare;
	}
	
	@Override
	public int compareTo(Member member) {
		if(this.isInMyContacts != member.isInMyContacts){ // 联系人优先
			if(this.isInMyContacts)
				return -1;
			else
				return 1;
		}
		
		if(!this.memberStatus.equals(member.memberStatus)){
			if(this.memberStatus.equals("Online"))
				return -1;
			else
				return 1;
		}
		
		if(this.entityID < member.getEntityID()){  
            return -1;
        } else if(this.entityID > member.getEntityID()){  
            return 1;
        }
		return 0;
	}
}
