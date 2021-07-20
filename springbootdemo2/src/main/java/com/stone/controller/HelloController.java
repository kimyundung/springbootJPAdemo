package com.stone.controller;

import com.stone.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot")
public class HelloController {

    // 1 测试：SpringBoot
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot Demo2 Quick Start!!!!!";
    }

    // 2 测试：JDBC
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("jdbc")
    public String jdbc(){
        return jdbcTemplate.toString();
    }

    // 3 测试：获取配置文件信息
    @Autowired
    private Person person;
    @GetMapping("person")
    public Person person(){
        return person;
    }


}
