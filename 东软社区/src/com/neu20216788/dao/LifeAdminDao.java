package com.neu20216788.dao;

import java.util.ArrayList;

public class LifeAdminDao extends AdminDao {
    private ArrayList<ElderDao> elders = new ArrayList<>();
    private String name;
    private boolean ismale;
    private String birthday;
    private String phonenumber;
    @Override
    public String toString(){
        return name;
    }

    public LifeAdminDao(String id, String password, String name, boolean ismale,
                        String birthday, String phonenumber) {
        super(id, password);
        this.name = name;
        this.ismale = ismale;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        //加入一个包含老人的集合
        //可以继承自后勤管理
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsmale() {
        return ismale;
    }

    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void modifyAdmin(String id, String password, String name, boolean ismale,
                            String birthday, String phonenumber) {//被认为是无用的
        this.setId(id);
        this.setPassword(password);
        this.name = name;
        this.ismale = ismale;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
    }


    public ArrayList<ElderDao> getElders() {
        return elders;
    }
}
