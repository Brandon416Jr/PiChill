package com.pichill.contactus.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ContactUs implements Serializable {
	private Integer formID;
	private Integer oUserID;
	private Integer gUserID;
	private String formPurpose;
	private String formContent;
	private byte[] formPic;
	private Timestamp formTime;
	private Integer formStatus;
	private Integer formType;
	
	public ContactUs() {
		super();
	}
	
	public ContactUs(Integer formID, Integer oUserID, Integer gUserID, String formPurpose, String formContent,
			byte[] formPic, Timestamp formTime, Integer formType) {
		this.formID = formID;
		this.oUserID = oUserID;
		this.gUserID = gUserID;
		this.formPurpose = formPurpose;
		this.formContent = formContent;
		this.formPic = formPic;
		this.formTime = formTime;
		this.formType = formType;

	}
	

	public Integer getFormType() {
		return formType;
	}

	public void setFormType(Integer formType) {
		this.formType = formType;
	}

	public Integer getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(Integer formStatus) {
		this.formStatus = formStatus;
	}




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

	@Override
	public String toString() {
		return "ContactUs [formID=" + formID + ", oUserID=" + oUserID + ", gUserID=" + gUserID + ", formPurpose="
				+ formPurpose + ", formContent=" + formContent + ",formPic=" + formPic + ",formTime=" + formTime
				+ ",formStatus=" + formStatus + ",formType=" + formType + "]";
	}
}
