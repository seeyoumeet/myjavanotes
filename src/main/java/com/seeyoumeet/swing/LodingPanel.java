package com.seeyoumeet.swing;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * @Classname LodingPanel
 * @Description ：...
 * @Date ：2021-08-18
 * @Created by seeyoumeet
 */
@Slf4j
public class LodingPanel extends JPanel {

    private static final long serialVersionUID = 1551571546L;

    private Timer timer;
    private int delay;
    private int startAngle = 0;
    private int arcAngle = 0;
    private int orientation;
    private double arcLength = 0;
    private int arcLengthDegree = 0;

    public static final int CLOCKWISE = 0;
    public static final int ANTICLOCKWISE = 1;

    public LodingPanel() {
        this.delay = 100;
        this.orientation = CLOCKWISE;
        init();
    }

    public LodingPanel(int delay) {
        this.delay = delay;
        this.orientation = CLOCKWISE;
        init();
    }

    public LodingPanel(int delay, int orientation) {
        this.delay = delay;
        this.orientation = orientation;
        init();
    }

    @Override
    public void show() {
        this.timer.start();
    }

    /**
     * @param orientation	set the direction of rotation
     *
     * @beaninfo
     *        enum: CLOCKWISE LodingPanel.CLOCKWISE
     *        		ANTICLOCKWISE LodingPanel.ANTICLOCKWISE
     */
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    private void init() {
        this.timer = new Timer(delay, new ReboundListener());
        setOpaque(false);   // 设置透明背景
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        drawImage(g);
        drawArc(g);
    }

    private void drawImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // 从本地读取一张图片
        String filepath = "demo.jpg";
        Image image = Toolkit.getDefaultToolkit().getImage(
                getClass().getClassLoader().getResource( "loading.gif"));

        // 绘制图片（如果宽高传的不是图片原本的宽高, 则图片将会适当缩放绘制）
        g2d.drawImage(image, 50, 50, image.getWidth(this), image.getHeight(this), this);

        g2d.dispose();
    }

    private void drawArc(Graphics g) {
        int outer_radius = 110, inner_radius = 105;     // 内外圆的半径差即为最终显示出来的圆弧宽
        Graphics2D g2d = (Graphics2D) g.create();
        //抗锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        //设置画笔颜色
        g2d.setColor(Color.WHITE);
        g2d.drawArc(width / 2 - outer_radius, height / 2 - outer_radius, 20 + 200, 20 + 200, 0, 360);     // 外圈圆
        g2d.setColor(Color.ORANGE);
        g2d.fillArc(width / 2 - outer_radius, height / 2 - outer_radius, 20 + 200, 20 + 200, startAngle, arcAngle);   // 有色圆弧
        g2d.setColor(Color.WHITE);
        g2d.fillArc(width / 2 - inner_radius, height / 2 - inner_radius, 20 + 190, 20 + 190, 0, 360);     // 内圈圆(带填充)
        g2d.dispose();
    }

    private class ReboundListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (orientation == CLOCKWISE) {
                if (arcAngle > -360) {
                    arcAngle -= 5;
                } else {
                    arcAngle %= 360;
                }

                arcLengthDegree += 5;
                double arcLengthAng = (arcLengthDegree * Math.PI) / 360;

                double ratio = Math.round(Math.sin(arcLengthAng));
                arcLength = arcAngle * ratio;
                startAngle = (int) (arcAngle + Math.round(arcLength));
                if (startAngle < -360) {
                    arcAngle %= 360;
                }

                if (startAngle < arcAngle) {
                    log.info("arcLength: ", arcLength);
                    log.info("startAngle: " + startAngle);
                    log.info("arcAngle: " + arcAngle);
                }
            } else if (orientation == ANTICLOCKWISE) {
                if (arcAngle > 360) {
                    arcAngle %= 360;
                } else {
                    arcAngle += 5;
                }
            }

//            if (startAngle < 360) {
//                // 控制每个DELAY周期旋转的角度，+ 为逆时针  - 为顺时针
//                switch (orientation) {
//                    case CLOCKWISE:
//                        startAngle = startAngle + 5;
//                        break;
//                    case ANTICLOCKWISE:
//                        startAngle = startAngle - 5;
//                        break;
//                    default:
//                        startAngle = startAngle + 5;
//                        break;
//                }
//            } else {
//                startAngle = 0;
//            }

//            if (o == 0) {
//                if (arcAngle >= 355) {
//                    o = 1;
//                    orientation = ANTICLOCKWISE;
//                }
////                else {
////                    if (orientation == CLOCKWISE) {
////                        arcAngle += 5;
////                    }
////                }
//            }else {
//                if (arcAngle <= 5) {
//                    o = 0;
//                    orientation = CLOCKWISE;
//                }
////                else {
////                    if (orientation == ANTICLOCKWISE) {
////                        arcAngle -= 5;
////                    }
////                }
//            }

            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        LodingPanel lodingPanel = new LodingPanel();
        lodingPanel.setBackground(Color.WHITE);
        lodingPanel.show();

        frame.add(lodingPanel);
        frame.setVisible(true);
    }
}
