package com.stone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.entity.Person;
import com.stone.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import java.util.stream.Stream;

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

    @Test
    public void findAllByCustomQueryAndStreamTest(){
        //stream是流，需要关闭
        Stream<Person> personStream = personRepository.findAllByCustomQueryAndStream(PageRequest.of(1, 3));
        try {
            personStream.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(personStream!=null){
                personStream.close();
            }
        }
    }

    @Test
    public void findAllByCustomQueryAndSliceTest(){
        //我们利用ObjectMapper将我们的返回结果Json to String
        ObjectMapper objectMapper = new ObjectMapper();
        Slice<Person> personSlice = personRepository.findAllByCustomQueryAndSlice(PageRequest.of(0, 3));
        try {
            System.out.println(objectMapper.writeValueAsString(personSlice));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
