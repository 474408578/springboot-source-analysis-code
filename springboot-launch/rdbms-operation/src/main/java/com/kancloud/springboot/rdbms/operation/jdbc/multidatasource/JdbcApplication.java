package com.kancloud.springboot.rdbms.operation.jdbc.multidatasource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * @author xschen
 */

@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JdbcApplication.class)
                .profiles("multidatasource")
                .run(args);
    }
}
