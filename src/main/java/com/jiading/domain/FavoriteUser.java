package com.jiading.domain;

import java.io.Serializable;

/**
 * 收藏实体类,收藏帖子
 */
public class FavoriteUser implements Serializable {
    private User likedUser;//旅游线路对象
    private String date;//收藏时间
    private int uid;//所属用户

    /**
     * 无参构造方法
     */
    public FavoriteUser() {
    }

    public FavoriteUser(User likedUser, String date, int uid) {
        this.likedUser = likedUser;
        this.date = date;
        this.uid = uid;
    }

    public User getLikedUser() {
        return likedUser;
    }

    public void setLikedUser(User likedUser) {
        this.likedUser = likedUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
