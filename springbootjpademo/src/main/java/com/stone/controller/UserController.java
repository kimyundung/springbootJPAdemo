package com.stone.controller;

import com.stone.entity.User;
import com.stone.repository.UserRepository;
import com.stone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/findAll")
    public Iterable<User> findAll(){
        Iterable<User> users = userService.findAll();
        return users;
    }

    /**
     * 新僧 & 编辑
     * @param user
     * @return
     */
    @PostMapping("/save")
    public User save(@RequestBody User user){
        User user1 = userService.save(user);
        System.out.println(user);
        System.out.println(user1);
        return user1;
    }

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    @GetMapping("/findByName")
    public List<User> findByName(String name){
        System.out.println("name = " + name);
        List<User> userList = userService.findByName(name);
        return userList;
    }

    /**
     * 通过邮箱查询
     * @param email
     * @return
     */
    @GetMapping("findByEmail")
    public List<User> findByEmail(String email){
        List<User> userList = userService.findByEmail(email);
        return userList;
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping("/getOne/{id}")
    public User getOne(@PathVariable Long id){
        System.out.println("id = " + id);
        User user = userService.getOne(id);
        System.out.println(user);
        return user;
    }
}
