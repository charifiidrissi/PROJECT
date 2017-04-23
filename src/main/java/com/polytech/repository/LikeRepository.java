package com.polytech.repository;

import com.polytech.model.LikePost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CODING on 17/04/2017.
 */
@Repository
public interface LikeRepository {

    List<LikePost> findAll();
    public void likeAndNoLike(LikePost likePost);
    List<LikePost> likesPost(String idPost);
    public void delete(LikePost likePost);

}
