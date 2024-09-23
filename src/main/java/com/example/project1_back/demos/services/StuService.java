package com.example.project1_back.demos.services;


import com.example.project1_back.demos.utils.Message.Message;

public interface StuService {
    Message getStudentInfo(String stuId);

    Message getCourse(String stuId, Integer status,Integer course_type,Integer course_nature,Integer semester);
}
