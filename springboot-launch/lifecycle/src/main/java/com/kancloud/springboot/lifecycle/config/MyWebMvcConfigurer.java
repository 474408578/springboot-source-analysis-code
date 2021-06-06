package com.kancloud.springboot.lifecycle.config;

import com.kancloud.springboot.lifecycle.interceptor.CustomInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xschen
 */

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(customInterceptor).addPathPatterns("/*");

    }
}
