package com.likui.springboot.controller;

import com.likui.springboot.exception.UserNotExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
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

    @Autowired
    JdbcTemplate jdbcTemplate;


    @ResponseBody
    @RequestMapping("hello")
    public String hello(@RequestParam("user") String username){
        if (username.equals("aaa")) {
            System.out.println("抛出异常");
            throw new UserNotExitException();
        }
        return "hello world";
    }

    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>likui</h1>");
        map.put("name","张三");
        map.put("class", Arrays.asList("语文","数学","英语"));
        return "success";
    }

    @RequestMapping("query")
    public String query(Model model){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        model.addAttribute("query",maps.get(0));
        return "emp/list";
    }
}