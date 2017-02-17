package com.gyc.controller;

import com.gyc.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yc.guo@zuche.com on 2017/2/16.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("index")
    public String index() {
        return "hello world";
    }

    @RequestMapping("test/error")
    public String testError() {
        MyException e = new MyException();
        e.setErrorCode(MyException.NULL_DATA);
        e.setErrorMsg("出错了！！");
        throw e;
    }
}
