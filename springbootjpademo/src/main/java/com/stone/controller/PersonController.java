package com.stone.controller;

import com.stone.entity.Person;
import com.stone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.beans.Expression;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 添加 & 更新
     * @param person
     * @return
     */
    @PostMapping("/save")
    public Person save(@RequestBody Person person){
        Person resultPerson = personService.save(person);
        return resultPerson;
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/findAll")
    public List<Person> findAll(){
        List<Person> personList = personService.findAll();
        return personList;
    }

    /**
     * 根据邮箱地址和名字查询
     * @param emailAddress
     * @param lastname
     * @return
     */
    @GetMapping("/findByEmailAddressAndLastname")
    public List<Person> findByEmailAddressAndLastname(String emailAddress,String lastname){
        List<Person> personList = personService.findByEmailAddressAndLastname(emailAddress, lastname);
        return personList;
    }

    /**
     * 根据性去重查询
     * @param firstname
     * @return
     */
    @GetMapping("/findDistinctByFirstnameOrLastname")
    public List<Person> findDistinctByFirstnameOrLastname(String firstname,String lastname){
        List<Person> personList = personService.findDistinctByFirstnameOrLastname(firstname,lastname);
        return personList;
    }

    /**
     * 根据忽略大小写名字查询
     * @param lastname
     * @return
     */
    @GetMapping("/findByLastnameIgnoreCase")
    public List<Person> findByLastnameIgnoreCase(String lastname){
        List<Person> personList = personService.findByLastnameIgnoreCase(lastname);
        return personList;
    }

    /**
     * 根据性和名并且忽略大小写查询
     * @param firstname
     * @param lastname
     * @return
     */
    @GetMapping("/findByFirstnameAndLastnameAllIgnoreCase")
    public List<Person> findByFirstnameAndLastnameAllIgnoreCase(String firstname, String lastname){
        List<Person> personList = personService.findByFirstnameAndLastnameAllIgnoreCase(firstname, lastname);
        return personList;
    }

    /**
     * 根据性和名查询 （默认忽略大小写）
     * @param firstname
     * @param lastname
     * @return
     */
    @GetMapping("/findByFirstnameAndLastname")
    public List<Person> findByFirstnameAndLastname(String firstname, String lastname){
        List<Person> personList = personService.findByFirstnameAndLastname(firstname, lastname);
        return personList;
    }

    /**
     * 根据名字查询并性的正序排列
     * @param lastname
     * @return
     */
    @GetMapping("/findByLastnameOrderByFirstnameAsc")
    public List<Person> findByLastnameOrderByFirstnameAsc(String lastname){
        List<Person> personList = personService.findByLastnameOrderByFirstnameAsc(lastname);
        return personList;
    }

    /**
     * 根据名字查询并性的倒序排列
     * @param lastname
     * @return
     */
    @GetMapping("/findByLastnameOrderByFirstnameDesc")
    public List<Person> findByLastnameOrderByFirstnameDesc(String lastname){
        List<Person> personList = personService.findByLastnameOrderByFirstnameDesc(lastname);
        return personList;
    }

    /**
     * 根据名字查询个数
     * @param lastname
     * @return
     */
    @GetMapping("/countByLastname")
    public long countByLastname(String lastname){
        long count = personService.countByLastname(lastname);
        return count;
    }

    /**
     * 根据名字删除并返回删除个数
     * @param lastname
     * @return
     */
    @DeleteMapping("/deleteByLastname")
    public long deleteByLastname(String lastname){
        long delete = personService.deleteByLastname(lastname);
        return delete;
    }

    /**
     * 根据名字删除一堆Person并返回删除的所有Person
     * @param lastname
     * @return
     */
    @DeleteMapping("/removeByLastname")
    public List<Person> removeByLastname(String lastname){
        List<Person> personList = personService.removeByLastname(lastname);
        return personList;
    }
}
