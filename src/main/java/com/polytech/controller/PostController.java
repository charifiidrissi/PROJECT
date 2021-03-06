package com.polytech.controller;

import com.polytech.model.Comment;
import com.polytech.model.LikePost;
import com.polytech.model.Post;
import com.polytech.service.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

/**
 * Created by CODING on 3/15/17.
 */
@Controller
public class PostController {


    @Autowired
    private PostServiceImp postServiceImp;

    List<Post> posts ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "forward:feed";
    }



    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feed(Model model){
        posts = postServiceImp.fetchAll();
        model.addAttribute("posts", posts);
        System.out.println(posts.toString());
        return "feed";
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String post(Post post, Principal principal){
        String username = principal.getName();
        post.setUsername(username);
        postServiceImp.post(post);
        return "redirect:feed";
    }




}