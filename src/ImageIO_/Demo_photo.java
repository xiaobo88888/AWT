package ImageIO_;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
    FileDialog:
        String getDirectory()
            获取此文件对话框的目录。

        String getFile()
            获取此文件对话框的选定文件。


    ImageIO:该类包含一些用来查找 ImageReader 和 ImageWriter 以及执行简单编码和解码的静态便捷方法。
        static BufferedImage read(File input)
            返回一个 BufferedImage，作为使用 ImageReader（它是从当前已注册 ImageReader 中自动选择的）解码所提供 File 的结果。

        static BufferedImage read(InputStream input)
            返回一个 BufferedImage，作为使用 ImageReader（它是从当前已注册 ImageReader 中自动选择的）解码所提供 InputStream 的结果。

        static boolean write(RenderedImage im, String formatName, File output)
            使用支持给定格式的任意 ImageWriter 将一个图像写入 File
 */

public class Demo_photo {
    Frame frame = new Frame("图片编辑器");

    //定义菜单条，菜单，菜单项
    MenuBar menuBar = new MenuBar();
    Menu menu = new Menu("文件");
    MenuItem openItem = new MenuItem("打开");
    MenuItem saveItem = new MenuItem("另存为");

    //声明BufferedImage对象
    BufferedImage image;

    //自定义类继承Canvas类
    private class myCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }
    myCanvas drawArea = new myCanvas();

    //组装视图
    public void demo(){
        //给菜单项组测监听器

        openItem.addActionListener(e -> {
            //打开文件对话框
            FileDialog fileDialog = new FileDialog(frame, "打开图片", FileDialog.LOAD);
            fileDialog.setVisible(true);

            //获取用户选择的图片路径和名称
            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();

            try {
                image = ImageIO.read(new File(directory, file));
                //重绘
                drawArea.repaint();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        saveItem.addActionListener(e -> {
            //打开文件对话框
            FileDialog fileDialog = new FileDialog(frame, "保存图片", FileDialog.SAVE);
            fileDialog.setVisible(true);

            //获取用户选择的图片的路径和名称
            String directory = fileDialog.getDirectory();
            String file = fileDialog.getFile();

            try {
                ImageIO.write(image, "JPEG",new File(directory, file));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        menu.add(openItem);
        menu.add(saveItem);

        menuBar.add(menu);
        frame.setMenuBar(menuBar);

        frame.add(drawArea);

        //设置窗口大小与可见
        frame.setBounds(100, 100, 800, 700);
        frame.setVisible(true);

        //为窗口组测监听器，监听窗口关闭
        frame.addWindowListener(new WindowAdapter() {
            //如果点击X，则关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        new Demo_photo().demo();
    }
}
