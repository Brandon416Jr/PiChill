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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.google.gson.annotations.Expose;
import com.pichill.comment.entity.Comment;
import com.pichill.forumlike.entity.ForumLike;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.report.entity.Report;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postID", updatable = false, insertable = false)
	@Expose
	private Integer postID;

	@ManyToOne
	@JoinColumn(name = "gUserID",referencedColumnName = "gUserID", updatable = false, insertable = false)
    private GeneralUser generalUser;

//	@Column(name = "gUserID", updatable = false, insertable = false)
//	private Integer gUserID;

	@ManyToOne
	@JoinColumn(name = "oUserID",referencedColumnName = "oUserID", updatable = false, insertable = false)
    private OwnerUser ownerUser;

//	@Column(name = "oUserID", updatable = false, insertable = false)
//	private Integer oUserID;

//@ManyToOne
//@JoinColumn(name= "placeID",referencedColumnName = "placeID")
//private Place place;

//	@Column(name = "placeID")
//	private Integer placeID;

	@Column(name = "postTitle")
	@Expose
	private String postTitle;

	@Column(name = "postContent", columnDefinition = "text")
	@Expose
	private String postContent;

	@Column(name = "postType",updatable = false)
	@Expose
	private Integer postType;

	@Column(name = "postTime", updatable = false)
	@CreationTimestamp
	@Expose
	private Timestamp postTime;
	
	@Column(name = "postPic", columnDefinition = "longblob")
	@Expose
	private byte[] postPic;

	@Column(name = "likeCnt", updatable = false)
	@Expose
	private Integer likeCnt;
	
	@Column(name = "commentCnt", updatable = false)
	@Expose
	private Integer commentCnt;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@OrderBy("commentID asc")
	private Set<Comment> comment;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@OrderBy("reportID asc")
	private Set<Report> reports;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@OrderBy("likeID asc")
	private Set<ForumLike> like;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Integer postID, GeneralUser generalUser, OwnerUser ownerUser, String postTitle, String postContent,
			Integer postType, Timestamp postTime, byte[] postPic, Integer likeCnt, Integer commentCnt,
			Set<Comment> comment, Set<Report> reports, Set<ForumLike> like) {
		super();
		this.postID = postID;
		this.generalUser = generalUser;
		this.ownerUser = ownerUser;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postType = postType;
		this.postTime = postTime;
		this.postPic = postPic;
		this.likeCnt = likeCnt;
		this.commentCnt = commentCnt;
//		this.comment = comment;
//		this.reports = reports;
//		this.like = like;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public GeneralUser getGeneralUser() {
		return generalUser;
	}

	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}

	public OwnerUser getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(OwnerUser ownerUser) {
		this.ownerUser = ownerUser;
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

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Set<Report> getReports() {
		return reports;
	}

	public void setReports(Set<Report> reports) {
		this.reports = reports;
	}
//
	public Set<ForumLike> getLike() {
		return like;
	}

	public void setLike(Set<ForumLike> like) {
		this.like = like;
	}
}