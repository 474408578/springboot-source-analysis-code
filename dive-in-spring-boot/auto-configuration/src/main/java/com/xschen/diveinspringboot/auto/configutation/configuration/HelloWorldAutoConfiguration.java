package com.xschen.diveinspringboot.auto.configutation.configuration;

import com.xschen.diveinspringboot.auto.configutation.annotation.EnableHelloWorld;
import com.xschen.diveinspringboot.auto.configutation.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * HelloWorld 自动装配
 * @author xschen
 */

@Configuration // Spring 模式装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "xschen") // 条件装配
public class HelloWorldAutoConfiguration {

}
