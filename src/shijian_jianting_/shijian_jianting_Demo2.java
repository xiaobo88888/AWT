package shijian_jianting_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
    TextListener:用于接收文本事件的侦听器接口。

    public String getText()
        返回此文本组件表示的文本。默认情况下，此文本是一个空字符串。

    public Object getSource()
        最初发生 Event 的对象。


    ItemListener:接收项事件的侦听器接口。

    public Object getItem()
        返回受事件影响的项。


    ContainerListener:用于接收容器事件的侦听器接口

    public Component getChild()
        返回受事件影响的组件。
*/
public class shijian_jianting_Demo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("事件监听器测试");

        //创建组件——事件源
        TextField tf = new TextField(30);
        Choice choice = new Choice();
        choice.add("煤球");
        choice.add("刘博");
        choice.add("高辉");

        //给文本域添加TextListener，监听内容变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                Object text = e.getSource();//通过事件对象获取事件信息
                System.out.println("当前文本框的内容为：" + text);
            }
        });

        //给下拉选择框添加ItemListener，监听条目选项的变化
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();//通过事件对象获取事件信息
                System.out.println("当前所选条目为：" + item);
            }
        });

        //给frame注册ContainerListener监听器，监听容器中组件的添加
        frame.addContainerListener(new ContainerListener() {
            //监听组件添加
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();//通过事件对象获取事件信息
                System.out.println("frame中添加了" + child);
            }

            //监听组件移除
            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        //添加到frame中
        Box box =Box.createHorizontalBox();
        box.add(choice);
        box.add(tf);
        frame.add(box);//运行开头出现的代码是这里添加了box容器，被监听到了

        frame.pack();
        frame.setVisible(true);
    }
}
