package com.zh.jpa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Author         zhangHan
 * @ Date           2021/9/24 10:43
 * @ Description
 */
@Entity
@Getter
@Setter
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "age", length = 4)
    private int age;
}
