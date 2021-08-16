package com.stone.controller;

import com.stone.entity.User;
import com.stone.repository.UserRepository;
import com.stone.specification.SpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/users")
    @ResponseBody
    public List<User> search(@RequestParam(value = "search") String search){
        Specification<User> userSpecification = new SpecificationsBuilder<User>().buildSpecification(search);
        return userRepository.findAll(userSpecification);
    }
}
