package Graphics_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
    Timer:提供对计时器 MBean 的实现。
         void start()
            启动计时器。
         public Timer(int delay, ActionListener listener);
            delay:多少毫秒启动一次
            listener:事件监听


    Font 类表示字体，可以使用它以可见方式呈现文本。
    public Font(String name,int style, int size)
        根据指定名称、样式和磅值大小，创建一个新 Font。
        protected  String name
            Font 的逻辑名称，它被传递到构造方法中。
            如"宋体"， "仿宋体"， "楷体"...
        protected int style
            Font 的样式，它被传递到构造方法中。此样式可以为 PLAIN、BOLD、ITALIC 或 BOLD+ITALIC。
            static int PLAIN  普通样式常量。
            static int BOLD  粗体样式常量。
            static int ITALIC  斜体样式常量。

        protected  int size
            Font 的磅值大小，舍入为整数。


     Graphics:
        abstract  void drawString(String str, int x, int y)
            使用此图形上下文的当前字体和颜色绘制由指定 string 给定的文本。

        abstract  void fillOval(int x, int y, int width, int height)
            使用当前颜色填充外接指定矩形框的椭圆。

        abstract  void fillRect(int x, int y, int width, int height)
            填充指定的矩形


     KeyEvent:表示组件中发生键击的事件。
        int getKeyCode()
            返回与此事件中的键关联的整数 keyCode。——返回按下的键的键值
            static int VK_LEFT  用于非数字键盘向左方向键的常量。
            static int VK_RIGHT 用于数字键盘向右方向键的常量。
 */
public class Demo_youxi {
    //创建窗口
    Frame frame = new Frame("弹球小游戏");

    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;

    //球拍宽度
    private final int RACKET_WIDTH = 60;
    //球拍高度
    private final int RACKET_HEIGHT = 20;

    //小球大小
    private final int BALL_SIZE = 16;

    //定义变量，纪录小球的位置
    private int ballX = TABLE_WIDTH / 2;
    private int ballY = 10;

    //定义变量，纪录小球在x和y方向上分别移动的速度
    private int ballSpeedX = 10;
    private int ballSpeedY = 10;

    //定义变量纪录球拍的移动速度
    private int racketSpeed = 10;

    //定义变量，纪录球拍的坐标
    private int racketX = TABLE_WIDTH / 2 - RACKET_WIDTH / 2;
    private final int racketY = 340;//球拍只能在一条平行于x轴的线上移动，所以y不能动

    //定义变量，纪录当前游戏是否结束
    private boolean isOver = false;

    //定义一个计时器
    private Timer timer;

    //自定义一个类，充当画布
    private class myCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //在这里绘制内容

            if(isOver){
                //游戏结束
                g.setColor(Color.BLUE);//设置字体颜色
                g.setFont(new Font("楷体", Font.BOLD + Font.ITALIC, 30));//设置字体
                g.drawString("游戏结束！！", 60, TABLE_HEIGHT / 2);//设置字体的位置和样式

            }else{
                //游戏中

                //绘制小球
                g.setColor(Color.RED);//设置画笔为红色
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

                //绘制球拍
                g.setColor(Color.pink);//设置画笔为粉色
                g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);

            }
        }
    }

    //创建画布对象，定义绘制区域
    myCanvas drawArea = new myCanvas();

    //组装视图以及游戏逻辑的控制
    public void demo(){
        //球拍变化
        KeyListener listener = new KeyAdapter() {//适配器
            @Override
            public void keyPressed(KeyEvent e) {
                //先获取按下的键
                int code = e.getKeyCode();

                //左移
                if(code == KeyEvent.VK_LEFT){
                    //左边没到桌面边框才能移动
                    if(racketX >= 0){
                        racketX -= racketSpeed;
                    }
                }

                //右移
                if(code == KeyEvent.VK_RIGHT){
                    //右边没到桌面边框才能移动
                    if(racketX + RACKET_WIDTH <= TABLE_WIDTH){
                        racketX += racketSpeed;
                    }
                }
            }
        };

        //给frame和drawArea注册监听器
        drawArea.addKeyListener(listener);
        frame.addKeyListener(listener);

        //小球坐标的控制
        ActionListener task = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据边界范围修正速度

                //如果到达左边边框或者右边边框
                if(ballX <= 0 || (ballX + BALL_SIZE) >= TABLE_WIDTH){
                    //则速度相反
                    ballSpeedX = -ballSpeedX;
                }

                //如果小球被球拍接到了或者小球到达上边边框
                if(ballY <= 0 || ((ballX >= racketX && ballX <= (racketX + RACKET_WIDTH)) && (ballY + BALL_SIZE) >= racketY)){
                    //则速度相反
                    ballSpeedY = -ballSpeedY;
                }

                //如果小球没有被球拍接到
                if((ballY + BALL_SIZE) > racketY && (ballX < racketX || ballX > (racketX + RACKET_WIDTH))){
                    //先暂停计时器
                    timer.stop();
                    //然后将游戏是否结束的状态变为true
                    isOver = true;
                    //然后重绘界面
                    drawArea.repaint();
                }

                //更新小球坐标，重绘界面
                ballX += ballSpeedX;
                ballY += ballSpeedY;
                drawArea.repaint();
            }
        };
        timer = new Timer(100, task);
        timer.start();

        //设置画布的大小
        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        //将画布添加到frame中
        frame.add(drawArea);

        //给frame设置最佳大小且可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Demo_youxi().demo();
    }
}
