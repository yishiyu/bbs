package com.jiading.domain;

import java.io.Serializable;

/**
 * 收藏实体类,收藏帖子
 */
public class FavoritePost implements Serializable {
    private Post post;//帖子对象
    private String date;//收藏时间
    private int uid;//所属用户

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     * 无参构造方法
     */
    public FavoritePost() {
    }

    public FavoritePost(Post post, String date, int uid) {
        this.post = post;
        this.date = date;
        this.uid = uid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
