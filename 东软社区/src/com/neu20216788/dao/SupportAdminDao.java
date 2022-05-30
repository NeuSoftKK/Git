package com.neu20216788.dao;

public class SupportAdminDao extends AdminDao {


    private String name;
    private boolean ismale;
    private String birthday;
    private String phonenumber;

    public SupportAdminDao(String id, String password, String name, boolean ismale,
                           String birthday, String phonenumber) {
        super(id, password);
        this.name = name;
        this.ismale = ismale;
        this.birthday = birthday;
        this.phonenumber = phonenumber;

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

    public void modidyAdmin(String id, String password, String name, boolean ismale,
                            String birthday, String phonenumber) {
        this.setId(id);
        this.setPassword(password);
        this.name = name;
        this.ismale = ismale;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
    }

}
