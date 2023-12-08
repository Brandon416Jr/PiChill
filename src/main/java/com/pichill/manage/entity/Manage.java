package com.pichill.manage.entity;

import java.io.Serializable; 
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
@Table(name = "manage")
public class Manage implements Serializable {
//	private static final long serialVersionUID = 1L; // 可加可不加
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manageID", updatable = false)
	private int manageID;
	
	@Column(name = "mName")
	private String mName;
	
	@Column(name="mUserName")
	private String mUserName;
	
	@Column(name="mPassword")
	private String mPassword;
	
	@Column(name="mBirth", updatable = false)
	private Date mBirth;
	
	@Column(name="mGender",updatable = false)
	private Integer mGender;
	
	@Column(name="mTelephone")
	private String mTelephone;
	
	@Column(name="mEmgContact")
	private String mEmgContact;
	
	@Column(name="mEmgPhone")
	private String mEmgPhone;
	
	@Column(name="mAddress")
	private String mAddress;
	
	@Column(name="mHiredate", updatable = false)
	private Date mHiredate;
	
	
	
	@Column(name="mID", columnDefinition="char", updatable = false) // 資料庫char型別要用columnDefinition標示!
	private String mID;
	
	@Column(name="mEmail")
	private String mEmail;
	
	@Column(name="mProfilePic", columnDefinition="longblob") // 資料庫blob型別要用columnDefinition標示!
	private byte[] mProfilePic;
	
	@Column(name="mStatus" ,insertable = false, nullable = true)
	private Integer mStatus;
	
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manage(int manageID, String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
			String mID, String mEmail, byte[] mProfilePic, int mStatus) {
		super();
		this.manageID = manageID;
		this.mName = mName;
		this.mUserName = mUserName;
		this.mPassword = mPassword;
		this.mBirth = mBirth;
		this.mGender = mGender;
		this.mTelephone = mTelephone;
		this.mEmgContact = mEmgContact;
		this.mEmgPhone = mEmgPhone;
		this.mAddress = mAddress;
		this.mHiredate = mHiredate;
		this.mID = mID;
		this.mEmail = mEmail;
		this.mProfilePic = mProfilePic;
		this.mStatus = mStatus;
	}

	public int getManageID() {
		return manageID;
	}

	public void setManageID(int manageID) {
		this.manageID = manageID;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public Date getmBirth() {
		return mBirth;
	}

	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}

	public Integer getmGender() {
		return mGender;
	}

	public void setmGender(Integer mGender) {
		this.mGender = mGender;
	}

	public String getmTelephone() {
		return mTelephone;
	}

	public void setmTelephone(String mTelephone) {
		this.mTelephone = mTelephone;
	}

	public String getmEmgContact() {
		return mEmgContact;
	}

	public void setmEmgContact(String mEmgContact) {
		this.mEmgContact = mEmgContact;
	}

	public String getmEmgPhone() {
		return mEmgPhone;
	}

	public void setmEmgPhone(String mEmgPhone) {
		this.mEmgPhone = mEmgPhone;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public Date getmHiredate() {
		return mHiredate;
	}

	public void setmHiredate(Date mHiredate) {
		this.mHiredate = mHiredate;
	}

	

	public String getmID() {
		return mID;
	}

	public void setmID(String mID) {
		this.mID = mID;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	
	public byte[] getmProfilePic() {
		return mProfilePic;
	}

	public void setmProfilePic(byte[] mProfilePic) {
		this.mProfilePic = mProfilePic;
	}

	public Integer getmStatus() {
		return mStatus;
	}

	public void setmStatus(Integer mStatus) {
		this.mStatus = mStatus;
	}

	@Override
	public String toString() {
		return "Manage [manageID=" + manageID + ", mName=" + mName + ", mUserName=" + mUserName + ", mPassword="
				+ mPassword + ", mBirth=" + mBirth + ", mGender=" + mGender + ", mTelephone=" + mTelephone
				+ ", mEmgContact=" + mEmgContact + ", mEmgPhone=" + mEmgPhone + ", mAddress=" + mAddress
				+ ", mHiredate=" + mHiredate + ", mLastLogTime="  + ", mID=" + mID + ", mEmail=" + mEmail
				+ ", mProfilePic=" + Arrays.toString(mProfilePic) + ", mStatus=" + mStatus + "]";
	}

}
