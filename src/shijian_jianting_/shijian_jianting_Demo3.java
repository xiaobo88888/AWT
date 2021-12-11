package shijian_jianting_;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
    WindowListener:用于接收窗口事件的侦听器接口

    WindowAdapter:适配器，不需要重写WindowListener的所有方法，像重写哪个就重写哪个
 */

public class shijian_jianting_Demo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("事件监听其测试2");
        frame.setBounds(300, 300, 500, 500);

        //设置WindowListener，监听窗口级事件，如果用户点击X，则关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            //如果是new WindowListener，需要写很多方法，但使用new WindowAdapter像重写哪个就重写哪个
            @Override
            public void windowClosing(WindowEvent e) {//选择重写windowClosing方法
                //停止当前程序
                System.exit(0);
            }
        });


        frame.setVisible(true);
    }
}
