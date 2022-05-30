/*
 * Created by JFormDesigner on Fri May 27 11:30:51 CST 2022
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
public class ErrormassageOfDDelete extends JFrame {
    SuperAdminController superAdminController;

    public ErrormassageOfDDelete() {
        initComponents();

    }

    private void button1(ActionEvent e) {
        System.out.println("点了");
        frame1.setVisible(false);


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("new");
        frame1 = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();

        //======== frame1 ========
        {
            frame1.setVisible(true);
            var frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setMinimumSize(new Dimension(450, 215));
                panel1.setPreferredSize(new Dimension(450, 215));
                panel1.setLayout(new MigLayout(
                        "fill,hidemode 3,align center center",
                        // columns
                        "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]" +
                                "[fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]"));

                //---- label1 ----
                label1.setText(bundle.getString("ErrormassageOfDDelete.label1.text"));
                panel1.add(label1, "cell 0 0 7 2,align center center,grow 0 0");

                //---- button1 ----
                button1.setText(bundle.getString("ErrormassageOfDDelete.button1.text"));
                button1.addActionListener(this::button1);
                panel1.add(button1, "cell 0 3 7 1,alignx center,growx 0");
            }
            frame1ContentPane.add(panel1, BorderLayout.CENTER);
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
