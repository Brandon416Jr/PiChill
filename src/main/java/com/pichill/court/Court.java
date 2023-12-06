package com.pichill.court;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity

@Table(name = "Court")
public class Court {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courtID", updatable = false) //PK鍵不用更新
	private Integer courtID;
	
	@Column(name = "oUserID")
	private Integer oUserID;
	
	@Column(name = "manageID")
	private Integer manageID;
	
	@Column(name = "courtOnTime" , updatable = false)
	private Timestamp courtOnTime;
	
	@Column(name = "courtApplyTime" ,insertable = false, updatable = false)
	@CreationTimestamp
	private Timestamp courtApplyTime;
	
	@Column(name = "courtName")
	private String courtName;
	
	@Column(name = "courtPic" , columnDefinition = "longblob")
	private byte[] courtPic;
	
	@Column(name = "courtTelephone")
	private String courtTelephone;
	
	@Column(name = "courtAddress")
	private String courtAddress;
	
	@Column(name = "courtRule" , columnDefinition = "text")
	private String courtRule;
	
	@Column(name = "loc")
	private String loc;
	
	@Column(name = "courtApplyStatus")
	private Integer courtApplyStatus;
	
	
	@Column(name = "courtOpenTime")
	private Time courtOpenTime;

	
	@Column(name = "courtCloseTime")
	private Time courtCloseTime;
	
	public Court() {
        super();
    }
	
	public Court(Integer courtID, Integer oUserID, Integer manageID, Timestamp courtOnTime, Timestamp courtApplyTime, String courtName,byte[] courtPic, String courtTelephone, String courtAddress, String courtRule, String loc, Integer courtApplyStatus, Time courtOpenTime, Time courtCloseTime) {
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
		this.courtApplyStatus = courtApplyStatus;
		this.courtOpenTime = courtOpenTime;
		this.courtCloseTime = courtCloseTime;
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

	public Integer getCourtApplyStatus() {
		return courtApplyStatus;
	}

	public void setCourtApplyStatus(Integer courtApplyStatus) {
		this.courtApplyStatus = courtApplyStatus;
	}
	public Time getCourtOpenTime() {
		return courtOpenTime;
	}

	public void setCourtOpenTime(Time courtOpenTime) {
		this.courtOpenTime = courtOpenTime;
	}

	public Time getCourtCloseTime() {
		return courtCloseTime;
	}

	public void setCourtCloseTime(Time courtCloseTime) {
		this.courtCloseTime = courtCloseTime;
	}

	
}
