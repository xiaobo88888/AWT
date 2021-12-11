package caidan_zujian;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
    PopupMenu:此类实现能够在组件中的指定位置上动态弹出的菜单
        public void show(Component origin, int x, int y)
            在相对于初始组件的 x、y 位置上显示弹出式菜单。
            origin - 定义坐标空间的组件——PopupMenu要显示在哪个组件之上
            x - 弹出菜单的 x 坐标位置
            y - 弹出菜单的 y 坐标位置

    MouseEvent:指示组件中发生鼠标动作的事件。
        public boolean isPopupTrigger()
            返回此鼠标事件是否为该平台的弹出菜单触发事件。

        public int getX()
            返回事件相对于源组件的水平 x 坐标。

        public int getY()
            返回事件相对于源组件的垂直 y 坐标。


    Component:
        void setPreferredSize(Dimension preferredSize)
          将组件的首选大小设置为常量值。

    Dimension 类封装单个对象中组件的宽度和高度（精确到整数）。
        Dimension(int width, int height)
          构造一个 Dimension，并将其初始化为指定宽度和高度
 */
public class Demo_PopupMenu {
    //创建窗口
    Frame frame = new Frame("右击弹出测试");

    //创建文本域
    TextArea ta = new TextArea("我爱中国！！！", 6, 40);

    //创建Panel
    Panel p = new Panel();

    //创建PopupMenu
    PopupMenu popupMenu = new PopupMenu();

    //创建菜单项
    MenuItem comment = new MenuItem("注释");
    MenuItem cancelcomment = new MenuItem("取消注释");
    MenuItem copy = new MenuItem("复制");
    MenuItem save = new MenuItem("保存");

    //组装组件
    public void demo(){
        //组装事件监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                ta.append("您点击了" + command + "\n");
            }
        };

        //注册监听
        comment.addActionListener(listener);
        cancelcomment.addActionListener(listener);
        copy.addActionListener(listener);
        save.addActionListener(listener);

        //将菜单项组装到PopupMenu中
        popupMenu.add(comment);
        popupMenu.add(cancelcomment);
        popupMenu.add(copy);
        popupMenu.add(save);

        //将PopupMenu组装到Panel中
        p.add(popupMenu);

        //设置Panel的大小
        p.setPreferredSize(new Dimension(500, 300));

        //给Panel添加鼠标点击监听器，监听鼠标释放
        p.addMouseListener(new MouseAdapter() {//适配器，就可以不要重写全部方法了
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()){
                    popupMenu.show(p, e.getX(), e.getY());
                }
            }
        });

        //将Panel和TextArea组装到Frame中
        frame.add(ta);
        frame.add(p, BorderLayout.SOUTH);

        //调整frame大小并显示
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Demo_PopupMenu().demo();
    }
}
