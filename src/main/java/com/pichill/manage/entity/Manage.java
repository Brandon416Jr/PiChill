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
	
	@Column(name="mBirth")
	private Date mBirth;
	
	@Column(name="mGender")
	private Integer mGender;
	
	@Column(name="mTelephone")
	private String mTelephone;
	
	@Column(name="mEmgContact")
	private String mEmgContact;
	
	@Column(name="mEmgPhone")
	private String mEmgPhone;
	
	@Column(name="mAddress")
	private String mAddress;
	
	@Column(name="mHiredate")
	private Date mHiredate;
	
	@Column(name="mLastLogTime")
	private Timestamp mLastLogTime;
	
	@Column(name="mID")
	private String mID;
	
	@Column(name="mEmail")
	private String mEmail;
	
	@Column(name="mProfilePic")
	private byte[] mProfilePic;
	
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manage(int manageID, String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
			Timestamp mLastLogTime, String mID, String mEmail, byte[] mProfilePic) {
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
		this.mLastLogTime = mLastLogTime;
		this.mID = mID;
		this.mEmail = mEmail;
		this.mProfilePic = mProfilePic;
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

	public Timestamp getmLastLogTime() {
		return mLastLogTime;
	}

	public void setmLastLogTime(Timestamp mLastLogTime) {
		this.mLastLogTime = mLastLogTime;
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

	@Override
	public String toString() {
		return "Manage [manageID=" + manageID + ", mName=" + mName + ", mUserName=" + mUserName + ", mPassword="
				+ mPassword + ", mBirth=" + mBirth + ", mGender=" + mGender + ", mTelephone=" + mTelephone
				+ ", mEmgContact=" + mEmgContact + ", mEmgPhone=" + mEmgPhone + ", mAddress=" + mAddress
				+ ", mHiredate=" + mHiredate + ", mLastLogTime=" + mLastLogTime + ", mID=" + mID + ", mEmail=" + mEmail
				+ ", mProfilePic=" + Arrays.toString(mProfilePic) + "]";
	}

}
