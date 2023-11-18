package com.pichill.post;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postID;
    private Integer gUserID;
    private Integer oUserID;
    private String postTitle;
    private String postContent;
    private Integer postType;
    private Timestamp postTime;
    private Integer likeCnt;
	
    public Post() {
	}
	public Post(Integer postID, Integer gUserID, Integer oUserID, String postTitle, String postContent, Integer postType,
			Timestamp postTime, Integer likeCnt) {
		this.postID = postID;
		this.gUserID = gUserID;
		this.oUserID = oUserID;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postType = postType;
		this.postTime = postTime;
		this.likeCnt = likeCnt;
	}
	
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	public Integer getgUserID() {
		return gUserID;
	}
	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}
	public Integer getoUserID() {
		return oUserID;
	}
	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Integer getPostType() {
		return postType;
	}
	public void setPostType(Integer postType) {
		this.postType = postType;
	}
	public Timestamp getPostTime() {
		return postTime;
	}
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
	public Integer getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(Integer likeCnt) {
		this.likeCnt = likeCnt;
	}
      
}
