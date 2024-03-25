package com.in28minutes.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class NormalClass{


}
@Scope(value = ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)){
            System.out.println(ac.getBean(NormalClass.class));
            System.out.println(ac.getBean(NormalClass.class));
            System.out.println(ac.getBean(NormalClass.class));
            System.out.println(ac.getBean(NormalClass.class));
            System.out.println(ac.getBean(NormalClass.class));

            System.out.println(ac.getBean(PrototypeClass.class));
            System.out.println(ac.getBean(PrototypeClass.class));
            System.out.println(ac.getBean(PrototypeClass.class));
            System.out.println(ac.getBean(PrototypeClass.class));
        }
    }
}
