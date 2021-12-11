import javax.swing.*;
import java.awt.*;

/*
    public TextArea(int rows, int columns)
         构造一个新文本区，该文本区具有指定的行数和列数，并将空字符串作为文本。

    public Choice()
       创建一个新的选择菜单。最初，此菜单中没有任何项。
       public void add(String item) 将一个项添加到此 Choice 菜单中。

    public CheckboxGroup()
        创建 CheckboxGroup 的一个新实例。

    public Checkbox(String label, CheckboxGroup group, boolean state)
         创建具有指定标签的 Checkbox，并使它处于指定复选框组内，将它设置为指定状态。

    public Checkbox(String label)
         使用指定标签创建一个复选框。此复选框的状态被设置为“关”，并且它不属于任何复选框组。

    public TextField(int columns)
          构造具有指定列数的新空文本字段

    public List(int rows, boolean multipleMode)
     创建一个初始化为显示指定行数的新滚动列表。注意，如果指定了零行，则会按默认的四行创建列表。
     还要注意，列表中的可视行数一旦创建就不能更改。
     如果 multipleMode 的值为 true，则用户可从列表中选择多项。如果为 false，则一次只能选择一项。
        public void add(String item)  向滚动列表的末尾添加指定的项。
 */
public class AWT_jibenzujian {
    //总体的窗口
    public static Frame frame = new Frame("基本组件测试");

    //多行文本域
    public static TextArea ta = new TextArea(5, 30);

    //下拉选择框
    public static Choice choice = new Choice();

    //复选框组
    public static CheckboxGroup cbg = new CheckboxGroup();
    //复选框
    public static Checkbox man = new Checkbox("男", cbg, true);
    public static Checkbox woman = new Checkbox("女", cbg, false);

    //复选框
    public static Checkbox hunyin = new Checkbox("是否保存");

    //单行文本框
    public static TextField tf = new TextField(50);
    //按钮
    public static Button b1 = new Button("事件发生地址");

    //列表框组件
    public static List list = new List(6, true);

    private static  void zuzhuang(){
        //先组装底部
        Box bottomBox = Box.createHorizontalBox();
        bottomBox.add(tf);//添加单行文本框
        bottomBox.add(Box.createHorizontalStrut(5));//添加宽度指定间隔
        bottomBox.add(b1);//添加按钮
        frame.add(bottomBox, BorderLayout.SOUTH);//将底部的Box添加到frame的南部区域

        //然后组装顶部

        //先组装顶部的左边

        //先组装顶部左边的下面
        Box box_left_bottom = Box.createHorizontalBox();
        //先给下拉选择框添加内容
        choice.add("星期一");
        choice.add("星期二");
        choice.add("星期三");
        choice.add("星期四");
        choice.add("星期五");
        choice.add("星期六");
        choice.add("星期日");
        box_left_bottom.add(choice);//添加下拉选择框
        box_left_bottom.add(man);
        box_left_bottom.add(woman);//添加复选框
        box_left_bottom.add(hunyin);//添加复选框

        //然后组装顶部左边——将顶部左边下方的Box添加进去
        Box topBox_left = Box.createVerticalBox();
        topBox_left.add(ta);//添加多行文本框
        topBox_left.add(box_left_bottom);//将顶部左边下方的Box添加进去

        //然后组装顶部——将顶部右边添加进去
        Box topBox = Box.createHorizontalBox();
        topBox.add(topBox_left);//先将顶部的左边添加进去
        //先给列表添加内容
        list.add("今天很不爽");
        list.add("今天还不错");
        list.add("今天一级棒");
        topBox.add(list);//然后添加顶部右边的列表框

        //然后将顶部放入frame的中部
        frame.add(topBox);


        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        zuzhuang();

    }
}
