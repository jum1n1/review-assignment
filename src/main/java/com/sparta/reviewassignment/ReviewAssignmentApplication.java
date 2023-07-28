package com.sparta.reviewassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReviewAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewAssignmentApplication.class, args);
    }

}
