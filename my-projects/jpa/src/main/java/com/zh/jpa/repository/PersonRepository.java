package com.zh.jpa.repository;

import com.zh.jpa.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @ Author         zhangHan
 * @ Date           2021/9/24 10:54
 * @ Description
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
