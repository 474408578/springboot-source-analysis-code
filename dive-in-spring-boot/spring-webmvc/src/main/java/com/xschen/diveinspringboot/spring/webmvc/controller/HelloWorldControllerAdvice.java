package com.xschen.diveinspringboot.spring.webmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link HelloWorldController} 通知（增强）
 *
 * @author xschen
 */

// 针对 HelloWorldController 做逻辑的增强
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {


    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

    //@ModelAttribute("jsessionId")
    //public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
    //    return jsessionId;
    //}

    @ModelAttribute("message")
    public String message() {
        return "Hello, World";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }
}
