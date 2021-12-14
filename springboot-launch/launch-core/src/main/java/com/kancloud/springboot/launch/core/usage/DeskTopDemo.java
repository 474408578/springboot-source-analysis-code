package com.kancloud.springboot.launch.core.usage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * DeskTop设置系统启动时，打开一个网页示例
 * @author xschen
 * @date 2021/9/15 17:00
 * 系统属性 "java.awt.headless"
 */
public class DeskTopDemo {

    public static void main(String[] args) throws URISyntaxException, IOException {
        // headless 模式： 在缺少显示屏，键盘，鼠标时的系统配置
        // 没有检测到显示器时，不允许启动
        System.setProperty("java.awt.headless", Boolean.FALSE.toString());
        Desktop.getDesktop().browse(new URI("https://www.baidu.com/"));
    }
}
