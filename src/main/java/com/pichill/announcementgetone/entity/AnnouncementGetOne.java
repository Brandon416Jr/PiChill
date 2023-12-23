package com.pichill.announcementgetone.entity;

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

import com.pichill.manage.entity.Manage;

@Entity
@Table(name ="announcement")
public class AnnouncementGetOne {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "announceID", updatable = false)
		private Integer announceID;
		
		@JoinColumn(name = "manageID")
		@ManyToOne
		private Manage manage;
		
		@Column(name = "formID")
		private Integer formID;
		
		@Column(name = "annoTitle")
		private String annoTitle;
		
		@Column(name = "annoContent", columnDefinition = "text")
		private String annoContent;
		
		@Column(name = "annoPic", columnDefinition = "longblob")
		private byte[] annoPic;
		
		@Column(name = "annoTime", updatable = false)
		@CreationTimestamp
		private Timestamp annoTime;
		
		@Column(name = "annoStatus")
		private Integer annoStatus;

		public AnnouncementGetOne() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AnnouncementGetOne(Integer announceID, Integer manageID, Integer formID, String annoTitle, String annoContent,
				byte[] annoPic, Timestamp annoTime, Integer annoStatus) {
			super();
			this.announceID = announceID;
			this.manage = manage;
			this.formID = formID;
			this.annoTitle = annoTitle;
			this.annoContent = annoContent;
			this.annoPic = annoPic;
			this.annoTime = annoTime;
			this.annoStatus = annoStatus;
		}

		public Integer getAnnounceID() {
			return announceID;
		}

		public void setAnnounceID(Integer announceID) {
			this.announceID = announceID;
		}

		public Manage getManage() {
			return manage;
		}

		public void setManageID(Integer manageID) {
			this.manage = manage;
		}

		public Integer getFormID() {
			return formID;
		}

		public void setFormID(Integer formID) {
			this.formID = formID;
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

		public Integer getAnnoStatus() {
			return annoStatus;
		}

		public void setAnnoStatus(Integer annoStatus) {
			this.annoStatus = annoStatus;
		}

		@Override
		public String toString() {
			return "Announcement [announceID=" + announceID + ", manageID=" + manage + ", formID=" + formID
					+ ", annoTitle=" + annoTitle + ", annoContent=" + annoContent + ", annoPic=" + Arrays.toString(annoPic)
					+ ", annoTime=" + annoTime + ", annoStatus=" + annoStatus + "]";
		}

	}