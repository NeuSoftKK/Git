package com.neu20216788.dao;

import com.neu20216788.service.SuperAdminService;
import com.neu20216788.view.PreLoginView;

public class Test {


    public static void main(String[] args) {
        SupportAdminDao Tony = new SupportAdminDao("6", "6", "Tony", true,
                "20021201", "15542433631");
        SupportAdminDao Bee = new SupportAdminDao("5", "5", "Bee", true,
                "20021201", "15542433631");
        SupportAdminDao Yee = new SupportAdminDao("4", "4", "Yee12", false,
                "20021201", "15542433631");
        LifeAdminDao Alex = new LifeAdminDao("3", "3", "Alex", true,
                "20021201", "15542433631");
        LifeAdminDao Rex = new LifeAdminDao("2", "2", "Rex", true,
                "20021201", "15542433631");
        LifeAdminDao Lily = new LifeAdminDao("1", "1", "Lily", false,
                "20021201", "15542433631");
        AdminListDao adminList = AdminListDao.getSingletonInstance();
        SuperAdminService superAdminService = SuperAdminService.getSingletonInstance();
        adminList.addAdmin(Alex);
        adminList.addAdmin(Rex);
        adminList.addAdmin(Lily);
        adminList.addAdmin(Tony);
        adminList.addAdmin(Bee);
        adminList.addAdmin(Yee);
        AdminDao wkk = new AdminDao("w2002121", "2002121");
        //System.out.println(LoginService.Login("4","4") instanceof SupportAdminDao);

        superAdminService.deleteAdmin("3");//检查删除功能ok

        PreLoginView preLoginView = new PreLoginView();
        System.out.println(AdminListDao.getSingletonInstance().getLifeAdmins());
        ElderDao elder1 = new ElderDao("老人2", "19500101", true, "15542344641");
        System.out.println("Setresult1:" + superAdminService.setService(Lily, elder1));
        //SuperAdminService.finishService(Lily,elder1);// 测试解约功能，解除注释会使下一句输出true。
        System.out.println("Setresult2:" + superAdminService.setService(Rex, elder1));


        //preLoginView.setDefaultCloseOperation();
        //preLoginView.setSize(1024,768);
        // preLoginView.setVisible(true);


    }
}
