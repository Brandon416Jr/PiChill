package com.pichill.comment;

import java.util.List;

public interface CommentDAO {
	void add(Comment comment);
	void update(Comment comment);
	void delete(int commentID);
	Comment findByPK(Integer commentID);
	List<Comment> getAll();
}
