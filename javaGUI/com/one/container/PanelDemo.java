package com.one.container;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.container
 * @FileName: PanelDemo
 * @Author: wude
 * @Date: 2023/6/9-11:36
 * @Version: 1.0
 * @Description:
 */
public class PanelDemo {
    public static void main(String[] args) {
        //创建一个window对象,panel和其他组件需要依附于window
        Frame frame = new Frame("这里显示panel");

        //创建一个Panel对象
        Panel p = new Panel();

        //创建一个文本框和一个按钮，并将其放入Panel容器中
        p.add(new TextField("这里是一个测试文本"));
        p.add(new Button("这里是一个测试按钮"));
        //这里由于编码问题会有乱码，需要设置-Dfile.encoding=gbk

        //把panel放入window中
        frame.add(p);

        //设置可见
        frame.setVisible(true);
    }
}
