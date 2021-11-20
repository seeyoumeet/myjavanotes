package seeyoumeet.swing;//package com.seeyoumeet.swing;
//
//import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//
///**
// * @Author : yuc5015
// * @Date : 2021/8/18
// * @Description :
// * @Modified By :
// */
//public class GroupLayoutTest {
//    public static void main(String[] args) {
//        JFrame jf = new JFrame("测试窗口");
//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        int location_x = 640;
//
//        int location_y = 640;
//
//        int frame_width = 600;
//
//        int frame_height = 400;
//
//        // 创建内容面板容器
//        JPanel panel = new JPanel();
//        // 创建分组布局，并关联容器
//        GroupLayout layout = new GroupLayout(panel);
//        // 设置容器的布局
//        panel.setLayout(layout);
//
//        // 创建组件
//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//        textArea.setForeground(Color.BLUE);
//        textArea.setBounds(location_x - 200, location_y - 200, frame_width - 200, frame_height - 100);
//        textArea.setPreferredSize(new Dimension(frame_width - 200, frame_height - 150));
//
//        JButton gdbChooserBtn = new JButton("选择gdb根目录");
//        JButton importBtn = new JButton("开始入库");
//        JRadioButton pauseBtn = new JRadioButton("暂停入库", false);
//
//        gdbChooserBtn.setForeground(Color.WHITE);
//        gdbChooserBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
//        importBtn.setForeground(Color.WHITE);
//        importBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
//
//        // 自动创建组件之间的间隙
//        layout.setAutoCreateGaps(true);
//        // 自动创建容器与触到容器边框的组件之间的间隙
//        layout.setAutoCreateContainerGaps(true);
//
////        GroupLayout.SequentialGroup hSeqGroup1 = layout.createSequentialGroup().addComponent(textArea);
////        GroupLayout.SequentialGroup hSeqGroup2 = layout.createSequentialGroup().addComponent(gdbChooserBtn).addComponent(importBtn).addComponent(pauseBtn);
////        GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup().addGroup(hSeqGroup1).addGroup(GroupLayout.Alignment.CENTER, hSeqGroup2);
////        layout.setHorizontalGroup(hParalGroup);  // 指定布局的 水平组（水平坐标）
////
////        GroupLayout.ParallelGroup vParalGroup01 = layout.createParallelGroup().addComponent(textArea);
////        GroupLayout.ParallelGroup vParalGroup02 = layout.createParallelGroup().addComponent(gdbChooserBtn).addComponent(importBtn).addComponent(pauseBtn);
////        GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addGroup(vParalGroup01).addGroup(vParalGroup02);
////        layout.setVerticalGroup(vSeqGroup);    // 指定布局的 垂直组（垂直坐标）
//
//        JButton okBtn = new JButton("确认");
//        Object[] columnNames = {"姓名", "语文", "数学", "英语", "总分"};
//
//        // 表格所有行数据
//        Object[][] rowData = {
//                {"张三", 80, 80, 80, 240},
//                {"John", 70, 80, 90, 240},
//                {"Sue", 70, 70, 70, 210},
//                {"Jane", 80, 70, 60, 210},
//                {"Joe", 80, 70, 60, 210}
//        };
//        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
//        JTable table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(
//                table,
//                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
//        );
//
//        GroupLayout.SequentialGroup hSeqGroup1 = layout.createSequentialGroup().addComponent(table);
//        GroupLayout.SequentialGroup hSeqGroup2 = layout.createSequentialGroup().addComponent(okBtn);
//        GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup().addGroup(hSeqGroup1).addGroup(GroupLayout.Alignment.CENTER, hSeqGroup2);
//        layout.setHorizontalGroup(hParalGroup);  // 指定布局的 水平组（水平坐标）
//
//        GroupLayout.ParallelGroup vParalGroup01 = layout.createParallelGroup().addComponent(table);
//        GroupLayout.ParallelGroup vParalGroup02 = layout.createParallelGroup().addComponent(okBtn);
//        GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addGroup(vParalGroup01).addGroup(vParalGroup02);
//        layout.setVerticalGroup(vSeqGroup);    // 指定布局的 垂直组（垂直坐标）
//
//        jf.setContentPane(panel);
//        jf.pack();
//        jf.setLocationRelativeTo(null);
//        jf.setVisible(true);
//    }
//}
