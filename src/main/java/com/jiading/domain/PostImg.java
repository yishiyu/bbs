package com.jiading.domain;

import java.io.Serializable;

/**
 * @program: bbs
 * @description: 为文章配一个图片
 * @author: JiaDing
 * @create: 2020-07-16 10:44
 **/
public class PostImg implements Serializable {
    private int rgid;//文章的图片的id
    private int rid;//文章的id
    private String pic;//文章的路径

    public PostImg(int rgid, int rid, String pic) {
        this.rgid = rgid;
        this.rid = rid;
        this.pic = pic;
    }

    public int getRgid() {
        return rgid;
    }

    public void setRgid(int rgid) {
        this.rgid = rgid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
