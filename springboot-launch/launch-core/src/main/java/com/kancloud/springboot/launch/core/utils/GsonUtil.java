package com.kancloud.springboot.launch.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author xschen
 */
public class GsonUtil {

    public static void prettyPrint(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(obj));
    }
}
