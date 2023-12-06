package com.pichill.forumpic.entity;

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

@Entity
@Table(name = "forumpic")
public class ForumPic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "forumPicID",updatable = false , insertable = false)
    private Integer forumPicID;
	
//	@ManyToOne
//	@JoinColumn(name = "postID",referencedColumnName = "postID")
//	 private Post post;
	@Column(name = "postID",updatable = false)
    private Integer postID;
	
	@Column(name = "postPic", columnDefinition = "longblob")
    private byte[] postPic;
	
	@Column(name = "picTime",updatable = false)
	@CreationTimestamp
    private Timestamp picTime;
	
    public ForumPic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForumPic(Integer forumPicID, Integer postID, byte[] postPic, Timestamp picTime) {
		super();
		this.forumPicID = forumPicID;
		this.postID = postID;
		this.postPic = postPic;
		this.picTime = picTime;
	}

	public Integer getForumPicID() {
		return forumPicID;
	}

	public void setForumPicID(Integer forumPicID) {
		this.forumPicID = forumPicID;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public byte[] getPostPic() {
		return postPic;
	}

	public void setPostPic(byte[] postPic) {
		this.postPic = postPic;
	}

	public Timestamp getPicTime() {
		return picTime;
	}

	public void setPicTime(Timestamp picTime) {
		this.picTime = picTime;
	}
    	
}
