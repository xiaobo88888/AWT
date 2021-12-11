package ImageIO_;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
    MouseAdapter:
         void mouseExited(MouseEvent e)
            鼠标离开组件时调用。
 */

public class Demo_game {
    //使用swing提供的JFrame，使用缓冲，可以解决闪屏问题
//    Frame frame = new Frame("五子棋");
    JFrame frame = new JFrame("五子棋");

    //声明四个BufferedImage，纪录四张图片
    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    BufferedImage selected;

    //定义棋盘高度和宽度
    private final int TABLE_WIDTH = 672;
    private final int TABLE_HEIGHT = 672;

    //定义棋盘横向和纵向最多下多少个棋子
    private final int BALL_SIZE = 15;

    //定义棋子在X和Y方向的偏移量
    private final int X_OFFSET = 10;
    private final int Y_OFFSET = 10;

    //定义每个棋子占用棋盘的比率
    private final int RATE = TABLE_WIDTH / BALL_SIZE;

    //定义二维数组，纪录每个点，[i][j]为0，则没有棋子，为1，则为白子，为2，则为黑子
    private int[][] board = new int[BALL_SIZE][BALL_SIZE];

    //声明红色选择框的坐标  其实就是二维数组board的索引
    private int selected_X = -1;
    private int selected_Y = -1;

    //判断游戏是否结束
    private boolean isOver = false;

    //用于判断是否连成五子了
    private int isFive = 0;


    //自定义类，继承Canvas类
//    private class chessBored extends Canvas
    //继承自JPanel，也是解决缓存问题
    private class chessBored extends JPanel{
        @Override
        public void paint(Graphics g) {
            if(isOver){
                //游戏结束了
                g.fillRect(0, 0, TABLE_WIDTH, TABLE_HEIGHT);
                g.setColor(Color.RED);
                g.setFont(new Font("楷体", Font.BOLD, 50));
                g.drawString("游戏结束！！", 100, 100);

            }else {
                //游戏继续

                //绘制棋盘
                g.drawImage(table, 0, 0, null);

                //绘制选择框
                if (selected_X >= 0 && selected_Y >= 0) {
                    g.drawImage(selected, selected_X* RATE + X_OFFSET, selected_Y * RATE + Y_OFFSET, null);
                }

                //绘制棋子
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {

                        //绘制黑棋
                        if (board[i][j] == 2) {
                            g.drawImage(black, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                        }

                        //绘制白棋
                        if (board[i][j] == 1) {
                            g.drawImage(white, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
                        }
                    }
                }
            }
        }
    }
    chessBored drawArea = new chessBored();

    //声明变量，纪录当前下棋的颜色(黑/白)
    private int boardColor = 0;

    //定义顶部要用到的组件
    Panel panel = new Panel();
    Button blackButton = new Button("黑棋");
    Button whiteButton = new Button("白棋");
    Button deleteButton = new Button("删除");


    public void setChessColor(Color whiteColor, Color blackColor, Color deleteColor){
        whiteButton.setBackground(whiteColor);
        blackButton.setBackground(blackColor);
        deleteButton.setBackground(deleteColor);
    }
    //组装视图，编写逻辑
    private void demo() throws IOException {
        //组装按钮

        //为三个按钮组测监听
        //黑棋按钮
        blackButton.addActionListener(e -> {
            //修改棋子标志
            boardColor = 2;
            //改变按钮颜色
            setChessColor(Color.GRAY, Color.GREEN, Color.GRAY);
        });
        //白棋按钮
        whiteButton.addActionListener(e -> {
            //修改棋子标志
            boardColor = 1;
            //改变按钮颜色
            setChessColor(Color.GREEN, Color.GRAY, Color.GRAY);
        });
        //删除按钮
        deleteButton.addActionListener(e -> {
            //修改棋子标志
            boardColor = 0;
            //改变按钮颜色
            setChessColor(Color.GRAY, Color.GRAY, Color.GREEN);
        });

        panel.add(blackButton);
        panel.add(whiteButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.SOUTH);

        //组装棋盘

        //初始化图片
        table = ImageIO.read(new File("E:\\Projects_IDEA\\AWT\\Img\\table.png"));
        black = ImageIO.read(new File("E:\\Projects_IDEA\\AWT\\Img\\black.png"));
        white = ImageIO.read(new File("E:\\Projects_IDEA\\AWT\\Img\\white.png"));
        selected = ImageIO.read(new File("E:\\Projects_IDEA\\AWT\\Img\\selected.png"));


        //监听鼠标移动
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            //当鼠标移动时调用该方法
            @Override
            public void mouseMoved(MouseEvent e) {

                //确保红色选择框是出现在下子的位置，而不是跟随鼠标
                selected_X = (e.getX() - X_OFFSET) / RATE;//因为是int型，所以一些小差别就省略了
                selected_Y = (e.getY() - Y_OFFSET) / RATE;


                //重绘界面
                drawArea.repaint();
            }

        });

