package com.xschen.springboot.diveinspringboot.springboot.view.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xschen
 */

@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
            return acceptLanguage;
    }

    @ModelAttribute("message")
    public String message() {
        return "Hello, World";
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        return jsessionId;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}
