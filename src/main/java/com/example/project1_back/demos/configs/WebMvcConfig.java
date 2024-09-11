package com.example.project1_back.demos.configs;

import com.example.project1_back.demos.Interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor(){
        return new AuthorizationInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor())
                .addPathPatterns("/**"); // 配置拦截路径（所有路径都拦截）
                //.excludePathPatterns("/hello2"); // 配置排除的路径
    }
}
