package com.pichill.announcement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

public class Announcement  implements Serializable  {
	private Integer announceID;
	private Integer manageID;
	private String annoTitle;
	private String annoContent;
	private byte[] annoPic;
	private Timestamp annoTime;
	
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Announcement(Integer announceID, Integer manageID, String annoTitle, String annoContent, byte[] annoPic,
			Timestamp annoTime) {
		super();
		this.announceID = announceID;
		this.manageID = manageID;
		this.annoTitle = annoTitle;
		this.annoContent = annoContent;
		this.annoPic = annoPic;
		this.annoTime = annoTime;
	}

	public Integer getAnnounceID() {
		return announceID;
	}

	public void setAnnounceID(Integer announceID) {
		this.announceID = announceID;
	}

	public Integer getManageID() {
		return manageID;
	}

	public void setManageID(Integer manageID) {
		this.manageID = manageID;
	}

	public String getAnnoTitle() {
		return annoTitle;
	}

	public void setAnnoTitle(String annoTitle) {
		this.annoTitle = annoTitle;
	}

	public String getAnnoContent() {
		return annoContent;
	}

	public void setAnnoContent(String annoContent) {
		this.annoContent = annoContent;
	}

	public byte[] getAnnoPic() {
		return annoPic;
	}

	public void setAnnoPic(byte[] annoPic) {
		this.annoPic = annoPic;
	}

	public Timestamp getAnnoTime() {
		return annoTime;
	}

	public void setAnnoTime(Timestamp annoTime) {
		this.annoTime = annoTime;
	}

	@Override
	public String toString() {
		return "Annoucement [announceID=" + announceID + ", manageID=" + manageID + ", annoTitle=" + annoTitle
				+ ", annoContent=" + annoContent + ", annoPic=" + Arrays.toString(annoPic) + ", annoTime=" + annoTime
				+ "]";
	}

	
}
