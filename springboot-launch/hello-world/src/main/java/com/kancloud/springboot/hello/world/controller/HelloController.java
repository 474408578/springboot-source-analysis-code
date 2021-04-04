package com.kancloud.springboot.hello.world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xschen
 */

@RestController
public class HelloController {

    /**
     * http://localhost:8080/hello?name=song
     * hello world, song
     * @param name
     * @return
     */
    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello world, " + name;
    }
}
