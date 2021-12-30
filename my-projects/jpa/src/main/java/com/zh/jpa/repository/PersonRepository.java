package com.zh.jpa.repository;

import com.zh.jpa.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;




/**
 * @ Author         zhangHan
 * @ Date           2021/9/24 10:54
 * @ Description
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> queryAllByIdIn(List<Long> ids);
}
