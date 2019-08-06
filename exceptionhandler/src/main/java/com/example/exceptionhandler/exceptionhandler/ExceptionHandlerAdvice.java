package com.example.exceptionhandler.exceptionhandler;

import com.example.exceptionhandler.entity.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @Author PengHao
 * @Description 异常处理类
 * @Date 2019/8/6
 * @Version 1.0.0
 */

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class, MethodArgumentConversionNotSupportedException.class})
    public Result handleIllegalParamException(Exception e) {
        e.printStackTrace();
        return new Result(-1, "输入参数格式有误！", null);
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handleException(NullPointerException e){
        e.printStackTrace();
        return new Result(-1,"参数不能为空！",null);
    }
}
