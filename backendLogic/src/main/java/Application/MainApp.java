package Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // TODO code application logic here

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/Beans.xml");


    }
}