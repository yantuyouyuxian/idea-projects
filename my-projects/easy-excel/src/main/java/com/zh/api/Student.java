package com.zh.api;

import java.util.Date;

import lombok.Data;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/18 21:58
 * @ Description
 */
@Data
public class Student {
    private String id;
    private String name;
    private String gender;
    private Date birthday;
}
