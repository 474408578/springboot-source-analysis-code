package com.kancloud.springboot.jdbc.operation.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xschen
 */

@SpringBootApplication
@ComponentScan(value = "com.kancloud.springboot.jdbc.operation.single")
public class JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
//        new SpringApplicationBuilder(JdbcApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }
}
