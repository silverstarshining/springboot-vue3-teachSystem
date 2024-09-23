package com.example.project1_back.demos.entitys;

import lombok.Data;

@Data
public class Course {

    //课程名
    private String course_name;

    //先修课
    private String pre_course;

    //学分
    private Integer credit;

    //课程类型
    private Integer course_type;

    //课程学时
    private Integer course_hours;

    //所属专业
    private String major;

    //开课学期
    private Integer semester;

    //课程性质
    private Integer course_nature;


}
