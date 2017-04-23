package com.polytech.view;

import com.polytech.service.PostServiceImp;
import com.polytech.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dev on 3/13/17.
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "PROD");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PostServiceImp postServiceImp = applicationContext.getBean(PostServiceImp.class);

        /*Post post = new Post("Luminy est cool");
        Post post1 = new Post("Etoil");
        Post post2 = new Post("Test");
        publicationService.post(post);
        publicationService.post(post1);
        publicationService.post(post2);*/

        System.out.println(postServiceImp.fetchAll());
    }
}
