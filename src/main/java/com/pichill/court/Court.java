package com.pichill.court;

import java.sql.Timestamp;

public class Court implements java.io.Serializable{
	private Integer courtID;
	private Integer oUserID;
	private Integer manageID;
	private Timestamp courtOnTime;
	private Timestamp courtApplyTime;
	private String courtName;
	private byte[] courtPic;
	private String courtTelephone;
	private String courtAddress;
	private String courtRule;
	private String loc;
	private Integer courtApplyStatus;
	
	public Integer getCourtApplyStatus() {
		return courtApplyStatus;
	}

	public void setCourtApplyStatus(Integer courtApplyStatus) {
		this.courtApplyStatus = courtApplyStatus;
	}

	public Integer getCourtID() {
		return courtID;
	}

	public void setCourtID(Integer courtID) {
		this.courtID = courtID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public Integer getManageID() {
		return manageID;
	}

	public void setManageID(Integer manageID) {
		this.manageID = manageID;
	}

	public Timestamp getCourtOnTime() {
		return courtOnTime;
	}

	public void setCourtOnTime(Timestamp courtOnTime) {
		this.courtOnTime = courtOnTime;
	}

	public Timestamp getCourtApplyTime() {
		return courtApplyTime;
	}

	public void setCourtApplyTime(Timestamp courtApplyTime) {
		this.courtApplyTime = courtApplyTime;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public byte[] getCourtPic() {
		return courtPic;
	}

	public void setCourtPic(byte[] courtPic) {
		this.courtPic = courtPic;
	}

	public String getCourtTelephone() {
		return courtTelephone;
	}

	public void setCourtTelephone(String courtTelephone) {
		this.courtTelephone = courtTelephone;
	}

	public String getCourtAddress() {
		return courtAddress;
	}

	public void setCourtAddress(String courtAddress) {
		this.courtAddress = courtAddress;
	}

	public String getCourtRule() {
		return courtRule;
	}

	public void setCourtRule(String courtRule) {
		this.courtRule = courtRule;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Court() {
	}

	public Court(Integer courtID, Integer oUserID, Integer manageID, Timestamp courtOnTime, Timestamp courtApplyTime, String courtName,byte[] courtPic, String courtTelephone, String courtAddress, String courtRule, String loc) {
		this.courtID = courtID;
		this.oUserID = oUserID;
		this.manageID = manageID;
		this.courtOnTime = courtOnTime;
		this.courtApplyTime = courtApplyTime;
		this.courtName = courtName;
		this.courtPic = courtPic;
		this.courtTelephone = courtTelephone;
		this.courtAddress = courtAddress;
		this.courtRule = courtRule;
		this.loc = loc;
	}
	
	
}
