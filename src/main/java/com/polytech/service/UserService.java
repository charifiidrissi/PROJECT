package com.polytech.service;

import com.polytech.model.User;

/**
 * Created by CODING on 15/04/2017.
 */
public interface UserService {

     boolean existUser(String user);
     String bcryptPass(String passClair);
     void sendPass(String mail);
     void registreUser(User user);


}
