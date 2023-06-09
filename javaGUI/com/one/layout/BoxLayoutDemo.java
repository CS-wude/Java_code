package com.one.layout;

import java.awt.*;
import javax.swing.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.layout
 * @FileName: BoxLayoutDemo
 * @Author: wude
 * @Date: 2023/6/9-13:11
 * @Version: 1.0
 * @Description:
 */
public class BoxLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("BoxLayout测试");

        //基于frame容器创建一个BoxLayout对象，并且存放组件垂直存放
        int yAxis = BoxLayout.Y_AXIS;
        //X_AXIS水平排列
        BoxLayout boxLayout = new BoxLayout(frame , yAxis);

        //把BoxLayout对象设置给Frame
        frame.setLayout(boxLayout);

        //往Frame中添加两个按钮组件
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));


        frame.pack();
        frame.setVisible(true);
    }
}
