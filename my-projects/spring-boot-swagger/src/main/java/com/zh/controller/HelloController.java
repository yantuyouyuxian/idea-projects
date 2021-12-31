package com.zh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/31 14:12
 * @ Description
 */
@Api("hello")
@RestController
public class HelloController {

    @ApiOperation("say hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
