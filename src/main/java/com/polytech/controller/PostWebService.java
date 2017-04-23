package com.polytech.controller;

import com.polytech.model.Post;
import com.polytech.service.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by CODING on 23/04/2017.
 */
@RestController
public class PostWebService {
    @Autowired
    private PostServiceImp postServiceImp;

    @RequestMapping("/greeting")
    public Post greeting(@RequestParam(value="id", defaultValue="0") String id) {


        return null;
    }
}
