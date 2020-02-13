package com.qst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorld {

    @ResponseBody
    @RequestMapping("/hello")
    public String  hello(){
        return "hello world";
    }

    @RequestMapping("/success")
    public static String success(Map<String, Object> map){
        map.put("hello","<h1>你好<h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
