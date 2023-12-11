package com.pichill.backstage.contactus.entity;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "contactus")
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "formID", updatable = false, insertable = false)
	private Integer formID;

//	@ManyToOne
//	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID")
//    private GUser gUser;

	@Column(name = "gUserID", updatable = false)
	private Integer gUserID;

//	@ManyToOne
//	@JoinColumn(name = "oUserID",referencedColumnName = "oUserID")
//    private OUser oUser;

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
		// TODO Auto-generated constructor stub
	}

	public ContactUs(Integer formID, Integer gUserID, Integer oUserID, String formPurpose, String formContent,
			byte[] formPic, Timestamp formTime, Integer formStatus, Integer formType) {
		super();
		this.formID = formID;
		this.gUserID = gUserID;
		this.oUserID = oUserID;
		this.formPurpose = formPurpose;
		this.formContent = formContent;
		this.formPic = formPic;
		this.formTime = formTime;
		this.formStatus = formStatus;
		this.formType = formType;
	}

	public Integer getFormID() {
		return formID;
	}

	public void setFormID(Integer formID) {
		this.formID = formID;
	}

	public Integer getgUserID() {
		return gUserID;
	}

	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public String getFormPurpose() {
		return formPurpose;
	}

	public void setFormPurpose(String formPurpose) {
		this.formPurpose = formPurpose;
	}

	public String getFormContent() {
		return formContent;
	}

	public void setFormContent(String formContent) {
		this.formContent = formContent;
	}

	public byte[] getFormPic() {
		return formPic;
	}

	public void setFormPic(byte[] formPic) {
		this.formPic = formPic;
	}

	public Timestamp getFormTime() {
		return formTime;
	}

	public void setFormTime(Timestamp formTime) {
		this.formTime = formTime;
	}

	public Integer getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(Integer formStatus) {
		this.formStatus = formStatus;
	}

	public Integer getFormType() {
		return formType;
	}

	public void setFormType(Integer formType) {
		this.formType = formType;
	}

	@Override
	public String toString() {
		return "ContactUsBack [formID=" + formID + ", gUserID=" + gUserID + ", oUserID=" + oUserID + ", formPurpose="
				+ formPurpose + ", formContent=" + formContent + ", formPic=" + Arrays.toString(formPic) + ", formTime="
				+ formTime + ", formStatus=" + formStatus + ", formType=" + formType + "]";
	}
	
	

}
