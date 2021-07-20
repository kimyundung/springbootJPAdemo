package com.stone.example;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User,Integer> {
    /**
     * 根据名称进行查询用户列表
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据邮箱和名称查询用户列表
     * @param email
     * @param name
     * @return
     */
    List<User> findByEmailAndName(String email, String name);
}
