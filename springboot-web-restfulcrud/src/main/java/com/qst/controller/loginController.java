package com.qst.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {

    @PostMapping(value = "/user/login")
    public  String login(@RequestParam("username") String username, @RequestParam("password") String password,
                         Map<String,String> map, HttpSession session){

        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("LoginUser",username);

            return "redirect:/main.html";
        }else{
            map.put("msg","账号密码错误");
            return "login";
        }
    }
}
