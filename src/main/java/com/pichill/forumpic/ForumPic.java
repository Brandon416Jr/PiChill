package com.pichill.forumpic;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forumpic")
public class ForumPic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumPicID;
    private Integer postID;
    private byte[] postPic;
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
