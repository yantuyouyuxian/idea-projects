package com.zh.redis_template.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/26 18:01
 * @ Description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 3206371533282821431L;

    private String name;
    private Integer age;

}
