package com.stone.repository;

import com.stone.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 通过query注解根据name查询user信息
     */
    @Query("From User where name=:name")
    List<User> findByQuery(@Param("name") String nameParam);

    /**
     * 案例 1
     * Repository 的查询方法上声明一个注解，这里就是 @Query 注解标注的地方。
     */
    @Query("select u from User u where u.email=?1")
    List<User> findByEmail(String email);

    /**
     * 案例 2
     * LIKE 查询，注意 firstname 不会自动加上“%”关键字。
     */
    @Query("select u from User u where u.name like %?1")
    List<User> findByNameEndsWith(String name);

    /**
     * 案例 3
     * 直接用原始 SQL，nativeQuery = true 即可。
     * 注意：nativeQuery 不支持直接 Sort 的参数查询。
     */
    @Query(value = "SELECT * FROM USER WHERE ADDRESS = ?1", nativeQuery = true)
    List<User> findByAddress(String address);

    /**
     * 案例 4
     * 下面是****nativeQuery 的排序错误的写法，会导致无法启动。
     */
//    @Query(value = "select * from user where name = ?1 and email = ?2", nativeQuery = true)
//    List<User> findByNameAndEmail(String name, String email, Sort sort);

    /**
     * 案例 5
     * nativeQuery 排序的正确写法。
     *
     * 调用的地方写法last_name是数据里面的字段名，不是对象的字段名
     * repository.findByFirstName("jackzhang","last_name");
     */
    @Query(value = "select * from user where name = ?1 and email = ?2 order by ?3", nativeQuery = true)
    List<User> findByNameAndEmail(String name, String email, String sort);

    /**
     * 案例 6
     * Sort and JpaSort 的使用，它可以进行排序。
     */
    @Query("select u from User u where u.name like %?1")
    List<User> findByAndSort(String name, Sort sort);

    @Query("select u.id, LENGTH(u.name) as fn_len from User u where u.name like %?1")
    List<Object[]> findByAsArrayAndSort(String name,Sort sort);

    /**
     * Query 的分页
     * 案例 7
     * 直接用 Page 对象接受接口, 参数直接用 Pageable 的实现类即可.
     */
    @Query(value = "select u from User u where u.name = ?1")
    Page<User> findByName (String name, Pageable pageable);

    /**
     * Query 的分页
     * 案例 8
     * @Query 对原生 SQL 的分页支持, 并不是特别友好, 因为这种写法比较"hacker", 可能随着版本的不同有所变化
     * 这里需要注意：这个注释 / #pageable# / 必须有
     */
    @Query( value = "select * from user where name like %?%1 /* #pageable# */",
            countQuery = "select count(*) from user where name like %?%1",
            nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * @Param 用法
     * 案例 9
     * 根据 name 或 email 参数查询 user 对象
     */
    @Query("select u from User u where u.name = :name or u.email like %:email%")
    List<User> findByNameOrEmail(@Param("name") String name, @Param("email") String email);

    /**
     * @Param 用法
     * 案例 10
     * 根据参数进行查询, top10前面说的"query method"关键字照样有用
     */
    @Query("select u from User u where u.name = :name or u.email like %:email%")
    List<User> findTop2ByNameOrEmail(@Param("name") String name, @Param("email") String email);













}
