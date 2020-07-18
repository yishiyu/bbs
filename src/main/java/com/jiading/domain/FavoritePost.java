package com.jiading.domain;

import java.io.Serializable;

/**
 * 收藏实体类,收藏帖子
 */
public class FavoritePost implements Serializable {
    private Post post;//旅游线路对象
    private String date;//收藏时间
    private User user;//所属用户

    /**
     * 无参构造方法
     */
    public FavoritePost() {
    }

    public FavoritePost(Post post, String date, User user) {
        this.post = post;
        this.date = date;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
