package com.example.project1_back.demos.controller;


import com.alibaba.fastjson.JSON;
import com.example.project1_back.demos.Annotation.AuthToken;
import com.example.project1_back.demos.entitys.User;
import com.example.project1_back.demos.services.UserService;
import com.example.project1_back.demos.utils.Message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /*
    *函数功能：用户登录
    * 输入参数：用户名，密码
    * 流程：
    *
    * 1.判断用户名、密码是否相符
    * 2.如果相符，则返回成功，为应答添加token，否则返回失败
     */
    @PostMapping ("/login")
    public String Login(@RequestBody User user) {
        Message message = userService.userLogin(user);
        return JSON.toJSONString(message);
    }

    @AuthToken
    @PostMapping("/autoLogin")
    public String autoLogin(@RequestBody String token) {
        Message message = userService.autoLogin(token);
        log.info("autologin-controller");
        return JSON.toJSONString(message);
    }

    @AuthToken
    @GetMapping(value = "/getUserHeadshot")
    public String getUserHeadshot(String userName, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        Message message = userService.getUserHeadshot(userName);
        return JSON.toJSONString(message);
    }


}
