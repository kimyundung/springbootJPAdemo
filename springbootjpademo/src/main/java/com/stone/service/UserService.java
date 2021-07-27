package com.stone.service;

import com.stone.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有
     * @return
     */
    Iterable<User> findAll();

    /**
     * 添加 & 更新
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 通过姓名查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 通过邮箱查询
     * @param email
     * @return
     */
    List<User> findByEmail(String email);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    User getOne(Long id);
}
