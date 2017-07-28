package com.example.sample.hibernate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.sample.hibernate")
public class SpringBootHibernateDatabaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootHibernateDatabaseApplication.class, args);

    }
}
