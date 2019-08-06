package com.example.exceptionhandler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author PengHao
 * @Description 测试controller
 * @Date 2019/8/6
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/param")
    public String param(Integer id){
        if(id==1)throw new NullPointerException();
        return id.toString();
    }
}
