package com.stone.repository;

import com.stone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

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


    //分页 排序
    //根据分页参数查询Person，返回一个带分页结果的Page对象（方法一）
    Page<Person> findByLastname(String lastname, Pageable pageable);

    //根据分页参数返回一个Slice的Person结果（方法二）
    Slice<Person> findByFirstname(String firstname, Pageable pageable);

    //根据排序结果返回一个List（方法三）
    List<Person> findByLastname(String lastname, Sort sort);

    //根据分页参数返回一个List对象（方法四）
    List<Person> findByEmailAddress(String emailAddress, Pageable pageable);


    // First Top 限制查询结果
    Person findFirstByOrderByLastnameAsc();

    Person findTopByOrderByIdAsc();

    List<Person> findDistinctPersonTop3ByLastname(String lastname, Pageable pageable);  //Top3无效
    List<Person> findDistinctTop3ByLastname(String lastname, Pageable pageable);        //Top3有效

    List<Person> findFirst5ByLastname(String lastname, Sort sort);

    List<Person> findTop5ByLastname(String lastname, Pageable pageable);


    // @NonNullApi @NonNull @Nullable
    List<Person> getByEmailAddress(String emailAddress);


    // List/Stream/Page/Slice  ->  test测试
    //自定义一个查询方法，返回Stream对象，并且有分页属性
    @Query("select p from Person p")
    Stream<Person> findAllByCustomQueryAndStream(Pageable pageable);

    //测试Slice的返回结果
    @Query("select p from Person p")
    Slice<Person> findAllByCustomQueryAndSlice(Pageable pageable);

}
