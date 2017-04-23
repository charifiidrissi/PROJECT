package com.polytech.repository;

import com.polytech.model.Comment;
import com.polytech.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CODING on 16/04/2017.
 */
@Repository
public interface CommentRepository {

    List<Comment> findAll();
    void save(Comment comment);
    List<Comment> getCommentsPost(String id);
    void deleteComment(String id);
}
