package com.kancloud.springboot.mybatis.operation.single;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xschen
 */


@SpringBootApplication
@MapperScan(basePackages = {"com.kancloud.springboot.mybatis.operation.single.mapper"})
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