        //监听鼠标点击
        drawArea.addMouseListener(new MouseAdapter() {
            //当鼠标点击时调用该方法
            @Override
            public void mouseClicked(MouseEvent e) {
                //确保棋子是下在下子的地方，而不是跟随鼠标
                int xPos = (e.getX() - X_OFFSET) / RATE;

                int yPos = (e.getY() - Y_OFFSET) / RATE;

                //在该点处下子
                board[xPos][yPos] = boardColor;

                //判断是否游戏结束
                if(boardColor != 0) {//如果点的是删除，则不需要去判断是否游戏结束
                    isOver = Over(xPos, yPos);
                }

                //重绘界面
                drawArea.repaint();
            }

            //鼠标离开组件时调用
            @Override
            public void mouseExited(MouseEvent e) {
                //鼠标离开组件时不再显示红色选择框
                selected_X = -1;
                selected_Y = -1;

                //重绘界面
                drawArea.repaint();
            }


        });

        //设置棋盘大小
        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        frame.add(drawArea);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);

        //为窗口添加窗口关闭监听器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private boolean Over(int xPos, int yPos){
        //下子时就判断是否游戏结束
        //因为我既然下子了，那么说明我之前下的子不需要去判断有没有连成五子，只需要对我下的子的位置去判断是否在四个方向上连成五子

        //先判断落子的位置距离边界的距离
        //先判断行
        isFive = 0;
        for(int i = 0; i < 10; i++){
            if(xPos - 5 + i >= 0 && xPos - 5 + i < 15){
                if(board[xPos - 5 + i][yPos] == boardColor){
                    isFive++;
                }else{
                    isFive = 0;
                }
            }
            if(isFive == 5){
                return true;
            }
        }

        isFive = 0;

        //再判断列
        for (int i = 0; i < 10; i++) {
            if(yPos - 5 + i >= 0 && yPos - 5 + i < 15){
                if(board[xPos][yPos - 5 + i] == boardColor){
                    isFive++;
                }else{
                    isFive = 0;
                }
            }
            if(isFive == 5){
                return true;
            }
        }

        isFive = 0;

        //判断主对角线
        for(int i = 0; i < 10; i++){
            if(xPos - 5 + i >= 0 && xPos - 5 + i < 15 && yPos - 5 + i >= 0 && yPos - 5 + i < 15){
                if(board[xPos - 5 + i][yPos - 5 + i] == boardColor){
                    isFive++;
                }else {
                    isFive = 0;
                }
            }
            if(isFive == 5){
                return true;
            }
        }

        isFive = 0;

        //判断副对角线
        for (int i = 0; i < 10; i++) {
            if(xPos - 5 + i >= 0 && xPos - 5 + i < 15 && yPos + 5 - i < 15 && yPos + 5 - i >= 0){
                if(board[xPos - 5 + i][yPos + 5 - i] == boardColor){
                    isFive++;
                }else{
                    isFive = 0;
                }
            }
            if(isFive == 5){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) throws IOException {
        new Demo_game().demo();
    }
}
