package com.stone;

import com.stone.repository.TestRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepositoryTest {
    @Autowired
    private TestRepository testRepository;

    @Test
    public void testSaveTest(){
        com.stone.entity.Test test = testRepository.save(com.stone.entity.Test.builder().name("stone10").email("stone10@stone.com").build());
        Assert.assertNotNull(test);
        List<com.stone.entity.Test> all = testRepository.findAll();
        System.out.println(all);
        Assert.assertNotNull(test);
    }
}
