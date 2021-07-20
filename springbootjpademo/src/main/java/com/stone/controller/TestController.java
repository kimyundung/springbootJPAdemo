package com.stone.controller;

import com.stone.example.Test;
import com.stone.example.Test2;
import com.stone.example.Test2Repository;
import com.stone.example.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boot")
public class TestController {
    @GetMapping("hello")
    public String hello(){
        return "Hello Spring Boot JPA";
    }

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/getOne/{id}")
    public Test getOneTest(@PathVariable Long id){
        Test one = testRepository.getOne(id);
        System.out.println(one);
        return one;
    }

    @PostMapping("test")
    public String addNewTest(@RequestBody Test test){
        Test save = testRepository.save(test);
        System.out.println(save);
        return "success";
    }

    @GetMapping("/tests")
    public Page<Test> getTests(Pageable request){
        Page<Test> all = testRepository.findAll(request);
        System.out.println(all);
        return all;
    }

    @Autowired
    private Test2Repository test2Repository;

    // consumes 加不加没看出区别
    @PostMapping(path = "test2",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Test2 addNewTest2(@RequestBody Test2 test2){
        System.out.println(test2);
        Test2 save = test2Repository.save(test2);
        System.out.println(save);
        return save;
    }

}
