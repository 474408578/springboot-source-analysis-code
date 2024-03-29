package com.xschen.diveinspringboot.auto.configutation.bootstrap;

import com.xschen.diveinspringboot.auto.configutation.configuration.HelloWorldAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * {@link EnableAutoConfiguration} 引导类，实现自动装配
 * @author xschen
 *
 * 1. 激活自动装配 @EnableAutoConfiguration
 * 2. 实现自动装配 {@link HelloWorldAutoConfiguration}
 * 3. 配置自动装配实现 META-INF/spring.factories ， 可参考spring-boot-autoconfigure包中的 META-INF/spring.factories 文件
 *
 * @see SpringFactoriesLoader#loadFactories(Class, ClassLoader)
 * @see SpringFactoriesLoader#FACTORIES_RESOURCE_LOCATION
 */

@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run();

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("hello World Bean: " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
