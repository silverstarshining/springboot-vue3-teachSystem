package com.example.project1_back.demos.services;

import com.example.project1_back.demos.entitys.User;
import com.example.project1_back.demos.utils.Message.Message;

import javax.servlet.http.HttpSession;

public interface UserService {

    public Message userLogin(User user);


    public Message autoLogin(String token);

    public Message getUserHeadshot(String userName);
}
