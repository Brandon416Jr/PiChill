package com.pichill.comment.model;

import java.util.List;

import com.pichill.comment.entity.Comment;

public interface CommentDAO {
	int add(Comment comment);
	int update(Comment comment);
	int delete(Integer commentID);
	Comment getByCommentID(Integer commentID);
	List<Comment> getAll(Integer postID);
	long getCommentCnt(Integer postID);
}
