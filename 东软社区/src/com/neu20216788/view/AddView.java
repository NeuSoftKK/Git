/*
 * Created by JFormDesigner on Thu May 26 00:38:16 CST 2022
 */

package com.neu20216788.view;

import com.neu20216788.controller.SuperAdminController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class AddView extends JFrame {
    SuperAdminController superAdminController;

    public AddView() {
        initComponents();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton4);
        buttonGroup.add(radioButton3);
        radioButton3.setSelected(true);


        superAdminController = new SuperAdminController(this);
        this.setVisible(true);
        this.setSize(768, 1024);
        this.setLocationRelativeTo(null);//使弹出的窗口位于屏幕中央，而不是父窗口中央，要放在setsize之后
        this.setDefaultCloseOperation(0);
        button2.addActionListener(superAdminController);
        button1.addActionListener(superAdminController);


    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public SuperAdminController getSuperAdminController() {
        return superAdminController;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JRadioButton getRadioButton3() {
        return radioButton3;
    }

    public JRadioButton getRadioButton4() {
        return radioButton4;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public JComboBox<String> getComboBox1() {
        return comboBox1;
    }

    public JLabel getLabel8() {
        return label8;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("new");
        xinz = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label7 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        button2 = new JButton();
        label8 = new JLabel();

        //======== this ========
        var xinzContentPane = getContentPane();
        xinzContentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
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
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText(bundle.getString("AddView.label1.text"));
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
            panel1.add(label1, "cell 2 3");
            panel1.add(textField1, "cell 3 3 4 1");

            //---- label2 ----
            label2.setText(bundle.getString("AddView.label2.text"));
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
            panel1.add(label2, "cell 2 5");
            panel1.add(textField2, "cell 3 5 4 1");

            //---- label7 ----
            label7.setText(bundle.getString("AddView.label7.text"));
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 4f));
            panel1.add(label7, "cell 2 7");
            panel1.add(textField3, "cell 3 7 4 1");

            //---- label3 ----
            label3.setText(bundle.getString("AddView.label3.text"));
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
            panel1.add(label3, "cell 2 9");

            //---- radioButton3 ----
            radioButton3.setText(bundle.getString("AddView.radioButton3.text"));
            panel1.add(radioButton3, "cell 3 9 2 1");

            //---- radioButton4 ----
            radioButton4.setText(bundle.getString("AddView.radioButton4.text"));
            panel1.add(radioButton4, "cell 5 9 2 1");

            //---- label4 ----
            label4.setText(bundle.getString("AddView.label4.text"));
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
            panel1.add(label4, "cell 2 11");
            panel1.add(textField4, "cell 3 11 4 1");

            //---- label5 ----
            label5.setText(bundle.getString("AddView.label5.text"));
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
            panel1.add(label5, "cell 2 13");
            panel1.add(textField5, "cell 3 13 4 1");

            //---- label6 ----
            label6.setText(bundle.getString("AddView.label6.text"));
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
            panel1.add(label6, "cell 2 15");

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u751f\u6d3b\u7ba1\u5bb6",
                "\u540e\u52e4\u7ba1\u5bb6"
            }));
            comboBox1.setFont(comboBox1.getFont().deriveFont(comboBox1.getFont().getSize() + 3f));
            panel1.add(comboBox1, "cell 3 15 4 1");

            //---- button1 ----
            button1.setText(bundle.getString("AddView.button1.text"));
            panel1.add(button1, "cell 2 22");

            //---- button2 ----
            button2.setText(bundle.getString("AddView.button2.text"));
            panel1.add(button2, "cell 5 22");

            //---- label8 ----
            label8.setText(bundle.getString("AddView.label8.text"));
            label8.setForeground(Color.red);
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 3f));
            label8.setVisible(false);
            panel1.add(label8, "cell 1 20 6 1,align center center,grow 0 0");
        }
        xinzContentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame xinz;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label3;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JButton button2;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
