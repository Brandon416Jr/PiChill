package com.pichill.like;

import java.util.List;

public interface LikeDAO {
	void add(Like like);
	void update(Like like);
	void delete(int likeID);
	Like findByPK(Integer likeID);
	List<Like> getAll();
}
