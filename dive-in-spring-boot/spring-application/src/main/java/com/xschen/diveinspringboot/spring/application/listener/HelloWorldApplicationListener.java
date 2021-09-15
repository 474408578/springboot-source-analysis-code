package com.xschen.springboot.diveinspringboot.spring.application.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * HelloWorldApplicationListener 监听 {@link ContextRefreshedEvent}
 * @author xschen
 */


@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorld: " + event.getApplicationContext().getId() +
                ", timestamp: " + event.getTimestamp());
    }
}
