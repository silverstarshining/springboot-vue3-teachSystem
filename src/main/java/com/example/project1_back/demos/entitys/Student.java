package com.example.project1_back.demos.entitys;

import lombok.Data;

@Data
public class Student {

    //学号
    private String id;
    //姓名
    private String name;
    //性别
    private Integer sex;
    //专业
    private String major;
    //院系
    private String faculties;
    //学制
    private Integer academic;
    //现居地
    private String current_home_address;
    //出生日期
    private Long birthDay;
    //邮政编码
    private String zipCode;
    //家庭电话
    private String home_phone;
    //手机号码
    private String mobile_phone;
    //入学日期
    private Long enrollment_dates;
    //身份证号
    private String ID_number;

}
