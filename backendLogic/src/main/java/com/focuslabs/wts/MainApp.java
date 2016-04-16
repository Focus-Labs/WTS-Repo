package com.focuslabs.wts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = SpringApplication.run(MainApp.class, args);
    }
}