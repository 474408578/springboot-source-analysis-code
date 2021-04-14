package com.kancloud.springboot.jpa.operation.single.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xschen
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    private String name;
    private int age;
}
