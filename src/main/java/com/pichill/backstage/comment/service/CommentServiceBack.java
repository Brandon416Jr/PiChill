package com.pichill.backstage.comment.service;

import java.util.List;
import com.pichill.comment.model.CommentDAO;
import com.pichill.backstage.comment.model.CommentDAOImplBack;
import com.pichill.comment.entity.Comment;

public class CommentServiceBack {
	private final CommentDAO dao;

	public CommentServiceBack() {
		dao = new CommentDAOImplBack();
	}
	
	public void deleteCommentBack(Integer commentID) {
		dao.delete(commentID);
	}
	
	public List<Comment> getAll() {
		return dao.getAll();
	}

}
