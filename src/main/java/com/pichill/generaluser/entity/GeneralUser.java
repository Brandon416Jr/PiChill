package com.pichill.generaluser.entity;

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
	
	@Column(name="gUsername")
	private String gUsername;
	
	@Column(name="gPassword")
	private String gPassword;
	
	@Column(name="gIDNum", columnDefinition = "char")
	private String gIDNum;
	
	@Column(name="nicknameID")
	private String nicknameID;
	
	@Column(name="gPostAmount",insertable = false)
	private Integer gPostAmount;
	
	@Column(name="commentAmount",insertable = false)
	private Integer commentAmount;
	
	@Column(name="gReportCnt",insertable = false)
	private Integer gReportCnt;
	
	@Column(name="gRegistDate", updatable = false)
	private Date gRegistDate;
	
	@Column(name="gBirth")
	private Date gBirth;
	
	@Column(name="yoyakuCnt",insertable = false, updatable = false)
	private Integer yoyakuCnt;
	
	@Column(name="gProfilePic", columnDefinition = "longblob")
	private byte[] gProfilePic;

	public GeneralUser() {
		super();
	}

	public GeneralUser(Integer gUserID, String gName, String gTelephone, String gEmail, String gAddress, Integer status,
			Integer gGender, String gUsername, String gPassword, String gIDNum, String nicknameID, Integer gPostAmount,
			Integer commentAmount, Integer gReportCnt, Date gRegistDate, Date gBirth, Integer yoyakuCnt,
			byte[] gProfilePic) {
		super();
		this.gUserID = gUserID;
		this.gName = gName;
		this.gTelephone = gTelephone;
		this.gEmail = gEmail;
		this.gAddress = gAddress;
		this.status = status;
		this.gGender = gGender;
		this.gUsername = gUsername;
		this.gPassword = gPassword;
		this.gIDNum = gIDNum;
		this.nicknameID = nicknameID;
		this.gPostAmount = gPostAmount;
		this.commentAmount = commentAmount;
		this.gReportCnt = gReportCnt;
		this.gRegistDate = gRegistDate;
		this.gBirth = gBirth;
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

	public String getgUsername() {
		return gUsername;
	}

	public void setgUsername(String gUsername) {
		this.gUsername = gUsername;
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

	public Date getgBirth() {
		return gBirth;
	}

	public void setgBirth(Date gBirth) {
		this.gBirth = gBirth;
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
				+ gEmail + ", gAddress=" + gAddress + ", status=" + status + ", gGender=" + gGender + ", gUsername="
				+ gUsername + ", gPassword=" + gPassword + ", gIDNum=" + gIDNum + ", nicknameID=" + nicknameID
				+ ", gPostAmount=" + gPostAmount + ", commentAmount=" + commentAmount + ", gReportCnt=" + gReportCnt
				+ ", gRegistDate=" + gRegistDate + ", gBirth=" + gBirth + ", yoyakuCnt=" + yoyakuCnt + ", gProfilePic="
				+ Arrays.toString(gProfilePic) + "]";
	}

	
	
	

	

	
	

}
