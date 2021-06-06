package com.kancloud.springboot.lifecycle;


import com.kancloud.springboot.lifecycle.event.MyEvent;
import com.kancloud.springboot.lifecycle.listener.MyListener1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author xschen
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyListener1Tests {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @BeforeAll
    void init() {
        applicationContext.addApplicationListener(new MyListener1());
    }


    @Test
    public void testEvent() {
        applicationContext.publishEvent(new MyEvent("测试事件"));
    }
}
