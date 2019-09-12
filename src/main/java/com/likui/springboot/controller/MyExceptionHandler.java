package com.likui.springboot.controller;

import com.likui.springboot.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyExceptionHandler
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-10 17:49
 * @Version: 1.0
 */
@ControllerAdvice
public class MyExceptionHandler {


    //浏览器 客户端 都返回json 数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExitException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user not Exit");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExitException.class)
    public String handleException(Exception e,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user not Exit");
        map.put("message",e.getMessage());
        //转发 、error
        return "forward:/error";
    }

}