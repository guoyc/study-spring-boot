package com.gyc.controller;

import com.gyc.exception.MyException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yc.guo@zuche.com on 2017/2/17.
 */
@ControllerAdvice
public class GlobalExceptionHander {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public MyException myExceptionHandler(HttpServletRequest request, MyException e) {
        e.setUrl(request.getRequestURI());
        return e;
    }

}
