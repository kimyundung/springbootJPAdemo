package com.stone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.entity.*;
import com.stone.repository.UserAddressRepository;
import com.stone.repository.UserRepository;
import com.stone.specification.MySpecification;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JpaTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;
    private Date now = new Date();

//    @BeforeAll
//    @Rollback
//    @Transactional
//    void init(){
//        User user = User.builder()
//                .name("jack")
//                .email("123456@126.com")
//                .sex(SexEnum.BOY)
//                .age(20)
//                .createDate(now)
//                .updateDate(now)
//                .build();
//        userAddressRepository.saveAll(
//                Lists.newArrayList(
//                        UserAddress.builder()
//                        .user(user)
//                        .address("shanghai")
//                        .build(),
//                        UserAddress.builder()
//                        .user(user)
//                        .address("beijing")
//                        .build()
//                )
//        );
//    }

    @Test
    public void testMySpecification(){
        MySpecification<User> name =
                new MySpecification<>(new SearchCriteria("name",Operator.LK,"jack"));
        MySpecification<User> age =
                new MySpecification<>(new SearchCriteria("age", Operator.GT,2));
        List<User> userList = userRepository.findAll(Specification.where(name).and(age));
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void TestSPE() throws JsonProcessingException {
        User userQuery = User.builder()
                .name("jack")
                .email("123456@126.com")
                .sex(SexEnum.BOY)
                .age(20)
                .addresses(Lists.newArrayList(UserAddress.builder().address("shanghai").build()))
                .build();
        Date startDate = Date.from(Instant.now().plus(-2, ChronoUnit.HOURS));
        Date endDate = Date.from(Instant.now().plus(+1, ChronoUnit.HOURS));
        // predicate 断言
        // criteria  标准
        // specification 规范
        Page<User> userPage = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(userQuery.getName())){
                    //like查询, 根据name模糊查询
                    predicates.add(criteriaBuilder.like(root.get("name"),"%"+userQuery.getName()+"%"));
                }
                if(userQuery.getSex()!=null){
                    //equal查询条件, 这里需要注意, 直接传递的是枚举
                    predicates.add(criteriaBuilder.equal(root.get("sex"),userQuery.getSex()));
                }
                if(userQuery.getAge()!=null){
                    //greaterThanOrEqualTo大于等于查询条件
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("age"),userQuery.getAge()));
                }
                if(startDate!=null && endDate!=null){
                    //根据时间区间查询创建
                    predicates.add(criteriaBuilder.between(root.get("createDate"),startDate,endDate));
                }
                if(!ObjectUtils.isEmpty(userQuery.getAddresses())){
                    //联表查询, 利用root的join方法, 根据关联关系表里面的字段进行查询
                    predicates.add(criteriaBuilder.in(root.join("addresses").get("address")).value(userQuery.getAddresses().stream().map(a->a.getAddress()).collect(Collectors.toList())));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        }, PageRequest.of(0,2));
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(userPage));
    }

}
