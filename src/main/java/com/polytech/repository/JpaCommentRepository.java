package com.polytech.repository;

import com.polytech.model.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by CODING on 17/04/2017.
 */
@Repository
@Transactional
public class JpaCommentRepository implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        String req = "SELECT c FROM Comment c";
        Query query = entityManager.createQuery(req);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getCommentsPost(String id) {
        String req = "SELECT c FROM Comment c WHERE c.ID_POST like "+id;
        Query query = entityManager.createQuery(req);

        return query.getResultList();
    }

    @Override
    public void deleteComment(String id) {
        entityManager.createQuery("DELETE FROM Comment c WHERE c.id=" + id).executeUpdate();
    }
}
