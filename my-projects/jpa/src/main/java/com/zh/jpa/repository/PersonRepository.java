package com.zh.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Person;


/**
 * @ Author         zhangHan
 * @ Date           2021/9/24 10:54
 * @ Description
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
