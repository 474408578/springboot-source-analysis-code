package com.kancloud.springboot.configuration.management;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.Properties;

/**
 * {@link PropertySourceFactory } 示例
 * @author xschen
 * @see org.springframework.context.annotation.PropertySource
 * @see DefaultPropertySourceFactory#createPropertySource(String, EncodedResource)  进行配置文件加载的工厂类
 * @see ResourcePropertySource
 *
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        // 传入 resource 资源文件
        yamlPropertiesFactoryBean.setResources(resource.getResource());
        // 直接获得 properties 对象
        Properties properties = yamlPropertiesFactoryBean.getObject();
        // 如果 @PropertySource 没有指定 name, 自使用资源文件的文件名
        return new PropertiesPropertySource((name != null ? name : resource.getResource().getFilename()), properties);
    }
}
