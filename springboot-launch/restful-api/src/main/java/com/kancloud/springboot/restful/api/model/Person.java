package com.kancloud.springboot.restful.api.model;

/**
 * @author xschen
 * @date 2021/11/12 14:47
 */


public class Person {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
