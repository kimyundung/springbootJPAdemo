package com.stone;

import com.stone.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Test
    public void deleteByLastname(){
        long delete = personService.deleteByLastname("yu");
        System.out.println(delete);
    }
}
