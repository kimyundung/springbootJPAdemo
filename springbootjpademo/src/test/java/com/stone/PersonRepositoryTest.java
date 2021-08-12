package com.stone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.entity.Person;
import com.stone.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    // 静态排序 动态排序 (生成的SQL语句相同)
    @Test
    public void testSort(){
        /*List<Person> personList = personRepository.findByLastname("stone", Sort.by(Sort.Direction.ASC, "firstname"));
        System.out.println(personList);*/
        List<Person> personList1 = personRepository.findByLastnameOrderByFirstnameAsc("stone");
        System.out.println(personList1);
    }

    // pageable
    @Test
    public void testPageable() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        //from person person0_ where person0_.lastname=? limit ?, ?
        /*Page<Person> personPage = personRepository.findByLastname("stone", PageRequest.of(1, 2));
        System.out.println(objectMapper.writeValueAsString(personPage));*/

        //from person person0_ where person0_.firstname=? limit ?, ?
        /*Slice<Person> personSlice = personRepository.findByFirstname("kim", PageRequest.of(1, 2));
        System.out.println(objectMapper.writeValueAsString(personSlice));*/

        //from person person0_ where person0_.email_address=? limit ?, ?
        /*List<Person> personList = personRepository.findByEmailAddress("stone@stone", PageRequest.of(1, 2));
        System.out.println(objectMapper.writeValueAsString(personList));*/

        //from person person0_ where person0_.email_address=? order by person0_.firstname asc limit ?, ?
        /*List<Person> personList = personRepository.findByEmailAddress("stone@stone", PageRequest.of(1,2, Sort.Direction.ASC,"firstname"));
        System.out.println(objectMapper.writeValueAsString(personList));*/
    }
}
