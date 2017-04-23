package com.polytech.repository;

import com.polytech.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CODING on 3/13/17.
 */
@Repository
public interface PostRepository{
    List<Post> findAll();
    void save(Post post);
    List<Post> findById(long id);
    void saveAndFlash(Post post);

}
