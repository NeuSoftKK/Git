/*
 * Created by JFormDesigner on Tue May 24 21:43:07 CST 2022
 */

package com.neu20216788.view;

import com.neu20216788.controller.SuperAdminController;
import com.neu20216788.service.SuperAdminService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class SuperAdminView extends JFrame {
    DefaultTableModel defaultTableModel;
    SuperAdminController superAdminController;

    public SuperAdminView() {
        initComponents();
        superAdminController = new SuperAdminController(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(superAdminController);
        button2.addActionListener(superAdminController);
        button3.addActionListener(superAdminController);
        button4.addActionListener(superAdminController);
        button5.addActionListener(superAdminController);
        button6.addActionListener(superAdminController);
        button7.addActionListener(superAdminController);

        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);

        defaultTableModel = new DefaultTableModel() {
            Class<?>[] columnTypes = new Class<?>[]{
                    Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
            };
            boolean[] columnEditable = new boolean[]{//使表格不可编辑1
                    false, false, false, false, false, false, false
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {//让模型得到每一列的正确类型
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];//使表格不可编辑2
            }
        };

        table1.setModel(defaultTableModel);
        table1.addMouseListener(superAdminController);
        table1.setName("table1");//判断点击事件非常有用
    }

    public void freshTabble() {//跳过了controller
        SuperAdminService superAdminService = SuperAdminService.getSingletonInstance();
        defaultTableModel.setDataVector(superAdminService.getAdminData(), new String[]{
                "\u9009\u62e9", "用户名", "\u59d3\u540d", "\u6027\u522b", "\u51fa\u751f\u65e5\u671f", "\u7535\u8bdd", "\u6743\u9650"
        });
    }

    private void createUIComponents() {
        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("new");
        panel1 = new JPanel();
        button4 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button7 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "fill,insets 0,hidemode 3,align center center",
                // columns
                "[106:n,fill]" +
                "[106:n,fill]" +
                "[fill]" +
                "[110,fill]" +
                "[fill]",
                // rows
                "[0,center]" +
                "[20,center]" +
                "[7,center]" +
                "[27,center]" +
                "[center]" +
                "[center]" +
                "[center]" +
                "[center]0" +
                "[center]" +
                "[150,center]" +
                "[8,center]" +
                "[64,center]"));

            //---- button4 ----
            button4.setText(bundle.getString("SuperAdminView.button4.text"));
            panel1.add(button4, "cell 4 1");

            //---- button1 ----
            button1.setText(bundle.getString("SuperAdminView.button1.text"));
            panel1.add(button1, "cell 0 3");

            //---- button2 ----
            button2.setText(bundle.getString("SuperAdminView.button2.text"));
            panel1.add(button2, "cell 1 3");

            //---- button3 ----
            button3.setText(bundle.getString("SuperAdminView.button3.text"));
            button3.setMinimumSize(new Dimension(150, 30));
            button3.setPreferredSize(new Dimension(150, 30));
            panel1.add(button3, "cell 2 3 2 1");

            //---- button7 ----
            button7.setText(bundle.getString("SuperAdminView.button7.text"));
            panel1.add(button7, "cell 4 3");

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setFont(new Font("\u96b6\u4e66", Font.BOLD, 19));
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {false, "", "kk123", null, null, null, null},
                        {false, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                    },
                    new String[] {
                        "\u9009\u62e9", "ID", "\u59d3\u540d", "\u6027\u522b", "\u51fa\u751f\u65e5\u671f", "\u7535\u8bdd", "\u6743\u9650"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
                    };
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false, false
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = table1.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                    cm.getColumn(1).setResizable(false);
                    cm.getColumn(2).setResizable(false);
                    cm.getColumn(3).setResizable(false);
                    cm.getColumn(4).setResizable(false);
                    cm.getColumn(5).setResizable(false);
                    cm.getColumn(6).setResizable(false);
                }
                table1.setMaximumSize(new Dimension(999999, 999999));
                table1.setGridColor(new Color(102, 102, 102));
                table1.setRowHeight(35);
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, "cell 0 5 5 6,grow");

            //---- button5 ----
            button5.setText(bundle.getString("SuperAdminView.button5.text"));
            panel1.add(button5, "cell 0 11");

            //---- button6 ----
            button6.setText(bundle.getString("SuperAdminView.button6.text"));
            panel1.add(button6, "cell 4 11");
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton button4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button7;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JTable getTable1() {
        return table1;
    }

    public JButton getButton5() {
        return button5;
    }

    public JButton getButton6() {
        return button6;
    }

    public JButton getButton7() {
        return button7;
    }
}
