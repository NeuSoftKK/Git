package com.neu20216788.service;

import com.neu20216788.dao.*;

import java.util.ArrayList;

public class SuperAdminService {
    private   AdminListDao adminListDao = AdminListDao.getSingletonInstance();
    private static SuperAdminService instance = null;

    private SuperAdminService() {}

    public static SuperAdminService getSingletonInstance() {
        if (instance == null) {
            instance = new SuperAdminService();
        }
        return instance;
    }

    public  boolean addAdmin(AdminDao adminDao) {
        if ( checkById(adminDao.getId())!=null ){//先检查这个人是否存在，不存在才可以增加
            return false;
        } else {
            System.out.println("加入成功");
            adminListDao.addAdmin(adminDao);

        }
        return true;
    }

    public boolean deleteAdmin(String id) {//for loop删除只能从后往前遍历,用delete方法调用remove方法省去遍历
        AdminListDao adminListDao = AdminListDao.getSingletonInstance();
        AdminDao adminDao = checkById(id);
        if (adminDao != null) {//找到返回true,没找到返回false
            if (adminDao instanceof LifeAdminDao) {
                if (((LifeAdminDao) adminDao).getElders().size() != 0) {
                    return false;//有未解绑的服务，不可以删除，等待测试
                }
            }
            adminListDao.deleteAdmin(adminDao);
            return true;
        }
        return false;
    }

    public  int modifyAdmin(AdminDao adminDaoOld,AdminDao adminDaoNew) {//dao中设置一下这个方法ok


        if ((adminDaoOld instanceof LifeAdminDao) &&(adminDaoNew instanceof SupportAdminDao) ) {
            if (((LifeAdminDao) adminDaoOld).getElders().size() != 0) {
                return 1;//1生活管家存在未解绑的服务，无法转换权限
            }

        }
        if ((!adminDaoOld.getId().equals(adminDaoNew.getId()))&&(checkById(adminDaoNew.getId())!=null)) {//2业务规则，不允许将id改成和别人相同的
            return 2;//若新ID和老ID不一样，且新ID在列表中I存在，失败

        } else {
            deleteAdmin(adminDaoOld.getId());//修改的本质是删掉这个对象并重新创建
            addAdmin(adminDaoNew);
            return 3;//3成功
        }

    }

    public AdminDao checkById(String id) {
        for (int i = 0; i < adminListDao.getLifeAdmins().size(); i++) {
            if (id.equals(adminListDao.getLifeAdmins().get(i).getId())) {
                return adminListDao.getLifeAdmins().get(i);
            }
        }
        for (int i = 0; i < adminListDao.getSupportAdmins().size(); i++) {
            if (id.equals(adminListDao.getSupportAdmins().get(i).getId())) {
                return adminListDao.getSupportAdmins().get(i);
            }
        }
        return null;
    }

    public boolean setService(LifeAdminDao lifeAdminDao, ElderDao elderDao) {
        if (elderDao.getLifeAdmin() != null) {
            return false;
        } else {
            elderDao.setLifeAdmin(lifeAdminDao);
            lifeAdminDao.getElders().add(elderDao);
            return true;
        }
    }

    public boolean finishService(LifeAdminDao lifeAdminDao, ElderDao elderDao) {
        if (lifeAdminDao.getElders().contains(elderDao)) {//强化条件，防止出错
            lifeAdminDao.getElders().remove(elderDao);
            elderDao.setLifeAdmin(null);
            return true;
        }
        return false;
    }

    public ArrayList<ElderDao> showElder(LifeAdminDao lifeAdminDao) {
        return lifeAdminDao.getElders();
    }

    public Object[][] getAdminData() {//生成一个含有所有管理员的二维数组，用于在table上显示
        Object[][] arr = new Object[(adminListDao.getLifeAdmins().size() + adminListDao.getSupportAdmins().size())][7];
        for (int i = 0; i < adminListDao.getLifeAdmins().size(); i++) {
            arr[i][0] = false;
            arr[i][1] = adminListDao.getLifeAdmins().get(i).getId();
            arr[i][2] = adminListDao.getLifeAdmins().get(i).getName();
            if (adminListDao.getLifeAdmins().get(i).isIsmale()) {
                arr[i][3] = "男";
            } else {
                arr[i][3] = "女";
            }

            arr[i][4] = adminListDao.getLifeAdmins().get(i).getBirthday();
            arr[i][5] = adminListDao.getLifeAdmins().get(i).getPhonenumber();
            arr[i][6] = "生活管家";
        }
        for (int i = adminListDao.getLifeAdmins().size(); i < (adminListDao.getLifeAdmins().size() + adminListDao.getSupportAdmins().size()); i++) {
            arr[i][0] = false;
            arr[i][1] = adminListDao.getSupportAdmins().get(i - adminListDao.getLifeAdmins().size()).getId();
            arr[i][2] = adminListDao.getSupportAdmins().get(i - adminListDao.getLifeAdmins().size()).getName();
            if (adminListDao.getSupportAdmins().get(i - adminListDao.getLifeAdmins().size()).isIsmale()) {
                arr[i][3] = "男";
            } else {
                arr[i][3] = "女";
            }

            arr[i][4] = adminListDao.getSupportAdmins().get(i - adminListDao.getLifeAdmins().size()).getBirthday();
            arr[i][5] = adminListDao.getSupportAdmins().get(i - adminListDao.getLifeAdmins().size()).getPhonenumber();
            arr[i][6] = "后勤管家";
        }
        return arr;
    }
    public Object[][]getEldersData(LifeAdminDao lifeAdminDao){//不加入中间变量的原因：不直观
        Object[][] arr = new Object[lifeAdminDao.getElders().size()][5];
        for (int i=0;i<lifeAdminDao.getElders().size();i++){
            arr[i][0] = false;
            arr[i][1] = lifeAdminDao.getElders().get(i).getName();
            if (lifeAdminDao.getElders().get(i).isIsmale()){
                arr[i][2] = "男";
            }else{
                arr[i][2] = "女";
            }
            arr[i][3] =lifeAdminDao.getElders().get(i).getPhonenumber();
            arr[i][4] =lifeAdminDao.getElders().get(i).getBirthday();
        }
        return arr;
    }


}
