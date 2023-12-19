package com.pichill.backstage.comment.service;

import java.util.List;
import com.pichill.backstage.comment.model.CommentDAOBack;
import com.pichill.backstage.comment.model.CommentDAOImplBack;
import com.pichill.comment.entity.Comment;
import com.pichill.report.entity.Report;

public class CommentServiceBack {
	private final CommentDAOBack dao;

	public CommentServiceBack() {
		dao = new CommentDAOImplBack();
	}
	
	public void deleteCommentBack(Integer commentID) {
		dao.delete(commentID);
	}
	
	public List<Comment> getAll() {
		return dao.getAll();
	}
	
	public Comment getOneComment(Integer commentID) {
		return dao.getByCommentID(commentID);
	}


}
