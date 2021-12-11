package Container_;

import java.awt.*;

/*
    public Component add(Component comp)
        将指定组件追加到此容器的尾部

    TextField 对象是允许编辑单行文本的文本组件。
        public TextField(String text) throws HeadlessException
            构造使用指定文本初始化的新文本字段。

    Button 此类创建一个标签按钮。当按下该按钮时，应用程序能执行某项动作
        public Button(String label) throws HeadlessException
            构造一个带指定标签的按钮
*/
public class PanelDemo {
    public static void main(String[] args) {
        //创建Window对象
        Frame frame = new Frame("Panel测试");

        //创建Panel对象
        Panel panel = new Panel();

        //设置一个文本框和一个按钮，并把它们放入Panel容器中
        panel.add(new TextField("这是一个测试文本框"));
        panel.add(new Button("这是一 个测试按钮"));

        //把Panel放入Window中
        frame.add(panel);

        //设置Window的位置及大小
        frame.setLocation(300, 300);
        frame.setSize(500, 500);

        //设置Window可见
        frame.setVisible(true);
    }
}
