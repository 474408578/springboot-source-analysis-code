package com.xschen.diveinspringboot.overview.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 统计接口耗时。
 * @author xschen
 * @date 2021/9/15 14:21
 */

@Slf4j
@WebFilter(urlPatterns = "/my/servlet", asyncSupported = true)
public class MyFilter implements Filter {

    public MyFilter() {
        log.info("myFilter construct execute");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("开始计算接口耗时");
        long starTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        log.info("执行时间: {} ms.", endTime - starTime);
    }
}
