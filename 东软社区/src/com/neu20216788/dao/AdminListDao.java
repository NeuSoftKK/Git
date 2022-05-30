package com.neu20216788.dao;

import java.util.ArrayList;

public class AdminListDao {
    private static AdminListDao instance = null;

    private AdminListDao() {

    }

    public static AdminListDao getSingletonInstance() {
        if (instance == null) {
            instance = new AdminListDao();
        }
        return instance;
    }

    private ArrayList<LifeAdminDao> lifeAdmins = new ArrayList<LifeAdminDao>();
    private ArrayList<SupportAdminDao> supportAdmins = new ArrayList<SupportAdminDao>();

    public void addAdmin(AdminDao e) {
        if (e instanceof LifeAdminDao) {
            addLifeAdmin((LifeAdminDao) e);
        } else {
            addSupportAdmin((SupportAdminDao) e);
        }
    }

    private void addLifeAdmin(LifeAdminDao e) {
        lifeAdmins.add(e);
    }

    private void addSupportAdmin(SupportAdminDao e) {
        supportAdmins.add(e);
    }

    public void deleteAdmin(AdminDao adminDao) {
        if (adminDao instanceof LifeAdminDao) {
            lifeAdmins.remove(adminDao);
        } else {
            supportAdmins.remove(adminDao);
        }
    }

   // public void modifyAdmin(AdminDao adminDao, String id, String password, String name, boolean ismale,
       //                     String birthday, String phonenumber) {

    //}

    public ArrayList<LifeAdminDao> getLifeAdmins() {
        return lifeAdmins;
    }

    public ArrayList<SupportAdminDao> getSupportAdmins() {
        return supportAdmins;
    }


}
