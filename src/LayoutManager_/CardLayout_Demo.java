package LayoutManager_;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    public Component add(String name, Component comp)
        将指定组件添加到此容器中

    public String getActionCommand()
        返回与此动作相关的命令字符串


    public void first(Container parent)
        翻转到容器的第一张卡片。

    public void last(Container parent)
        翻转到容器的最后一张卡片。

    public void next(Container parent)
        翻转到指定容器的下一张卡片。如果当前的可见卡片是最后一个，则此方法翻转到布局的第一张卡片

    public void previous(Container parent)
        翻转到指定容器的前一张卡片。如果当前的可见卡片是第一个，则此方法翻转到布局的最后一张卡片。

    public void show(Container parent, String name)
        翻转到使用 addLayoutComponent 添加到此布局的具有指定 name 的组件。如果不存在这样的组件，则不发生任何操作。


    public void addActionListener(ActionListener l)
        添加指定的动作侦听器，以接收发自此按钮的动作事件。当用户在此按钮上按下或释放鼠标时，发生动作事件。
 */
public class CardLayout_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("CardLayout测试");

        //创建Panel对象，用来存储多张卡片
        Panel p1 = new Panel();

        //创建CardLayout布局管理器，并设置给Panel
        CardLayout cl = new CardLayout(5, 5);
        p1.setLayout(cl);

        //往Panel中存储多个组件
        String[] names = {"第一张", "第二张", "第三张", "第四张", "第五张"};
        for (int i = 0; i < names.length; i++) {
            p1.add(names[i], new Button(names[i]));//给按钮指定的名字
        }

        //把Panel放入frame中间区域
//        frame.add(p1, BorderLayout.CENTER);
        frame.add(p1);//如果不指定则默认中间区域


        //创建另外一个Panel，用于存放按钮组件
        Panel p2 = new Panel();

        //创建五个按钮组件
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第四张");


        //创建一个事件监听器，监听按钮的点击动作
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //public String getActionCommand()返回与此动作相关的命令字符串，获取组件上的字，不是组件的名字
                String actionCommand = e.getActionCommand();//现在会返回按钮上的文字
                switch (actionCommand){
                    case "上一张":
                        cl.previous(p1);
                        break;
                    case "下一张":
                        cl.next(p1);
                        break;
                    case "第一张":
                        cl.first(p1);
                        break;
                    case "最后一张":
                        cl.last(p1);
                        break;
                    case "第四张":
                        cl.show(p1, names[3]);
                        break;
                }
            }
        };

        //把当前的事件监听器和多个按钮绑定到一起
        //public void addActionListener(ActionListener l)
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);


        //把按钮添加到Panel中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);


        //把Panel添加到frame南部区域
        frame.add(p2, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
