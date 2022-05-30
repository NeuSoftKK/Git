package com.neu20216788.controller;

import com.neu20216788.dao.AdminDao;
import com.neu20216788.dao.LifeAdminDao;
import com.neu20216788.dao.SuperAdminDao;
import com.neu20216788.dao.SupportAdminDao;
import com.neu20216788.service.LoginService;
import com.neu20216788.view.PreLoginView;
import com.neu20216788.view.SuperAdminView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginController extends KeyAdapter implements ActionListener {

    private PreLoginView preLoginView;
    private LoginService loginService = LoginService.getSingletonInstance();

    public LoginController(PreLoginView preLoginView) {
        this.preLoginView = preLoginView;
        System.out.println("new controller");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if ("登录".equals(e.getActionCommand())) {
            System.out.println("外部监听器响应登录按钮");
            login();
        }


        //System.out.println(e.getActionCommand());


        //System.out.println( (LoginService.Login(preLoginView.getTextField3().getText(),
        // String.valueOf(preLoginView.getPasswordField1().getPassword()))));
    }

    private void login() {//抽象出登录方法
        AdminDao user = loginService.Login(preLoginView.getTextField3().getText(),
                String.valueOf(preLoginView.getPasswordField1().getPassword()));
        {
            if (user instanceof SuperAdminDao) {
                System.out.println("进入超管界面");
                preLoginView.setVisible(false);
                SuperAdminView superAdminView = new SuperAdminView();
                superAdminView.freshTabble();

                //superAdminView.setVisible(true);

            } else if (user instanceof LifeAdminDao) {
                System.out.println("进入生活管家界面");
            } else if (user instanceof SupportAdminDao) {
                System.out.println("进入后勤管家界面");
            } else {
                System.out.println("在原页面提示用户名密码错误");
                preLoginView.showError();
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
            System.out.println("回车登录");
            login();
        }
    }//回车等同于按下登录，使用十需要继承KeyAdpter类。
}
