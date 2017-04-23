package com.polytech.service;

import com.polytech.model.Comment;
import com.polytech.model.LikePost;
import com.polytech.model.Post;

import java.util.List;

/**
 * Created by CODING on 18/04/2017.
 */
public interface PostService {

    //////////////Post service
    public void post(Post post) ;

    public List<Post> fetchAll();

    public List<Post> searchPost(long id);

    public void update(Post p);
//////////////////////////Comment service

    public void addComment(Comment comment);

    public List<Comment> getCommentsPost(String idPost);

    /////////////Like service
    public void addLike(LikePost likePost) ;

    public List<LikePost> getLikesPost(String idPost);
}
