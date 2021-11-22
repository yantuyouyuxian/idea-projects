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
 * @ Date           2021/11/22 19:30
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

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
}
