package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
            ac.getBean(GamingConsole.class).up();

            ac.getBean(GameRunner.class).run();
        }
    }
}
