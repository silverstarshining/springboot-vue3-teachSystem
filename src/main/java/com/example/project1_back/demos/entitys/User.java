package com.example.project1_back.demos.entitys;

import lombok.Data;

@Data
public class User {
    //用户编号
    private Integer id;
    //用户名-默认为学号
    private String username;
    //密码
    private String password;
    //头像
    private String headshot;
}
