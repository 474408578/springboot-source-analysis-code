package com.kancloud.springboot.configuration.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * @author xschen
 *
 * @see EnableAutoConfiguration : SpringBoot 自动装载开关
 */


@SpringBootApplication
class ConfigurationManagementApplication {

    public static void main(String[] args) {
        /**
         * @see SpringApplication#run(Class, String...)  ->
         * @see SpringApplication#run(Class[], String[]) -> 
         * @see SpringApplication#run(String...) -> 
         * @see SpringApplication#getSpringFactoriesInstances(Class, Class[], Object...) ->
         * @see SpringFactoriesLoader#loadFactoryNames(Class, ClassLoader) -> 
         * @see SpringFactoriesLoader#loadSpringFactories(ClassLoader)  ->
         * classLoader.getResources(FACTORIES_RESOURCE_LOCATION)
         * @see SpringFactoriesLoader#instantiateFactory(String, Class, ClassLoader)
         *
         * SpringFactoriesLoader会以@EnableAutoConfiguration的包名
         * 和类名org.springframework.boot.autoconfigure.EnableAutoConfiguration为Key查找spring.factories文件
         */
        SpringApplication.run(ConfigurationManagementApplication.class, args);
    }

}
