package com.xschen.springboot.diveinspringboot.springboot.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xschen
 */

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam("value") int value,  Model model) {
        //model.addAttribute("acceptLanguage",acceptLanguage);
        //model.addAttribute("jsessionId",jsessionId);
        model.addAttribute("message","Hello,World");
        return "index";
    }

}
