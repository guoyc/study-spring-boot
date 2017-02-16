package com.gyc.controller;

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
}
