package com.kancloud.springboot.launch.core.utils.collections;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xschen
 */
public class CollectionsUtil {


    @Test
    public void addAllTest() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(i);
        }

        String str = sb.toString();
        List<String> list = new ArrayList<>();
        Collections.addAll(list, str.split(","));
        System.out.println(list);
    }
}
