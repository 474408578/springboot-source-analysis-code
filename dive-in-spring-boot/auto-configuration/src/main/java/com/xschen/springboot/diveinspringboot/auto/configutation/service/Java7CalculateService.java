package com.xschen.springboot.diveinspringboot.auto.configutation.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Java 7 循环实现
 * @author xschen
 */

@Service
@Profile("Java7")
public class Java7CalculateService implements  CalculateService {

    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 7 循环实现 ");
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum;
    }
}
