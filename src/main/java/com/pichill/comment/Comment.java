package com.pichill.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentID;
	private Integer gUserID;
	private Integer postID;
	private String commentContent;
	private Timestamp commentTime;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Integer commentID, Integer gUserID, Integer postID, String commentContent, Timestamp commentTime) {
		super();
		this.commentID = commentID;
		this.gUserID = gUserID;
		this.postID = postID;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
	}
	public Integer getCommentID() {
		return commentID;
	}
	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}
	public Integer getgUserID() {
		return gUserID;
	}
	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	
}
