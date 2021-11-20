package com.seeyoumeet.study.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @Classname RobotTest
 * @Description ： ...
 * @Date ：2021-08-13
 * @Created by seeyoumeet
 */
public class RobotTest {
    public static void main(String[] args) throws Exception {
        final Robot robot = new Robot();

        new Thread(){
            public void run(){
                robot.delay(2000);
                //回车
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        }.start();

        JOptionPane.showMessageDialog(null,"以下程序自动执行,包括本对话框,请不必进行人为干预.\n如果不能正常执行程序,请先关闭输入法");

        // 设置开始菜单的大概位置
        int startMenu_x = 40;
        int startMenu_y = Toolkit.getDefaultToolkit().getScreenSize().height-10;

        // 鼠标移动到开始菜单
        robot.mouseMove(startMenu_x, startMenu_y);
        robot.delay(500);

        // 单击三次开始菜单s
//        for(int i = 0; i < 3; i++)
//            pressMouse(robot, InputEvent.BUTTON3_MASK,500);

        pressMouse(robot, InputEvent.BUTTON3_MASK,500);
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyRelease(KeyEvent.VK_X);
        robot.keyRelease(KeyEvent.VK_WINDOWS);

        // 运行CMD命令  r  cmd enter
        int[] ks = {KeyEvent.VK_R, KeyEvent.VK_C, KeyEvent.VK_M, KeyEvent.VK_D, KeyEvent.VK_ENTER};
        pressKeys(robot, ks, 500);
        robot.mouseMove(400, 400);
        robot.delay(500);

        // 运行DIR命令  dir enter
        ks = new int[]{KeyEvent.VK_D, KeyEvent.VK_I, KeyEvent.VK_R, KeyEvent.VK_ENTER};
        pressKeys(robot, ks,500);
        robot.delay(1000);

        // 运行CLS命令 cls enter
        ks = new int[]{KeyEvent.VK_C, KeyEvent.VK_L, KeyEvent.VK_S, KeyEvent.VK_ENTER};
        pressKeys(robot,ks,500);
        robot.delay(1000);

        // 运行EXIT命令 exit enter
        ks = new int[]{KeyEvent.VK_E, KeyEvent.VK_X, KeyEvent.VK_I, KeyEvent.VK_T, KeyEvent.VK_ENTER};
        pressKeys(robot,ks,500);
        robot.delay(1000);

        // 右键测试
        startMenu_x = Toolkit.getDefaultToolkit().getScreenSize().width - 80;
        robot.mouseMove(startMenu_x, startMenu_y);

        // 如果是双键鼠标, 请改用InputEvent.BUTTON2_MASK试试,我没有这种鼠标
        pressMouse(robot, InputEvent.BUTTON3_MASK,500);

        // 显示日期调整对话框 a
        pressKeys(robot, new int[]{KeyEvent.VK_A},1000);
        robot.delay(2000);

        pressKeys(robot,new int[]{KeyEvent.VK_ESCAPE},0);
        robot.delay(1000);

        new Thread(){
            public void run(){
                robot.delay(1000);
                //回车
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
        }.start();

        JOptionPane.showMessageDialog(null,"演示完毕!");
    }

    // 模拟鼠标单击, 要双击就连续调用
    private static void pressMouse(Robot r, int m, int delay){
        r.mousePress(m);
        r.delay(10);
        r.mouseRelease(m);
        r.delay(delay);
    }

    // 模拟键盘输入
    private static void pressKeys(Robot r, int[] ks, int delay){
        for(int i = 0; i < ks.length; i++){
            r.keyPress(ks[i]);
            r.delay(10);
            r.keyRelease(ks[i]);
            r.delay(delay);
        }
    }
}
