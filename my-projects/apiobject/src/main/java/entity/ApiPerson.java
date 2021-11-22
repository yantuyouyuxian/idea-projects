package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Author         zhangHan
 * @ Date           2021/11/19 16:40
 * @ Description
 */
@Entity
@Getter
@Setter
@Table(name = "t_person")
public class ApiPerson {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
}
