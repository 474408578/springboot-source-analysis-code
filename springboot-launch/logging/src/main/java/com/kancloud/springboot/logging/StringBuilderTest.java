package com.kancloud.springboot.logging;

import com.kancloud.springboot.launch.core.utils.GsonUtil;

import java.util.*;

/**
 * @author xschen
 */

public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i!=0) {
                sb.append(",");
            }
            sb.append("i" + i);
        }

        String s = sb.toString();
        String[] split = s.split(",");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }

        List<String> str = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            str.add("i" + i);
        }

        System.out.println(str);
        for (String s2 : split) {
            str.remove(s2);
        }

        System.out.println(str);
    }


}
