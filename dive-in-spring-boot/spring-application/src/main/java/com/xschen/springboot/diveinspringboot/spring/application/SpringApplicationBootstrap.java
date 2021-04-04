package com.xschen.springboot.diveinspringboot.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * {@link SpringApplication} 引导类
 *
 * @author xschen
 * @see SpringApplication#deduceEnvironmentClass() 推断 web 应用类型
 *
 * @see SpringApplication#deduceMainApplicationClass() 根据 Main 线程执行堆栈判断实际的引导类
 */


public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        //SpringApplication.run(ApplicationConfiguration.class, args);

        SpringApplication springApplication = new SpringApplication();
        Set<String> sources = new HashSet<>();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        Stream.of(stackTraceElements).forEach(stackTraceElement -> System.out.println(stackTraceElement));
        sources.add(ApplicationConfiguration.class.getName());

        springApplication.setSources(sources); // 配置SpringBoot Bean 源，一个或者多个源
        springApplication.run(args);

    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
