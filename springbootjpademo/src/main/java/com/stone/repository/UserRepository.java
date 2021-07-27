package com.stone.repository;

import com.stone.entity.User;
import com.stone.entity.UserOnlyNameEmailDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
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
