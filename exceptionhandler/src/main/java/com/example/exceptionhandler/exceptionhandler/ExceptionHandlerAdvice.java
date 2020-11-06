package com.example.exceptionhandler.exceptionhandler;

import com.example.exceptionhandler.entity.ResponseStatus;
import com.example.exceptionhandler.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

/**
 * @Author PengHao
 * @Description 全局异常处理类
 * @Date 2019/8/6
 */

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    Logger log= LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleException(ConstraintViolationException e){
        //这里可以手动写日志
        log.warn("发生了参数校验错误！");

        return new Result(ResponseStatus.ERR.getCode(),e.getMessage(),null);
    }
}
