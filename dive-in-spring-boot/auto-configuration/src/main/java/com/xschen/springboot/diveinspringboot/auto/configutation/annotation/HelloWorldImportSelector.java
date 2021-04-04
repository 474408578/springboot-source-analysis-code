package com.xschen.springboot.diveinspringboot.auto.configutation.annotation;

import com.xschen.springboot.diveinspringboot.auto.configutation.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xschen
 */
public class HelloWorldImportSelector  implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {HelloWorldConfiguration.class.getName()};
    }
}
