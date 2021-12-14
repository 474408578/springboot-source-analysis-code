package com.xschen.diveinspringboot.auto.configutation.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 类似 {@link ConditionalOnProperty} 功能的注解
 * 当参数设置或者值一致时，才执行实例化方法或将类实例化。
 * @author xschen
 * @see Conditional
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    String name();
    String value();
}
