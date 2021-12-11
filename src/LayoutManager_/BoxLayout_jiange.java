package LayoutManager_;

import javax.swing.*;
import java.awt.*;

/*
    public static Component createHorizontalGlue()
        创建一个横向 glue 组件。

    public static Component createVerticalGlue()
        创建一个纵向 glue 组件。

    public static Component createHorizontalStrut(int width)
        创建一个不可见的、固定宽度的组件。

    public static Component createVerticalStrut(int height)
        创建一个不可见的、固定高度的组件。
 */
public class BoxLayout_jiange {
    public static void main(String[] args) {
        Frame frame = new Frame("BoxLayout_间隔测试");

        //创建水平Box
        Box hbox = Box.createHorizontalBox();

        //在Box中添加按钮，且按钮之间还需要添加水平间隔
        hbox.add(new Button("水平按钮一"));
        hbox.add(Box.createHorizontalGlue());//该分割在两个方向上都可以拉伸
        hbox.add(new Button("水平按钮二"));
        hbox.add(Box.createHorizontalStrut(20));//指定宽度的分割
        hbox.add(new Button("水平按钮三"));

        //创建垂直Box
        Box vbox = Box.createVerticalBox();

        //在Box中添加按钮，且按钮之间还需要添加垂直间隔
        vbox.add(new Button("垂直按钮一"));
        vbox.add(Box.createVerticalGlue());//该分割在两个方向上都可以拉伸
        vbox.add(new Button("垂直按钮二"));
        vbox.add(Box.createVerticalStrut(20));//指定高度的分割
        vbox.add(new Button("垂直按钮三"));

        //将两个容器添加到frame中
        frame.add(hbox, BorderLayout.NORTH);
        frame.add(vbox);

        frame.pack();
        frame.setVisible(true);
    }
}
