package com.example.boardweb.bean;

public class UserBean {
    private String id;
    private String password;

    public UserBean() {
    }

    public UserBean(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
