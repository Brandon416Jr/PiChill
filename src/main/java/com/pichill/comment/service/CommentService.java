package com.pichill.comment.service;

import java.util.List;

import com.pichill.comment.entity.Comment;

public interface CommentService {
	Comment addComment(Comment comment);
	Comment updateComment(Comment comment);
	void delete(Integer commentID);
	Comment getByCommentID(Integer commentID);
	List<Comment> getAllComments(Integer postID);
}
