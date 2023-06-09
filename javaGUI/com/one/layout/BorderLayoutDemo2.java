package com.one.layout;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.container
 * @FileName: BorderLayoutDemo
 * @Author: wude
 * @Date: 2023/6/9-12:13
 * @Version: 1.0
 * @Description:
 */
public class BorderLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("BorderLayout布局管理器");

        //给frame设置BorderLayout布局管理器
        frame.setLayout(new BorderLayout(30 , 10));

        //指定区域添加组件
        frame.add(new Button("北侧按钮"), BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"), BorderLayout.SOUTH);
        /*frame.add(new Button("中间按钮"), BorderLayout.CENTER);

        frame.add(new TextField("测试文本框"));
        会覆盖
        */

        Panel p = new Panel();
        p.add(new Button("中间按钮"));
        p.add(new TextField("测试文本框"));
        //这时两个内容都显示，没有被覆盖

        frame.add(p);

        frame.pack();
        frame.setVisible(true);
    }
}
