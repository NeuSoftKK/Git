package com.neu20216788.controller;

import com.neu20216788.dao.*;
import com.neu20216788.service.SuperAdminService;
import com.neu20216788.view.*;
import jdk.jfr.Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SuperAdminController extends MouseAdapter implements ActionListener {//可设为单实例,除了原样使用懒汉式外只需要设一些set方法
    static AddView addView;
    static SuperAdminView superAdminView;
    static Succeedview_reusable succeedview_reusable;
    static ShowServiceView showServiceView=new ShowServiceView();//防止空指针异常
    static int tableFlag1 = -1;//用于获取用户选取的复选框
    static int tableFlag2 = -1;
    SuperAdminService superAdminService = SuperAdminService.getSingletonInstance();


    public SuperAdminController(SuperAdminView superAdminView) {
        SuperAdminController.superAdminView = superAdminView;
    }

    public SuperAdminController(AddView addView) {
        SuperAdminController.addView = addView;
    }

    public SuperAdminController(ShowServiceView showServiceView){
        SuperAdminController.showServiceView=showServiceView;
    }
    public SuperAdminController(Succeedview_reusable succeedview_reusable) {
        SuperAdminController.succeedview_reusable = succeedview_reusable;
    }

    @Override
    public void mousePressed(MouseEvent e) {//表格中的只能单选的复选框

        JTable table1 = superAdminView.getTable1();
        JTable table2 = showServiceView.getTable2();
        int selectedColumn1 = table1.getSelectedColumn();
        int selectedColumn2 = table2.getSelectedColumn();
        if (e.getComponent().getName().equals("table1")){//表一被选中啦
            System.out.println("点击表一事件");
            if (selectedColumn1 != 0) {//只有点中第0列才可以，否则结束流程
                return;
            }
            if ((boolean) table1.getValueAt(table1.getSelectedRow(), selectedColumn1)) {//是否又选了已选的
                table1.setValueAt(false, table1.getSelectedRow(), selectedColumn1);
                tableFlag1 = -1;//如果选了已选的就取消勾选
                return;
            }
            if (tableFlag1 == -1) {//能到这一步的都是点击了没有选择的复选框，还需限制只能选一个
                table1.setValueAt(true, table1.getSelectedRow(), selectedColumn1);
                tableFlag1 = table1.getSelectedRow();
                //System.out.println("flag为：" + tableFlag);
            } else {//已经选过了，取消原来选的，换成新选的
                table1.setValueAt(true, table1.getSelectedRow(), selectedColumn1);
                table1.setValueAt(false, tableFlag1, selectedColumn1);
                tableFlag1 = table1.getSelectedRow();
            }
        }
        if (e.getComponent().getName().equals("table2")){//如果表二（删除服务的表）被选中，则为真
            System.out.println("点击表二事件");
            //table1.setCellSelectionEnabled(false);
            //table1.setColumnSelectionAllowed(false);
            if (selectedColumn2 != 0) {//只有点中第0列才可以，否则结束流程

                return;
            }
            if ((boolean) table2.getValueAt(table2.getSelectedRow(), selectedColumn2)) {//是否又选了已选的
                table2.setValueAt(false, table2.getSelectedRow(), selectedColumn2);
                tableFlag2 = -1;//如果选了已选的就取消勾选
                return;
            }
            if (tableFlag2 == -1) {//能到这一步的都是点击了没有选择的复选框，还需限制只能选一个
                table2.setValueAt(true, table2.getSelectedRow(), selectedColumn2);
                tableFlag2 = table2.getSelectedRow();
                //System.out.println("flag为：" + tableFlag);
            } else {//已经选过了，取消原来选的，换成新选的
                table2.setValueAt(true, table2.getSelectedRow(), selectedColumn2);
                table2.setValueAt(false, tableFlag2, selectedColumn2);
                tableFlag2 = table2.getSelectedRow();
                table2.
            }
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("外部监听器调用");
        if (e.getActionCommand().equals("新增")) {

            addView = new AddView();//controller 可设置成单例更为合理
            superAdminView.setEnabled(false);
        }
        if (e.getActionCommand().equals("确定")) {//注意空输入，解决办法，在本方法判断是否为空，可加入*为必填
            System.out.println("点击了确定");//生日格式,用户名不能含有空格在controller层加人
            String id = addView.getTextField1().getText();
            String password = addView.getTextField2().getText();
            String name = addView.getTextField3().getText();
            boolean ismale = addView.getRadioButton3().isSelected();
            String birthday = addView.getTextField4().getText();
            String phonenumber = addView.getTextField5().getText();
            int classification = addView.getComboBox1().getSelectedIndex();
            boolean isLifeAdmin = (classification == 0);//判断下拉列表中的选择
            boolean haveAdd;

            if (id.contains(" ") || password.contains(" ")) {
                addView.getLabel8().setVisible(true);
                addView.getLabel8().setText("用户名和密码不得含有空格");
                return;
            }
            if (id.equals("") || password.equals("") || name.equals("") || birthday.equals("") || phonenumber.equals("")) {
                addView.getLabel8().setVisible(true);//业务规则，不能有空的框
                return;

            }
            if(isLifeAdmin){
                haveAdd = superAdminService.addAdmin((new LifeAdminDao(id, password, name, ismale, birthday, phonenumber)));
            }else{
                haveAdd = superAdminService.addAdmin(new SupportAdminDao(id, password, name, ismale, birthday, phonenumber));
            }
            if (haveAdd) {//成功加入了！
                new Succeedview_reusable().setVisible(true);


                addView.setVisible(false);
                superAdminView.setEnabled(true);
                superAdminView.freshTabble();//刷新table
                System.out.println(AdminListDao.getSingletonInstance().getLifeAdmins());//仅用于测试

            } else {
                addView.getLabel8().setText("id已存在，不能新增");
                addView.getLabel8().setVisible(true);
                return;
            }


        }
        if (e.getActionCommand().equals("取消")) {
            superAdminView.setEnabled(true);
            addView.setVisible(false);
        }
        if (e.getActionCommand().equals("删除")) {
            JTable table1 = superAdminView.getTable1();
            if (tableFlag1 ==-1) {
                return;//如果什么都没选就结束，避免空指针异常
            }

            if (superAdminService.deleteAdmin((String) table1.getValueAt(tableFlag1, 1))) {
                // table1.setValueAt(false, tableflag, 0);//符合业务逻辑，删除成功，表格打勾的值去掉
                superAdminView.freshTabble();
                tableFlag1 = -1;
            } else {
                System.out.println("弹窗");
                ErrormassageOfDDelete erroframe = new ErrormassageOfDDelete();


            }
        }
        if (e.getActionCommand().equals("查看服务&解除服务（生活管家）")){
            System.out.println("查看服务");
            if (tableFlag1 ==-1){//如果没有选择就结束，避免空指针异常
                return;
            }
            AdminListDao adminListDao = AdminListDao.getSingletonInstance();
            JTable table1= superAdminView.getTable1();
            if (superAdminService.checkById((String) table1.getValueAt(tableFlag1, 1) )instanceof SupportAdminDao){
                System.out.println("不是生活管家");
                return;
            }
            System.out.println("可以");
            LifeAdminDao lifeAdmin =(LifeAdminDao)superAdminService.checkById((String) table1.getValueAt(tableFlag1, 1));
            ArrayList<ElderDao> elders = lifeAdmin.getElders();
            ShowServiceView showServiceView = new ShowServiceView();
            showServiceView.freshtable(lifeAdmin);

        }
        if (e.getSource().equals("解除")){

        }
    }
}
