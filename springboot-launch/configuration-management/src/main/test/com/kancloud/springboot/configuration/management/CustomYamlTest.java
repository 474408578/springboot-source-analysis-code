package com.kancloud.springboot.configuration.management;

import com.kancloud.springboot.configuration.management.model.Employee;
import com.kancloud.springboot.configuration.management.model.Family;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xschen
 */

@Slf4j
@SpringBootTest
public class CustomYamlTest {
    @Autowired
    Family family;

    @Autowired
    Employee employee;

    @Test
    public void valueBindTests() {
        System.out.println(family.toString());
    }


    @Test
    public void valueBindTests2() {
        System.out.println(employee);
    }


}
