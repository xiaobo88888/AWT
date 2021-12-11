package Dialog_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog_Demo2 {
    public static void main(String[] args) {
        //父窗口
        Frame frame = new Frame("Dialog测试");

        //创建一个Dialog对象，一个是模式的
        Dialog dialog1 = new Dialog(frame, "模式对话框", true);

        //往Dialog中添加内容
        //创建垂直Box容器，在里面存放文本框和按钮
        Box box = Box.createVerticalBox();
        TextField tf = new TextField(20);
        Button button = new Button("确定");
        box.add(tf);
        box.add(button);
        dialog1.add(box);

        //通过setBounds方法设置Dialog的位置和大小
        dialog1.setBounds(30, 30, 300, 300);

        //创建一个按钮
        Button b1 = new Button("模式对话框");

        //给这一个按钮添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog1.setVisible(true);
            }
        });

        //把按钮添加到frame中
        frame.add(b1, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }
}
