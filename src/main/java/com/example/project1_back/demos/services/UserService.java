package com.example.project1_back.demos.services;

import com.example.project1_back.demos.entitys.User;
import com.example.project1_back.demos.utils.Message.Message;

public interface UserService {

    Message userLogin(User user);

    Message autoLogin(String token);

    Message getUserHeadshot(String userName);
}
