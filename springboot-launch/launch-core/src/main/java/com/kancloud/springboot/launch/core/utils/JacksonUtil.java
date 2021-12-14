package com.kancloud.springboot.launch.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.StringUtils;

/**
 * @author xschen
 * @date 2021/11/12 14:54
 */
public class JacksonUtil {
    private static volatile JacksonUtil instance;

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 允许 pojo 中有json串不存在的字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private JacksonUtil() {
    }

    public static JacksonUtil getInstance() {
        if (instance == null) {
            synchronized (JacksonUtil.class) {
                if (instance == null) {
                    instance = new JacksonUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 对象转换为json字符串
     * @param obj
     * @return
     */
    public static String obj2Json(Object obj) {
        try {
            return getInstance().objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    // json字符串转换为对象
    public static <T> T json2Obj(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return null;
        }
        if (String.class.isAssignableFrom(clazz)) {
            return (T) json;
        }

        try {
            T obj = objectMapper.readValue(json, clazz);
            return obj;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
