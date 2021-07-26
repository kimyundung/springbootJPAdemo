package com.stone.service;

import com.stone.entity.User;
import com.stone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    /**
     * 查询所有
     * @return
     */
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 添加 & 更新
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * 通过姓名查询
     * @param name
     * @return
     */
    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    /**
     * 通过邮箱查询
     * @param email
     * @return
     */
    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public User getOne(Long id) {
        return userRepository.getOne(id);
    }
}
