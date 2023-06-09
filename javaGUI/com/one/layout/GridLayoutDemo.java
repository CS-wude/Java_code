package com.one.layout;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.layout
 * @FileName: GridLayoutDemo
 * @Author: wude
 * @Date: 2023/6/9-12:30
 * @Version: 1.0
 * @Description:
 */
public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("计算器");

        //创建一个Panel组件,再放一个TextField组件
        Panel p = new Panel();
        p.add(new TextField(30));

        //将当前的Panel放在北部区域
        frame.add(p,BorderLayout.NORTH);

        //创建一个Panel对象并设置其布局管理器GridLayout
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3,5,4,4));
        //网格

        //往Panel中添加内容
        for (int i = 0; i < 10 ; i++){
            p2.add(new Button(i+""));
        }
        //添加组件的顺序是从左往右，从上往下

        p2.add(new Button("+"));
        p2.add(new Button("-"));
        p2.add(new Button("*"));
        p2.add(new Button("/"));
        p2.add(new Button("."));



        //把panel、放在frame中
        frame.add(p2);


        frame.pack();
        frame.setVisible(true);
    }
}
