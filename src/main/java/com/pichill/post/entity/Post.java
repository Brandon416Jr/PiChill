package com.pichill.post.entity;

import java.sql.Timestamp;
import java.util.Arrays;
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
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.forumpic.entity.ForumPic;
import com.pichill.forumlike.entity.ForumLike;
import com.pichill.report.entity.Report;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postID", updatable = false, insertable = false)
	private Integer postID;

//	@ManyToOne
//	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID", updatable = false, insertable = false)
//    private GUser gUser;

	@Column(name = "gUserID", updatable = false, insertable = false)
	private Integer gUserID;

//	@ManyToOne
//	@JoinColumn(name = "oUserID",referencedColumnName = "oUserID", updatable = false, insertable = false)
//    private OUser oUser;

	@Column(name = "oUserID", updatable = false, insertable = false)
	private Integer oUserID;

//@ManyToOne
//@JoinColumn(name= "placeID",referencedColumnName = "placeID")
//private Place place;

	@Column(name = "placeID")
	private Integer placeID;

	@Column(name = "postTitle")
	private String postTitle;

	@Column(name = "postContent", columnDefinition = "text")
	private String postContent;

	@Column(name = "postType",updatable = false)
	private Integer postType;

	@Column(name = "postTime", updatable = false)
	@CreationTimestamp
	private Timestamp postTime;
	
	@Column(name = "postPic", columnDefinition = "longblob")
	private byte[] postPic;

	@Column(name = "likeCnt", updatable = false)
	private Integer likeCnt;
	
	@Column(name = "commentCnt", updatable = false)
	private Integer commentCnt;
	
//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	@OrderBy("reportID asc")
//	private Set<Report> reports;

//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	@OrderBy("likeID asc")
//	private Set<Like> likes;
	
//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	@OrderBy("forumPicID asc")
//	private Set<ForumPic> forumPics;

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

	public Integer getPlaceID() {
		return placeID;
	}

	public void setPlaceID(Integer placeID) {
		this.placeID = placeID;
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

	public byte[] getPostPic() {
		return postPic;
	}

	public void setPostPic(byte[] postPic) {
		this.postPic = postPic;
	}

	public Integer getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(Integer likeCnt) {
		this.likeCnt = likeCnt;
	}

	public Integer getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(Integer commentCnt) {
		this.commentCnt = commentCnt;
	}

//	public Set<Like>getLikes(){
//		return likes;
//	}
//	
//	public void setLikes(Set<Like>likes) {
//		this.likes = likes;
//	}
	@Override
	public String toString() {
		return "Post [postID=" + postID + ", gUserID=" + gUserID + ", oUserID=" + oUserID + ", placeID=" + placeID
				+ ", postTitle=" + postTitle + ", postContent=" + postContent + ", postType=" + postType + ", postTime="
				+ postTime + ", postPic=" + Arrays.toString(postPic) + ", likeCnt=" + likeCnt + ", commentCnt="
				+ commentCnt + "]";
	}


	
}
