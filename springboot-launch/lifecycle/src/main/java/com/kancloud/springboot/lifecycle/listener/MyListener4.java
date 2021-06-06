package com.kancloud.springboot.lifecycle.listener;

import com.kancloud.springboot.lifecycle.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 * @author xschen
 */

@Component
@Slf4j
public class MyListener4{

    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s", MyListener4.class.getName(), event.getSource()));
    }
}
