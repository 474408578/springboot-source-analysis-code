package com.xschen.springboot.diveinspringboot.spring.webmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

/**
 * Spring Mvc 配置类
 * @author xschen
 * 
 * DispatcherServlet#doDispatch(HttpServletRequest, HttpServletResponse)
 *  DispatcherServlet#getHandler(HttpServletRequest) 1
 *  DispatcherServlet#getHandlerAdapter(Object) 2
 *  DispatcherServlet#processDispatchResult 3
 *  DispatcherServlet#render(ModelAndView, HttpServletRequest, HttpServletResponse) 4
 *  DispatcherServlet#resolveViewName(String, Map, Locale, HttpServletRequest) 5
 *
 *
 * @see DelegatingWebMvcConfiguration
 * @see WebMvcConfigurer
 * @see WebMvcConfigurer#addInterceptors(InterceptorRegistry)
 */


@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     *  <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
     *
     *     <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>
     *
     *     <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     *         <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
     *         <property name="prefix" value="/WEB-INF/jsp/"/>
     *         <property name="suffix" value=".jsp"/>
     * </bean>
     */

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request,
                                     HttpServletResponse response,
                                     Object handler) throws Exception {
                System.out.println("preHandle拦截...");
                return true;
            }
        });
    }
}
