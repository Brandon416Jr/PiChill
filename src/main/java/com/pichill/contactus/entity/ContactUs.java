package com.pichill.contactus.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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

	@Column(name = "gUserID")
	private Integer gUserID;

//	@ManyToOne
//	@JoinColumn(name = "oUserID",referencedColumnName = "oUserID")
//    private OUser oUser;

	@Column(name = "oUserID")
	private Integer oUserID;

	@Column(name = "formPurpose" , columnDefinition = "varchar")
	private String formPurpose;

	@Column(name = "formContent" , columnDefinition = "text")
	private String formContent;
	
	@Column(name = "formPic" , columnDefinition = "longblob")
	private byte[] formPic;
	
	@Column(name = "formTime")
	private Timestamp formTime;
	
	@Column(name = "formStatus")
	private Integer formStatus;
	
	@Column(name = "formType")
	private Integer formType;
	
	
	public ContactUs() {
		super();

	}
	
	
	@Override
	public String toString() {
		return "ContactUs [formID=" + formID + ", oUserID=" + oUserID + ", gUserID=" + gUserID + ", formPurpose="
				+ formPurpose + ", formContent=" + formContent + ",formPic=" + formPic + ",formTime=" + formTime
				+ ",formStatus=" + formStatus + ",formType=" + formType + "]";
	}	
	
	
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

	public Integer getFormID() {
		return formID;
	}

	public void setFormID(Integer formID) {
		this.formID = formID;
	}

	public Integer getOUserID() {
		return oUserID;
	}

	public void setOUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public Integer getGUserID() {
		return gUserID;
	}

	public void setGUserID(Integer gUserID) {
		this.gUserID = gUserID;
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
}
