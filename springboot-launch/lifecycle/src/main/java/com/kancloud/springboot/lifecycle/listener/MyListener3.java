package com.kancloud.springboot.lifecycle.listener;

import com.kancloud.springboot.lifecycle.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * 自定义事件监听器
 * @author xschen
 */

@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s监听到事件源：%s", MyListener3.class.getName(), event.getSource()));
    }
}
