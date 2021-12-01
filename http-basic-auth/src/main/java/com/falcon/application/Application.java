package com.falcon.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.falcon")
@EnableJpaRepositories("com.falcon.infrastructure.repository")
@EntityScan("com.falcon.infrastructure.models")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
