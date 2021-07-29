package com.stone.repository;

import com.stone.dto.UserDto;
import com.stone.dto.UserOnlyName;
import com.stone.dto.UserSimpleDto;
import com.stone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDtoRepository extends JpaRepository<User,Long> {

    /**
     * 查询User表里面的name, email和UserExtend表里面的idCard
     */
    @Query("select u.name, u.email, ue.idCard from User u, UserExtend ue where u.id=ue.userId and u.id=:id")
    List<Object[]> findByUserId(@Param("id") Long id);

    /**
     * 利用 class UserDto 获取我们想要的结果
     */
    @Query("select new com.stone.dto.UserDto(CONCAT(u.name,'JK123'), u.email, ue.idCard) from User u, UserExtend ue where u.id=ue.userId and u.id=:id")
    List<UserDto> findByUserDtoId(@Param("id") Long id);

    /**
     * 利用 UserDto 接口获得我们想要的结果
     */
    @Query("select CONCAT(u.name,'LOVE') as name, UPPER(u.email) as email, ue.idCard as idCard from User u, UserExtend ue where u.id = ue.userId and u.id = :id")
    List<UserSimpleDto> findByUserSimpleDtoId(@Param("id") Long id);

    /**
     * 利用JPQL动态查询用户信息
     */
    @Query("select u.name as name, u.email as email from User u where (:name is null or u.name = :name) and (:email is null or u.email = :email)")
    List<UserOnlyName> findByUser(@Param("name") String name, @Param("email") String email);

    /**
     * 利用原始SQL动态查询用户信息
     */
    @Query(value = "select u.name as name, u.email as email from user u where (:#{#user.name} is null or u.name = :#{#user.name}) and (:#{#user.email} is null or u.email = :#{#user.email})",
           nativeQuery = true)
    List<UserOnlyName> findByUser(@Param("user") User user);
}
