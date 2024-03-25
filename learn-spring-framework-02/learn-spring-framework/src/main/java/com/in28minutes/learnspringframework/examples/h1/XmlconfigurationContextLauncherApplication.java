package com.in28minutes.learnspringframework.examples.h1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlconfigurationContextLauncherApplication {
    public static void main(String[] args) {
        try (var ac = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(ac.getBean("name"));
        }
    }
}
