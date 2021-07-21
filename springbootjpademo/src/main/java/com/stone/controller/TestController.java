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

    /**
     * 添加&更新
     * @param test
     * @return
     */
    @PostMapping("test")
    public String addNewTest(@RequestBody Test test){
        Test save = testRepository.save(test);
        System.out.println(save);
        return "success";
    }

    /**
     * 分页查询
     * @param request
     * @return
     */
    @GetMapping("/tests")
    public Page<Test> getTests(Pageable request){
        Page<Test> all = testRepository.findAll(request);
        System.out.println(all);
        return all;
    }

}
