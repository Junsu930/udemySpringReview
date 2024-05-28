package com.junsu.rest.webservice.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<User>();
    private static int userCount = 0;

    static{
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Junsu", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }


    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOneUser(int id){
        User foundedUser = users.stream().filter(user-> id == user.getId()).findAny().orElse(null);

        return foundedUser;
    }

}
