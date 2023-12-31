package com.pichill.comment.service;

import java.util.List;

import com.pichill.comment.entity.Comment;
import com.pichill.comment.model.CommentDAO;
import com.pichill.comment.model.CommentDAOImpl;

public class CommentServiceImpl implements CommentService{

	private CommentDAO dao;
	
	public CommentServiceImpl() {
		dao = new CommentDAOImpl(); 
	}

	@Override
	public Comment addComment(Comment comment) {
		Integer id = dao.add(comment);
	    System.out.println("=================");
	    System.out.println(id);
		comment = dao.getByCommentID(id);
		return comment;
	}

	@Override
	public Comment updateComment(Comment comment) {
		if (dao.update(comment) == 1) {
			return comment;
		} else
			return null;
	}

	@Override
	public void delete(Integer commentID) {
		dao.delete(commentID);
		
	}

	@Override
	public Comment getByCommentID(Integer commentID) {
		return dao.getByCommentID(commentID);
	}

	@Override
	public List<Comment> getAllComments(Integer postID) {
		return dao.getAll(postID);
	}

	@Override
	public long getCommentCnt(Integer postID) {
	return dao.getCommentCnt(postID);
	}
			
}
