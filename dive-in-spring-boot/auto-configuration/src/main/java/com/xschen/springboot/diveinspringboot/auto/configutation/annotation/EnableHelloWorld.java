package com.xschen.springboot.diveinspringboot.auto.configutation.annotation;

import com.xschen.springboot.diveinspringboot.auto.configutation.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

}
