package me.akhalef;

import me.akhalef.service.IMetier;
import me.akhalef.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"me.akhalef.service", "me.akhalef.aspect"})
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        SecurityContext.authenticate("root", "root", new String[]{"admin", "user"});

        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("***************");
        System.out.println(metier.getClass().getName());
        System.out.println("***************");
        metier.process();
        double result = metier.compute();
        System.out.println("Result: " + result);
    }
}
