package main.java.Application;

import main.java.com.focuslabs.wts.entity.City;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // TODO code application logic here

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/Beans.xml");

        City student = (City) context.getBean("city");

        System.out.println("Name : " + student.getName() );
    }
}