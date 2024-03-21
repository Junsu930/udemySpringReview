package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // Lunch a Spring Context
        try {
             AnnotationConfigApplicationContext context
                     = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

            // Configure the things that we want Spring to manage -
            // HelloWorldConfiguration - @Configuration

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2"));
            System.out.println(context.getBean("person3"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));


            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
