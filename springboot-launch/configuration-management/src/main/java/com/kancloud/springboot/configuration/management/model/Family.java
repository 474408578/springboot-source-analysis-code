package com.kancloud.springboot.configuration.management.model;

import com.kancloud.springboot.configuration.management.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author xschen
 * @see ConfigurationProperties 批量注入属性值到 Java 类， 不支持 SpEL
 *
 */

@Data
@Configuration
@Validated // 需要检验的属性装配类上加 @Validated 注解
@ConfigurationProperties(prefix = "family")
// 不指定 PropertySource 默认去application.yaml中去找
@PropertySource(value = "classpath:/META-INF/family.yaml", factory = YamlPropertySourceFactory.class)
public class Family {

    @NotEmpty // 不能为空
    // @Value 进行属性值绑定
    @Value("${family.familyName}")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
