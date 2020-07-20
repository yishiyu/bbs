package com.jiading.domain;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private int uid;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String head_portrait;//头像
    private boolean admin_admin;//是否是特权用户，true为特权用户
    private String email;//邮箱
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码
    private String comment;//个人签名

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User(int uid, String username, String password, String head_portrait, boolean super_admin, String email, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.head_portrait = head_portrait;
        this.admin_admin = super_admin;
        this.email = email;
        this.status = status;
        this.code = code;
    }

    /**
     * 无参构造方法
     */
    public User() {
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

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public boolean isAdmin_admin() {
        return admin_admin;
    }

    public void setAdmin_admin(boolean admin_admin) {
        this.admin_admin = admin_admin;
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
