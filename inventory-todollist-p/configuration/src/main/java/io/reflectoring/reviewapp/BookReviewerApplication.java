package io.reflectoring.reviewapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BookReviewerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookReviewerApplication.class, args);
  }

}
