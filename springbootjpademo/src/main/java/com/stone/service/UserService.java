package com.stone.service;

import com.stone.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询所有
     * @return
     */
    public Iterable<User> findAll();

    /**
     * 添加 & 更新
     * @param user
     * @return
     */
    public User save(User user);

    /**
     * 通过姓名查询
     * @param name
     * @return
     */
    public List<User> findByName(String name);

    /**
     * 通过邮箱查询
     * @param email
     * @return
     */
    public List<User> findByEmail(String email);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public User getOne(Long id);
}
