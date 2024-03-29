package com.xschen.diveinspringboot.auto.configutation.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author xschen
 */

public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取 ConditionalOnSystemProperty注解的两个属性。
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propertyName = String.valueOf(attributes.get("name"));
        String propertyValue = String.valueOf(attributes.get("value"));
        String javaPropertyValue = System.getProperty(propertyName);
        return (javaPropertyValue.equals(propertyValue));
    }
}
