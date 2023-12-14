package com.pichill.like.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pichill.post.entity.Post;

@Entity
@Table(name = "like")
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "likeID",updatable = false)
	private Integer likeID;
	
//	@ManyToOne
//	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID")
//	private GUser gUser;
	@Column(name = "gUserID")
	private Integer gUserID;
	
	@ManyToOne
	@JoinColumn(name = "postID",referencedColumnName = "postID")
	private Post post;
//	private Integer postID;
	
	@Column(name = "likeStatus")
	private Integer likeStatus;
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(Integer likeID, Integer gUserID, Integer postID) {
		super();
		this.likeID = likeID;
		this.gUserID = gUserID;
//		this.postID = postID;
	}
	public Integer getLikeID() {
		return likeID;
	}
	public void setLikeID(Integer likeID) {
		this.likeID = likeID;
	}
	public Integer getgUserID() {
		return gUserID;
	}
	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}
//	public Integer getPostID() {
//		return postID;
//	}
//	public void setPostID(Integer postID) {
//		this.postID = postID;
//	}
	public Integer getLikeStatus() {
		return likeStatus;
	}
	public void setLikeStatus(Integer likeStatus) {
		this.likeStatus = likeStatus;
	}
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
