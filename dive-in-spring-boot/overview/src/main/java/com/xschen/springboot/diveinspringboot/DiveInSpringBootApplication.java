package com.xschen.springboot.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author xschen
 */

@SpringBootApplication
@ServletComponentScan(basePackages = "com.xschen.springboot.diveinspringboot.web.servlet") // 注册Servlet
public class DiveInSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiveInSpringBootApplication.class, args);

        //new SpringApplicationBuilder(DiveInSpringBootApplication.class)
                //.web(WebApplicationType.NONE)
                //.run(args);
    }

}
