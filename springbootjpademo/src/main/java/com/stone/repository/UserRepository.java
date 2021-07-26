package com.stone.repository;

import com.stone.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    /**
     * 根据名称进行查询用户列表
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据邮箱和名称查询用户列表
     * @param email
     * @return
     */
    List<User> findByEmail(String email);
}
