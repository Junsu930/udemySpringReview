package com.in28minutes.learnspringframework.examples.a1;

import com.in28minutes.learnspringframework.examples.c1.BusinessCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{

    @Autowired
    Dependency1 dependency1;
    @Autowired
    Dependency2 dependency2;

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }

}

@Component
class Dependency1{}

@Component
class Dependency2{}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
            Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println( ac.getBean(BusinessCalculationService.class).findMax());

        }
    }
}
