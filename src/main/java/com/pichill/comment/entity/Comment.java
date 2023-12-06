package com.pichill.comment.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.post.entity.Post;
import com.pichill.report.entity.Report;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentID", updatable = false, insertable = false)
	private Integer commentID;
	
//	@ManyToOne
//	@JoinColumn(name = "gUserID", referencedColumnName = "gUserID", updatable = false)
//	private GUser gUser;
	@Column(name = "gUserID", updatable = false)
	private Integer gUserID;
	
//	@ManyToOne
//	@JoinColumn(name = "postID",referencedColumnName = "postID", updatable = false)
//	private Post post;
	@Column(name = "postID", updatable = false)
	private Integer postID;
	
	@Column(name = "commentContent", columnDefinition = "text")
	private String commentContent;
	
	@Column(name = "commentTime", updatable = false)
	@CreationTimestamp
	private Timestamp commentTime;
	
//	@OneToMany(mappedBy = "comment",cascade = CascadeType.ALL)
//	@OrderBy("reportID asc")
//	private Set<Report> reports;
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
