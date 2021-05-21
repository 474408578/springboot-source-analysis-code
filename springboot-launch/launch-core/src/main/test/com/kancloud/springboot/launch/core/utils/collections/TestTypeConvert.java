package com.kancloud.springboot.launch.core.utils.collections;

import com.kancloud.springboot.launch.core.utils.TimeUtil;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xschen
 */
public class TestTypeConvert {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("ke", 1.0);
        System.out.println(map);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime from = now.minus(20, ChronoUnit.DAYS);
        long endTime = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long startTime = from.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("startTime: " + startTime);
        System.out.println("endTime: " + endTime);
        System.out.println(startTime > endTime);

        System.out.println(TimeUtil.getSpecifiedLengthTimestamp(now, 10));
        System.out.println(TimeUtil.getLocalDateTime(1621586237L));
        System.out.println(TimeUtil.getLocalDateTime(1621596434188L));
    }
}
