package com.one.container;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.container
 * @FileName: ScrollPaneDemo
 * @Author: wude
 * @Date: 2023/6/9-11:45
 * @Version: 1.0
 * @Description:
 */
public class ScrollPaneDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("这里演示滚动窗口");

        //创建一个ScrollPane对象
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        //往ScrollPane中添加内容
        sp.add(new TextField("这是一个测试文本"));
        sp.add(new Button("这是一个测试按钮"));
        //这里这里只能看见一个，这是布局的问题
        //所以需要用到布局管理器

        //把ScrollPane加入Frame中
        frame.add(sp);


        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }
}
