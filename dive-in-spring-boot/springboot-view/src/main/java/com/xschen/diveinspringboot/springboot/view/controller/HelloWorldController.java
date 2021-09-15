package com.xschen.diveinspringboot.springboot.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xschen
 */

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }

    // jsp
    @RequestMapping("")
    public String index(@RequestParam(value = "value", required = false, defaultValue = "0") int value, Model model) {
        return "index";
    }
}
