package com.kancloud.springboot.restful.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author xschen
 * @date 2021/11/12 14:48
 */
public class Student extends Person {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
