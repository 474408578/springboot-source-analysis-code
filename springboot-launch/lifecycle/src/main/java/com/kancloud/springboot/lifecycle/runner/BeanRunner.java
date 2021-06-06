package com.kancloud.springboot.lifecycle.runner;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author xschen
 */

@Configuration
public class BeanRunner {

    @Bean
    @Order(1)
    public CommandLineRunner runner1() {
        return args -> System.out.println("BeanCommandLineRunner run1()" + Arrays.toString(args));
    }


    @Bean
    @Order(2)
    public CommandLineRunner runner2() {
        return args -> System.out.println("BeanCommandLineRunner run2()" + Arrays.toString(args));
    }

    @Bean
    @Order(3)
    public ApplicationRunner runner3() {
        return args -> System.out.println("BeanApplicationRunner run3()" + Arrays.toString(args.getSourceArgs()));
    }
}
