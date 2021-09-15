package com.xschen.diveinspringboot.springboot.view.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xschen
 */

@SpringBootApplication
@ComponentScan("com.xschen.springboot.diveinspringboot.springboot.view")
public class SpringBootViewBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class, args);
    }
}
