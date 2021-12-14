package com.xschen.diveinspringboot.overview.web.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器 Demo
 * @author xschen
 * @date 2021/9/15 14:42
 */

@WebListener
@Slf4j
public class MyListener implements ServletContextListener,
        ServletRequestListener,
        HttpSessionListener
        /*,ServletRequestAttributeListener*/ {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("servlet context created");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("servlet context destroyed");
    }


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("servlet request destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("servlet request created");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session destroyed");
    }
}
