package com.pichill.backstage.commentb.model;

import java.util.List;

import com.pichill.comment.entity.Comment;

public interface CommentDAOBack {
	int add(Comment comment);
	int update(Comment comment);
	int delete(Integer commentID);
	Comment getByCommentID(Integer commentID);
	List<Comment> getAll();
}
