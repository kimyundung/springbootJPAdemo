package com.stone;

import com.stone.entity.User;
import com.stone.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springbootjpademo05ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void test1() {
		List<User> userList = userMapper.findAll();
		System.out.println(userList);
	}

}
