package com.xschen.diveinspringboot.spring.application.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * After HelloWorldApplicationListener 监听 {@link ContextRefreshedEvent}
 * @author xschen
 */


public class AfterHelloWorldApplicationListener
        implements ApplicationListener<ContextRefreshedEvent>, Ordered {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorld: " + event.getApplicationContext().getId() +
                ", timestamp: " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
