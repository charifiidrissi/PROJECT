package com.polytech.repository;


import com.polytech.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CODING on 15/04/2017.
 */

public interface UserRepository{

    List<User> findAll();
    void save(User user);
}
