package com.pichill.forumlike.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.post.entity.Post;

@Entity
@Table(name = "forumLike")
public class ForumLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "likeID",updatable = false)
	@Expose
	private Integer likeID;
	
	@ManyToOne
	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID")
	private GeneralUser generalUser;
//	@Column(name = "gUserID")
//	private Integer gUserID;
	
	@ManyToOne
	@JoinColumn(name = "postID",referencedColumnName = "postID")
	private Post post;
//	@Column(name = "postID")
//	@Expose
//	private Integer postID;
	
	@Column(name = "likeStatus")
	@Expose
	private boolean likeStatus;

	public Integer getLikeID() {
		return likeID;
	}

	public void setLikeID(Integer likeID) {
		this.likeID = likeID;
	}

	public GeneralUser getGeneralUser() {
		return generalUser;
	}

	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}

//	public Integer getPostID() {
//		return postID;
//	}
//
//	public void setPostID(Integer postID) {
//		this.postID = postID;
//	}

	public boolean isLikeStatus() {
		return likeStatus;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setLikeStatus(boolean likeStatus) {
		this.likeStatus = likeStatus;
	}
	
}
