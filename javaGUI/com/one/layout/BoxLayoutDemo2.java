package com.one.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.layout
 * @FileName: BoxLayoutDemo2
 * @Author: wude
 * @Date: 2023/6/9-13:18
 * @Version: 1.0
 * @Description:
 */
public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("");

        //创建一个水平排列组件的Box容器
        Box hBox = Box.createHorizontalBox();

        //往当前容器中添加两个按钮
        hBox.add(new Button("水平按钮1"));
        hBox.add(new Button("水平按钮2"));

        //创建一个垂直排列组件的Box容器
        Box vBox = Box.createVerticalBox();

        //往当前组件中添加两个按钮
        vBox.add(new Button("垂直按钮1"));
        vBox.add(new Button("垂直按钮2"));

        //把两个box容器添加到frame 中
        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);


        frame.pack();
        frame.setVisible(true);
    }
}
