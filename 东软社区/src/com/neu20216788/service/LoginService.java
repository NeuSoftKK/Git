package com.neu20216788.service;

import com.neu20216788.dao.*;

import java.util.ArrayList;

public class LoginService {
    //如果匹配返回对象，不匹配返回null
    private static LoginService instance = null;
    private LoginService() {
    }

    public static LoginService getSingletonInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }
    public  AdminDao Login(String id, String password) {
        // 测试：LifeAdminDao wkk=new LifeAdminDao("1910623","a1b2c3","wkk",true,
        //        "20021201","15542433631");
        // return wkk;
        AdminDao flag = null;
        if (id.equals("admin") && password.equals("admin")) {
            return new SuperAdminDao();
        } else if ((flag = canLoginLifeAdmin(id, password)) != null) {
            return flag;
        } else if ((flag = canLoginSupportAdmin(id, password)) != null) {
            return flag;
        }
        return null;
    }

    private   LifeAdminDao canLoginLifeAdmin(String id, String password) {
        ArrayList<LifeAdminDao> lifeAdmins = AdminListDao.getSingletonInstance().getLifeAdmins();//管理员列表为单例变量
        for (int i = 0; i < lifeAdmins.size(); i++) {
            if (lifeAdmins.get(i).getId().equals(id) && lifeAdmins.get(i).getPassword().equals(password)) {
                return lifeAdmins.get(i);
            }
        }
        return null;
    }

    private   SupportAdminDao canLoginSupportAdmin(String id, String password) {

        ArrayList<SupportAdminDao> supportAdmins = AdminListDao.getSingletonInstance().getSupportAdmins();
        for (int i = 0; i < supportAdmins.size(); i++) {
            if (supportAdmins.get(i).getId().equals(id) && supportAdmins.get(i).getPassword().equals(password)) {
                return supportAdmins.get(i);
            }
        }
        return null;
    }
}

