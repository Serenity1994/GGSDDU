package com.example.study_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class StudySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringbootApplication.class, args);
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();

    }

}
