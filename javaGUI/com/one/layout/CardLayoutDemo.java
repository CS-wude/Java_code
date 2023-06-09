package com.one.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.layout
 * @FileName: CardLayoutDemo
 * @Author: wude
 * @Date: 2023/6/9-12:53
 * @Version: 1.0
 * @Description:
 */
public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("卡片布局测试");

        //创建一个panel用来存储多张卡片
        Panel p1 = new Panel();


        //创建卡片布局对象CardLayout，并把该对象设置为之前创建的容器
        CardLayout cardLayout = new CardLayout();
        p1.setLayout(cardLayout);

        //往Panel中存储多个组件
        String[] names = {"第一张" ,"第二张","第三张","第四张","第五张" };

        for (int i = 0; i < names.length ; i++){
            p1.add(names[i] , new Button(names[i]));
        }

        //把Panel放在frame中间区域

        frame.add(p1);

        //创建另一个Panel用来存储多个按钮组件
        Panel p2 = new Panel();

        //创建五个按钮组件
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");

        //创建一个事件监听器，监听按钮的点击动作
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand(); //按钮上的文字
                switch (actionCommand){
                    case "上一张":
                        cardLayout.previous(p1);
                        break;
                    case "下一张":
                        cardLayout.next(p1);
                        break;
                    case "第一张":
                        cardLayout.first(p1);
                        break;
                    case "最后一张":
                        cardLayout.last(p1);
                        break;
                    case "第三张":
                        cardLayout.show(p1 , "第三张");
                        break;
                }
            }
        };

        //把当前这个事件监听器和多个按钮绑定在一起
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);

        //把按钮添加在容器p2中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);


        //把p2放在frame的南边区域
        frame.add(p2 , BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
