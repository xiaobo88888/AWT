package Dialog_;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    public Dialog(Frame owner, String title, boolean modal)
        构造一个最初不可见的 Dialog，它带有指定的所有者 Frame、标题和模式。
        owner - dialog 的所有者，如果此 dialog 没有所有者，则该参数为 null
        title - dialog 的标题，如果此 dialog 没有标题，则该参数为 null
        modal - 指定在显示的时候是否阻止用户将内容输入到其他顶级窗口中。
        如果该参数为 false，则 dialog 是 MODELESS；如果该参数为 true，则模式类型属性被设置为 DEFAULT_MODALITY_TYPE

 */
public class Dialog_Demo1 {
    public static void main(String[] args) {
        //父窗口
        Frame frame = new Frame("Dialog测试");

        //创建两个Dialog对象，一个是模式的，一个是非模式的
        Dialog dialog1 = new Dialog(frame, "模式对话框", true);
        Dialog dialog2 = new Dialog(frame, "非模式对话框", false);

        //通过setBounds方法设置Dialog的位置和大小
        dialog1.setBounds(30, 30, 300, 300);
        dialog2.setBounds(30, 30, 300, 300);

        //创建两个按钮
        Button b1 = new Button("模式对话框");
        Button b2 = new Button("非模式对话框");

        //给这两个按钮添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog1.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog2.setVisible(true);
            }
        });
        //把按钮添加到frame中
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
