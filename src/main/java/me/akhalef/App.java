package me.akhalef;

import me.akhalef.service.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "me.akhalef")
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);

        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("***************");
        System.out.println(metier.getClass().getName());
        System.out.println("***************");
        metier.process();
        double result = metier.compute();
        System.out.println("Result: " + result);
    }
}
