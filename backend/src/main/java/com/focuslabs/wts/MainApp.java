package com.focuslabs.wts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = SpringApplication.run(MainApp.class, args);
    }
}