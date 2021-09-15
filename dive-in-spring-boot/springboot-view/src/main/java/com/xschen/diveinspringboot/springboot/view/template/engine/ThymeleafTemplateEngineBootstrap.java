package com.xschen.diveinspringboot.springboot.view.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Thymeleaf 模板引导类
 * @author xschen
 */


public class ThymeleafTemplateEngineBootstrap {

    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "hello World");
        // 读取内容从 classpath:/templates/thymeleaf/hello-world.html
        // ResourceLoader
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
        File file = resource.getFile();
        // 文件流
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // copy
        IOUtils.copy(inputStream, outputStream);

        inputStream.close();
        // 模板内容
        String content = outputStream.toString("UTF-8");
        String result = templateEngine.process(content, context);
        System.out.println(result);
    }
}
