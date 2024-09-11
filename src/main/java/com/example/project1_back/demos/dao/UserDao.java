package com.example.project1_back.demos.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select count(*) from user where user_name=#{username} and user_password=#{password}")
    public int login(@Param("username") String username, @Param("password") String password);

    @Select("select headshot from user where user_name=#{username}")
    String getUserHeadshot(@Param("username") String userName);
}
