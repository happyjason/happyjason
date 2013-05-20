package com.ammob.communication.vidyo.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.vidyo.portal.user.v1_1.RoomMode;

//@org.codehaus.jackson.annotate.JsonIgnoreProperties(value={ "password" }, ignoreUnknown=true)
@JsonPropertyOrder(value={ "memberStatus" }, alphabetic=false)
@JsonSerialize(include=Inclusion.NON_NULL)
public class Member implements Comparable<Member> {
	
    private Integer entityID;
    private Integer memberID;
    private String name;
    private String password;
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
    private String groupName;
    private String proxyName;
    private String roleName;
    private String locationTag;
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
    
	/**
	 * @return entityID
	 */
	public int getEntityID() {
		return entityID;
	}
	
	/**
	 * @param entityID 要设置的 entityID
	 */
	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}
	
	/**
	 * @return memberID
	 */
	public Integer getMemberID() {
		return memberID;
	}

	/**
	 * @param memberID 要设置的 memberID
	 */
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	/**
	 * @return ownerID
	 */
	public String getOwnerID() {
		return ownerID;
	}
	
	/**
	 * @param ownerID 要设置的 ownerID
	 */
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return participantID
	 */
	public String getParticipantID() {
		return participantID;
	}
	
	/**
	 * @param participantID 要设置的 participantID
	 */
	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}
	
	/**
	 * @return entityType
	 */
	public String getEntityType() {
		return entityType;
	}
	
	/**
	 * @param entityType 要设置的 entityType
	 */
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	/**
	 * @return displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	
	/**
	 * @param displayName 要设置的 displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	/**
	 * @return extension
	 */
	public String getExtension() {
		return extension;
	}
	
	/**
	 * @param extension 要设置的 extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	/**
	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * @param emailAddress 要设置的 emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**
	 * @return tenant
	 */
	public String getTenant() {
		return tenant;
	}
	
	/**
	 * @param tenant 要设置的 tenant
	 */
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description 要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return language
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * @param language 要设置的 language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * @return memberStatus
	 */
	public String getMemberStatus() {
		return memberStatus;
	}
	
	/**
	 * @param memberStatus 要设置的 memberStatus
	 */
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	
	/**
	 * @return memberMode
	 */
	public String getMemberMode() {
		return memberMode;
	}
	
	/**
	 * @param memberMode 要设置的 memberMode
	 */
	public void setMemberMode(String memberMode) {
		this.memberMode = memberMode;
	}
	
	/**
	 * @return groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	
	/**
	 * @param groupName 要设置的 groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	/**
	 * @return proxyName
	 */
	public String getProxyName() {
		return proxyName;
	}

	/**
	 * @param proxyName 要设置的 proxyName
	 */
	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}

	/**
	 * @return roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName 要设置的 roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return locationTag
	 */
	public String getLocationTag() {
		return locationTag;
	}

	/**
	 * @param locationTag 要设置的 locationTag
	 */
	public void setLocationTag(String locationTag) {
		this.locationTag = locationTag;
	}

	/**
	 * @return canCallDirect
	 */
	public Boolean getCanCallDirect() {
		return canCallDirect;
	}
	
	/**
	 * @param canCallDirect 要设置的 canCallDirect
	 */
	public void setCanCallDirect(Boolean canCallDirect) {
		this.canCallDirect = canCallDirect;
	}
	
	/**
	 * @return canJoinMeeting
	 */
	public Boolean getCanJoinMeeting() {
		return canJoinMeeting;
	}
	
	/**
	 * @param canJoinMeeting 要设置的 canJoinMeeting
	 */
	public void setCanJoinMeeting(Boolean canJoinMeeting) {
		this.canJoinMeeting = canJoinMeeting;
	}
	
	/**
	 * @return canRecordMeeting
	 */
	public Boolean getCanRecordMeeting() {
		return canRecordMeeting;
	}
	
	/**
	 * @param canRecordMeeting 要设置的 canRecordMeeting
	 */
	public void setCanRecordMeeting(Boolean canRecordMeeting) {
		this.canRecordMeeting = canRecordMeeting;
	}
	
	/**
	 * @return isInMyContacts
	 */
	public Boolean getIsInMyContacts() {
		return isInMyContacts;
	}
	
	/**
	 * @param isInMyContacts 要设置的 isInMyContacts
	 */
	public void setIsInMyContacts(Boolean isInMyContacts) {
		this.isInMyContacts = isInMyContacts;
	}
	
	/**
	 * @return roomStatus
	 */
	public String getRoomStatus() {
		return roomStatus;
	}
	
	/**
	 * @param roomStatus 要设置的 roomStatus
	 */
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	/**
	 * @return roomMode
	 */
	public RoomMode getRoomMode() {
		return roomMode;
	}
	
	/**
	 * @param roomMode 要设置的 roomMode
	 */
	public void setRoomMode(RoomMode roomMode) {
		this.roomMode = roomMode;
	}
	
	/**
	 * @return canControl
	 */
	public Boolean getCanControl() {
		return canControl;
	}
	
	/**
	 * @param canControl 要设置的 canControl
	 */
	public void setCanControl(Boolean canControl) {
		this.canControl = canControl;
	}
	
	/**
	 * @return audio
	 */
	public Boolean getAudio() {
		return audio;
	}
	
	/**
	 * @param audio 要设置的 audio
	 */
	public void setAudio(Boolean audio) {
		this.audio = audio;
	}
	
	/**
	 * @return video
	 */
	public Boolean getVideo() {
		return video;
	}
	
	/**
	 * @param video 要设置的 video
	 */
	public void setVideo(Boolean video) {
		this.video = video;
	}
	
	/**
	 * @return appshare
	 */
	public Boolean getAppshare() {
		return appshare;
	}
	
	/**
	 * @param appshare 要设置的 appshare
	 */
	public void setAppshare(Boolean appshare) {
		this.appshare = appshare;
	}
	
	/**
	 * @param entityID 要设置的 entityID
	 */
	public void setEntityID(int entityID) {
		this.entityID = entityID;
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
