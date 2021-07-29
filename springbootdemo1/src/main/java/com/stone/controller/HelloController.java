package com.stone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot")
public class HelloController {

    @RequestMapping("/hello")
    public String helloBoot(){
        return "Hello Spring Boot";
    }

}
