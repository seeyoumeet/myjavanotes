package com.seeyoumeet.swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * @Author : yuc5015
 * @Date : 2021/8/17
 * @Description :
 * @Modified By :
 */
public class JListTest {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建一个 JList 实例
        final JList<String> list = new JList<String>();
        JScrollPane scrollPane = new JScrollPane(
                list,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        // 设置一下首选大小
        list.setPreferredSize(new Dimension(200, 100));

        // 允许可间断的多选
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // 设置选项数据（内部将自动封装成 ListModel ）
        list.setListData(new String[]{"香蕉", "雪梨", "苹果", "荔枝","香蕉", "雪梨", "苹果", "荔枝","香蕉", "雪梨", "苹果", "荔枝"});

        // 添加选项选中状态被改变的监听器
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 获取所有被选中的选项索引
                int[] indices = list.getSelectedIndices();
                // 获取选项数据的 ListModel
                ListModel<String> listModel = list.getModel();
                // 输出选中的选项
                for (int index : indices) {
                    System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
                }
                System.out.println();
            }
        });

        // 设置默认选中项
        list.setSelectedIndex(1);

        // 添加到内容面板容器
        panel.add(scrollPane);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }
}
