package com.xschen.diveinspringboot.auto.configutation.bootstrap;

import com.xschen.diveinspringboot.auto.configutation.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xschen
 * Enable 模块装配示例
 */

@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld bean: " + helloWorld);
        context.close();
    }
}
