package com.kancloud.springboot.launch.core.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 时间工具类
 * @author xschen
 */

public class TimeUtil {

    /**
     * DateTimeFormatter 时间格式
     */
    private static final DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.YEAR)
            .appendLiteral("-")
            .appendValue(ChronoField.MONTH_OF_YEAR, 2)
            .appendLiteral("-")
            .appendValue(ChronoField.DAY_OF_MONTH, 2)
            .appendLiteral(" ")
            .appendValue(ChronoField.HOUR_OF_DAY, 2)
            .appendLiteral(":")
            .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
            .appendLiteral(":")
            .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
            .toFormatter();

    // 2021-04-05 15:43:37
    public static String getLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(dateTimeFormatter);
    }

    /**
     * 获取 timeStamp
     * @param localDateTime
     * @return
     */
    public static Long getTimestamp(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Long timestamp = localDateTime.atZone(zoneId).toInstant().toEpochMilli();
        return timestamp;
    }

    /**
     * 获取时间戳，只取时间戳的前 length 位
     * @param localDateTime
     * @param length
     * @return
     */
    public static Long getSpecifiedLengthTimestamp(LocalDateTime localDateTime, int length) {
        String timestamp = String.valueOf(getTimestamp(localDateTime));
        if (timestamp.length() < length) {
            throw new RuntimeException("please check the specified length: " + length);
        }
        return Long.valueOf(timestamp.substring(0, length));
    }

    public static LocalDateTime getLocalDateTime(Long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        String date = localDateTime.format(dateTimeFormatter);
//        return date;
        return localDateTime;
    }
}
