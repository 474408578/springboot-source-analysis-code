package com.kancloud.springboot.launch.core.usage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection 方法toArray 演示
 * @author xschen
 * @date 2021/9/16 17:30
 * @see Collection#toArray()
 */
public class CollectionToArrayDemo {

    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        // String[] arr1 = (String[]) list.toArray(); // 强转会失败
        // Arrays.stream(arr1).forEach(System.out::println);

        String[] arr = list.toArray(new String[0]); // new String[0] 表示 转化为String数组
        Arrays.stream(arr).forEach(System.out::println);
    }
}
