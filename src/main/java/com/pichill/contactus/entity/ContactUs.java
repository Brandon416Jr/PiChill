package com.pichill.contactus.entity;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.generaluser.entity.GeneralUser;


@Entity
@Table(name = "contactus")

public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formID", updatable = false, insertable = false)
	private Integer formID;

	@ManyToOne
	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID")
	@Column(name = "oUserID", updatable = false)
    private GeneralUser generalUser;

	@ManyToOne
	@JoinColumn(name = "oUserID",referencedColumnName = "oUserID")
	@Column(name = "oUserID", updatable = false)
	private Integer oUserID;

	@Column(name = "formPurpose" , columnDefinition = "varchar", updatable = false)
	private String formPurpose;

	@Column(name = "formContent" , columnDefinition = "text", updatable = false)
	private String formContent;
	
	@Column(name = "formPic" , columnDefinition = "longblob", updatable = false)
	private byte[] formPic;
	
	@Column(name = "formTime" ,  updatable = false)
	@CreationTimestamp
	private Timestamp formTime;
	
	@Column(name = "formStatus")
	private Integer formStatus;
	
	@Column(name = "formType" , updatable = false)
	private Integer formType;
	
	
	public ContactUs() {
		super();

	}
	
	
//	@Override
//	public String toString() {
//		return "ContactUs [formID=" + formID + ", oUserID=" + oUserID + ", gUserID=" + gUserID + ", formPurpose="
//				+ formPurpose + ", formContent=" + formContent + ",formPic=" + formPic + ",formTime=" + formTime
//				+ ",formStatus=" + formStatus + ",formType=" + formType + "]";
//	}	
	
	
//public class ContactUs implements Serializable {
//	private Integer formID;
//	private Integer oUserID;
//	private Integer gUserID;
//	private String formPurpose;
//	private String formContent;
//	private byte[] formPic;
//	private Timestamp formTime;
//	private Integer formStatus;
//	private Integer formType;

//	public ContactUs() {
//		super();
//	}

//	public ContactUs(Integer formID, Integer oUserID, Integer gUserID, String formPurpose, String formContent,
//			byte[] formPic, Timestamp formTime, Integer formType) {
//		this.formID = formID;
//		this.oUserID = oUserID;
//		this.gUserID = gUserID;
//		this.formPurpose = formPurpose;
//		this.formContent = formContent;
//		this.formPic = formPic;
//		this.formTime = formTime;
	
//		this.formType = formType;
//
//	}

	@Override
	public String toString() {
		return "ContactUs [formID=" + formID + ", generalUser=" + generalUser + ", oUserID=" + oUserID
				+ ", formPurpose=" + formPurpose + ", formContent=" + formContent + ", formPic="
				+ Arrays.toString(formPic) + ", formTime=" + formTime + ", formStatus=" + formStatus + ", formType="
				+ formType + "]";
	}


	public Integer getformID() {
		return formID;
	}

	public GeneralUser getGeneralUser() {
		return generalUser;
	}


	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}


	public void setformID(Integer formID) {
		this.formID = formID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

//	public Integer getgUserID() {
//		return gUserID;
//	}
//
//	public void setgUserID(Integer gUserID) {
//		this.gUserID = gUserID;
//	}

	public String getformPurpose() {
		return formPurpose;
	}

	public void setformPurpose(String formPurpose) {
		this.formPurpose = formPurpose;
	}

	public String getformContent() {
		return formContent;
	}

	public void setformContent(String formContent) {
		this.formContent = formContent;
	}

	public byte[] getformPic() {
		return formPic;
	}

	public void setformPic(byte[] formPic) {
		this.formPic = formPic;
	}

	public Timestamp getformTime() {
		return formTime;
	}

	public void setformTime(Timestamp formTime) {
		this.formTime = formTime;
	}

	public Integer getformStatus() {
		return formStatus;
	}

	public void setformStatus(Integer formStatus) {
		this.formStatus = formStatus;
	}
	
	public Integer getformType() {
		return formType;
	}

	public void setformType(Integer formType) {
		this.formType = formType;
	}
}