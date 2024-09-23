package com.example.project1_back.demos.services.impl;

import com.example.project1_back.demos.dao.UserDao;
import com.example.project1_back.demos.entitys.User;
import com.example.project1_back.demos.services.UserService;
import com.example.project1_back.demos.utils.Bytes.ByteUtils;
import com.example.project1_back.demos.utils.Message.Message;
import com.example.project1_back.demos.utils.Token.JwtTokenGenerator;
import com.example.project1_back.demos.utils.Token.Md5TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Md5TokenGenerator tokenGenerator;

    @Autowired
    private ByteUtils byteUtils;

    @Autowired
    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;
    }


    /**
     * 用户登录,返回200成功，400失败
     * @param user 用户
     * @return message
     */
    @Override
    public Message userLogin(User user) {
        try{
            if(userDao.login(user.getUsername(),user.getPassword())>0)
            {
                String token = tokenGenerator.userTokenUtils(user.getUsername(),user.getPassword());
                Map<String,String> data = new HashMap<>();
                data.put("token",token);
                return new Message("200","登录成功",data);
            }else{
                return new Message("400","登录失败,用户名或密码错误",null);
            }
        }catch (Exception e) {
            log.error("login error",e);
            return new Message("500","服务器错误",null);
        }
    }

    @Override
    public Message autoLogin(String token) {
        try{
            boolean verified = tokenGenerator.verify(token);
            if(verified)
            {
                return new Message("200","登录成功",null);
            }
            return new Message("400","登录失败，token失效或不存在",null);
        }catch (Exception e){
            log.error("autoLogin: ",e);
            return new Message("500","服务器错误",null);
        }

    }

    @Override
    public Message getUserHeadshot(String userName) {
        FileInputStream picInput = null;
        try{
            String headshotPath = userDao.getUserHeadshot(userName);
            if(headshotPath.isEmpty()){
                return new Message("400","获取失败，用户头像为空",null);
            }
            picInput = new FileInputStream(new File(headshotPath));
            byte[] imageData = byteUtils.getBytesByStream(picInput);
            return new Message("200","获取成功",imageData);
        }catch(Exception e){
            log.error("getUserHeadshot: ",e);
            return new Message("500","服务器错误",null);
        }finally {
            if(picInput != null){
                try{
                    picInput.close();
                }catch (Exception e){
                    log.error("getUserHeadshot: ",e);
                }
            }
        }

    }

}
