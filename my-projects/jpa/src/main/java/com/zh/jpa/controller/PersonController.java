package com.zh.jpa.controller;


import com.zh.jpa.entity.Person;
import com.zh.jpa.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/24 10:56
 * @ Description
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path = "addPerson")
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @DeleteMapping(path = "deletePerson")
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
