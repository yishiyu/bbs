package com.jiading.domain;

import java.io.Serializable;

/**
 * 收藏实体类,收藏帖子
 */
public class FavoriteUser implements Serializable {
    private User likedUser;//旅游线路对象
    private String date;//收藏时间
    private User user;//所属用户

    /**
     * 无参构造方法
     */
    public FavoriteUser() {
    }

    public FavoriteUser(User likedUser, String date, User user) {
        this.likedUser = likedUser;
        this.date = date;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
