package com.one.layout;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.container
 * @FileName: FlowLayoutDemo
 * @Author: wude
 * @Date: 2023/6/9-12:01
 * @Version: 1.0
 * @Description:
 */
public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("布局管理器");

        //通过setLayout方法设置容器的布局管理器
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //这里可以根据RIGHT,CENTER.LEFT设置对齐方式

        //添加多个按钮到frame中
        for(int i = 0; i <100 ; i++){
            frame.add(new Button("按钮" + i));
        }

        //设置最佳大小，pack方法
        frame.pack();

        frame.setVisible(true);
    }
}
