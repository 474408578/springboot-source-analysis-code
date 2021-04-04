package com.xschen.springboot.diveinspringboot.spring.application;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文，引导类
 * @author xschen
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                // AnnotationConfigApplicationContext / AnnotationConfigServletWebServerApplicationContext
                //.web(WebApplicationType.NONE)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型： " + context.getClass().getName());
        System.out.println("Environment 类型: " + context.getEnvironment().getClass().getName());

        context.close();
    }
}
