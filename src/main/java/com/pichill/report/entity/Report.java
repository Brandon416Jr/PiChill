package com.pichill.report.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.google.gson.annotations.Expose;
import com.pichill.comment.entity.Comment;
import com.pichill.manage.entity.Manage;
import com.pichill.post.entity.Post;

@Entity
@Table(name = "report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reportID",updatable = false)
	@Expose
	private Integer reportID;
	
//	@ManyToOne
//	@JoinColumn(name = "manageID",referencedColumnName = "manageID",updatable = false)
//	private Manage manage;
	@Column(name = "manageID",updatable = false)
	@Expose
	private Integer manageID;
	
	@ManyToOne
	@JoinColumn(name = "postID",referencedColumnName = "postID",updatable = false)
	private Post post;
//	@Column(name = "postID",updatable = false)
//	@Expose
//	private Integer postID;
	
	@ManyToOne
	@JoinColumn(name = "commentID",referencedColumnName = "commentID",updatable = false)
	private Comment comment;
//	@Column(name = "commentID",updatable = false)
//	@Expose
//	private Integer commentID;
	
	@Column(name = "reportTime", updatable = false)
	@CreationTimestamp
	@Expose
	private Timestamp reportTime;
	
	@Column(name = "reportStatus")
	private Integer reportStatus;
	
	@Column(name = "reportType")
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
//		this.postID = postID;
//		this.commentID = commentID;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

//	public Integer getCommentID() {
//		return commentID;
//	}
//
//	public Integer getPostID() {
//		return postID;
//	}
//
//	public void setPostID(Integer postID) {
//		this.postID = postID;
//	}
//
//	public void setCommentID(Integer commentID) {
//		this.commentID = commentID;
//	}

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