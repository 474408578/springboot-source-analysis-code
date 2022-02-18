package com.xschen.diveinspringboot.spring.application;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ResourceLoader;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * {@link SpringApplication} 引导类
 *
 * @author xschen
 * 
 * @see SpringApplication#SpringApplication(ResourceLoader, Class[]) 
 * 
 * @see SpringApplication#deduceEnvironmentClass() 推断 web 应用类型
 *
 * @see SpringApplication#deduceMainApplicationClass() 根据 Main 线程执行堆栈判断实际的引导类
 *
 * @see SpringApplication#configureHeadlessProperty() 设置应用在启动时，即使没有检测到显示器，也允许其继续启动
 *
 * @see SpringApplicationRunListener
 *
 * @see ConversionService 类型转换的根接口
 */


public class SpringApplicationBootstrap {


    public static void main(String[] args) {
        //SpringApplication.run(ApplicationConfiguration.class, args);

        SpringApplication springApplication = new SpringApplication();
        Set<String> sources = new HashSet<>();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        Stream.of(stackTraceElements).forEach(System.out::println);
        sources.add(ApplicationConfiguration.class.getName());

        springApplication.setSources(sources); // 配置SpringBoot Bean 源，一个或者多个源
        springApplication.run(args);

        System.out.println("test");
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
