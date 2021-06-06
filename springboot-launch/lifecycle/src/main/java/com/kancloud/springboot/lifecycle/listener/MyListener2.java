package com.kancloud.springboot.lifecycle.listener;

import com.kancloud.springboot.lifecycle.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 * @author xschen
 */

@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s", MyListener2.class.getName(), event.getSource()));
    }
}
