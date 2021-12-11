package caidan_zujian;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/*
    Menu 对象是从菜单栏部署的下拉式菜单组件。
        Menu(String label)
          构造具有指定标签的新菜单。

        public MenuItem add(MenuItem mi)
            将指定的菜单项添加到此菜单。如果该菜单项为另一个菜单的一部分，则从该菜单移除它。

        public void add(String label)
            将有指定标签的项添加到此菜单。



    MenuBar 类封装绑定到框架的菜单栏的平台概念。为了将该菜单栏与 Frame 对象关联，可以调用该框架的 setMenuBar 方法。
        MenuBar()
          创建新的菜单栏。


    MenuItem:菜单中的所有项必须属于类 MenuItem 或其子类之一。
        MenuItem(String label)
          构造具有指定的标签且没有键盘快捷方式的新菜单项。

        MenuItem(String label, MenuShortcut s)
          创建具有关联的键盘快捷方式的菜单项。


    MenuShortcut:表示 MenuItem 键盘加速器的 MenuShortcut 类。
        MenuShortcut(int key, boolean useShiftModifier)
          为指定的虚拟键代码构造一个新的菜单快捷方式。
          key - 此菜单快捷方式的原键代码，如果按下此键，它将在 KeyEvent 的键代码字段中返回。
          useShiftModifier - 指示按下 SHIFT 键是否调用此菜单快捷方式。


    KeyEvent:表示组件中发生键击的事件。
        public static final int VK_Q:键盘上的Q键


    TextArea:
        public void append(String str)
            将给定文本追加到文本区的当前文本。


    ActionEvent:
        public String getActionCommand()
            返回与此动作相关的命令字符串。


    Frame:
        public void setMenuBar(MenuBar mb)
            将此窗体的菜单栏设置为指定的菜单栏。

 */
public class Demo_Menu_MenuBar {
    //创建窗口
    Frame frame = new Frame("菜单组件测试");

    //创建菜单条
    MenuBar menuBar = new MenuBar();

    //创建菜单组件
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu = new Menu("格式");

    //菜单项组件
    MenuItem auto = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");

    MenuItem comment = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_Q, true));
    MenuItem cancel = new MenuItem("取消注释");

    //创建文本域
    TextArea ta = new TextArea(6, 40);



    //组件菜单
    public void demo(){
        //从内到外组装

        //给注释菜单项添加事件监听
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //如果点击的了注释，则在文本框内展示
                ta.append("您点击了菜单项" + e.getActionCommand() + "\n");
            }
        });

        //给取消注释菜单项添加事件监听
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("您点击了菜单项" + e.getActionCommand() + "\n");
            }
        });


        //将注释和取消注释添加到菜单”格式“里
        formatMenu.add(comment);
        formatMenu.add(cancel);

        //将自动换行，复制，粘贴，格式菜单项添加到菜单”编辑“里
        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);

        //将文件和编辑菜单放入菜单条
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //将菜单条和多行文本框放入窗口中
        frame.setMenuBar(menuBar);
        frame.add(ta);

        //设置frame最佳大小并显示
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo_Menu_MenuBar().demo();
    }
}
