package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// 레코드란 컴팩트 생성자 - getter, setter 등 적을 필요 없이 자동 생성
record Person (String name , int age, Address address){};
record Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "SpringJs";
    }

    @Bean
    public int age() {return 30;}

    @Bean
    @Primary
    public Person person() {
        return new Person("Aldo", 32, new Address("Happy Apt"
                ,"Seoul"));
    }

    @Bean
    public Person person2(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3(String name, int age, @Qualifier("address3qualifier") Address address2){
        return new Person(name, age, address2);
    }

    @Bean(name = "address2")
    @Primary
    public  Address address() {
        return new Address("Shire", "Hobitton");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public  Address address3() {
        return new Address("Laffiniel", "Uijeongbu");
    }

}
