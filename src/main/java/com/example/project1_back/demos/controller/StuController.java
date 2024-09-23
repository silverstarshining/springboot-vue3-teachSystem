package com.example.project1_back.demos.controller;

import com.alibaba.fastjson.JSON;
import com.example.project1_back.demos.Annotation.AuthToken;
import com.example.project1_back.demos.services.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/stu")
public class StuController {

    @Autowired
    private final StuService stuService;

    @Autowired
    public StuController(StuService stuService) {
        this.stuService = stuService;
    }

    /*
     *函数功能：获取学生基础信息
     * 输入参数：学号
     * 流程：
     * 1. 从数据库中获取学生信息
     */
    @AuthToken
    @GetMapping(value = "/getStudentInfo")
    public String getStudentInfo(String stuId) {
        return JSON.toJSONString(stuService.getStudentInfo(stuId));
    }

    @AuthToken
    @GetMapping(value = "/getCourse")
    public String getCourse(String stuId, Integer status,Integer course_type,Integer course_nature,Integer semester) {
        return JSON.toJSONString(stuService.getCourse(stuId,status,course_type,course_nature,semester));
    }

}
