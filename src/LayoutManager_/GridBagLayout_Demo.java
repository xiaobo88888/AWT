package LayoutManager_;

import java.awt.*;

/*
    public int fill
        当组件的显示区域大于它所请求的显示区域的大小时使用此字段。
        它可以确定是否调整组件大小，以及在需要的时候如何进行调整。

        以下值适用于 fill：
            NONE：不调整组件大小。
            HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
            VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
            BOTH：使组件完全填满其显示区域。
        默认值为 NONE。


    public static final int BOTH
        在水平方向和垂直方向上同时调整组件大小。

    public double weightx
        指定如何分布额外的水平空间。
        这个就是如果调整窗口大小，那么组件会按照几倍于网格的大小扩大

    public double weighty
        指定如何分布额外的垂直空间。
        这个就是如果调整窗口大小，那么组件会按照几倍于网格的大小扩大

    public int gridwidth
        指定组件显示区域的某一行中的单元格数
        使用 REMAINDER 指定组件的显示区域，该区域的范围是从 gridx 到该行的最后一个单元格。——表示该换行了
        使用 RELATIVE 指定组件的显示区域，该区域的范围是从 gridx 到它所在行的倒数第二个单元格。

    public int gridheight
        指定在组件显示区域的一列中的单元格数。
        使用 REMAINDER 指定组件的显示区域，该区域的范围是从 gridy 到该列的最后一个单元格。——表示该换列了
        使用 RELATIVE 指定组件的显示区域，该区域的范围是从 gridy 到它所在列的倒数第二个单元格。

    public static final int REMAINDER
        指定此组件是其行或列中的最后一个组件。

    public double weighty
        指定如何分布额外的垂直空间。

    public void setConstraints(Component comp, GridBagConstraints constraints)
        设置此布局中指定组件的约束条件。
 */
public class GridBagLayout_Demo {
    public static void main(String[] args) {
        Frame frame = new Frame("GridBagLayout测试");

        //创建GridBagLayout对象
        GridBagLayout gbl = new GridBagLayout();

        //将frame的布局管理器设置为GridBagLayout
        frame.setLayout(gbl);

        //创建GridBagConstraints对象
        GridBagConstraints gbc = new GridBagConstraints();

        //创建容量为10的Button数组
        Button[] buttons = new Button[10];

        //初始化每个Button
        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new Button("按钮" + i);
        }

        //将所有的GridBagConstraints对象的fill属性设置为BOTH，当有空白区域时，组件自动扩大占满空白区域
        //这是为了将组建扩大占满分配的区域
        gbc.fill = GridBagConstraints.BOTH;

        //设置GridBagConstraints对象的weightx为1，表示横向扩展比例为1
        gbc.weightx = 1;

        //往frame添加三个组件
        addComponent(frame, buttons[0], gbl, gbc);
        addComponent(frame, buttons[1], gbl, gbc);
        addComponent(frame, buttons[2], gbl, gbc);

        //将GridBagConstraints对象的gridwidth设置为REMAINDER，表明该区域的范围是从 gridx 到该行的最后一个单元格
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //将第四个按钮添加到frame中
        addComponent(frame, buttons[3], gbl, gbc);

        //将GridBagConstraints对象的weighty设置为1，表示纵向扩展比例为1
        gbc.weighty = 1;

        //将第五个按钮存入frame中
        addComponent(frame, buttons[4], gbl, gbc);

        //将GridBagConstraints对象的gridwidth和gridheight设置为2，表示纵向和横向会占用两个网格
        gbc.gridwidth = 2;
        gbc.gridheight = 2;

        //将第六个按钮放入frame中
        addComponent(frame, buttons[5], gbl, gbc);

        //将GridBagConstraints对象的gridwidth和gridheight设置为1，表示纵向和横向会占用一个网格
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        //将第七按钮存入frame中
        addComponent(frame, buttons[6], gbl, gbc);

        //将GridBagConstraints对象的gridwidth设置为REMAINDER，表明该区域的范围是从 gridx 到该行的最后一个单元格
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //将第八个按钮存入frame中
        addComponent(frame, buttons[7], gbl, gbc);

        //将GridBagConstraints对象的gridwidth设置为1，表示纵向会占用一个网格
        gbc.gridwidth = 2;

        //将第九，十个按钮存入frame中
        addComponent(frame, buttons[8], gbl, gbc);
        addComponent(frame, buttons[9], gbl, gbc);

        frame.pack();
        frame.setVisible(true);
    }
    private static void addComponent(Container con, Component c,
                                     GridBagLayout gbl, GridBagConstraints gbc){
        gbl.setConstraints(c, gbc);
        con.add(c);
    }
}
