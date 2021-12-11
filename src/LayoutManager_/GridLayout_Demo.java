package LayoutManager_;

import java.awt.*;

/*
    BorderLayout中如果不在其他区域添加东西，则会被添加了东西的区域覆盖

    public TextField(int columns) throws HeadlessException
        构造具有指定列数的新空文本字段。列是近似平均字符宽度，它与平台有关
 */
public class GridLayout_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("GridLayout测试——计算器");

        //创建Panel对象，存放TextField
        Panel panel = new Panel();
        panel.add(new TextField(40));

        //将Panel存放到frame北部
        frame.add(panel, BorderLayout.NORTH);

        //创建Panel对象，设置为GridLayout布局管理器
        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(3, 5, 4, 4));

        //Panel对象存放Button对象
        for (int i = 0; i < 10; i++) {
            panel1.add(new Button(String.valueOf(i)));
        }
        panel1.add(new Button("+"));
        panel1.add(new Button("-"));
        panel1.add(new Button("*"));
        panel1.add(new Button("/"));
        panel1.add(new Button("="));

        //将Panel对象存放到frame中间
        frame.add(panel1, BorderLayout.CENTER);


        frame.pack();
        frame.setVisible(true);
    }
}
