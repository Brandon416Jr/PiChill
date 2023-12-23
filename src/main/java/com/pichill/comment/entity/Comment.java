package com.pichill.comment.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.google.gson.annotations.Expose;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.post.entity.Post;
import com.pichill.report.entity.Report;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentID", updatable = false, insertable = false)
	@Expose
	private Integer commentID;
	
	@ManyToOne
	@JoinColumn(name = "gUserID", referencedColumnName = "gUserID", updatable = false)
	private GeneralUser generalUser;
//	@Column(name = "gUserID", updatable = false)
//	private Integer gUserID;
	
//	@ManyToOne
//	@JoinColumn(name = "postID",referencedColumnName = "postID", updatable = false)
//	private Post post;
	@Column(name = "postID", updatable = false)
	@Expose
	private Integer postID;
	
	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	@Column(name = "commentContent", columnDefinition = "text")
	@Expose
	private String commentContent;
	
	@Column(name = "commentTime", updatable = false)
	@Expose
	@CreationTimestamp
	private Timestamp commentTime;
	
//	@OneToMany(mappedBy = "comment",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@OrderBy("reportID asc")
//	private Set<Report> reports;

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public GeneralUser getGeneralUser() {
		return generalUser;
	}

	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}

//	public Post getPost() {
//		return post;
//	}
//
//	public void setPost(Post post) {
//		this.post = post;
//	}

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

//	public  Set<Report> getReports() {
//		return reports;
//	}
//
//	public void setReports(Set<Report> reports) {
//		this.reports = reports;
//	}
}