package com.stone.repository;

import com.stone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDtoRepository extends JpaRepository<User,Long> {
    //通过query注解根据name查询user信息
    @Query("From User where name=:name")
    List<User> findByQuery(@Param("name") String nameParam);
}
