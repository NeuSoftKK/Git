package com.neu20216788.dao;

public class ElderDao {
    private String name;
    private String birthday;
    private boolean ismale;
    private String phonenumber;
    private LifeAdminDao lifeAdmin;

    public ElderDao(String name, String birthday, boolean ismale, String phonenumber) {
        this.name = name;
        this.birthday = birthday;
        this.ismale = ismale;
        this.phonenumber = phonenumber;
    }
    @Override
    public String toString(){//重写toString的妙用，在下拉列表中加入类的对象便可显示name；
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isIsmale() {
        return ismale;
    }

    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LifeAdminDao getLifeAdmin() {
        return lifeAdmin;
    }

    public void setLifeAdmin(LifeAdminDao lifeAdmin) {
        this.lifeAdmin = lifeAdmin;
    }
}
