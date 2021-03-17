package com.xschen.springboot.diveinspringboot.auto.configutation.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author xschen
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    String name();
    String value();
}
