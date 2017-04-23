package com.polytech.service;

import com.polytech.model.Role;
import com.polytech.model.User;
import com.polytech.repository.RoleRepository;
import com.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by CODING on 15/04/2017.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;





    @Override
    public boolean existUser(String user) {


     return false;
    }

    @Override
    public String bcryptPass(String passClair) {


     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
     String hashedPassword = passwordEncoder.encode(passClair);
     return hashedPassword;
    }

    @Override
    public void sendPass(String mail) {

    }

    @Override
    public void registreUser(User user) {
     user.setPassword(bcryptPass(user.getPassword()));
     user.setEnabled(true);
     userRepository.save(user);
     roleRepository.save(new Role(user.getUsername(),"USER"));



     System.out.println(userRepository.findAll().toString());
        System.out.println(roleRepository.findAll().toString());
    }
}
