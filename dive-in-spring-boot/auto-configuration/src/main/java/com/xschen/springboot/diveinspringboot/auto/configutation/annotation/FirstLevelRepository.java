package com.xschen.springboot.diveinspringboot.auto.configutation.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 一级 {@link Repository}
 * @author xschen
 */

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Repository
public @interface FirstLevelRepository {

    String value() default "";
}
