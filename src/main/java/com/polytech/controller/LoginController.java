package com.polytech.controller;

import com.polytech.model.User;
import com.polytech.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by CODING on 17/03/2017.
 */
@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/login")
    public String loginPage(@Valid User user ,BindingResult bindingResult)
    {

        return "login";
    }

    @RequestMapping(value ="/register" , method = RequestMethod.POST)
    public String registerPage(@Valid User user ,BindingResult bindingResult){
        System.out.println(">>>>>>>>>>>>>>>>>>>"+user.getEmail());
       user.setEnabled(true);
        if (bindingResult.hasErrors()) {
            return "register" ;
        }
        userService.registreUser(user);
        return "login";
    }
}
