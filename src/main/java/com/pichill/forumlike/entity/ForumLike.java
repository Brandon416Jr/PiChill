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

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.post.entity.Post;

@Entity
@Table(name = "forumLike")
public class ForumLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "likeID",updatable = false)
	private Integer likeID;
	
	@ManyToOne
	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID")
	private GeneralUser generalUser;
//	@Column(name = "gUserID")
//	private Integer gUserID;
	
	@ManyToOne
	@JoinColumn(name = "postID",referencedColumnName = "postID")
	private Post post;
//	private Integer postID;
	
	@Column(name = "likeStatus")
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public boolean isLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(boolean likeStatus) {
		this.likeStatus = likeStatus;
	}

	
}
