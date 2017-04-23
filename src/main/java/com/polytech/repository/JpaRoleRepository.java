package com.polytech.repository;

import com.polytech.model.Role;
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
public class JpaRoleRepository implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaRoleRepository(){

    }


    public List<Role> findAll() {
        //Langage JPQL
        String req = "SELECT r FROM Role r";
        Query query = entityManager.createQuery(req);
        return query.getResultList();

    }

    public void save(Role role) {
        entityManager.persist(role);

    }
}
