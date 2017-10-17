package com.zx.mes.model.admin;

import java.util.Date;
import java.util.List;

public class User {
    private String id;

    private Date createdatetime;

    private Date createdatetime2;

    private Date modifydatetime;

    private String name;

    private String pwd;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    private int value2;

    private List<UserRoleKey> userRoleKeys;



    public List<UserRoleKey> getUserRoleKeys() {
        return userRoleKeys;
    }

    public void setUserRoleKeys(List<UserRoleKey> userRoleKeys) {
        this.userRoleKeys = userRoleKeys;
    }

    public Date getCreatedatetime2() {
        return createdatetime2;
    }

    public void setCreatedatetime2(Date createdatetime2) {
        this.createdatetime2 = createdatetime2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Date getModifydatetime() {
        return modifydatetime;
    }

    public void setModifydatetime(Date modifydatetime) {
        this.modifydatetime = modifydatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}