package com.pichill.owneruser.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;



@Entity

@Table(name = "owneruser")
public class OwnerUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oUserID")
	private Integer oUserID;
	
	@Column(name = "oUserName")
	private String oUserName;
	
	@Column(name = "oPassword")
	private String oPassword;
	
	@Column(name = "oIDNum" , columnDefinition = "char")
	private String oIDNum;
	
	@Column(name = "compiled")
	private String compiled;
	
	@Column(name = "oName")
	private String oName;
	
	@Column(name = "oGender") 
	private Integer oGender;
	
	@Column(name = "oBirth")
	private Date oBirth;
	
	@Column(name = "oTelephone")
	private String oTelephone;
	
	@Column(name = "oAddress")
	private String oAddress;
	
	@Column(name = "oBankCode", columnDefinition = "char")
	private String oBankCode;
	
	@Column(name = "oBankAccount")
	private String oBankAccount;
	
	@Column(name = "oProfilePic" , columnDefinition = "longblob")
	private byte[] oProfilePic;
	
	@Column(name = "oRegisterDate ", updatable = false)
	private Date oRegisterDate;

	
	@Column(name = "oPostAmount")
	private Integer oPostAmount;
	
	@Column(name = "oReportCnt")
	private Integer oReportCnt;
	
	@Column(name = "courtArriveCnt")
	private Integer courtArriveCnt;
	
	@Column(name = "rsvdCnts")
	private Integer rsvdCnts;
	
	@Column(name = "oEmail")
	private String oEmail;
	
	
	public OwnerUser() {
	}
	
	public OwnerUser(Integer oUserID, String oUserName, String oPassword, String oIDNum, 
					 String compiled, String oName,Integer oGender, Date oBirth, String oTelephone,
					 String oAddress, String oBankCode, String oBankAccount, byte[] oProfilePic,
					 Date oRegisterDate, Integer oPostAmount, Integer oReportCnt,
					 Integer courtArriveCnt, Integer rsvdCnts, String oEmail) {
		super();
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
		this.oRegisterDate = oRegisterDate;
		this.oPostAmount = oPostAmount;
		this.oReportCnt = oReportCnt;
		this.courtArriveCnt = courtArriveCnt;
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
	public Date getoRegisterDate() {
		return oRegisterDate;
	}
	public void setoRegisterDate(Date oRegisterDate) {
		this.oRegisterDate = oRegisterDate;
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