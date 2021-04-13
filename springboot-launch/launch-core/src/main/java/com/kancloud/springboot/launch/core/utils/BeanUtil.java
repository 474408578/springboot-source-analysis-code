package com.kancloud.springboot.launch.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * map 与 bean 互转，不支持对象嵌套
 * @author xschen
 *
 * @see BeanInfo
 */

@Slf4j
@Component
public class BeanUtil {

    public Object mapToBean(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    Method setter = propertyDescriptor.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            log.error("BeanUtil.mapToBean.Exception:{}", e);
        }
        return obj;
    }

    public Map<String, Object> beanToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                if (!key.equalsIgnoreCase("class")) {
                    Method getter = propertyDescriptor.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.putIfAbsent(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
