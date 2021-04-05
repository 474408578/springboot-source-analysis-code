package com.kancloud.springboot.configuration.management.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.List;
import java.util.Map;

/**
 * {@link PropertySource} 引入外部配置文件示例
 * @author xschen
 * @see PropertySource
 * @see PropertySourceFactory // 使用什么类型的 解析器解析当前导入的资源文件，
 *      即使用 @PropertySource 注解引入的资源文件，需要使用什么策略来解析
 */

@Data
@Configuration
@PropertySource(value = "classpath:/META-INF/employee.properties", encoding = "UTF-8")
public class Employee {

    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split(',')[0]}")
    private  String mary;

    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value("#{${employee.age}['two']}")
    private String employeeAgeTwo;

    @Value("#{${employee.age}['three'] ?: 31}") // 如果不存在，则赋值 31
    private Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;

}
