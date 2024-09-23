package com.example.project1_back.demos.dao;


import com.example.project1_back.demos.entitys.Course;
import com.example.project1_back.demos.entitys.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface StuDao {

    @Select("select id,user_name,Gender,user_major,Faculties,Academic," +
            "Current_home_address,BirthDay,ZipCode,home_phone,user_phone," +
            "Enrollment_dates,ID_number" +
            "from user where user_name=#{stuID}")
    public Student getStudentInfo(@Param("stuId") String stuId);

    @Select("select * from course where id=(select course_Id from elective_courses where stu_Id=#{stuId} and status=#{status})")
    public List<Course> getAllBeChosenCourse(@Param("stuId") String stuId,@Param("status") Integer status);
}
