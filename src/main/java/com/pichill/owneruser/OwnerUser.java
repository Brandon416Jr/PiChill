package com.pichill.owneruser;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class OwnerUser implements java.io.Serializable{
	private Integer oUserID;
	private String oUserName;
	private String oPassword;
	private String oIDNum;
	private String compiled;
	private String oName;
	private Integer oGender;
	private Date oBirth;
	private String oTelephone;
	private String oAddress;
	private String oBankCode;
	private String oBankAccount;
	private byte[] oProfilePic;
	private Date oRegisterTime;
	private Timestamp oLastLogTime;
	private Integer oPostAmount;
	private Integer oReportCnt;
	private Integer courtArriveCnt;
	private Integer couponArriveCnt;
	private Integer rsvdCnts;
	private String oEmail;
	
	
	public OwnerUser() {
	}
	
	public OwnerUser(Integer oUserID, String oUserName, String oPassword, String oIDNum, 
					 String compiled, String oName,Integer oGender, Date oBirth, String oTelephone,
					 String oAddress, String oBankCode, String oBankAccount, byte[] oProfilePic,
					 Date oRegisterTime, Timestamp oLastLogTime, Integer oPostAmount, Integer oReportCnt,
					 Integer courtArriveCnt, Integer couponArriveCnt, Integer rsvdCnts, String oEmail) {
		this.oUserID = oUserID;
		this.oUserName = oUserName;
		this.oPassword = oPassword;
		this.oIDNum = oIDNum;
		this.compiled = compiled;
		this.oName = oName;
		this.oGender = oGender;
		this.oBirth = oBirth;
		this.oTelephone = oTelephone;
		this.oAddress = oAddress;
		this.oBankCode = oBankCode;
		this.oBankAccount = oBankAccount;
		this.oProfilePic = oProfilePic;
		this.oRegisterTime = oRegisterTime;
		this.oLastLogTime = oLastLogTime;
		this.oPostAmount = oPostAmount;
		this.oReportCnt = oReportCnt;
		this.courtArriveCnt = courtArriveCnt;
		this.couponArriveCnt = couponArriveCnt;
		this.rsvdCnts = rsvdCnts;
		this.oEmail = oEmail;
	}
	
	public Integer getoUserID() {
		return oUserID;
	}
	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}
	public String getoUserName() {
		return oUserName;
	}
	public void setoUserName(String oUserName) {
		this.oUserName = oUserName;
	}
	public String getoPassword() {
		return oPassword;
	}
	public void setoPassword(String oPassword) {
		this.oPassword = oPassword;
	}
	public String getoIDNum() {
		return oIDNum;
	}
	public void setoIDNum(String oIDNum) {
		this.oIDNum = oIDNum;
	}
	public String getCompiled() {
		return compiled;
	}
	public void setCompiled(String compiled) {
		this.compiled = compiled;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public Integer getoGender() {
		return oGender;
	}
	public void setoGender(Integer oGender) {
		this.oGender = oGender;
	}
	public Date getoBirth() {
		return oBirth;
	}
	public void setoBirth(Date oBirth) {
		this.oBirth = oBirth;
	}
	public String getoTelephone() {
		return oTelephone;
	}
	public void setoTelephone(String oTelephone) {
		this.oTelephone = oTelephone;
	}
	public String getoAddress() {
		return oAddress;
	}
	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}
	public String getoBankCode() {
		return oBankCode;
	}
	public void setoBankCode(String oBankCode) {
		this.oBankCode = oBankCode;
	}
	public String getoBankAccount() {
		return oBankAccount;
	}
	public void setoBankAccount(String oBankAccount) {
		this.oBankAccount = oBankAccount;
	}
	public byte[] getoProfilePic() {
		return oProfilePic;
	}
	public void setoProfilePic(byte[] oProfilePic) {
		this.oProfilePic = oProfilePic;
	}
	public Date getoRegisterTime() {
		return oRegisterTime;
	}
	public void setoRegisterTime(Date oRegisterTime) {
		this.oRegisterTime = oRegisterTime;
	}
	public Timestamp getoLastLogTime() {
		return oLastLogTime;
	}
	public void setoLastLogTime(Timestamp oLastLogTime) {
		this.oLastLogTime = oLastLogTime;
	}
	public Integer getoPostAmount() {
		return oPostAmount;
	}
	public void setoPostAmount(Integer oPostAmount) {
		this.oPostAmount = oPostAmount;
	}
	public Integer getoReportCnt() {
		return oReportCnt;
	}
	public void setoReportCnt(Integer oReportCnt) {
		this.oReportCnt = oReportCnt;
	}
	public Integer getCourtArriveCnt() {
		return courtArriveCnt;
	}
	public void setCourtArriveCnt(Integer courtArriveCnt) {
		this.courtArriveCnt = courtArriveCnt;
	}
	public Integer getCouponArriveCnt() {
		return couponArriveCnt;
	}
	public void setCouponArriveCnt(Integer couponArriveCnt) {
		this.couponArriveCnt = couponArriveCnt;
	}
	public Integer getRsvdCnts() {
		return rsvdCnts;
	}
	public void setRsvdCnts(Integer rsvdCnts) {
		this.rsvdCnts = rsvdCnts;
	}
	public String getoEmail() {
		return oEmail;
	}
	public void setoEmail(String oEmail) {
		this.oEmail = oEmail;
	}
}