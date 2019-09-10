package com.likui.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-4 14:40
 * @Version: 1.0
 */

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>likui</h1>");
        map.put("name","张三");
        map.put("class", Arrays.asList("语文","数学","英语"));
        return "success";
    }
}