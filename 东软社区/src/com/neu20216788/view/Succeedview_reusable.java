/*
 * Created by JFormDesigner on Thu May 26 15:40:16 CST 2022
 */

package com.neu20216788.view;

import com.neu20216788.controller.SuperAdminController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class Succeedview_reusable extends JFrame {
    SuperAdminController superAdminController;

    public Succeedview_reusable() {
        initComponents();
        superAdminController = new SuperAdminController(this);
    }

    private void buttonok(ActionEvent e) {
        // TODO add your code here
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("new");
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3,align center center",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText(bundle.getString("Succeedview_reusable.label1.text"));
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 26));
        contentPane.add(label1, "cell 0 1 2 1,align center center,grow 0 0");

        //---- button1 ----
        button1.setText(bundle.getString("Succeedview_reusable.button1.text"));
        button1.addActionListener(e -> buttonok(e));
        contentPane.add(button1, "cell 0 2 2 1,align center center,grow 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
