package com.neu20216788.dao;

public class AdminDao {


    private String id;
    private String password;

    public AdminDao(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }


}
