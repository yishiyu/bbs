package com.jiading.domain;

import java.io.Serializable;


/**
 * @program: bbs
 * @description: 帖子的对象
 * @author: JiaDing
 * @create: 2020-07-16 10:40
 **/
public class Post implements Serializable {
    private int pid;//pid是指帖子的id
    private int uid;//uid是值用户的id
    private int bid;//bid是所属的类别的id
    private String summary;//摘要
    private String content;//文章
    private String title;//标题
    private String date;//文章发布时间
    private String image;
    private boolean isCanShow;//是否显示
    private int view;//浏览量

    public Post() {
    }

    public Post(int pid, int uid, int bid, String summary, String content, String title, String date, String image, boolean isCanShow, int view) {
        this.pid = pid;
        this.uid = uid;
        this.bid = bid;
        this.summary = summary;
        this.content = content;
        this.title = title;
        this.date = date;
        this.image = image;
        this.isCanShow = isCanShow;
        this.view = view;
    }

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

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCanShow() {
        return isCanShow;
    }

    public void setCanShow(boolean canShow) {
        isCanShow = canShow;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
