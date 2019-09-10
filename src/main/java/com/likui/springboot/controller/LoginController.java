package com.likui.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: 处理登录请求
 * @Author: LiKui
 * @Date: 2019-9-9 14:53
 * @Version: 1.0
 */
@Controller
public class LoginController {

    /**
     * 处理登录请求
     * @return
     */
    @PostMapping("user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        //登录成功
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //防止表单重复提交 可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }

    }
}