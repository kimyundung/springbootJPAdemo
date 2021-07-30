package com.stone;

import com.stone.dto.UserDto;
import com.stone.dto.UserSimpleDto;
import com.stone.repository.UserDtoRepository;
import com.stone.repository.UserExtendRepository;
import com.stone.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserExtendRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDtoRepository userDtoRepository;
    @Autowired
    private UserExtendRepository userExtendRepository;

    @Test
    public void test1 () {
        //UserExtend userExtend = userExtendRepository.save(UserExtend.builder().userId(32L).ages(32).idCard("shengfengzhenghao").studentNumber("xuehao001").build());
        List<Object[]> objectList = userDtoRepository.findByUserId(32L);
        for(Object[] o: objectList){
            UserDto userDto = UserDto.builder().name((String) o[0]).build();
            System.out.println(userDto);
        }
    }

    @Test
    public void test2 () {
        List<UserDto> userDtoList = userDtoRepository.findByUserDtoId(32L);
        System.out.println(userDtoList);
    }

    @Test
    public void test3 () {
        List<UserSimpleDto> userSimpleDtoList = userDtoRepository.findByUserSimpleDtoId(32L);
        for (UserSimpleDto userSimpleDto : userSimpleDtoList) {
            System.out.println(userSimpleDto.getName() + ", " + userSimpleDto.getEmail() + ", " + userSimpleDto.getIdCard());
        }
    }
}
