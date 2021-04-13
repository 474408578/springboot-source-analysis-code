package com.kancloud.springboot.jdbc.operation.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author xschen
 */

@SpringBootApplication
@ComponentScan("com.kancloud.springboot.jdbc.operation.multi")
public class JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }
}
