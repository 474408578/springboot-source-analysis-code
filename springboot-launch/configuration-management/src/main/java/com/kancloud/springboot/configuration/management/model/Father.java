package com.kancloud.springboot.configuration.management.model;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author xschen
 */

@Data
public class Father {
    private String name;
    @Min(21) // 父亲的年龄必须大于 21 岁
    private Integer age;
}
