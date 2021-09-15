package com.xschen.diveinspringboot.auto.configutation.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 二级 {@link Repository}
 * @author xschen
 */

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@FirstLevelRepository
public @interface SecondLevelRepository {

    String value() default "";
}
