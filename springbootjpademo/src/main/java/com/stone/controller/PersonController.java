package com.stone.controller;

import com.stone.entity.Person;
import com.stone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

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
        return personService.save(person);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/findAll")
    public List<Person> findAll(){
        return personService.findAll();
    }

    /**
     * 根据邮箱地址和名字查询
     * @param emailAddress
     * @param lastname
     * @return
     */
    @GetMapping("/findByEmailAddressAndLastname")
    public List<Person> findByEmailAddressAndLastname(String emailAddress,String lastname){
        return personService.findByEmailAddressAndLastname(emailAddress, lastname);
    }

    /**
     * 根据性去重查询
     * @param firstname
     * @return
     */
    @GetMapping("/findDistinctByFirstnameOrLastname")
    public List<Person> findDistinctByFirstnameOrLastname(String firstname,String lastname){
        return personService.findDistinctByFirstnameOrLastname(firstname,lastname);
    }

    /**
     * 根据忽略大小写名字查询
     * @param lastname
     * @return
     */
    @GetMapping("/findByLastnameIgnoreCase")
    public List<Person> findByLastnameIgnoreCase(String lastname){
        return personService.findByLastnameIgnoreCase(lastname);
    }

    /**
     * 根据性和名并且忽略大小写查询
     * @param firstname
     * @param lastname
     * @return
     */
    @GetMapping("/findByFirstnameAndLastnameAllIgnoreCase")
    public List<Person> findByFirstnameAndLastnameAllIgnoreCase(String firstname, String lastname){
        return personService.findByFirstnameAndLastnameAllIgnoreCase(firstname, lastname);
    }

    /**
     * 根据性和名查询 （默认忽略大小写）
     * @param firstname
     * @param lastname
     * @return
     */
    @GetMapping("/findByFirstnameAndLastname")
    public List<Person> findByFirstnameAndLastname(String firstname, String lastname){
        return personService.findByFirstnameAndLastname(firstname, lastname);
    }

    /**
     * 根据名字查询并性的正序排列
     * @param lastname
     * @return
     */
    @GetMapping("/findByLastnameOrderByFirstnameAsc")
    public List<Person> findByLastnameOrderByFirstnameAsc(String lastname){
        return personService.findByLastnameOrderByFirstnameAsc(lastname);
    }

    /**
     * 根据名字查询并性的倒序排列
     * @param lastname
     * @return
     */
    @GetMapping("/findByLastnameOrderByFirstnameDesc")
    public List<Person> findByLastnameOrderByFirstnameDesc(String lastname){
        return personService.findByLastnameOrderByFirstnameDesc(lastname);
    }

    // count delete remove

    /**
     * 根据名字查询个数
     * @param lastname
     * @return
     */
    @GetMapping("/countByLastname")
    public long countByLastname(String lastname){
        return personService.countByLastname(lastname);
    }

    /**
     * 根据名字删除并返回删除个数
     * @param lastname
     * @return
     */
    @DeleteMapping("/deleteByLastname")
    public long deleteByLastname(String lastname){
        return personService.deleteByLastname(lastname);
    }

    /**
     * 根据名字删除一堆Person并返回删除的所有Person
     * @param lastname
     * @return
     */
    @DeleteMapping("/removeByLastname")
    public List<Person> removeByLastname(String lastname){
        return personService.removeByLastname(lastname);
    }

    // Sort Pageable

    @GetMapping("/findByLastnamePage")
    public Page<Person> findByLastnamePage(String lastname){
        //System.out.println("lastname = " + lastname);
        Page<Person> personPage = personService.findByLastname(lastname, PageRequest.of(0, 20));
        //System.out.println("personPage = " + personPage);
        return personPage;
    }


    @GetMapping("/findByFirstnameSlice")
    public Slice<Person> findByFirstname(String firstname){
        return personService.findByFirstname(firstname, PageRequest.of(0, 20));
    }


    @GetMapping("/findByLastnameSort")
    public List<Person> findByLastnameList(String lastname){
        return personService.findByLastname(lastname, Sort.by(Sort.Direction.ASC,"firstname"));
    }


    @GetMapping("/findByEmailAddressPage")
    public List<Person> findByEmailAddress(String emailAddress){
        return personService.findByEmailAddress(emailAddress, PageRequest.of(0, 100, Sort.Direction.ASC, "firstname"));
    }

    // First Top

    @GetMapping("/findFirstByOrderByLastnameAsc")
    public Person findFirstByOrderByLastnameAsc(){
        return personService.findFirstByOrderByLastnameAsc();
    }

    @GetMapping("/findTopByOrderByIdAsc")
    public Person findTopByOrderByIdAsc(){
        return personService.findTopByOrderByIdAsc();
    }

    @GetMapping("/findDistinctPersonTop3ByLastname")
    public List<Person> findDistinctPersonTop3ByLastname(String lastname) {
        return personService.findDistinctPersonTop3ByLastname(lastname, PageRequest.of(0, 10, Sort.Direction.ASC, "firstname"));
    }

    @GetMapping("/findDistinctTop3ByLastname")
    public List<Person> findDistinctTop3ByLastname(String lastname){
        return personService.findDistinctTop3ByLastname(lastname, PageRequest.of(0, 10, Sort.Direction.ASC,"firstname"));
    }

    @GetMapping("/findFirst5ByLastname")
    public List<Person> findFirst5ByLastname(String lastname){
        return personService.findFirst5ByLastname(lastname, Sort.by(Sort.Direction.ASC,"firstname"));
    }

    @GetMapping("/findTop5ByLastname")
    public List<Person> findTop5ByLastname(String lastname){
        return personService.findTop5ByLastname(lastname, PageRequest.of(0,10,Sort.Direction.ASC, "firstname"));
    }

    @GetMapping("/getByEmailAddress")
    public List<Person> getByEmailAddress(String emailAddress){
        System.out.println("emailAddress = " + emailAddress);
        List<Person> personList = personService.getByEmailAddress(emailAddress);
        System.out.println("personList = " + personList);
        return personList;
    }
}
