package com.example.project1_back.demos.services.impl;

import com.example.project1_back.demos.dao.StuDao;
import com.example.project1_back.demos.entitys.Course;
import com.example.project1_back.demos.services.StuService;
import com.example.project1_back.demos.utils.Message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDao stuDao;

    @Autowired
    public StuServiceImpl(StuDao stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    public Message getStudentInfo(String stuId) {
        try{
            return new Message("200","success",stuDao.getStudentInfo(stuId));
        }catch (Exception e){
            log.error("getStudentInfo error: ",e);
            return new Message("500","服务器错误",null);
        }
    }

    @Override
    public Message getCourse(String stuId, Integer status,Integer course_type,Integer course_nature,Integer semester) {
        try{
            List<Course> courseList = stuDao.getAllBeChosenCourse(stuId,status);
            for(Course course:courseList){
                if(course_type!=null){
                    if(course.getCourse_type()!=course_type){
                        courseList.remove(course);
                    }
                }
                if(course_nature!=null){
                    if(course.getCourse_nature()!=course_nature){
                        courseList.remove(course);
                    }
                }
            }
            return new Message("200","success",courseList);
        }catch (Exception e){
            log.error("getCourse error: ", e);
            return new Message("500","服务器错误",null);
        }
    }
}
