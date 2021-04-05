package com.kancloud.springboot.configuration.management.model;

import lombok.Data;

import java.util.List;

/**
 * @author xschen
 */

@Data // getter setter toString
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}
