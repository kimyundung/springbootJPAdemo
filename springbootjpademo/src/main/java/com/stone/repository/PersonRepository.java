package com.stone.repository;

import com.stone.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    //find

    //and 默认有忽略大小写功能
    List<Person> findByEmailAddressAndLastname(String emailAddress, String lastname);

    //distinct + or
    List<Person> findDistinctByFirstnameOrLastname(String firstname,String lastname);

    //忽略大小写 (MySQL本身带此功能)
    List<Person> findByLastnameIgnoreCase(String lastname);

    //根据 lastname 和 firstname 查询 equal 并且忽略大小写
    List<Person> findByFirstnameAndLastnameAllIgnoreCase(String firstname, String lastname);

    //根据 lastname 和 firstname 查询 equal 并且忽略大小写 (默认)
    List<Person> findByFirstnameAndLastname(String firstname, String lastname);

    //对查询结果根据 firstname 排序，正序
    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

    //对查询结果根据 firstname 排序，倒序
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

    //count delete remove

    //查询总数
    long countByLastname(String lastname);

    //根据一个字段进行删除操作，并返回删除行数
    long deleteByLastname(String lastname);

    //根据Lastname删除一堆Person,并返回删除的Person
    List<Person> removeByLastname(String lastname);

}
