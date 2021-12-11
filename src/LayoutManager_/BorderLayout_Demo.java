package LayoutManager_;

import java.awt.*;

/*
    static String CENTER
          中间区域的布局约束（容器中央）。

    static String EAST
          东区域的布局约束（容器右边）。

    static String NORTH
          北区域的布局约束（容器顶部）。

    static String SOUTH
          南区域的布局约束（容器底部）。

    static String WEST
          西区域的布局约束（容器左边）。


    public Component add(Component comp, int index)
        将指定组件添加到此容器的给定位置上。
 */
public class BorderLayout_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("BorderLayout测试");

        //将frame设置为BorderLayout布局管理器
        frame.setLayout(new BorderLayout());

        //往frame指定的区域内添加组件
        //public Component add(Component comp, int index)
        frame.add(new Button("北侧按钮"), BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"), BorderLayout.SOUTH);
        frame.add(new Button("西侧按钮"), BorderLayout.WEST);
        frame.add(new Button("东侧按钮"), BorderLayout.EAST);
        frame.add(new Button("中间按钮"), BorderLayout.CENTER);


        frame.pack();
        frame.setVisible(true);
    }
}
