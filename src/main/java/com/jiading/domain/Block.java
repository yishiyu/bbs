package com.jiading.domain;

import java.io.Serializable;

/**
 * 分类实体类
 */
public class Block implements Serializable {

    private int bid;//分类id
    private String blockName;//分类名称
    private String logo;//logo的路径

    public Block() {
    }

    public Block(int bid, String blockName, String logo) {
        this.bid = bid;
        this.blockName = blockName;
        this.logo = logo;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Block{" +
                "bid=" + bid +
                ", blockName='" + blockName + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
