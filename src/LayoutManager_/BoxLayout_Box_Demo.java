package LayoutManager_;

import javax.swing.*;
import java.awt.*;

/*
    Box使用 BoxLayout 对象作为其布局管理器的一个轻量级容器。

    public static Box createHorizontalBox()
        创建一个从左到右显示其组件的 Box。

    public static Box createVerticalBox()
        创建一个从上到下显示其组件的 Box。
 */
public class BoxLayout_Box_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("BoxLayout_Box测试");

        //创建水平容器
        Box box1 = Box.createHorizontalBox();

        //往容器中添加两个按钮
        box1.add(new Button("水平容器一"));
        box1.add(new Button("水平容器二"));

        //创建垂直容器
        Box box2 = Box.createVerticalBox();

        //往容器中添加两个按钮
        box2.add(new Button("垂直容器一"));
        box2.add(new Button("垂直容器二"));

        //将两个容器添加到frame中
        frame.add(box1, BorderLayout.NORTH);
        frame.add(box2);

        frame.pack();
        frame.setVisible(true);
    }
}
