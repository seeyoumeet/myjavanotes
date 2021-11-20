package com.seeyoumeet.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @Classname customComponent
 * @Description ：...
 * @Date ：2021-08-19
 * @Created by seeyoumeet
 */
public class customComponent {

    public static void main(String[] args) {
        /*
         * 在 AWT 的事件队列线程中创建窗口和组件, 确保线程安全,
         * 即 组件创建、绘制、事件响应 需要处于同一线程。
         */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 创建窗口对象
                MyFrame frame = new MyFrame();
                // 显示窗口
                frame.setVisible(true);
            }
        });
    }

    /**
     * 窗口
     */
    public static class MyFrame extends JFrame {

        public static final String TITLE = "Java图形绘制";

        public static final int WIDTH = 250;
        public static final int HEIGHT = 300;

        public MyFrame() {
            super();
            initFrame();
        }

        private void initFrame() {
            // 设置 窗口标题 和 窗口大小
            setTitle(TITLE);
            setSize(WIDTH, HEIGHT);

            // 设置窗口关闭按钮的默认操作(点击关闭时退出进程)
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // 把窗口位置设置到屏幕的中心
            setLocationRelativeTo(null);

            // 设置窗口的内容面板
            MyPanel panel = new MyPanel(this);
            setContentPane(panel);
        }

    }

    /**
     * 内容面板
     */
    public static class MyPanel extends JPanel {

        private MyFrame frame;

        public MyPanel(MyFrame frame) {
            super();
            this.frame = frame;
        }

        /**
         * 绘制面板的内容: 创建 JPanel 后会调用一次该方法绘制内容,
         * 之后如果数据改变需要重新绘制, 可调用 updateUI() 方法触发
         * 系统再次调用该方法绘制更新 JPanel 的内容。
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
             drawImage(g);
        }

        private void drawImage(Graphics g) {
            frame.setTitle("5. 图片");
            Graphics2D g2d = (Graphics2D) g.create();

            // 从本地读取一张图片
            String filepath = "demo.jpg";
            Image image = Toolkit.getDefaultToolkit().getImage(
                    getClass().getClassLoader().getResource( "loading.gif"));

            // 绘制图片（如果宽高传的不是图片原本的宽高, 则图片将会适当缩放绘制）
            g2d.drawImage(image, 50, 50, image.getWidth(this), image.getHeight(this), this);

            g2d.dispose();
        }
    }
}
