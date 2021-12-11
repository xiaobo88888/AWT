package Container_;

import java.awt.*;

/*
    实现用于单个子组件的自动水平和/或垂直滚动的容器类

    public ScrollPane() throws HeadlessException
        创建一个具有滚动条策略 "as needed" 的新滚动窗格容器。

    public ScrollPane(int scrollbarDisplayPolicy) throws HeadlessException
        创建新的滚动窗格容器。
        scrollbarDisplayPolicy - 显示滚动条时使用的策略


    public static final int SCROLLBARS_ALWAYS
        指定无论滚动窗格和子组件各自大小如何，总是显示水平/垂直滚动条。

    public Component add(Component comp)
        将指定组件追加到此容器的尾部。
 */
public class ScrollPaneDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("Scrollpane测试");

        //创建ScrollPane对象
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        //往ScrollPane中添加内容
        sp.add(new TextField("这是测试文本"));
        sp.add(new Button("这是测试按钮"));

        //将ScrollPane添加进Window中
        frame.add(sp);


        frame.setLocation(400, 300);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
