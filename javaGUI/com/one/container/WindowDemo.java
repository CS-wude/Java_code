package com.one.container;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.container
 * @FileName: WindowDemo
 * @Author: wude
 * @Date: 2023/6/9-11:32
 * @Version: 1.0
 * @Description:
 */
public class WindowDemo {
    public static void main(String[] args) {
        //创建一个窗口对象
        Frame frame = new Frame("这是测试window窗口");

        //指定窗口的位置和大小
        frame.setLocation(100,100);
        frame.setSize(500,300);

        //设置窗口对象可见
        frame.setVisible(true);
    }
}
