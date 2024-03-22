package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
            ac.getBean(GamingConsole.class).up();

            ac.getBean(GameRunner.class).run();
        }
    }
}
