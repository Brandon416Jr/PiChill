package com.pichill.like;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "like")
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeID;
	private Integer gUserID;
	private Integer postID;
	
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(Integer likeID, Integer gUserID, Integer postID) {
		super();
		this.likeID = likeID;
		this.gUserID = gUserID;
		this.postID = postID;
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
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	
	
}
