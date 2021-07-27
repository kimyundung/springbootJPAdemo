package com.stone;

import com.stone.entity.User;
import com.stone.entity.UserOnlyNameEmailDto;
import com.stone.entity.UserOnlyNameEmailEntity;
import com.stone.pojo.UserOnlyName;
import com.stone.repository.UserOnlyNameEmailEntityRepository;
import com.stone.repository.UserRepository;
import com.stone.repository.UserRepository2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserOnlyNameEmailEntityRepository userOnlyNameEmailEntityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepository2 userRepository2;

    @Test
    public void test1(){
        UserOnlyNameEmailEntity user = userOnlyNameEmailEntityRepository.getOne(54L);
        System.out.println("-------------------------------");
        System.out.println(user);
        System.out.println("-------------------------------");
        User one = userRepository.getOne(54L);
        System.out.println("-------------------------------");
        System.out.println(one);
        System.out.println("-------------------------------");

    }

    @Test
    public void testDTO(){ // not bad
        List<UserOnlyNameEmailDto> dtoList = userRepository2.findByEmail("stone@stone");
        System.out.println("-------------------------------");
        System.out.println(dtoList);
        System.out.println("-------------------------------");
    }

    @Test
    public void testPojo(){
        List<UserOnlyName> userList = userRepository2.findByAddress("shanghai");
        System.out.println("-------------------------------");
        System.out.println(userList);
//        System.out.println(userList.get(0).getName());
//        System.out.println(userList.get(0).getEmail());
        System.out.println("-------------------------------");
    }
}
