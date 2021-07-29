package com.stone;

import com.stone.dto.UserOnlyName;
import com.stone.entity.User;
import com.stone.repository.UserDtoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryDynamicQueryTest {
    @Autowired
    private UserDtoRepository userDtoRepository;

    @Test
    public void test1(){
        List<UserOnlyName> userOnlyNameList = userDtoRepository.findByUser("stone", null);
        //List<UserOnlyName> userOnlyNameList = userDtoRepository.findByUser(null, null);
        for (UserOnlyName userOnlyName : userOnlyNameList) {
            System.out.println(userOnlyName.getName()+", " + userOnlyName.getEmail());
        }
    }

    @Test
    public void test2(){
        List<UserOnlyName> userOnlyNameList = userDtoRepository.findByUser(User.builder().name("stone").build());
        for (UserOnlyName userOnlyName : userOnlyNameList) {
            System.out.println(userOnlyName.getName()+", " + userOnlyName.getEmail());
        }
    }
}
