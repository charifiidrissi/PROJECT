package com.polytech.service;

import com.polytech.model.Comment;
import com.polytech.model.LikePost;
import com.polytech.model.Post;
import com.polytech.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
@Component
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    public PostServiceImp() {

    }


    //////////////Post service
    public void post(Post post) {

        postRepository.save(post);
    }

    public List<Post> fetchAll(){
        List<Post> p =postRepository.findAll();
        for (Post post:p) {
            post.setComments(commentRepository.getCommentsPost(""+post.getId()));
            post.setLikePosts(likeRepository.likesPost(""+post.getId()));
        }
        return p;
    }

    public Post searchPost(long id)
    {
       List<Post> l =postRepository.findById(id);
       if(l.size()>0) {

           l.get(0).setComments(commentRepository.getCommentsPost("" + l.get(0).getId()));
           l.get(0).setLikePosts(likeRepository.likesPost("" + l.get(0).getId()));
           return l.get(0);
       }
       else return new Post();
    }

    public void update(Post p){
        postRepository.saveAndFlash(p);
    }
//////////////////////////Comment service

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> getCommentsPost(String idPost){
        return  commentRepository.getCommentsPost(idPost);
    }
    /////////////Like service
    public void addLike(LikePost likePost) {
        likeRepository.likeAndNoLike(likePost);
    }

    public List<LikePost> getLikesPost(String idPost){
        return likeRepository.likesPost(idPost);
    }

}
