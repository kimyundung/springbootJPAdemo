package com.stone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.entity.User;
import com.stone.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryQueryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){
        //调用上面的方法查看结果
        List<User> userDtoList = userRepository.findByQuery("stone");
        System.out.println(userDtoList);
    }

    @Test
    public void test2(){
        // 案例 1
//        List<User> userList = userRepository.findByEmail("stone@stone");
//        System.out.println(userList);

        // 案例 2
//        List<User> userList = userRepository.findByNameEndsWith("2");
//        System.out.println(userList);

        // 案例 3
//        List<User> userList = userRepository.findByAddress("shanghai");
//        System.out.println(userList);

        // 案例 4 ERROR
//        List<User> userList = userRepository.findByNameAndEmail("stone", "stone@stone", Sort.by(Sort.Direction.ASC, "name"));
//        System.out.println(userList);

        // 案例 5
//        List<User> userList = userRepository.findByNameAndEmail("STONE", "STONE@STONE", "name");
//        System.out.println(userList);
    }

    @Test
    public void test3(){
        // 案例 6
        List<User> userList = userRepository.findByAndSort("2", Sort.by(Sort.Direction.DESC, "name"));
        System.out.println(userList);
        System.out.println("-------------------------------------");

        // error
//        List<User> userList1 = userRepository.findByAndSort("2", Sort.by("LENGTH(name)"));
//        List<User> userList1 = userRepository.findByAndSort("2", Sort.by(Sort.Direction.ASC, "LENGTH(name)"));
//        System.out.println(userList1);
//        System.out.println("-------------------------------------");

        List<User> userList2 = userRepository.findByAndSort("2", JpaSort.unsafe("LENGTH(name)"));
        System.out.println(userList2);
        System.out.println("-------------------------------------");

        List<Object[]> objects = userRepository.findByAsArrayAndSort("2", Sort.by("fn_len"));
        for(Object[] o : objects){
            System.out.println(Arrays.toString(o));
        }
    }

    ObjectMapper ob = new ObjectMapper();
    @Test
    public void test4() throws JsonProcessingException {
        // 案例 7
        Page<User> userPage = userRepository.findByName("stone", PageRequest.of(1, 2));
        System.out.println(ob.writeValueAsString(userPage));
    }

    @Test
    public void test5() throws JsonProcessingException {
        // 案例 8
        Page<User> userPage = userRepository.findByNameLike("stone", PageRequest.of(1, 2));
        System.out.println(ob.writeValueAsString(userPage));
        /* ????????????????????????????????
        {
            "content": [
                {
                    "id": 32,
                    "name": "stoneUpdate2",
                    "email": "stone@stone",
                    "sex": null,
                    "address": null
                },
                {
                    "id": 33,
                    "name": "stone2",
                    "email": "stone2@stone",
                    "sex": null,
                    "address": "shanghai"
                },
                {
                    "id": 34,
                    "name": "stone",
                    "email": "stone@stone",
                    "sex": null,
                    "address": null
                },
                {
                    "id": 54,
                    "name": "stone",
                    "email": "stone@stone",
                    "sex": "women",
                    "address": "yancheng"
                },
                {
                    "id": 56,
                    "name": "stone",
                    "email": "stone3@stone",
                    "sex": "man",
                    "address": "yancheng"
                }
            ],
            "pageable": {
                "sort": {
                    "unsorted": true,
                    "sorted": false,
                    "empty": true
                },
                "offset": 2,
                "pageNumber": 1,
                "pageSize": 2,
                "paged": true,
                "unpaged": false
            },
            "last": false,
            "totalElements": 5,
            "totalPages": 3,
            "size": 2,
            "number": 1,
            "sort": {
                "unsorted": true,
                "sorted": false,
                "empty": true
            },
            "first": false,
            "numberOfElements": 5,
            "empty": false
        }
        */
    }
}
