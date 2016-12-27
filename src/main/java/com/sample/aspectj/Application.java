package com.sample.aspectj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by elvis on 12/27/16.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    SomeService someService;

    @Override
    public void run(String... args) {
        someService.someMethod("hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
