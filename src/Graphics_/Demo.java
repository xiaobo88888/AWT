package Graphics_;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Graphics:
        abstract  void setColor(Color c)
          将此图形上下文的当前颜色设置为指定颜色。


    Color 类用于封装默认 sRGB 颜色空间中的颜色，或者用于封装由 ColorSpace 标识的任意颜色空间中的颜色。
 */
public class Demo {
    //创建两个代表矩形和椭圆的常量
    private final String RECT_SHAPE = "绘制矩形";
    private final String OVEL_SHAPE = "绘制椭圆";

    //创建窗口
    Frame frame = new Frame("Graphics画图测试");

    //创建按钮
    Button btnRect = new Button("绘制矩形");
    Button btnOvel = new Button("绘制椭圆");

    //定义一个变量，用于确定绘制矩形还是椭圆
    private String shape = "";

    //自定义类，继承Canvas类，重写paint(Graphics g)方法完成画图
    private class myCanvas extends Canvas{

        @Override
        public void paint(Graphics g) {
            if(shape.equals(RECT_SHAPE)){
                //绘制矩形
                g.setColor(Color.BLACK);//将画笔设置为黑色
                g.drawRect(50, 50, 300, 200);//这里的坐标是相对于画布的位置的
            }
            if(shape.equals(OVEL_SHAPE)){
                //绘制椭圆
                g.setColor(Color.RED);//将画笔设置为红色
                g.drawOval(50, 50, 300, 200);//这里的坐标是相对于画布的位置的
            }
        }
    }

    //创建自定义的画布对象
    myCanvas drawArea = new myCanvas();

    //组装视图
    public void demo(){
        //给按钮添加事件监听
        btnRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改shape的值
                shape = RECT_SHAPE;
                drawArea.repaint();//组件第一次展示的时候会调用paint方法，如果没有调用repaint()，则不会绘制出图形
            }
        });

        btnOvel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改shape的值
                shape = OVEL_SHAPE;
                drawArea.repaint();//组件第一次展示的时候会调用paint方法，如果没有调用repaint()，则不会绘制出图形
            }
        });

        //创建Panel，承载两个按钮
        Panel p = new Panel();
        p.add(btnRect);
        p.add(btnOvel);

        //将Panel添加到frame窗口去
        frame.add(p, BorderLayout.SOUTH);

        //设置画布大小
        drawArea.setPreferredSize(new Dimension(400, 500));

        //将画布放到frame窗口的中间区域
        frame.add(drawArea);

        //设置frame大小及可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo().demo();
    }
}
