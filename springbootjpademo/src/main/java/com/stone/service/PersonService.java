package com.stone.service;

import com.stone.entity.Person;
import java.util.List;

public interface PersonService {

    Person save(Person person);

    List<Person> findAll();

    List<Person> findByEmailAddressAndLastname(String emailAddress, String lastname);

    List<Person> findDistinctByFirstnameOrLastname(String firstname,String lastname);

    List<Person> findByLastnameIgnoreCase(String lastname);

    List<Person> findByFirstnameAndLastnameAllIgnoreCase(String firstname, String lastname);

    List<Person> findByFirstnameAndLastname(String firstname, String lastname);

    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

    long countByLastname(String lastname);

    long deleteByLastname(String lastname);

    List<Person> removeByLastname(String lastname);
}
