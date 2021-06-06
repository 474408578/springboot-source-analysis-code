package com.kancloud.springboot.lifecycle.controller;

import com.kancloud.springboot.lifecycle.event.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xschen
 */

@RestController
public class HelloController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpSession session) {
        // 操作 Attribute
        request.setAttribute("a", "a");
        request.setAttribute("a", "b");
        request.getAttribute("a");
        request.removeAttribute("a");

        // 操作 session
        session.setAttribute("a", "a");
        session.getAttribute("a");
        // 清空 session
        session.invalidate();
        applicationContext.publishEvent(new MyEvent("controller测试事件"));

        return "Hello world!";
    }
}
