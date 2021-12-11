package Dialog_;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    FileDialog 类显示一个对话框窗口，用户可以从中选择文件。

    public FileDialog(Frame parent, String title, int mode)
        创建一个具有指定标题的文件对话框窗口，用于加载或保存文件。
        parent - 对话框的所有者
        title - 对话框的标题
        mode - 对话框的模式，可以是 FileDialog.LOAD 或 FileDialog.SAVE
            public static final int LOAD
                此常量值指示文件对话框窗口的作用是查找要读取的文件。
            public static final int SAVE
                此常量值指示文件对话框窗口的作用是查找要写入的文件。


        public String getDirectory()
            获取此文件对话框的目录

        public String getFile()
            获取此文件对话框的选定文件。

 */
public class FileDialog_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("FileDialog测试");

        //创建两个FileDialog对象
        FileDialog f1 = new FileDialog(frame, "选择要打开的文件", FileDialog.LOAD);
        FileDialog f2 = new FileDialog(frame, "选择要保存的文件", FileDialog.SAVE);

        //创建两个按钮
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        //给这两个按钮设置点击后的行为：获取打开或者保存的路径文件名
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);//选择完毕前，代码会阻塞到这里

                //获取选择的路径名和文件名
                System.out.println("打开的路径为" + f1.getDirectory());
                System.out.println("打开的名称为" + f1.getFile());
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);//选择完毕前，代码会阻塞到这里

                //获取选择的路径名和文件名
                System.out.println("保存的路径为" + f2.getDirectory());
                System.out.println("保存的名称为" + f2.getFile());
            }
        });

        //把按钮添加到frame中
        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);
    }
}
