package com.pichill.report;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reportID;
	private Integer manageID;
	private Integer postID;
	private Integer commentID;
	private Timestamp reportTime;
	private Integer reportStatus;
	private Integer reportType;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(Integer reportID, Integer manageID, Integer postID, Integer commentID, Timestamp reportTime,
			Integer reportStatus, Integer reportType) {
		super();
		this.reportID = reportID;
		this.manageID = manageID;
		this.postID = postID;
		this.commentID = commentID;
		this.reportTime = reportTime;
		this.reportStatus = reportStatus;
		this.reportType = reportType;
	}

	public Integer getReportID() {
		return reportID;
	}

	public void setReportID(Integer reportID) {
		this.reportID = reportID;
	}

	public Integer getManageID() {
		return manageID;
	}

	public void setManageID(Integer manageID) {
		this.manageID = manageID;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public Timestamp getReportTime() {
		return reportTime;
	}

	public void setReportTime(Timestamp reportTime) {
		this.reportTime = reportTime;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getReportType() {
		return reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

}