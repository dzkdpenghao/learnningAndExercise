package com.example.exceptionhandler.controller;

import com.example.exceptionhandler.entity.ResponseStatus;
import com.example.exceptionhandler.entity.Result;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * @Author PengHao
 * @Description 测试controller
 * @Date 2019/8/6
 * @Version 1.0.0
 */

//必须要加这个注解，参数校验才会生效
@Validated
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/param")
    //参数校验，会抛出ConstraintViolationException，在全局异常处理类进行处理
    public Result param( @Max(10) Integer id,@Length(min = 1,max = 10) String name){
        return new Result(ResponseStatus.SUCCESS.getCode(),"success",id);
    }
}
