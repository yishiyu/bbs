package com.jiading.domain;

import java.util.Date;

/**
 * @program: bbs
 * @description: 帖子的对象
 * @author: JiaDing
 * @create: 2020-07-16 10:40
 **/
public class Post {
    private int pid;//pid是指帖子的id
    private int uid;//uid是值用户的id

    public Post(int pid, int uid, String summary, String article, String title, Date date) {
        this.pid = pid;
        this.uid = uid;
        this.summary = summary;
        this.article = article;
        this.title = title;
        this.date = date;
    }

    private String summary;//摘要
    private String article;//文章
    private String title;//标题
    private Date date;//文章发布时间

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
