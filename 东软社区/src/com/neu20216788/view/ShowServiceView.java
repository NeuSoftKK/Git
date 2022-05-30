/*
 * Created by JFormDesigner on Sun May 29 20:07:26 CST 2022
 */

package com.neu20216788.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.neu20216788.controller.SuperAdminController;
import com.neu20216788.dao.AdminListDao;
import com.neu20216788.dao.ElderDao;
import com.neu20216788.dao.LifeAdminDao;
import com.neu20216788.service.SuperAdminService;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class ShowServiceView extends JFrame {
    DefaultTableModel defaultTableModel;
    SuperAdminController superAdminController;
    public ShowServiceView() {
        superAdminController = new SuperAdminController(this);//与控制层绑定
        initComponents();
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        table2.setName("table2");//判断点击事件非常有用


        defaultTableModel = new DefaultTableModel() {
            Class<?>[] columnTypes = new Class<?>[]{
                    Boolean.class, Object.class, Object.class, Object.class, Object.class
            };
            boolean[] columnEditable = new boolean[]{//使表格不可编辑1
                    false, false, false, false, false
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
        table2.addMouseListener(superAdminController);
        table2.setModel(defaultTableModel);


    }
    public void freshtable(LifeAdminDao lifeAdminDao){//单一的访问，跳过了controller层；也可以不跳过，写法略微复杂
       /* AdminListDao adminListDao = AdminListDao.getSingletonInstance();
        for(int i =0;i<adminListDao.getLifeAdmins().size();i++){
            comboBox1.addItem(adminListDao.getLifeAdmins().get(i));

        }
        (LifeAdminDao)comboBox1.getSelectedItem();//带复选框的代码直接从Dao层获取数据，好处是数据是直观的，最新的
*/
        label1.setText(lifeAdminDao.getName());
        if (lifeAdminDao.getElders().size()==0){
            label1.setText(lifeAdminDao.getName()+"无服务，请设置服务");
        }
        SuperAdminService superAdminService = SuperAdminService.getSingletonInstance();
        defaultTableModel.setDataVector(superAdminService.getEldersData(lifeAdminDao), new String[]{
                "\u9009\u62e9", "姓名", "性别", "电话", "生日"
        });

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table2 = new JTable();

        //======== this ========
        setMinimumSize(new Dimension(320, 320));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[142:200,fill]" +
                "[fill]" +
                "[118,fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("text");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
            panel1.add(label1, "cell 0 0 5 1,alignx center,growx 0");

            //---- button1 ----
            button1.setText("\u89e3\u9664");
            panel1.add(button1, "cell 3 1,growx");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table2);
            }
            panel1.add(scrollPane1, "cell 0 2 5 2");
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JTable getTable2() {
        return table2;
    }
    public JLabel getLabel1() {
        return label1;
    }
}

