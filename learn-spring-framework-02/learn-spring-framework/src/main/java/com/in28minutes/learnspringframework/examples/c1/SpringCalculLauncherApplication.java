package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SpringCalculLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringCalculLauncherApplication.class)){
            System.out.println( ac.getBean(BusinessCalculationService.class).findMax());

        }
    }
}
