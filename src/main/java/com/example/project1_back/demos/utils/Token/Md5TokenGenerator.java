package com.example.project1_back.demos.utils.Token;


import com.example.project1_back.demos.utils.Redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Slf4j
@Component
public class Md5TokenGenerator implements TokenGenerator {

    @Autowired
    RedisUtils redisUtils;

    /**
     * token生成器
     * @param strings 参数可以多个
     * @return token token->(s1+s2...+时间戳)MD5加密
     */
    @Override
    public String generate(String... strings) {
        long timestamp = System.currentTimeMillis();
        StringBuilder tokenMeta = new StringBuilder();
        for(String s:strings){
            tokenMeta.append(s);
        }
        tokenMeta.append(timestamp);
        String token = DigestUtils.md5DigestAsHex(tokenMeta.toString().getBytes());
        return token;
    }

    /**
     * token存入redis缓存
     * @param username  用户名
     * @param password  密码
     * @return token(username+password+时间戳)MD5加密
     */
    @Override
    public String userTokenUtils(String username,String password){
        //设置token
        String token = generate(username,password);
        redisUtils.set(username,token, ConstantKit.TOKEN_EXPIRE_TIME);//五分钟失效缓存
        redisUtils.set(token,username,ConstantKit.TOKEN_EXPIRE_TIME);
        Long currentTime = System.currentTimeMillis();//获取当前时间戳
        redisUtils.set(username+token,currentTime);//设置第一次登陆的时间为token的初始时间
        return token;
    }

    @Override
    public boolean verify(String token){
        try{
            token = token.replaceAll("\"","");
            //判断token是否在redis中
            if(redisUtils.get(token)!=null){
                return true;
            }
            return false;
        }catch (Exception e){
            log.error("Md5Verify: ",e);
            return false;
        }
    }
}
