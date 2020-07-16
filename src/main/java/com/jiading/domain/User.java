package com.jiading.domain;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    /*
    1. 管理员
    2. 普通用户
     */
    private static final int MANAGER = 0;
    private static final int NORMALUSER = 1;
    private int uid;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String headshot;//头像
    private int privilege;//权限
    private String email;//邮箱
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码（要求唯一）

    /**
     * 无参构造方法
     */
    public User() {
    }

    public User(int uid, String username, String password, String headshot, int privilege, String email, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.headshot = headshot;
        this.privilege = privilege;
        this.email = email;
        this.status = status;
        this.code = code;
    }

    public static int getMANAGER() {
        return MANAGER;
    }

    public static int getNORMALUSER() {
        return NORMALUSER;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
