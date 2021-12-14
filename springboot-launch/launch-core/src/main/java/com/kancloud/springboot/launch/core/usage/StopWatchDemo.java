package com.kancloud.springboot.launch.core.usage;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * StopWatch 示例
 * @author xschen
 * @date 2021/9/15 16:26
 * @see StopWatch
 * @see StopWatch.TaskInfo 以链表形式存在 stopWatch 中
 */

public class StopWatchDemo {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("myStopWatch");
        stopWatch.start("task1");
        System.out.println("do task1...");
        TimeUnit.SECONDS.sleep(3);
        stopWatch.stop();
        System.out.printf("task1 takes %s ms.\n", stopWatch.getLastTaskTimeMillis());

        stopWatch.start("task2");
        System.out.println("do task2...");
        TimeUnit.SECONDS.sleep(2);
        stopWatch.stop();
        System.out.printf("task2 takes %s ms.\n", stopWatch.getLastTaskTimeMillis());

        System.out.printf("myStopWatch takes %s ms.\n", stopWatch.getTotalTimeMillis());

        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());

        Arrays.stream(stopWatch.getTaskInfo()).forEach(taskInfo -> {
            System.out.println("taskInfo.getTaskName: " + taskInfo.getTaskName());
            System.out.println("taskInfo.getTimeMillis: " + taskInfo.getTimeMillis());
            System.out.println("--------------------------");
        });
    }
}
