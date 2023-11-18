package com.pichill.post;

import java.util.List;

public interface PostDAO {
    void add(Post post);
    void update(Post post);
    void delete(int postID);
    Post findByPK(Integer PostID);
    List<Post>getAll();
}
