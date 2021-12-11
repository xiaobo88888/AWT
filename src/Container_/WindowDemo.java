package Container_;

import java.awt.*;

/*
    Window 对象是一个没有边界和菜单栏的顶层窗口。窗口的默认布局是 BorderLayout。

    public class Frame extends Window  Frame 是带有标题和边框的顶层窗口
        public Frame(String title)  构造一个新的、最初不可见的、具有指定标题的 Frame 对象


    public void setLocation(int x, int y)
        将组件移到新位置。通过此组件父级坐标空间中的 x 和 y 参数来指定新位置的左上角

    public void setSize(int width, int height)
        调整组件的大小，使其宽度为 width，高度为 height

    public void setVisible(boolean b)
        根据参数 b 的值显示或隐藏此组件。
        b - 如果为 true，则显示此组件；否则隐藏此组件


 */
public class WindowDemo {
    public static void main(String[] args) {
        //创建窗口对象
        Frame frame = new Frame("window窗口测试");

        //指定窗口位置，大小
        frame.setLocation(100, 200);
        frame.setSize(500, 500);

        //设置窗口对象可见
        frame.setVisible(true);
    }
}
