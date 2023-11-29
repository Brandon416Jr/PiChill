package com.pichill.post.entity;

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
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.forumpic.entity.ForumPic;
import com.pichill.report.entity.Report;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postID", updatable = false , insertable=false)
    private Integer postID;
	
//	@ManyToOne
//	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID")
//    private GUser gUser;
	
	@Column(name = "gUserID")
	private Integer gUserID;
	
//	@ManyToOne
//	@JoinColumn(name = "oUserID",referencedColumnName = "oUserID")
//    private OUser oUser;
	
	@Column(name = "oUserID")
	private Integer oUserID;
	
	@Column(name = "postTitle")
    private String postTitle;
	
	@Column(name = "postContent")
    private String postContent;
	
	@Column(name = "postType")
    private Integer postType;
	
	@Column(name = "postTime")
	@CreationTimestamp
    private Timestamp postTime;
	
	@Column(name = "likeCnt")
    private Integer likeCnt;
	
//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	@OrderBy("reportID asc")
//	private Set<Report> reports;
//	
//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	@OrderBy("forumPicID asc")
//	private Set<ForumPic> forumPics;
//    public Post() {
//	}
//	public Post(Integer postID, Integer gUserID, Integer oUserID, String postTitle, String postContent, Integer postType,
//			Timestamp postTime, Integer likeCnt) {
//		this.postID = postID;
//		this.gUserID = gUserID;
//		this.oUserID = oUserID;
//		this.postTitle = postTitle;
//		this.postContent = postContent;
//		this.postType = postType;
//		this.postTime = postTime;
//		this.likeCnt = likeCnt;
//	}
	
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
		this.gUserID= gUserID;
	}
	public Integer getoUserID() {
		return oUserID;
	}
	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}
//	public GUser getGUser() {
//		return gUser;
//	}
//	public void setGUserID(GUser gUser) {
//		this.gUser = gUser;
//	}
//	public OUser getOUser() {
//		return oUser;
//	}
//	public void setOUser(OUser oUser) {
//		this.oUser = oUser;
//	}
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
      
	@Override
	public String toString() {
		return "Post [postID=" + postID + ", gUserID=" + gUserID + ", oUserID=" + oUserID + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + ", postType=" + postType + ", postTime=" + postTime + ", likeCnt="
				+ likeCnt + "]";
	}
}
