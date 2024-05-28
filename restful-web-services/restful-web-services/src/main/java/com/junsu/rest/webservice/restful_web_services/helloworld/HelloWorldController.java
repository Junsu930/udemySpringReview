package com.junsu.rest.webservice.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping ("/hello-world")
    public String helloWorld(){
        return "hello World";
    }

    @GetMapping ("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello World");
    }



    @GetMapping ("/hello-world/path-variable/{name}/{ba}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name, @PathVariable String ba){
        return new HelloWorldBean(String.format("Hello World, %s %s", name, ba));
    }
}

