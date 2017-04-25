package com.polytech.controller;

import com.polytech.model.Comment;
import com.polytech.model.LikePost;
import com.polytech.model.Post;
import com.polytech.service.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


/**
 * Created by CODING on 23/04/2017.
 */
@RestController
public class PostWebService {
    @Autowired
    private PostServiceImp postServiceImp;

    @RequestMapping("/posts")
    public  Post  posting(@RequestParam(value="id", defaultValue="0") String id) {


        return postServiceImp.searchPost(Long.parseLong(id));
    }

    @RequestMapping(value = "/addLike")
    public Post addLike(@RequestParam(value="post", required=false, defaultValue="1") String id, Principal principal){
        String username = principal.getName();
        LikePost likePost = new LikePost(username,Integer.parseInt(id));
        //if like already exist then will be deleted
        postServiceImp.addLike(likePost);
          return postServiceImp.searchPost(Long.parseLong(id));
    }


    @RequestMapping(value = "/addcomment")
    public Comment addComment(@RequestParam(value="post",
            required=false, defaultValue="1") String id, Principal principal)
    {

        String[] parts =id.split("-");
        String id2 = parts[0];
        String content = parts[1];

        String username = principal.getName();
        Comment comment = new Comment();
        comment.setUsername(username);
        comment.setContent(content);
        comment.setID_POST(Integer.parseInt(id2));
        comment.setNb_cmt(postServiceImp.getCommentsPost(id2).size()+1);
        postServiceImp.addComment(comment);
        return comment;
    }

}
