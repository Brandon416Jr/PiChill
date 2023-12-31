package com.pichill.test.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="generaluser")
public class GeneralUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gUserID", updatable = false)
	private Integer gUserID;
	
	@Column(name="gName")
	private String gName;
	
	@Column(name="gTelephone")
	private String gTelephone;
	
	@Column(name="gEmail")
	private String gEmail;
	
	@Column(name="gAddress")
	private String gAddress;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="gGender")
	private Integer gGender;
	
	@Column(name="gPassword")
	private String gPassword;
	
	@Column(name="gIDNum", columnDefinition = "char")
	private String gIDNum;
	
	@Column(name="nicknameID")
	private String nicknameID;
	
	@Column(name="piAmount",insertable = false)
	private Integer piAmount;
	
//	@Column(name="couponAmount",insertable = false)
//	private Integer couponAmount;
	
	@Column(name="gPostAmount",insertable = false)
	private Integer gPostAmount;
	
	@Column(name="commentAmount",insertable = false)
	private Integer commentAmount;
	
	@Column(name="gReportCnt",insertable = false)
	private Integer gReportCnt;
	
	@Column(name="gRegistDate", updatable = false)
	private Date gRegistDate;
	
	@Column(name="gLastLogTime")
	private Timestamp gLastLogTime;
	
	@Column(name="gBirth")
	private Date gBirth;
	
	@Column(name="purchaseCnt",insertable = false, updatable = false)
	private Integer purchaseCnt;
	
	@Column(name="yoyakuCnt",insertable = false, updatable = false)
	private Integer yoyakuCnt;
	
	@Column(name="gProfilePic", columnDefinition = "longblob")
	private byte[] gProfilePic;
	
	public GeneralUser() {
		super();
	}

	public GeneralUser(Integer gUserID, String gName, String gTelephone, String gEmail, String gAddress, Integer status,
			Integer gGender, String gPassword, String gIDNum, String nicknameID, Integer piAmount,
			Integer gPostAmount, Integer commentAmount, Integer gReportCnt, Date gRegistDate, Timestamp gLastLogTime,
			Date gBirth, Integer purchaseCnt, Integer yoyakuCnt, byte[] gProfilePic) {
		super();
		this.gUserID = gUserID;
		this.gName = gName;
		this.gTelephone = gTelephone;
		this.gEmail = gEmail;
		this.gAddress = gAddress;
		this.status = status;
		this.gGender = gGender;
		this.gPassword = gPassword;
		this.gIDNum = gIDNum;
		this.nicknameID = nicknameID;
		this.piAmount = piAmount;
//		this.couponAmount = couponAmount;
		this.gPostAmount = gPostAmount;
		this.commentAmount = commentAmount;
		this.gReportCnt = gReportCnt;
		this.gRegistDate = gRegistDate;
		this.gLastLogTime = gLastLogTime;
		this.gBirth = gBirth;
		this.purchaseCnt = purchaseCnt;
		this.yoyakuCnt = yoyakuCnt;
		this.gProfilePic = gProfilePic;
	}

	public Integer getgUserID() {
		return gUserID;
	}

	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgTelephone() {
		return gTelephone;
	}

	public void setgTelephone(String gTelephone) {
		this.gTelephone = gTelephone;
	}

	public String getgEmail() {
		return gEmail;
	}

	public void setgEmail(String gEmail) {
		this.gEmail = gEmail;
	}

	public String getgAddress() {
		return gAddress;
	}

	public void setgAddress(String gAddress) {
		this.gAddress = gAddress;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getgGender() {
		return gGender;
	}

	public void setgGender(Integer gGender) {
		this.gGender = gGender;
	}

	public String getgPassword() {
		return gPassword;
	}

	public void setgPassword(String gPassword) {
		this.gPassword = gPassword;
	}

	public String getgIDNum() {
		return gIDNum;
	}

	public void setgIDNum(String gIDNum) {
		this.gIDNum = gIDNum;
	}

	public String getNicknameID() {
		return nicknameID;
	}

	public void setNicknameID(String nicknameID) {
		this.nicknameID = nicknameID;
	}

	public Integer getPiAmount() {
		return piAmount;
	}

	public void setPiAmount(Integer piAmount) {
		this.piAmount = piAmount;
	}

//	public Integer getCouponAmount() {
//		return couponAmount;
//	}
//
//	public void setCouponAmount(Integer couponAmount) {
//		this.couponAmount = couponAmount;
//	}

	public Integer getgPostAmount() {
		return gPostAmount;
	}

	public void setgPostAmount(Integer gPostAmount) {
		this.gPostAmount = gPostAmount;
	}

	public Integer getCommentAmount() {
		return commentAmount;
	}

	public void setCommentAmount(Integer commentAmount) {
		this.commentAmount = commentAmount;
	}

	public Integer getgReportCnt() {
		return gReportCnt;
	}

	public void setgReportCnt(Integer gReportCnt) {
		this.gReportCnt = gReportCnt;
	}

	public Date getgRegistDate() {
		return gRegistDate;
	}

	public void setgRegistDate(Date gRegistDate) {
		this.gRegistDate = gRegistDate;
	}

	public Timestamp getgLastLogTime() {
		return gLastLogTime;
	}

	public void setgLastLogTime(Timestamp gLastLogTime) {
		this.gLastLogTime = gLastLogTime;
	}

	public Date getgBirth() {
		return gBirth;
	}

	public void setgBirth(Date gBirth) {
		this.gBirth = gBirth;
	}

	public Integer getPurchaseCnt() {
		return purchaseCnt;
	}

	public void setPurchaseCnt(Integer purchaseCnt) {
		this.purchaseCnt = purchaseCnt;
	}

	public Integer getYoyakuCnt() {
		return yoyakuCnt;
	}

	public void setYoyakuCnt(Integer yoyakuCnt) {
		this.yoyakuCnt = yoyakuCnt;
	}

	public byte[] getgProfilePic() {
		return gProfilePic;
	}

	public void setgProfilePic(byte[] gProfilePic) {
		this.gProfilePic = gProfilePic;
	}

	@Override
	public String toString() {
		return "GeneralUser [gUserID=" + gUserID + ", gName=" + gName + ", gTelephone=" + gTelephone + ", gEmail="
				+ gEmail + ", gAddress=" + gAddress + ", status=" + status + ", gGender=" + gGender + ", gPassword="
				+ gPassword + ", gIDNum=" + gIDNum + ", nicknameID=" + nicknameID + ", piAmount=" + piAmount
				+ ", couponAmount=" + ", gPostAmount=" + gPostAmount + ", commentAmount=" + commentAmount
				+ ", gReportCnt=" + gReportCnt + ", gRegistDate=" + gRegistDate + ", gLastLogTime=" + gLastLogTime
				+ ", gBirth=" + gBirth + ", purchaseCnt=" + purchaseCnt + ", yoyakuCnt=" + yoyakuCnt + ", gProfilePic="
				+ Arrays.toString(gProfilePic) + "]";
	}

	
	

}
