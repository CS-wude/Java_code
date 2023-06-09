package com.one.layout;

import java.awt.*;

/**
 * @BelongsProject: java_work
 * @BelongsPackage: com.one.layout
 * @FileName: GridBagLayoutDemo
 * @Author: wude
 * @Date: 2023/6/9-12:44
 * @Version: 1.0
 * @Description:
 */
public class GridBagLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("这是GridBagLayout测试");

        //创建GridBagLayout对象
        GridBagLayout gbl = new GridBagLayout();

        //把frame对象的布局管理器设置为GridBagLayout
        frame.setLayout(gbl);

        //创建GridBagConstraints对象
        GridBagConstraints gbc = new GridBagConstraints();

        //创建容量为10 的按钮数量
        Button[] bs = new Button[10];

        //遍历数组，初始化每个按钮
        for (int i = 0 ; i < bs.length ; i++){
            bs[i] = new Button("按钮" + i);
        }

        /*这里实现了让各种组件跨越多个网格来排列
        我后续有时间再研究... ...*/

        frame.pack();
        frame.setVisible(true);
    }
}
