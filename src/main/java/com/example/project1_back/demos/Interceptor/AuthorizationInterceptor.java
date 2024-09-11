package com.example.project1_back.demos.Interceptor;

import com.example.project1_back.demos.Annotation.AuthToken;
import com.example.project1_back.demos.utils.Redis.RedisUtils;
import com.example.project1_back.demos.utils.Token.ConstantKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 鉴权拦截器
 * 使用token鉴权
 */
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "lv-Token";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    //存放登录用户模型Key的Request Key
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            if (!(handler instanceof HandlerMethod)) {
                return true;
            }
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            // 如果打上了AuthToken注解则需要验证token
            if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {
                //获取token
                String token = request.getHeader(httpHeaderName);
                log.info("token is: " + token);
                String username = "";
                //根据token获取redis缓存的username
                if (token != null && token.length() != 0) {
                    username = redisUtils.get(token).toString();
                    log.info("username is: " + username);
                    //根据token+username获取token的初始时间
                    if (username != null && !username.trim().equals("")) {
                        Long tokenBirthTime = Long.valueOf(redisUtils.get(username + token).toString());
                        log.info("token Birth time is: " + tokenBirthTime.toString());
                        Long diff = System.currentTimeMillis() - tokenBirthTime;
                        log.info("token is remain: " + diff.toString());
                        //重置缓存失效时间
                        if (diff > ConstantKit.TOKEN_RESET_TIME) {
                            redisUtils.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
                            redisUtils.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
                            log.info("Reset expire time success!");
                            Long newBirthTime = System.currentTimeMillis();
                            redisUtils.set(token + username, newBirthTime.toString());
                        }
                        request.setAttribute(REQUEST_CURRENT_KEY, username);
                        return true;
                    } else {
                        response.sendRedirect("/login");
                        return false;
                    }
                }
                return true;

            }

            request.setAttribute(REQUEST_CURRENT_KEY, null);

            return true;
        }catch (Exception e){
            log.error("AuthorizationInterceptor",e);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
