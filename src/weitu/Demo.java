package weitu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/*
    BufferedImage 子类描述具有可访问图像数据缓冲区的 Image。
        public BufferedImage(int width,int height, int imageType)
            构造一个类型为预定义图像类型之一的 BufferedImage。
            width - 所创建图像的宽度
            height - 所创建图像的高度
            imageType - 所创建图像的类型

        static int TYPE_INT_RGB
            表示一个图像，它具有合成整数像素的 8 位 RGB 颜色分量。

        public Graphics getGraphics()
            此方法返回 Graphics2D，但此处是出于向后兼容性的考虑。——获取画笔


    Graphics:
        public abstract boolean drawImage(Image img,int x,int y,ImageObserver observer)
            img - 要绘制的指定图像。如果 img 为 null，则此方法不执行任何操作。
            x - x 坐标。
            y - y 坐标。
            observer - 转换了更多图像时要通知的对象。


    MouseMotionListener:用于接收组件上的鼠标移动事件的侦听器接口

 */
public class Demo {
    Frame frame = new Frame("手绘小程序");

    //定义画布的宽高
    private final int AREA_WIDTH = 400;
    private final int AREA_HEIGHT = 500;

    //定义弹出菜单
    private PopupMenu popupMenu = new PopupMenu();

    //定义弹出菜单的菜单项
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem blueItem = new MenuItem("蓝色");

    //定义变量，纪录当前画笔颜色
    private Color forceColor = Color.BLACK;

    //定义BufferedImage对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    //通过位图，获取关联的Graphics对象——获取画笔
    Graphics g = image.getGraphics();

    //定义画布，自定义一个类，继承Canvas类
    private class myCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //绘制image对象
            g.drawImage(image, 0, 0, null);
        }
    }
    myCanvas drawArea = new myCanvas();

    //定义变量，纪录鼠标拖动过程中，上一次的坐标
    private int preX = -1;
    private int preY = -1;

    //组装视图，逻辑控制
    public void demo(){
        //组装视图

        //设置事件监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                switch(command){
                    case "红色":
                        forceColor = Color.RED;
                        break;
                    case "绿色":
                        forceColor = Color.GREEN;
                        break;
                    case "蓝色":
                        forceColor = Color.BLUE;
                        break;
                }
            }
        };

        //给菜单项组测监听器
        redItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        blueItem.addActionListener(listener);

        //将菜单项添加到弹出菜单中
        popupMenu.add(redItem);
        popupMenu.add(greenItem);
        popupMenu.add(blueItem);

        //将弹出菜单项添加到画布上
        drawArea.add(popupMenu);

        //给画布添加监听器
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {//如果鼠标被抬起
                if(e.isPopupTrigger()){//鼠标是否是点击弹出菜单
                    popupMenu.show(drawArea, e.getX(), e.getY());//如果是，则在画布上的鼠标点击位置展示处菜单
                }

                //重置preX和preY (如果不重置的话，那么我画完一条线后再去画另一条线，那么这之间也会被画线)
                preX = -1;
                preY = -1;
            }
        });

        //设置位图背景为白色——默认是黑色的
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

        //给画布组测监听鼠标移动
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {//适配器
            @Override
            public void mouseDragged(MouseEvent e) {
                if(preX >= 0 && preY >= 0){
                    g.setColor(forceColor);//设置画笔颜色
                    //画线条需要两组坐标(两点连线)，getX()和getY()只能获取最后那个点的坐标
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }

                //修正preX和preY
                preX = e.getX();
                preY = e.getY();

                //重绘组件，画笔g是画在位图上的，所以得重绘到组件上
                drawArea.repaint();
            }
        });

        //设置画布大小
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));

        //讲画布组装到窗口上
        frame.add(drawArea);

        //设置窗口大小并可见
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Demo().demo();
    }
}
