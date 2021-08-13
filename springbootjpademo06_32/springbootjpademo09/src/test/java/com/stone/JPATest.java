package com.stone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.entity.SexEnum;
import com.stone.entity.User;
import com.stone.entity.UserAddress;
import com.stone.repository.UserAddressRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JPATest {

    @Autowired
    private UserAddressRepository userAddressRepository;
    private Date now = new Date();

    @BeforeAll
    @Rollback(value = false)
    @Transactional
    void init(){
        User user = User.builder()
                .name("jack")
                .email("123456@126.com")
                .sex(SexEnum.BOY)
                .age(20)
                .createDate(now)
                .updateDate(now)
                .build();
        userAddressRepository.saveAll(
                Lists.newArrayList(
                        UserAddress.builder().user(user).address("shanghai").build(),
                        UserAddress.builder().user(user).address("yancheng").build()
                )
        );
    }

    @Test
    @Rollback(value = false)
    public void testQBEFormUserAddress() throws JsonProcessingException {
        User request = User.builder()
                .name("jack")
                .age(20)
                .email("123")
                .build();
        UserAddress address = UserAddress.builder()
                .address("shang")
                .user(request)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        //打印参数
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address));
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("user.email", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Page<UserAddress> u = userAddressRepository.findAll(Example.of(address, exampleMatcher), PageRequest.of(0, 2));
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(u));
    }
}
