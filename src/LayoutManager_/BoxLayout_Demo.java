package LayoutManager_;

import javax.swing.*;
import java.awt.*;

/*
    public BoxLayout(Container target, int axis)
        创建一个将沿给定轴放置组件的布局管理器。

    public static final int X_AXIS
        指定组件应该从左到右放置。

    public static final int Y_AXIS
        指定组件应该从上到下放置。
 */
public class BoxLayout_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("BoxLayout测试");

        //创建BoxLayout组件，垂直布局
//        BoxLayout box = new BoxLayout(frame, BoxLayout.Y_AXIS);
        BoxLayout box = new BoxLayout(frame, BoxLayout.X_AXIS);


        //并把它设置为frame的布局管理器
        frame.setLayout(box);

        //往frame中添加两个按钮
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));

        frame.pack();
        frame.setVisible(true);
    }
}
