package com.example.project1_back.demos.utils.Token;


import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.project1_back.demos.utils.Message.Message;
import com.example.project1_back.demos.utils.Redis.RedisUtils;
import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtTokenGenerator implements TokenGenerator {

    private final String secretKey = "lvfengxin";

    @Autowired
    RedisUtils redisUtils;

    @Override
    public String generate(String... strings) {
        JWTCreator.Builder builder = JWT.create();
        //设置过期时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + ConstantKit.TOKEN_EXPIRE_TIME;
        Date exp = new Date(expMillis);
        Map<String,Object> headers = new HashMap<>();
        headers.put("typ", "jwt");   //设置token的type为jwt
        headers.put("alg", "hs256");
        Map<String,Object> Claims = new HashMap<>();
        for(int i=0;i<strings.length;i+=2){
            if(i+1<strings.length){
                Claims.put(strings[i],strings[i+1]);
            }
        }
        String token = builder.withHeader(headers)
                .withClaim("claim", Claims)
                .withExpiresAt(exp)
                .withIssuedAt(now)
                .withIssuer("issuer")
                .sign(Algorithm.HMAC256(secretKey));
        return token;
    }

    @Override
    public String userTokenUtils(String username,String password){
        String token = generate("username",username,"password",password);
        redisUtils.set(username,token, ConstantKit.TOKEN_EXPIRE_TIME);//五分钟失效缓存
        redisUtils.set(token,username,ConstantKit.TOKEN_EXPIRE_TIME);
        Long currentTime = System.currentTimeMillis();//获取当前时间戳
        redisUtils.set(username+token,currentTime);//设置第一次登陆的时间为token的初始时间
        return token;
    }

    @Override
    public boolean verify(String token){
        if(token == null) return false;
        token = token.replaceAll("\"", "");
        JWTVerifier require = JWT.require(Algorithm.HMAC256(secretKey)).withIssuer("issuer").build();

        DecodedJWT decode;
        try{
            /*开始进行验证，该函数会验证此token是否遭到修改，
                以及是否过期，验证成功会生成一个解码对象
                ，如果token遭到修改或已过期就会
                抛出异常*/
            decode = require.verify(token);
        }catch(Exception e){
            log.error("verify: ",e);
            return false;
        }
        //检查是否过期
        Date exp = decode.getExpiresAt();
        if(exp.before(new Date())){
            return false;
        }
        return true;
    }


}
