package com.stone;

import com.stone.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void deleteByLastname(){
        long delete = personRepository.deleteByLastname("yu");
        System.out.println(delete);
    }
}
