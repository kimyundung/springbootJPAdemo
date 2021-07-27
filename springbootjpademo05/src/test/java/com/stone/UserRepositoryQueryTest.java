package com.stone;

import com.stone.entity.User;
import com.stone.repository.UserDtoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryQueryTest {
    @Autowired
    private UserDtoRepository userDtoRepository;

    @Test
    public void test1(){
        //调用上面的方法查看结果
        List<User> userList = userDtoRepository.findByQuery("stone");
        System.out.println(userList);
    }
}
