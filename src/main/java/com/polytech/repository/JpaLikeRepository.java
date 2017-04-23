package com.polytech.repository;

import com.polytech.model.LikePost;
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
public class JpaLikeRepository implements LikeRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<LikePost> findAll() {
        String req = "SELECT c FROM LikePost c";
        Query query = entityManager.createQuery(req);
        return query.getResultList();
    }

    @Override
    public void likeAndNoLike(LikePost likePost) {
        String req = "SELECT c FROM LikePost c WHERE " +
                "c.ID_POST like "+ likePost.getID_POST()+" " +
                "and c.username like '"+likePost.getUsername()+"'";
        Query query = entityManager.createQuery(req);
        List<LikePost> l = query.getResultList();

        System.out.println(l.toString());
        if(l.size()==0) entityManager.persist(likePost);
        else delete(l.get(0));

    }

    @Override
    public List<LikePost> likesPost(String idPost) {
        String req = "SELECT c FROM LikePost c WHERE c.ID_POST like "+idPost;
        Query query = entityManager.createQuery(req);

        return query.getResultList();


    }

    @Override
    public void delete(LikePost likePost) {
        entityManager.remove(likePost);
    }


}
