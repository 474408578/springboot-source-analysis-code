package com.xschen.diveinspringboot.auto.configutation.annotation;

import com.xschen.diveinspringboot.auto.configutation.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活 HelloWorld 模块
 * @author xschen
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class) // import HelloWorldImportSelector
public @interface EnableHelloWorld {

}
