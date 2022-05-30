/*
 * Created by JFormDesigner on Tue May 24 02:16:03 CST 2022
 */

package com.neu20216788.view;

import com.neu20216788.controller.LoginController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class PreLoginView extends JFrame {
    LoginController loginController;

    public PreLoginView() {//为了设置外部监听，在这里添加监听器（否则会被插件自动改动）

        loginController = new LoginController(this);
        initComponents();
        button1.addActionListener(loginController);
        passwordField1.addKeyListener(loginController);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showError() {
        label4.setVisible(true);
    }


    public JTextField getTextField3() {
        return textField3;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("new");
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                    "fill,insets 0,hidemode 3,align right center",
                    // columns
                    "[72,fill]" +
                            "[48,fill]" +
                            "[167,fill]" +
                            "[304,fill]" +
                            "[229,fill]" +
                            "[46,fill]" +
                            "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[center]" +
                            "[49,center]" +
                            "[14,center]" +
                            "[46,center]" +
                            "[33,center]" +
                            "[]" +
                            "[]" +
                            "[center]"));

            //---- label1 ----
            label1.setText(bundle.getString("LoginFrame.label1.text"));
            label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
            panel1.add(label1, "cell 3 1,align center center,grow 0 0");

            //---- label2 ----
            label2.setText(bundle.getString("LoginFrame.label2.text"));
            label2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            panel1.add(label2, "cell 1 2,alignx center,growx 0");
            panel1.add(textField3, "cell 2 2 3 1");

            //---- label3 ----
            label3.setText(bundle.getString("LoginFrame.label3.text"));
            label3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            panel1.add(label3, "cell 1 4,align center center,grow 0 0");
            panel1.add(passwordField1, "cell 2 4 3 1");

            //---- label4 ----
            label4.setText(bundle.getString("LoginFrame.label4.text"));
            label4.setForeground(Color.red);
            label4.setVisible(false);
            panel1.add(label4, "cell 3 5");

            //---- button1 ----
            button1.setText(bundle.getString("LoginFrame.button1.text"));
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD));
            panel1.add(button1, "cell 3 6");
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        setSize(1040, 750);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField3;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
