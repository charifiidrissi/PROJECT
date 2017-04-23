package com.polytech.repository;

import com.polytech.model.Post;
import com.polytech.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by CODING on 16/04/2017.
 */
@Repository
@Transactional
public class JpaUserRepository implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public JpaUserRepository(){

    }

    public List<User> findAll() {
        //Langage JPQL
        String req = "SELECT u FROM User u";
        Query query = entityManager.createQuery(req);
        return query.getResultList();

    }

    public void save(User user) {
        entityManager.persist(user);

    }
}
