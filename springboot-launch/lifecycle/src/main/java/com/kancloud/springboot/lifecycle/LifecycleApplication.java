package com.kancloud.springboot.lifecycle;

import com.kancloud.springboot.lifecycle.listener.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * program arguments:  --name=song --age=24
 * @author xschen
 */

@SpringBootApplication
@ServletComponentScan // @WebServlet、@WebFilter、@WebListener 注解自动注册
public class LifecycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LifecycleApplication.class, args);
        context.addApplicationListener(new MyListener1());
    }
}
