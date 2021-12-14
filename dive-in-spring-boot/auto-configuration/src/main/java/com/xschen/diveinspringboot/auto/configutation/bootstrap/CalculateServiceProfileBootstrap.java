package com.xschen.diveinspringboot.auto.configutation.bootstrap;

import com.xschen.diveinspringboot.auto.configutation.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Profile 环境条件装配 启动类
 * @author xschen
 */


@ComponentScan(basePackages = "com.xschen.diveinspringboot.auto.configutation.service")
public class CalculateServiceProfileBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceProfileBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer sum = calculateService.sum(values);
        System.out.println(sum);

        context.close();
    }
}
