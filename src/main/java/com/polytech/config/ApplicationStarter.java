package com.polytech.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Created by CODING on 3/16/17.
 */
@SpringBootApplication
@Import(ApplicationConfig.class)
public class ApplicationStarter {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "DEV");
        SpringApplication.run(ApplicationStarter.class, args);
    }





}
