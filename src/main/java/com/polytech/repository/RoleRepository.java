package com.polytech.repository;

import com.polytech.model.Role;
import com.polytech.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CODING on 16/04/2017.
 */
@Repository
public interface RoleRepository {

    List<Role> findAll();
    void save(Role role);
}
