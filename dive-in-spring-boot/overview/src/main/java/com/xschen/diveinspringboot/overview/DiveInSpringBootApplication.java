package com.xschen.diveinspringboot.overview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * @author xschen
 * @see ServletComponentScan
 * @see WebFilter
 * @see WebServlet
 * @see WebListener
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.xschen.diveinspringboot.overview.web")
public class DiveInSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiveInSpringBootApplication.class, args);

        //new SpringApplicationBuilder(DiveInSpringBootApplication.class)
                //.web(WebApplicationType.NONE)
                //.run(args);
    }

}
