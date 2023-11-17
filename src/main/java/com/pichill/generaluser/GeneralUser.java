package com.pichill.generaluser;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class GeneralUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer gUserID;
	private String gName;
	private String gTelephone;
	private String gEmail;
	private String gAddress;
	private Integer status;
	private Integer gGender;
	private String gPassword;
	private String gIDNum;
	private String nicknameID;
	private Integer piAmount;
	private Integer couponAmount;
	private Integer gPostAmount;
	private Integer commentAmount;
	private Integer gReportCnt;
	private Date gRegistDate;
	private Timestamp gLastLogTime;
	private Date gBirth;
	private Integer purchaseCnt;
	private Integer yoyakuCnt;
	private byte[] gProfilePic;
	
	public GeneralUser() {
		super();
	}

	public GeneralUser(Integer gUserID, String gName, String gTelephone, String gEmail, String gAddress, Integer status,
			Integer gGender, String gPassword, String gIDNum, String nicknameID, Integer piAmount, Integer couponAmount,
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
		this.couponAmount = couponAmount;
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

	public Integer getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(Integer couponAmount) {
		this.couponAmount = couponAmount;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
