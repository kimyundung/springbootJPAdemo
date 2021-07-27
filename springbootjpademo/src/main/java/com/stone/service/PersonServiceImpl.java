package com.stone.service;

import com.stone.entity.Person;
import com.stone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    // find

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
         return personRepository.findAll();
    }

    @Override
    public List<Person> findByEmailAddressAndLastname(String emailAddress, String lastname) {
        return personRepository.findByEmailAddressAndLastname(emailAddress,lastname);
    }

    @Override
    public List<Person> findDistinctByFirstnameOrLastname(String firstname,String lastname) {
        return personRepository.findDistinctByFirstnameOrLastname(firstname,lastname);
    }

    @Override
    public List<Person> findByLastnameIgnoreCase(String lastname) {
        return personRepository.findByLastnameIgnoreCase(lastname);
    }

    @Override
    public List<Person> findByFirstnameAndLastnameAllIgnoreCase(String firstname, String lastname) {
        return personRepository.findByFirstnameAndLastnameAllIgnoreCase(firstname,lastname);
    }

    @Override
    public List<Person> findByFirstnameAndLastname(String firstname, String lastname) {
        return personRepository.findByFirstnameAndLastname(firstname, lastname);
    }

    @Override
    public List<Person> findByLastnameOrderByFirstnameAsc(String lastname) {
        return personRepository.findByLastnameOrderByFirstnameAsc(lastname);
    }

    @Override
    public List<Person> findByLastnameOrderByFirstnameDesc(String lastname) {
        return personRepository.findByLastnameOrderByFirstnameDesc(lastname);
    }

    // count delete remove

    @Override
    public long countByLastname(String lastname) {
        return personRepository.countByLastname(lastname);
    }

    @Override
    @Transactional
    public long deleteByLastname(String lastname) {
        return personRepository.deleteByLastname(lastname);
    }

    @Override
    @Transactional
    public List<Person> removeByLastname(String lastname) {
        return personRepository.removeByLastname(lastname);
    }

    // Sort Pageable

    @Override
    public Page<Person> findByLastname(String lastname, Pageable pageable) {
        return personRepository.findByLastname(lastname, pageable);
    }

    @Override
    public Slice<Person> findByFirstname(String firstname, Pageable pageable) {
        return personRepository.findByFirstname(firstname,pageable);
    }

    @Override
    public List<Person> findByLastname(String lastname, Sort sort) {
        //System.out.println("sort = " + sort);
        //System.out.println("lastname = " + lastname);
        List<Person> personList = personRepository.findByLastname(lastname, sort);
        return personList;
    }

    @Override
    public List<Person> findByEmailAddress(String emailAddress, Pageable pageable) {
        return personRepository.findByEmailAddress(emailAddress, pageable);
    }

}
