package com.kancloud.springboot.launch.core.utils.bean;

import com.kancloud.springboot.launch.core.utils.BeanUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xschen
 */

public class BeanTest {

    @Test
    public void testMapToBean() {
        BeanUtil beanUtil = new BeanUtil();
        Map<String, Object> map = new HashMap();
        map.put("name", "song");
        map.put("age", 24);
        Person person = new Person();
        System.out.println(person);
        beanUtil.mapToBean(map, person);
        System.out.println(person);
    }

    @Test
    public void testBeanToMap() {
        BeanUtil beanUtil = new BeanUtil();
        Person person = new Person();
        person.setAge(24);
        person.setName("song");
        Map<String, Object> map = beanUtil.beanToMap(person);
        System.out.println(map);
    }
}
