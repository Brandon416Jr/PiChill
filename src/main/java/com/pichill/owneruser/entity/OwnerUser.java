package com.pichill.owneruser.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;



@Entity

@Table(name = "owneruser") 
public class OwnerUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oUserID")
	
	private Integer oUserID;
	
	@Column(name = "oUserName")
	private String oUserName;
	
	@Column(name = "oPassword")
	private String oPassword;
	
	@Column(name = "oIDNum" , columnDefinition = "char" , updatable = false)
	private String oIDNum;
	
	@Column(name = "compiled")
	private String compiled;
	
	@Column(name = "oName")
	private String oName;
	
	@Column(name = "oGender" , updatable = false)
	private Integer oGender;
	
	@Column(name = "oBirth" , updatable = false)
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
	
	@Column(name = "oRegisterDate ", updatable = false ,insertable = false)
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
	
	// fetch 預設為 LAZY
//	@OneToMany(mappedBy = "ownerUser", cascade = CascadeType.ALL)
//	@OrderBy("courtID asc") 
//	private Set<Court> Court; // Set不重複
	
	// fetch 預設為 LAZY
//	@OneToMany(mappedBy = "ownerUser", cascade = CascadeType.ALL)
//	@OrderBy("formID asc") 
//	public Set<Court> getCourt() {
//		return Court;
//	}

//	public void setCourt(Set<Court> court) {
//		Court = court;
//	}
//
//	public Set<ContactUs> getContactUs() {
//		return contactUs;
//	}
//
//	public void setContactUs(Set<ContactUs> contactUs) {
//		this.contactUs = contactUs;
//	}
//
//	public Set<reserveOrder> getReserveOrder() {
//		return reserveOrder;
//	}
//
//	public void setReserveOrder(Set<reserveOrder> reserveOrder) {
//		this.reserveOrder = reserveOrder;
//	}
//
//	public Set<Post> getPost() {
//		return post;
//	}
//
//	public void setPost(Set<Post> post) {
//		this.post = post;
//	}
//	private Set<ContactUs> contactUs; // Set不重複
//	
//	 fetch 預設為 LAZY
//	@OneToMany(mappedBy = "ownerUser", cascade = CascadeType.ALL)
//	@OrderBy("reserveOrderID asc") 
//	private Set<reserveOrder> reserveOrder; // Set不重複
//	
//	 fetch 預設為 LAZY
//	@OneToMany(mappedBy = "ownerUser", cascade = CascadeType.ALL)
//	@OrderBy("postID asc") 
//	private Set<Post> post; // Set不重複

	
	
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
	public String getcompiled() {
		return compiled;
	}
	public void setcompiled(String compiled) {
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