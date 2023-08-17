package com.it.controller;

import com.it.pojo.Que;
import com.it.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @RequestMapping("test")
    public String test(){

        return "feige测试专用";
    }
}
