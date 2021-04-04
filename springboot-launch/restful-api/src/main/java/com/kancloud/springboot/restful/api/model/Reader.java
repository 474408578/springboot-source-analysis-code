package com.kancloud.springboot.restful.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xschen
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reader {
    private String name;
    private int age;
}
