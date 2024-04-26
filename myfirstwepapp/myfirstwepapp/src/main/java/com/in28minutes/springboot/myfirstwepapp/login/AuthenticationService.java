package com.in28minutes.springboot.myfirstwepapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean isValidUserName = username.equalsIgnoreCase("junsu");
        boolean isValidUserPassword = password.equalsIgnoreCase("wnstn");
        return isValidUserName && isValidUserPassword;

    }
}
