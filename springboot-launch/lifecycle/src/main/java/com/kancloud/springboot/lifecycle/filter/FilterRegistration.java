package com.kancloud.springboot.lifecycle.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xschen
 */

@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CustomFilter());
        // 过滤器名称
        registrationBean.setName("customFilter");
        // 设置拦截路径
        registrationBean.addUrlPatterns("/*");
        // 设置顺序
        registrationBean.setOrder(10);
        return registrationBean;
    }
}
