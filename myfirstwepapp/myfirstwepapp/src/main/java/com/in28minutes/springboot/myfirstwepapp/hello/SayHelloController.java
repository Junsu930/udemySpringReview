package com.in28minutes.springboot.myfirstwepapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    // "say-hello" => "Hello! What are you learning today?"

    @RequestMapping("say-hello")
    public String sayHello(){
        return "sayHello";

    }
}
