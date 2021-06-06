package com.kancloud.springboot.lifecycle.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xschen
 */

@Slf4j
@Component
public class AppStartUpRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner 参数名称：{}", args.getOptionNames());
        log.info("ApplicationRunner 参数值：{}", args.getOptionValues("age"));
        log.info("ApplicationRunner 参数：{}", Arrays.toString(args.getSourceArgs()));
    }
}
