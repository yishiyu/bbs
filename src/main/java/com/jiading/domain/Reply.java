package com.jiading.domain;

import java.io.Serializable;

/**
 * @program: bbs
 * @description: 评论的实体类
 * @author: JiaDing
 * @create: 2020-07-18 15:43
 **/
public class Reply implements Serializable {
    private User user;//评论的用户
    private int pid;//评论的文章的id
    private String content;
    private String Date;
    private boolean isCanShow;//是否显示

    public Reply(User user, int pid, String content, String date, boolean isCanShow) {
        this.user = user;
        this.pid = pid;
        this.content = content;
        Date = date;
        this.isCanShow = isCanShow;
    }
}
