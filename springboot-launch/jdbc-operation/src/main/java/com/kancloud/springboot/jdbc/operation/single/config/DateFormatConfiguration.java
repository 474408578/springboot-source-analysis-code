package com.kancloud.springboot.jdbc.operation.single.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xschen
 * 需求背景：
 * 在Jackson序列化的时候，会根据不同类型调用不同的 Serializer 进行序列化，如果没有默认的Serializer时，调用的是类的toString()。
 * 而Date类型序列化时会使用 DateSerializer，里面会使用 spring.jackson.date-format 中的配置，
 * 而 LocalDateTime 则是通过 LocalDateTimeSerializer，它默认使用的是 DateTimeFormatter.ISO_LOCAL_DATE_TIME，
 * 如果能够覆盖默认的LocalDateTimeSerializer，就可以按照自己的需求进行日期格式化了。
 */

//@Configuration
public class DateFormatConfiguration {

    /**
     * Date格式化字符串
     */
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * DateTime格式化字符串
     */
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * Time格式化字符串
     */
    private static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 自定义Bean
     *
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
                .serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_FORMAT)))
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)))
                .deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_FORMAT)));
    }

}
