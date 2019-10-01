package com.ssc.showinfo.web.config;

import com.ssc.showinfo.web.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: show-info
 * @description: token的拦截器配置的文件
 * @author: ssc
 * @create: 2019/9/29 18:58
 **/
@Configuration
public class TokenInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
    }
    @Bean
    public TokenInterceptor authenticationInterceptor() {
        return new TokenInterceptor();
    }
}
