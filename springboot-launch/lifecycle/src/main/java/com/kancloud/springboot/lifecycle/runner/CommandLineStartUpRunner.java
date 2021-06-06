package com.kancloud.springboot.lifecycle.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xschen
 */

@Slf4j
@Component
public class CommandLineStartUpRunner  implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner 传入参数：{}", Arrays.toString(args));
    }
}
