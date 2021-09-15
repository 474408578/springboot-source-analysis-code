package com.xschen.springboot.diveinspringboot.spring.application.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;


/**
 * Before {@link ConfigFileApplicationListener} 实现
 *
 * @author xschen
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        // 判断 ApplicationEnvironmentPreparedEvent/ApplicationPreparedEvent 是否和 eventType相同，
        // 或者eventType 类是否由 ApplicationEnvironmentPreparedEvent/ApplicationPreparedEvent 派生。（assignable 可赋值的）
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\"): " + environment.getProperty("name"));
        }

        if (event instanceof ApplicationPreparedEvent) {

        }
    }

    /**
     * 比 ConfigFileApplicationListener 优先级更高
     * @return
     */
    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }
}
