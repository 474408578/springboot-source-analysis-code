package com.xschen.diveinspringboot.springboot.webmvc.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot  mvc 引导类
 * @author xschen
 */

@SpringBootApplication(scanBasePackages = "com.xschen.springboot.diveinspringboot.springboot.webmvc")
public class SpringBootMvcBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcBootstrap.class, args);
    }

}
