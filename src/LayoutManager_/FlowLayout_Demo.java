package LayoutManager_;

import java.awt.*;

/*
    public void setLayout(LayoutManager mgr)
        设置此容器的布局管理器。

    public void pack()
        调整此窗口的大小，以适合其子组件的首选大小和布局。
 */
public class FlowLayout_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("FlowLayout测试");

        //通过setLayout()设置容器的布局管理器
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 30));

        //添加多个按钮
        for (int i = 0; i < 100; i++) {
            frame.add(new Button("这是测试按钮" + i));
        }

        //设置最佳大小，使用pack
        frame.pack();

        frame.setVisible(true);
    }
}
