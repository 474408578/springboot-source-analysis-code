package com.kancloud.springboot.rdbms.operation.jdbc.singledatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xschen
 */

@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
//        new SpringApplicationBuilder(JdbcApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }
}
