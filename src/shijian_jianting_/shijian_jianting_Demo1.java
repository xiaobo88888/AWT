package shijian_jianting_;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    public void setText(String t)
        将此文本组件显示的文本设置为指定文本。
 */
public class shijian_jianting_Demo1 {
    public static Frame frame = new Frame("事件处理机制测试");

    public static TextField tf = new TextField(30);
    private void ceshi(){

        //事件源
        Button b = new Button("开始");

        //注册监听
//        MyListener myListener = new MyListener();
        //匿名内部类
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("Hello World");
            }
        });


        frame.add(tf, BorderLayout.NORTH);
        frame.add(b);

        frame.pack();
        frame.setVisible(true);
    }

    //事件监听器
//    private class MyListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            tf.setText("Hello World");
//        }
//    }
    public static void main(String[] args) {
        new shijian_jianting_Demo1().ceshi();//创建了一个本类对象，然后调用它的ceshi()方法
    }
}
