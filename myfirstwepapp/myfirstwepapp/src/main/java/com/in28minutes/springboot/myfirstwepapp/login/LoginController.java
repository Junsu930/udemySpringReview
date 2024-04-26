package com.in28minutes.springboot.myfirstwepapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    // Model을 통해 전달
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotologinPage(){
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelmap){

        if(authenticationService.authenticate(name,password)){
            modelmap.put("name", name);
            modelmap.put("password",password);
            // Authentication
            return "welcome";
        }

        modelmap.put("errorMessage", "Invalid Credentials! Please Try Again");
        return "login";
    }


}

