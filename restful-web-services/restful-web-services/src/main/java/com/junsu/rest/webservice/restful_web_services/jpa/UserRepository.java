package com.junsu.rest.webservice.restful_web_services.jpa;

import com.junsu.rest.webservice.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
