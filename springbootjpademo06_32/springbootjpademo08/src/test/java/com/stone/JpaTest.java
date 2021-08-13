package com.stone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.entity.UserJson;
import com.stone.repository.UserJsonRepository;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JpaTest {

    @Autowired
    private UserJsonRepository userJsonRepository;

    @BeforeAll
    @Rollback(value = false)
    @Transactional
    void init(){
        UserJson userJson = UserJson.builder().name("jackxx").createDate(new Date()).updateDate(new Date()).sex("M").email("123456@126.com").build();
        userJsonRepository.save(userJson);
    }


    @Test
    public void userJsonTest() throws JsonProcessingException {
        List<UserJson> userJsonList = userJsonRepository.findAll();
        userJsonList.get(0).setOther(Maps.newHashMap("address","shanghai"));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userJsonList.get(0)));

    }

}
