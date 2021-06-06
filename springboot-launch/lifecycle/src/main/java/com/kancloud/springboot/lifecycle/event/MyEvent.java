package com.kancloud.springboot.lifecycle.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author xschen
 */
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
